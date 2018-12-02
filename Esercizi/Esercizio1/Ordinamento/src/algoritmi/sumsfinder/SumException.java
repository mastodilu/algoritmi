/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmi.sumsfinder;

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
