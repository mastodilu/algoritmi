/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordinamento;

import algoritmi.InsertionSort;
import java.io.IOException;

/**
 *
 * @author MatteoDiLucchio
 */
public class MainClass {
    /**
     * path del file da aprire
     */
    private static final String PATH = "C:\\Users\\masto\\Documents\\MieiProgetti\\Algoritmi_file_enormi\\Esercizio1\\integers.csv";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InsertionSort is = new InsertionSort(PATH);
        try{
            is.sort();//avvia l'ordinamento del file
            System.out.println("Sorting done with no errors");
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
        is.close();
    }
    
}
