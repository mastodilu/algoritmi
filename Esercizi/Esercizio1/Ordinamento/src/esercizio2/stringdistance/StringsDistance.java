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
            System.out.println("La stringa e' lunga " + s.length() + " caratteri.");
            s.substring(1);
            System.out.println("Ora la stringa e' lunga " + s.length() + " caratteri.");
        }
        // se la stringa e' vuota
        return "";
    }
    
    
    
    
}
