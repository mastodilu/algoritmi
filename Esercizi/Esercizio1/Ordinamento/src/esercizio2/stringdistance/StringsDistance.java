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

import static esercizio2.stringdistance.Utils.*;



/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class StringsDistance {
    
    /**
     * costruttore
     */
    public StringsDistance(){
    }
    
    
    /**
     * metodo che restituisce la distanza di edit minima
     * tra le due stringhe "s1" e "s2".
     */
    public int evaluateDistance(String s1, String s2){
        if(s1.length() == 0)    return s2.length();
        if(s2.length() == 0)    return s1.length();
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        return min(
                noopEditDistance(s1,s2),
                cancEditDistance(s1,s2),
                insEditDistance(s1,s2));
        
    }
    
    
    private int editDistance(String s1, String s2){
        //nessuna delle due e' la stringa vuota
        //this.printCurrentStatus("edit", s1, s2);
        if(s1.length() > 0 && s2.length() > 0)
            return min(
                noopEditDistance(s1,s2),
                cancEditDistance(s1,s2),
                insEditDistance(s1,s2));
        // almeno una delle due e' la stringa vuota
        if(s1.length() == 0 )
            return s2.length();
        return s1.length();
    }
    
    
    /**
     * metodo di supporto per editDistance
     */
    private int noopEditDistance(String s1, String s2){
        //this.printCurrentStatus("noop", s1, s2);
        if( s1.charAt(0) == s2.charAt(0) ){
            return this.editDistance( rest(s1), rest(s2) );
        }
        return Integer.MAX_VALUE;
    }
    
    /**
     * metodo di supporto per editDistance
     */
    private int cancEditDistance(String s1, String s2){
        //this.printCurrentStatus("canc", s1, s2);
        return 1 + this.editDistance(s1, rest(s2));
    }
    
    /**
     * metodo di supporto per editDistance
     */
    private int insEditDistance(String s1, String s2){
        // this.printCurrentStatus("ins", s1, s2);
        return 1 + this.editDistance(rest(s1), s2);
    }
    
//    /**
//     * metodo che restituisce la stringa passata come parametro
//     * troncata del primo carattere.
//     * @param s la stringa da modificare
//     * @return la stringa 's' senza il primo carattere, null altrimenti
//     */
//    private String rest(String s){
//        if(!s.isEmpty()){
//            s = s.substring(1);
//            return s;
//        }
//        return "";
//    }
//    
//    
//    private void printCurrentStatus(String op, String s1, String s2){
//        System.out.println(op + " - " + s1 + ", " + s2);
//    }
//    
//    
//    /**
//     * Restituisce il minimo dei 3 parametri interi passati.
//     * Se sono uguali viene favorito noop, poi canc, poi ins.
//     * I parametri interi passati sono non negativi perche' rappresentano
//     * costi di operazioni.
//     * @param noop
//     * @param canc
//     * @param ins 
//     */
//    private int min(int _noop, int _canc, int _ins){
//        int min;
//        
//        try{
//            PositiveInt noop =  new PositiveInt(_noop);
//            PositiveInt canc =  new PositiveInt(_canc);
//            PositiveInt ins =   new PositiveInt(_ins);
//            
//            min = noop.getValue();
//            if(canc.getValue() < min)   min = canc.getValue();
//            if(ins.getValue() < min)    min = ins.getValue();
//            
//        }catch(PosIntException e){
//            System.err.println(e.getMessage());
//            min = -1;
//        }
//        
//        return min;
//    }
    
}
