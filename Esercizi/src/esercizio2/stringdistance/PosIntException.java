/*
* classe che rappresenta l'eccezione lanciata quando si cerca
* di inizializzare un PositiveInt con un valore negativo
*/
package esercizio2.stringdistance;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */

public class PosIntException extends Exception {

   public PosIntException(String message) {
       super(message);
   }

}
