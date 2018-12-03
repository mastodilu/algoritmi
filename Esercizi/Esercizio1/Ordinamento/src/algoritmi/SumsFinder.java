/*
 * Questa classe sfrutta delle hashmap per cercare di trovare quei numeri
 * che sono la possibile somma di altri due numeri.
 * I primi sono cercati nella hashmap "sums", gli altri in "integersmap" ed
 * eventualmente in "foundAgain".
 * Ogni somma trovata viene rappresentata dall'oggetto Sum e aggiunta
 * all'arraylist "sumList" che puo' essere letto al termine dell'algoritmo
 * per vedere il risultato.
 */
package algoritmi;

import algoritmi.sumsfinder.Sum;
import algoritmi.sumsfinder.SumException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class SumsFinder {
    
    /**
     * hashmap dell'array di numeri tra cui cercare gli addendi.
     * chiave: come chiavi vengono usati gli elementi letti dall'array passato nel costruttore
     * valore: come valori vengono usati gli indici degli elementi letti nell'array.
     * 
     *  Esempio:
     *      array[5] = elemento
     *      mappa('elemento') = 5
     */
    private HashMap<Long, Integer> integersMap;
    
    /**
     * mappa ausiliaria popolata con gli elementi presenti piu' di una volta
     * nell'arraylist passato al costruttore.
     * permette di tenere traccia degli addendi che sono usabili due volte
     * per calcolare una somma
     */
    private HashMap<Long,Integer> foundAgain;
    
    /**
     * array di numeri da verificare se sono formati dalla somma di due addendi
     */
    private ArrayList<Long> sums;
    
    
    /**
     * arraylist di Sum che contiene gli elementi che hanno creato una somma
     */
    private ArrayList<Sum> sumList;
    
    /**
     * costruttore
     * @param array arraylist di elementi usati per popolare la mappa
     * @param arraySums arraylist di elementi che rappresentano le somme,
     *      elementi di cui cercare le possibili somme
     */
    public SumsFinder(ArrayList<Long> array, ArrayList<Long> arraySums){
        this.integersMap = new HashMap<Long, Integer>();
        this.foundAgain = new HashMap<Long, Integer>();
        this.sums = arraySums;
        this.sumList = new ArrayList<Sum>();
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
    private void populateMap(ArrayList<Long> array){
        for(int i = 0; i < array.size(); i++){
            if(this.integersMap.get(array.get(i)) == null) //se l'elemento non esiste nella mappa principale
                this.integersMap.put(array.get(i), i);
            else
                this.foundAgain.put(array.get(i), i);
        }
    }
    
    
    
    public void findAddends(){
        for(Long sum : this.sums){
            for(Map.Entry<Long,Integer> entry : this.integersMap.entrySet()){
                Long firstKey = entry.getKey();
                Long secondKey = sum - firstKey;
                
                boolean found = this.integersMap.get(secondKey) != null;
                // se i due addendi sono chiavi (e quindi numeri) diversi allora OK
                //altrimenti controlla che ci sia almeno un doppione per quel numero
                if( found && firstKey == secondKey){
                    found = false;
                    if(this.foundAgain.get(secondKey) != null){ // trovato il doppione, allora OK
                        found = true;
                    }
                }
                if(found == true){
                    addToSumList(sum, firstKey, secondKey);
                    this.printSum(sum, firstKey, secondKey);
                    break;
                }
            }
        }
    }

    
    public ArrayList<Sum> getSumList() {
        return sumList;
    }
    
    
    
    
    
    /**
     * helper method
     * stampa un messaggio quando si trova una somma
     * @param sum
     * @param firstElem
     * @param secondElem 
     */
    private void printSum(Long sum, Long firstElem, Long secondElem){
        System.out.println(sum + " = " + firstElem + " + " + secondElem);
    }

    @Override
    public String toString(){
        return 
                "map " + this.integersMap.toString()
                + "\nfound twice " + this.foundAgain.toString()
                + "\nsums " + this.sums.toString();
    }

    
    
    private void addToSumList(Long sum, Long firstKey, Long secondKey) {
        try{
            this.sumList.add(new Sum(sum, firstKey, secondKey));
        }catch(SumException se){
            System.err.println(se.getMessage());
        }
    }
}
