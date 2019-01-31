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
/**
* classe che rappresenta un intero non negativo
*/
public class PositiveInt{
   private int value;

   public PositiveInt(int n) throws PosIntException{
       if(n >= 0)
           this.value = n;
       else throw new PosIntException("Value must be non negative");
   }

   public int getValue(){
       return this.value;
   }
}
