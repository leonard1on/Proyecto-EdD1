/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.edd1;

/**
 *
 * @author Leonardo Borjas
 */
public class Empleado {
    private String nombre;
    private float nota;

    public Empleado() {
    }

    
    public Empleado(String nombre) {
        this.nombre = nombre;
        this.nota=0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        if (this.nota==0) {
            return "" + nombre + " - Evaluación Pendiente";
        }else{
            return "" + nombre + " - " + nota;
        }
    }
    
    
    
}
