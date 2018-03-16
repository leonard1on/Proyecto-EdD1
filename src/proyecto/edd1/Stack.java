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
public interface Stack {
    
    public boolean push(Object data);
    public Object pop();
    public boolean isEmpty();
    public Object top ();
    public void clear();
    public void print();

}
