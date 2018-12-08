/*
 * Classe che usa la programmazione dinamica per trovare la distanza
 * minima di edit tra due stringhe
 */
package esercizio2.stringdistance;

import static esercizio2.stringdistance.Utils.*;

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
        EMPTY,
        INS,NOOP,CANC
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
    
    String str1, str2;
    
    
    
    /**
     * Costruttore.
     * Inizializza le variabili prendendo in input
     * le due stringhe da confrontare.
     * @param s1
     * @param s2 
     */
    public StringsDistanceDynamic(String s1, String s2){
        this.str1 = s1;
        this.str2 = s2;
        int len1 = this.str1.length();
        int len2 = this.str2.length();
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
    
    /**
     * Restituisce la distanza minima di edit tra le due stringhe
     * pssate come parametro.
     */
    public int evaluateDistance(){
        if(this.str1.length() == 0)    return this.str2.length();
        if(this.str2.length() == 0)    return this.str1.length();
        
        this.str1 = this.str1.toLowerCase();
        this.str2 = this.str2.toLowerCase();
        
        return this.editDistance(this.str1, this.str2);
    }
    
    private int editDistance(String s1, String s2){
        //nessuna delle due e' la stringa vuota
        //printCurrentStatus("edit", s1, s2);
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        if(s1.length() > 0 && s2.length() > 0){
            int noop = this.noopCosts[i][j];
            int canc = this.cancCosts[i][j];
            int ins = this.insCosts[i][j];

            if(noop == -1)  noop = noopEditDistance(s1,s2);
            if(canc == -1)  canc = cancEditDistance(s1,s2);
            if(ins == -1)   ins = insEditDistance(s1,s2);
            
            this.minimumCosts[i][j] = min( noop, canc, ins);
            this.writeMinOperationType(i, j, noop, canc, ins);
            return this.minimumCosts[i][j];
        }
        
        // almeno una delle due e' la stringa vuota
        if(s1.length() == 0 ){
            return s2.length();
        }
        return s1.length();
    }
    
    private int noopEditDistance(String s1, String s2){
        //printCurrentStatus("noop", s1, s2);
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        if(this.noopCosts[i][j] == -1){//se l'operazione non e' mai stata fatta
            if(s1.charAt(0) == s2.charAt(0))
                this.noopCosts[i][j] = this.editDistance(rest(s1), rest(s2));
            else 
                this.noopCosts[i][j] = Integer.MAX_VALUE;
        }
        return this.noopCosts[i][j];
    }
    
    private int cancEditDistance(String s1, String s2){
        //printCurrentStatus("canc", s1, s2);
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        if(this.cancCosts[i][j] == -1){
            this.cancCosts[i][j] = 1 + this.editDistance(s1, rest(s2));
        }
        return this.cancCosts[i][j];
    }
    
    private int insEditDistance(String s1, String s2){
        //printCurrentStatus("ins", s1, s2);
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        if( this.insCosts[i][j] == -1 ){
            this.insCosts[i][j] = 1 + this.editDistance(rest(s1), s2);
        }
        return this.insCosts[i][j];
    }
    
    
    
    private void writeMinOperationType(
            int i,
            int j,
            int noop,
            int canc,
            int ins){
        if(this.minimumCosts[i][j] == noop)
            this.minimumOperationType[i][j] = OperationTypes.NOOP;
        else if(this.minimumCosts[i][j] == canc)
            this.minimumOperationType[i][j] = OperationTypes.CANC;
        else if(this.minimumCosts[i][j] == ins)
            this.minimumOperationType[i][j] = OperationTypes.INS;
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
    
    
    public void printMinimumCosts(){
        int len1 = this.str1.length();
        int len2 = this.str2.length();
        System.out.println("Matrix minimum costs");
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                System.out.print(this.minimumCosts[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println();

    }
    
    public void printCancCosts(){
        int len1 = this.str1.length();
        int len2 = this.str2.length();
        System.out.println("Matrix canc");
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                System.out.print(this.cancCosts[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void printInsCosts(){
        int len1 = this.str1.length();
        int len2 = this.str2.length();
        System.out.println("Matrix ins");
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                System.out.print(this.insCosts[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    
    public void printNoopCosts(){
        int len1 = this.str1.length();
        int len2 = this.str2.length();
        System.out.println("Matrix noop");
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                if(this.noopCosts[i][j] == Integer.MAX_VALUE)
                    System.out.print(this.noopCosts[i][j] + "\t");
                else System.out.print(this.noopCosts[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    
    public void printMinOpType(){
        int len1 = this.str1.length();
        int len2 = this.str2.length();
        System.out.println("Matrix min op type");
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                System.out.print(this.minimumOperationType[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
