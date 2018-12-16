/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio4;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class NonPositiveException extends Exception{
    public NonPositiveException(){
        super();
    }
    
    public NonPositiveException(String msg){
        super(msg);
    }
}
