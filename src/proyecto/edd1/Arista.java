/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.edd1;

import java.util.Comparator;

/**
 *
 * @author Borjas
 */
public class Arista {

    public String id;
    public int peso;

    public Arista(String id, int peso) {
        this.id = id;
        this.peso = peso;
    }
    public static Comparator<Arista> Comparador = (Arista n1, Arista n2) -> n1.peso - n2.peso;
}
