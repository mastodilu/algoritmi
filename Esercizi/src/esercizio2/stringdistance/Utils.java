/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio2.stringdistance;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class Utils {
    
    /**
     * metodo che restituisce la stringa passata come parametro
     * troncata del primo carattere.
     * @param s la stringa da modificare
     * @return la stringa 's' senza il primo carattere, null altrimenti
     */
    public static String rest(String s){
        if(!s.isEmpty()){
            s = s.substring(1);
            return s;
        }
        return "";
    }
    
    
    public static void printCurrentStatus(String op, String s1, String s2){
        System.out.println(op + " - " + s1 + ", " + s2);
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
    public static int min(int _noop, int _canc, int _ins){
        int min;
        
        try{
            PositiveInt noop =  new PositiveInt(_noop);
            PositiveInt canc =  new PositiveInt(_canc);
            PositiveInt ins =   new PositiveInt(_ins);
            
            min = noop.getValue();
            if(canc.getValue() < min)   min = canc.getValue();
            if(ins.getValue() < min)    min = ins.getValue();
            
        }catch(PosIntException e){
            System.err.println(e.getMessage());
            min = -1;
        }
        
        return min;
    }
    
}
