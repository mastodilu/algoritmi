/*
 * Insertion sort permette di ordinare un array.
 * Si comincia con un array vuoto, e ogni nuovo inserimento deve
 * mantenere la parte precedente ordinata. Così facendo anche l'ultimo
 * inserimento mantiene la parte sinistra ordinata e tutto l'array risulta
 * ordinato correttamente.
 */
package algoritmi;

import java.io.BufferedReader;

/**
 *
 * @author MatteoDiLucchio
 */
public class InsertionSort<T extends Comparable<T>>{
    private BufferedReader bf;
    
    
    /**
     * costruttore
     */
    public InsertionSort(){}
    
    /**
     * Costruttore
     * @param bf file reader
     */
    public InsertionSort(BufferedReader bf){
        this.bf = bf;
    }

    public void sort() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
