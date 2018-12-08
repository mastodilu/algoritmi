/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio2.stringdistance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class LennonWords {
    
    /**
     * path del file che contiene l'eleneco delle parole italiane
     */
    public static String PATH_DICT = "C:\\Users\\masto\\Documents\\MieiProgetti\\Algoritmi_file_enormi\\Esercizio2\\dictionary.txt";
    
    /**
     * path del file con le parole da correggere
     */
    public static String PATH_LENNON = "C:\\Users\\masto\\Documents\\MieiProgetti\\Algoritmi_file_enormi\\Esercizio2\\correctme.txt";
    
    private BufferedReader buffReadDict, buffReadLennon;
    private FileReader frDict, frLennon;
    
    /**
     * arraylist di parole lette nel dizionario italiano
     */
    private ArrayList<String> words;
    
    
    public LennonWords(){
        words = new ArrayList<String>();
        readDict();
        closeDict();
    }
    
    
    private void readDict(){
        try{
            frDict = new FileReader(PATH_DICT);
            buffReadDict = new BufferedReader(frDict);
            
            String line = "";
            while( (line = this.buffReadDict.readLine()) != null){
                words.add(line);
                System.out.println("Ho scritto " + line);
            }
        }catch(FileNotFoundException e){
            System.err.println("Unable to open " + PATH_DICT);
            closeDict();
        }catch(IOException e){
            System.err.println("Error reading " + PATH_DICT);
        }
    }
    
    
    private void closeDict(){
        try{
            this.buffReadDict.close();
            this.frDict.close();
        }catch(IOException e){
            System.err.println("Unable to close stream.");
        }
    }



}
