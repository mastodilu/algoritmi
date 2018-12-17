/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio3.heapexceptions;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class IndexOutOfHeapException extends Exception{
    public IndexOutOfHeapException(String msg){
        super(msg);
    }
    public IndexOutOfHeapException(){
        super("Index is either less than 1 or greater than last index in the arraylist.");
    }
}
