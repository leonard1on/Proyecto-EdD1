/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.edd1;

import java.util.Comparator;
import jdk.nashorn.internal.ir.BinaryNode;

/**
 *
 * @author Leonardo Borjas
 */
public class Binarynode {

    Binarynode parent;
    
    Binarynode lchild, rchild;
    private Object data;
    private int frequency;

    public Binarynode(Object data, int frequency) {
        this.data = data;
        this.frequency = frequency;
        parent=null;
    }

    public void AddRightChild(Binarynode child) {
        rchild = child;
        rchild.parent=this;
    }
    
    public void AddLeftChild(Binarynode child) {
        lchild = child;
        lchild.parent=this;
    }
    
    public Binarynode RightChild(){
        return rchild;
    }
    
    public Binarynode LeftChild(){
        return lchild;
    }
    
    public Binarynode RightSibling(){
        if (parent == null) {
            return null;
        }
        if (this.getParent().rchild!=this) {
            return this.getParent().rchild;        
        }else{
            return this;
        }
    }
    public Binarynode LeftSibling(){
        if (parent == null) {
            return null;
        }
        if (this.getParent().lchild!=this) {
            return this.getParent().lchild;        
        }else{
            return this;
        }
    }

    public Binarynode getParent() {
        return parent;
    }

    public void setParent(Binarynode parent) {
        this.parent = parent;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Object getChar() {
        if (data != null) {
            return data;            
        }else{
            return null;
        }
    }

    public void setChar(Object data) {
        this.data = data;
    }
    
 public static Comparator<Binarynode> Comparador = (Binarynode n1, Binarynode n2) -> n1.getFrequency()-n2.getFrequency();
 
}
