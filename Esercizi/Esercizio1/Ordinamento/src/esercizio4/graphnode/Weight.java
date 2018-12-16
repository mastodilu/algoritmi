/*
 * Questa classe rappresenta il peso di un collegamento tra due nodi.
 * Il valore deve essere >= 1.
 */
package esercizio4.graphnode;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class Weight {
    protected Double weight;
    
    public Weight(Double d) throws WeightException{
        if(d < 1)   throw new WeightException("Weight value must be greater than 1");
        this.weight = d;
    }
    
    public Double getWeight(){
        return this.weight;
    }
    
}
