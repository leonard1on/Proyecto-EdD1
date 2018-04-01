/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.edd1;

import java.util.ArrayList;

/**
 *
 * @author Leonardo Borjas
 */
public class Treenode {

    ArrayList<Object> children = new ArrayList();
    Treenode parent;
    Object data;

    public Treenode(Object data) {
        this.data = data;
        parent=null;
    }

    public void AddChild(Treenode child) {
        child.parent=this;
        children.add(child);
        
    }
    
    public Treenode LeftChild(){
        if (children.isEmpty()) {
            return null;
        }else{
            return (Treenode) this.children.get(0);
        }
    }
    
    public Treenode RightSibling(){
        if (parent == null) {
            return null;
        }
        if (this.getParent().children.indexOf(this) < this.getParent().children.size()-1) {
            return (Treenode) this.getParent().children.get(this.getParent().children.indexOf(this)+1);        
        }else{
            return null;
        }
    }

    public Treenode getParent() {
        return parent;
    }

    public void setParent(Treenode parent) {
        this.parent = parent;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
    public boolean isLeaf(Treenode nodo){
        return nodo.LeftChild() == null;
    }
    
    

}
