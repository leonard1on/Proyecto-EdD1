/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.edd1;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

/**
 *
 * @author Borjas
 */
public class Prueba1 {

    static Graph grafo = new SingleGraph("Grafo", false, true);

    public static void main(String[] args) {
        grafo.addEdge("AB", "A", "B");
        grafo.addEdge("BC", "B", "C");
        grafo.addEdge("CF", "C", "F");
        grafo.addEdge("FD", "F", "D");
        grafo.addEdge("FI", "F", "I");
        grafo.addEdge("IH", "I", "H");
        grafo.addEdge("HG", "H", "G");
        grafo.addEdge("GF", "G", "F");
        grafo.addEdge("DB", "D", "B");      
        grafo.addEdge("DE", "D", "E");
        grafo.addEdge("EA", "E", "A");       
        for (Node nodo : grafo) {
            nodo.setAttribute("No visitado", true);
            nodo.setAttribute("Color", "Ninguno");
        }
        System.out.println(bicoloreable(grafo.getNode("A"), true, "Azul"));

    }

    public static boolean bicoloreable(Node nodo, boolean bicolor, String color) {
        if (nodo.getAttribute("No visitado")) {
            nodo.setAttribute("No visitado", false);
            if (nodo.getAttribute("Color").equals("Ninguno")) {
                nodo.setAttribute("Color", color);
            }
            for (Edge edge : nodo) {
                if (edge.getOpposite(nodo).getAttribute("Color").equals(nodo.getAttribute("Color"))) {
                    bicolor = false;
                }
                if (color.equals("Azul")) {
                    bicolor = bicoloreable(edge.getOpposite(nodo), bicolor, "Rojo");
                } else {
                    bicolor = bicoloreable(edge.getOpposite(nodo), bicolor, "Azul");
                }
            }
            System.out.println("Recorrido Nodo " + nodo.getId() + ", " + nodo.getAttribute("Color") + ".");
        }
        return bicolor;
    }
}
