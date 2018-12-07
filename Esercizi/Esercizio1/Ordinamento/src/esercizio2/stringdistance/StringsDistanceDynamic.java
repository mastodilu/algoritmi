/*
 * Classe che usa la programmazione dinamica per trovare la distanza
 * minima di edit tra due stringhe
 */
package esercizio2.stringdistance;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class StringsDistanceDynamic {
    
    /**
     * rappresenta il tipo di operazione senza usare le stringhe. Utile per
     * alleggerire l'impiego di risorse.
     */
    private enum OperationTypes{
        EMPTY,INS,NOOP,CANC
    }
    
    /**
     * Tabella dei costi minimi.
     * Contiene il costo minimo delle tre operazioni sulle 2 stringhe
     */
    private int[][] minimumCosts;
    
    /**
     * Spiegazione dell'operazione di costo minimo per la tabella 'minimumCosts'
     */
    private OperationTypes[][] minimumOperationType;
    
    /**
     * Tabella dei costi minimi per l'operazione 'noop'
     */
    private int[][] noopCosts;
    
    /**
     * Tabella dei costi minimi per l'operazione 'canc'
     */
    private int[][] cancCosts;
 
    /**
     * Tabella dei costi minimi per l'operazione 'ins'
     */
    private int[][] insCosts;
    
    
    
    /**
     * Costruttore.
     * Inizializza le variabili prendendo in input
     * le due stringhe da confrontare.
     * @param s1
     * @param s2 
     */
    public StringsDistanceDynamic(String s1, String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        minimumOperationType = new OperationTypes[len1][len2];
        minimumCosts = new int[len1][len2];
        noopCosts = new int[len1][len2];
        cancCosts = new int[len1][len2];
        insCosts = new int[len1][len2];
        for(int i = 0; i < len1; i++)
            for(int j = 0; j < len2; j++){
                minimumOperationType[i][j] = OperationTypes.EMPTY;
                minimumCosts[i][j] = -1;
                noopCosts[i][j] = -1;
                cancCosts[i][j] = -1;
                insCosts[i][j] = -1;
            }
    }
    
    public int evaluateDistance(String s1, String s2){
        return -1;
    }
    
    private int editDistance(String s1, String s2){
        return -1;
    }
    
    private int noopEditDistance(String s1, String s2){
        return -1;
    }
    
    private int cancEditDistance(String s1, String s2){
        return -1;
    }
    
    private int insEditDistance(String s1, String s2){
        return -1;
    }
    
    
    
    /**
     * metodo che restituisce la stringa passata come parametro
     * troncata del primo carattere.
     * @param s la stringa da modificare
     * @return la stringa 's' senza il primo carattere, null altrimenti
     */
    private String rest(String s){
        if(!s.isEmpty()){
            s = s.substring(1);
            return s;
        }
        return "";
    }
    
    
    private void printCurrentStatus(String op, String s1, String s2){
        System.out.println(op + " - " + s1 + ", " + s2);
    }
}
