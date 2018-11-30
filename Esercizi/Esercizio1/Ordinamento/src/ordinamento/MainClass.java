/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordinamento;

import algoritmi.InsertionSort;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
    private static BufferedReader br;
    private static FileReader fr;
    private static ArrayList<Long> al;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean shortTest = true;
        if(shortTest){ //test con un array corto
//            al = new ArrayList<Long>(Arrays.asList(1L,2L,2L,2L,3L,3L,4L,4L,5L,6L,8L,11L,1L));
//            al = new ArrayList<Long>(Arrays.asList(5L,1L,2L,2L,2L,3L,3L,4L,4L,5L,6L,9L,8L));
//            al = new ArrayList<Long>(Arrays.asList(1L,2L,2L,2L,3L,3L,4L,4L,5L,6L,8L,11L,1L));
//            al = new ArrayList<Long>(Arrays.asList(10L,2L,2L,3L,1L,4L));
//            al = new ArrayList<Long>(Arrays.asList(2L,4L,1L,3L));
            al = new ArrayList<Long>(Arrays.asList(5L,10L,2L,2L,3L,1L,4L,1L,2L,20L,2L,3L,3L,4L,4L,5L,6L,9L,8L,1L,2L,2L,2L,3L,3L,4L,4L,5L,6L,8L,11L,1L,1L,2L,2L,2L,3L,3L,4L,4L,5L,6L,8L,11L,1L,10L,2L,2L,3L,1L,4L));


        }else{//legge il file enorme
            al = new ArrayList<Long>();
            open();
            read();
            close();
        }
        
        System.out.println(al.size() + " elementi da riordinare");
        sort();
        printArray();
    }
    
    
    /**
     * stampa ogni numero contenuto nell'array
     */
    private static void printArray(){
        for (int i = 0; i < al.size(); i++){
            System.out.println(al.get(i) + " ");
        }
        System.out.println();

    }
    
    
    /**
     * legge i numeri dal file e li aggiunge all'array
     */
    private static void read(){
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
    private static void open(){
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
            System.err.println("Unable to close " + PATH);
        }
    }


    /**
      * avvia l'algoritmo di ordinamento
      */
    private static void sort() {
        InsertionSort<Long> is = new InsertionSort<Long>(al);
        is.sort();
    }
}
