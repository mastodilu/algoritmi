/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmi;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class SumsFinder<T extends Comparable> {
    
    /**
     * hashmap dell'array di numeri tra cui cercare gli addendi.
     * chiave: come chiavi vengono usati gli elementi letti dall'array passato nel costruttore
     * valore: come valori vengono usati gli indici degli elementi letti nell'array.
     * 
     *  Esempio:
     *      array[5] = elemento
     *      mappa('elemento') = 5
     */
    private HashMap<T, Integer> integersMap;
    
    /**
     * mappa ausiliaria popolata con gli elementi presenti piu' di una volta
     * nell'arraylist passato al costruttore.
     * permette di tenere traccia degli addendi che sono usabili due volte
     * per calcolare una somma
     */
    private HashMap<T,Integer> foundAgain;
    
    /**
     * array di numeri da verificare se sono formati dalla somma di due addendi
     */
    private ArrayList<T> sums;
    
    /**
     * costruttore
     * @param array arraylist di elementi usati per popolare la mappa
     * @param arraySums arraylist di elementi che rappresentano le somme,
     *      elementi di cui cercare le possibili somme
     */
    public SumsFinder(ArrayList<T> array, ArrayList<T> arraySums){
        this.integersMap = new HashMap<T, Integer>();
        this.foundAgain = new HashMap<T, Integer>();
        this.sums = arraySums;
        populateMap(array);
    }
    
    /**
     * popola la mappa usando
     *      chiave: array[i]
     *      valore: i
     * ogni doppione viene aggiunto alla mappa ausiliaria 'foundAgain'
     * per tenere traccia degli elementi trovati piu' di una volta
     * @param array arraylist di elementi usati per popolare la mappa
     */
    private void populateMap(ArrayList<T> array){
        for(int i = 0; i < array.size(); i++){
            if(this.integersMap.get(array.get(i)) == null) //se l'elemento non esiste nella mappa principale
                this.integersMap.put(array.get(i), i);
            else
                this.foundAgain.put(array.get(i), i);
        }
    }

    @Override
    public String toString(){
        return "map " + this.integersMap.toString() + "\nfound twice " + this.foundAgain.toString();
    }
    
}
