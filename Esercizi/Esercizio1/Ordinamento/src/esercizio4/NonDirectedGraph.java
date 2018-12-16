/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio4;

import esercizio4.graphnode.Node;
import esercizio4.graphnode.NodeException;
import esercizio4.graphnode.Weight;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class NonDirectedGraph extends Graph{



    @Override
    public void addLink(Node from, Node to, Weight weight) throws GraphException {
        if(from == null)  throw new GraphException("Nodes must be non null.");
        if(this.nodes.contains(from) && this.nodes.contains(to)){
            try{
                from.addLink(to, weight);
                to.addLink(from, weight);
            }catch(NodeException e){
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void removeLink(Node from, Node to) throws GraphException {
        if(from == null)  throw new GraphException("Nodes must be non null.");
        from.removeLink(to);
        to.removeLink(from);
    }

    @Override
    public boolean isDirected() {
        return false;
    }

}
