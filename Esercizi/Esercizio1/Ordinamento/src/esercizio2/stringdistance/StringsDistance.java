/*
 * Questa classe permette di calcolare la distanza di edit tra due stringhe
 * in modo ricorsivo e usando la programmazione dinamica.
 * Le operazioni consentite sono:
 *      - cancellazione
 *      - inserimento
 * 
 * 

 */
package esercizio2.stringdistance;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class StringsDistance {
    
    /**
     * costruttore
     */
    public StringsDistance(){}
    
    
    /**
     * metodo che restituisce la distanza di edit minima
     * tra le due stringhe "s1" e "s2".
     */
    public int editDistance(String s1, String s2){
        
        return -1;
    }
    
    
    /**
     * metodo che restituisce la stringa passata come parametro
     * troncata del primo carattere.
     * @param s la stringa da modificare
     * @return la stringa 's' senza il primo carattere, null altrimenti
     */
    public String rest(String s){
        if(!s.isEmpty()){
            s = s.substring(1);
            return s;
        }
        return "";
    }
    
    
    /**
     * Restituisce il minimo dei 3 parametri interi passati.
     * Se sono uguali viene favorito noop, poi canc, poi ins.
     * I parametri interi passati sono non negativi perche' rappresentano
     * costi di operazioni.
     * @param noop
     * @param canc
     * @param ins 
     */
    private int min(int _noop, int _canc, int _ins){
        int min;
        
        try{
            PositiveInt noop =  new PositiveInt(_noop);
            PositiveInt canc =  new PositiveInt(_canc);
            PositiveInt ins =   new PositiveInt(_ins);
            
            min = noop.getValue();
            if(canc.getValue() < min)   min = canc.getValue();
            if(ins.getValue() < min)    min = ins.getValue();
            
        }catch(PositiveInt.PosIntException e){
            System.err.println(e.getMessage());
            min = -1;
        }
        
        return min;
    }
    
    /**
     * classe che rappresenta un intero non negativo
     */
    private class PositiveInt{
        private int value;
        
        public PositiveInt(int n) throws PosIntException{
            if(n >= 0)
                this.value = n;
            else throw new PosIntException("Value must be non negative");
        }
        
        public int getValue(){
            return this.value;
        }
        
        
        
        /**
         * eccezione lanciata quando si cerca di inizializzare
         * un PositiveInt con un valore negativo
         */
        class PosIntException extends Exception {

            public PosIntException(String message) {
                super(message);
            }

        }
    }
    
}
