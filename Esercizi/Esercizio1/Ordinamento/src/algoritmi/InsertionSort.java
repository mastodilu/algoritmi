/*
 * Insertion sort permette di ordinare un array.
 * Si comincia con un array vuoto, e ogni nuovo inserimento deve
 * mantenere la parte precedente ordinata. Così facendo anche l'ultimo
 * inserimento mantiene la parte sinistra ordinata e tutto l'array risulta
 * ordinato correttamente.
 */
package algoritmi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author MatteoDiLucchio
 */
public class InsertionSort<T extends Comparable<T>>{
    private BufferedReader br;
    private FileReader fr;
    /**
     * path del file da aprire
     */
    private String path;
    
    
    /**
     * costruttore
     * @param path del file da aprire
     */
    public InsertionSort(String PATH){
        this.path = PATH;
        this.open();
        
        System.out.println("File " + PATH + " opened correctly.");
    }

    /**
     * esegue l'ordinamento sul file
     */
    public void sort() throws IOException{
        String currentLine;
        while ((currentLine = br.readLine()) != null) {
            System.out.println(currentLine);
        }
    }
    
    /**
     * apre lo stream per la lettura del file
     */
    private void open(){
        try{
            fr = new FileReader(path);
            br = new BufferedReader(fr);
        }catch(FileNotFoundException e){
            System.err.println("Unable to open " + path);
            this.close();
        }
    }
    
    /**
     * chiude lo stream per la lettura del file
     */
    public void close(){
        try{
            br.close();
            fr.close();
        }catch(IOException e){
            System.err.println("Unable to close " + path);
        }
    }
    
}
