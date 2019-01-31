/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio3.heapelementexceptions;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class NullContentException extends Exception{
    public NullContentException(String msg){
        super(msg);
    }
    public NullContentException(){
        super("HeapElement can't have a null content.");
    }
}
