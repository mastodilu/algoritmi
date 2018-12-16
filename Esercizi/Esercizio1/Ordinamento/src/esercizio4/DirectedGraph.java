/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio4;

import esercizio4.graphnode.Node;
import esercizio4.graphnode.NodeException;
import esercizio4.graphnode.Weight;
import java.util.ArrayList;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class DirectedGraph extends Graph{
    

    
    /**
     * Costruttore.
     */
    public DirectedGraph(){
        super();
    }
    
    
    @Override
    public void addLink(Node from, Node to, Weight weight) throws GraphException{
        if(from == null)  throw new GraphException("Nodes must be non null.");
        if(this.nodes.contains(from) && this.nodes.contains(to)){
            try{
                from.addLink(to, weight);
            }catch(NodeException e){
                System.out.println(e.getMessage());
            }
        }
        else System.err.println("Nodes do not exist.");
    }

    
    @Override
    public void removeLink(Node from, Node to) throws GraphException{
        if(from == null)  throw new GraphException("Nodes must be non null.");
        from.removeLink(to);
    }

    @Override
    public boolean isDirected() {
        return true;
    }

}
