/*
 * Questa class serve a leggere i file "integers.csv" e "sums.txt" e a creare
 * gli arraylist da passare come parametri alle altre classi.
 * Permette di avviare insertion sort (crescente, decrescente), merge sort
 * (crescente, decrescente) e di cercare le somme di numeri con la classe sumsfinder.
 */
package main;

import esercizio1.algoritmi.InsertionSort;
import esercizio1.algoritmi.MergeSort;
import esercizio1.algoritmi.SumsFinder;
import esercizio2.stringdistance.LennonWords;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author MatteoDiLucchio
 */
public class MainClass {
    /**
     * path del file da aprire
     */
    private static final String PATH = "C:\\Users\\masto\\Documents\\MieiProgetti\\Algoritmi_file_enormi\\Esercizio1\\integers.csv";
//    private static final String PATH = "C:\\Users\\MatteoDiLucchio\\Documents\\Algoritmi\\Algoritmi file enormi\\Esercizio1\\integers.csv";
    private static final String PATH_SUMS = "C:\\Users\\masto\\Documents\\MieiProgetti\\Algoritmi_file_enormi\\Esercizio1\\sums.txt";
    static BufferedReader br;
    static FileReader fr;
    /**
     * arraylist dei numeri letti da file integers.csv
     */
    static ArrayList<Long> al;
    
    /**
     * arraylist di numeri letti da file sums.txt
     */
    static ArrayList<Long> sumslist;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //lettura da file integers.csv
//        al = new ArrayList<Long>();
//        openIntegers();
//        readIntegers();
//        close();

//        System.out.println(al.size() + " elements in the array");
//        System.out.println("Start sorting");
        
//        insertionSort();
//        mergeSort();
//        findSums();
        
//        System.out.println("Done sorting");

        correctLennonWords();
    }
    
    
    /**
     * stampa ogni numero contenuto nell'array
     */
    private static void printArray(){
        for (int i = 0; i < al.size(); i++){
            System.out.print(al.get(i) + ", ");
        }
        System.out.println();

    }
    
    
    /**
     * legge i numeri dal file e li aggiunge all'array
     */
    private static void readIntegers(){
        String line;
        try{
            while( (line = br.readLine()) != null){
                al.add(Long.parseLong(line));
            }
        }catch(IOException e){
            System.err.println("Errore IO");
        }
    }
    
    
    /**
     * apre lo stream per la lettura del file
     */
    private static void openIntegers(){
        try{
            fr = new FileReader(PATH);
            br = new BufferedReader(fr);
        }catch(FileNotFoundException e){
            System.err.println("Unable to open " + PATH);
            close();
        }
    }
    
    
    /**
     * chiude lo stream per la lettura del file
     */
    private static void close(){
        try{
            br.close();
            fr.close();
        }catch(IOException e){
            System.err.println("Unable to close the stream");
        }
    }


    /**
      * avvia l'algoritmo di ordinamento insertion sort
      */
    private static void insertionSort() {
        InsertionSort<Long> is = new InsertionSort<Long>(al);
        is.sortAscending();
//        is.sortDescending();
    }
    
    
    
    /**
      * avvia l'algoritmo di ordinamento insertion sort
      */
    private static void mergeSort() {
        MergeSort<Long> is = new MergeSort<Long>(al);
        is.sortAscending();
//        is.sortDescending();
    }
    
    
    private static void findSums(){
        try{
            fr = new FileReader(PATH_SUMS);
            br = new BufferedReader(fr);
            sumslist = new ArrayList<Long>();
            
            String line;
            while( (line = br.readLine()) != null){
                sumslist.add(Long.parseLong(line));
            }
        
        }catch(FileNotFoundException e){
            System.err.println("Unable to open " + PATH);
            close();
        }catch(IOException e){
            System.err.println("Errore IO");
        }
        
        close();
        
        SumsFinder sumsFinder = new SumsFinder(al, sumslist);
        sumsFinder.findAddends();
        System.out.println(sumsFinder.getSumList().toString());
    }
    
    
    
    /**
     * esegue la classe che legge il dizionario, le parole di Lennon
     * e propone delle correzioni.
     */
    private static void correctLennonWords(){
        LennonWords lennon = new LennonWords();
        lennon.startCorrection();
    }
}
