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
public class Arraylist implements Lista{
    private int size = 2000;
    private int availpos=0;
    private Object[] array = new Object [size];

    public Arraylist() {
    }

    public int getAvailpos() {
        return availpos;
    }    
    
    public void set(int pos, Object data){
        array[pos]=data;
    }
    
    public boolean append(Object data){
        array[availpos]=data;
        availpos++;
        return true;
    }
    
    public boolean insert(int pos, Object data){
        if (pos >= 0 && pos <= availpos) {
            if (pos == availpos) {
                array[pos]=data;
                availpos++;
            }else{
                for (int i = availpos; i < pos; i--) {
                    array[i]=array[i-1];
                    availpos++;
                    array[pos]=data;
                }
            }
            return true;
        }else{
            return false;
        }
    }
       
    public int find(Object data){
        for (int i = 0; i < availpos; i++) {
            if (data == array[i]) {
                return i;
            }
        }
        return availpos;
    }
    
    public Object get(int pos){
        if (pos>=0 && pos<availpos) {
            return array[pos];
        }else{
            return null;
        }
    }
    
    public boolean delete (int pos){
        if (pos>=0 && pos<availpos) {
            for (int i = pos; i < availpos-1; i++) {
                array[i]=array[i+1];
            }
            availpos--;
            array[availpos]=null;
            return true;
        }else{
            return false;
        }
    }
    
    public Object next(int pos){
        if (pos>=0 && pos<availpos-1) {
            return array[pos+1];
        }else{
            return null;
        }
    }
    
    public void clear(){
        for (int i = 0; i < array.length; i++) {
            array[i]=null;
        }
    }
    
    public Object first(){
        return array[0];
    }
    
    public void print(){
        for (int i = 0; i < availpos; i++) {
            System.out.println(array[i]);
        }
    }
}
