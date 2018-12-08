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
    
    
    
    /**
     * arraylist di parole da correggere
     */
    private ArrayList<String> lennon;
    
    
    
    /**
     * costruttore
     */
    public LennonWords(){
        this.words = new ArrayList<String>();
        this.lennon = new ArrayList<String>();
        
        this.readDict();        this.closeDict();
        this.readLennon();      this.closeLennon();
    }
    
    
    
    
    
    /**
     * apre lo stream del dizionario e scrive le parole nell'arraylist
     */
    private void readDict(){
        try{
            frDict = new FileReader(PATH_DICT);
            buffReadDict = new BufferedReader(frDict);
            
            String line = "";
            while( (line = this.buffReadDict.readLine()) != null){
                words.add(line);
            }
        }catch(FileNotFoundException e){
            System.err.println("Unable to open " + PATH_DICT);
            closeDict();
        }catch(IOException e){
            System.err.println("Error reading " + PATH_DICT);
        }
    }
    
    
    
    /**
     * chiude lo stream del dizionario
     */
    private void closeDict(){
        try{
            this.buffReadDict.close();
            this.frDict.close();
        }catch(IOException e){
            System.err.println("Unable to close stream.");
        }
    }
    
    
    
    
    
    /**
     * apre lo stream del dizionario e scrive le parole nell'arraylist
     */
    private void readLennon(){
        String[] temp;
        try{
            frLennon = new FileReader(PATH_LENNON);
            buffReadLennon = new BufferedReader(frLennon);
            
            String line = "", regex = "[^a-zA-Z]";
            while( (line = this.buffReadLennon.readLine()) != null){
                // crea l'array di parole sapendo che una parola e' una sequenza di lettere
                // ogni parola viene aggiunta in arraylist per una gestione piu' semplice
                temp = line.split(regex);
                for(int i = 0; i < temp.length; i++){
                    if( !temp[i].equals("") ){
                        this.lennon.add(temp[i].toLowerCase());
                    }
                }
            }
        }catch(FileNotFoundException e){
            System.err.println("Unable to open " + PATH_LENNON);
            closeLennon();
        }catch(IOException e){
            System.err.println("Error reading " + PATH_LENNON);
        }
    }
    
    
    
    /**
     * chiude lo stream del dizionario
     */
    private void closeLennon(){
        try{
            this.buffReadLennon.close();
            this.frLennon.close();
        }catch(IOException e){
            System.err.println("Unable to close stream.");
        }
    }



}
