/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.edd1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

/**
 *
 * @author Borjas
 */
public class ArbolMinimo {    
    Graph grafo = new SingleGraph("grafo", false, true);
    Graph arbol = new SingleGraph("arbol", false, true);
    Random r = new Random();
    ArrayList<Arista> aristas = new ArrayList<>();

    public void clase() {
        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        grafo.addAttribute("ui.stylesheet", "edge{text-alignment:above;} node{size:50px; text-alignment:above; fill-mode: image-scaled; fill-image: url('.\\kb.png');}");
        arbol.addAttribute("ui.stylesheet", "edge{text-alignment:above;} node{size:50px; text-alignment:above; fill-mode: image-scaled; fill-image: url('.\\kr.png');}");
        grafo.addEdge("AB", "A", "B");
        grafo.addEdge("BC", "B", "C");
        grafo.addEdge("CF", "C", "F");
        grafo.addEdge("CD", "C", "D");
        grafo.addEdge("FD", "F", "D");
        grafo.addEdge("DB", "D", "B");
        grafo.addEdge("DE", "D", "E");
        grafo.addEdge("EA", "E", "A");
        for (org.graphstream.graph.Node node : grafo) {
            node.setAttribute("ui.label", node.getId());
            arbol.addNode(node.getId());
            arbol.getNode(node.getIndex()).setAttribute("ui.label", node.getId());
            arbol.getNode(node.getIndex()).setAttribute("No visitado", true);
        }
        for (Edge edge : grafo.getEachEdge()) {
            edge.setAttribute("Peso", r.nextInt(9) + 1);
            aristas.add(new Arista(edge.getId(),edge.getAttribute("Peso")));
            edge.setAttribute("ui.label", edge.getAttribute("Peso") + "");
        }
        Collections.sort(aristas, Arista.Comparador);
        for (Arista arista : aristas) {
            if (ciclo(true, arbol.getNode(grafo.getEdge(arista.id).getNode0().getId()), arbol.getNode(grafo.getEdge(arista.id).getNode1().getId()))) {
                arbol.addEdge(arista.id, arbol.getNode(grafo.getEdge(arista.id).getNode0().getId()).getId(), arbol.getNode(grafo.getEdge(arista.id).getNode1().getId()).getId());
            }
            for (org.graphstream.graph.Node node : arbol) {
                arbol.getNode(node.getIndex()).setAttribute("No visitado", true);
            }
        }
        for (Edge edge : arbol.getEachEdge()) {
            edge.setAttribute("ui.label", grafo.getEdge(edge.getId()).getAttribute("Peso") + "");
        }
        grafo.display();
        arbol.display();
    }

    public static boolean ciclo(boolean conecta, org.graphstream.graph.Node a, org.graphstream.graph.Node b) {
        b.setAttribute("No visitado", false);
        for (Edge edge : b) {
            if (a == b || a == edge.getOpposite(b)) {
                conecta = false;
            } else {
                if (edge.getOpposite(b).getAttribute("No visitado")) {
                    conecta = ciclo(conecta, a, edge.getOpposite(b));
                }
            }
        }
        return conecta;
    }
}
