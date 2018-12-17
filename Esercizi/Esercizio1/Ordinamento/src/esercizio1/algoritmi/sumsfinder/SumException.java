/*
 * Classe eccezione usata dalla class SumsFinder.
 * Questa eccezione viene lanciata quando si specifica la somma sbagliata.
 */
package esercizio1.algoritmi.sumsfinder;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class SumException extends Exception {
    public SumException(Long r, Long f, Long s){
        super("SumException: " + r + " is not " + f + " + " + s );
    }
    
    public SumException(){
        super("SumException: wrong sum");
    }
}
