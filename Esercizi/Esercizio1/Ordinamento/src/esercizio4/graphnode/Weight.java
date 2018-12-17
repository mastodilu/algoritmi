/*
 * Questa classe rappresenta il peso di un collegamento tra due nodi.
 * Il valore deve essere >= 1.
 */
package esercizio4.graphnode;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class Weight implements Comparable<Weight>{
    protected Integer weight;
    
    public Weight(Integer d) throws WeightException{
        if(d < 1)   throw new WeightException("Weight value must be greater than 1");
        this.weight = d;
    }
    
    public Integer getWeight(){
        return this.weight;
    }

    @Override
    public String toString() {
        return weight.toString();
    }

    @Override
    public int compareTo(Weight o) {
        return weight.compareTo(o.weight);
    }
    
}
