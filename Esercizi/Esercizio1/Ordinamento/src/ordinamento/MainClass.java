/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordinamento;

import algoritmi.InsertionSort;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author MatteoDiLucchio
 */
public class MainClass {
    private static final String PATH = "C:\\Users\\masto\\Documents\\MieiProgetti\\Algoritmi_file_enormi\\Esercizio1\\integers.csv";
    static BufferedReader br = null;
    static FileReader fr = null;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            fr = new FileReader(PATH);
            br = new BufferedReader(fr);
            InsertionSort is = new InsertionSort(br);
            System.out.println("File " + PATH + " opened correctly.");
            is.sort();
            System.out.println("Sorting done with no errors!\nCheck the modified file.");
        }catch(IOException e){
            System.err.println(e.getMessage());
        }finally{
            try{
                br.close();
                fr.close();
            }catch(IOException e){
                System.err.println(e.getMessage());
            }
        }
            
        

    }
    
}
