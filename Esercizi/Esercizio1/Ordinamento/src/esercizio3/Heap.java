/*
 * NB: il primo elemento dell'arraylist e' sempre un elemento null
 * che mantiene sempre vera la relazione tra un nodo e i due figli:
 *      indice nodo:    i
 *      indici figli:   2i, 2i+1
 * 

 */
package esercizio3;

import esercizio3.heapexceptions.IndexOutOfHeapException;
import java.util.ArrayList;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public abstract class Heap<T extends Comparable> {
    
    /**
     * elementi che compongono lo heap
     */
    protected ArrayList<HeapElement> elements;
    
    /**
     * Costruttore partendo da un arraylist.
     * Il primo elemento e' sempre null per mantenere la relazione tra gli
     * indici del padre e dei figli.
     * @param elements arraylist di HeapElement.
     */
    public Heap(ArrayList<HeapElement> elements){
        this.elements = new ArrayList<HeapElement>(); // nuovo arraylist
        this.elements.add(0, null); // primo elemento null
        for(HeapElement elem : elements)//aggiunge ogni elemento nella giusta posizione
            this.heapInsert(elem);
    }
    
    /**
     * Costruttore partendo da un array di HeapElement.
     * Il primo elemento e' sempre null per mantenere la relazione tra gli
     * indici del padre e dei figli.
     * @param elements array di HeapElement
     */
    public Heap(HeapElement[] elements){
        this.elements = new ArrayList<HeapElement>();
        this.elements.add(null);
        for(HeapElement elem : elements){
            this.heapInsert(elem);
        }
    }
    
    /**
     * Costruttore senza parametri.
     * Il primo elemento e' sempre null per mantenere la relazione tra gli
     * indici del padre e dei figli.
     */
    public Heap(){
        elements = new ArrayList<HeapElement>();
        elements.add(null); // primo elemento null
    }
    
    
    
    /**
     * Restituisce una copia di "elements" senza il null node.
     */
    public ArrayList<HeapElement> getElements(){
        ArrayList<HeapElement> temp = new ArrayList<HeapElement>();
        for(int i = 1; i < this.elements.size(); i++)
            temp.add(this.elements.get(i));
        return temp;
    }
    
    
    public void heapInsert(HeapElement elem){
        if(elem == null){
            System.err.println("Can't heapInsert null HeapElement.");
            return;
        }
        
        //inserimento in coda
        this.elements.add(elem);
        int elemIndex = this.elements.size()-1;
        //risalita verso l'olimpo
        try{
            //se elem ha priorita' maggiore allora deve risalire
            while(this.prior(parent(elemIndex), elem) == elem){
                int parentIndex = this.getParentIndex(elemIndex);
                this.swap(elemIndex, parentIndex);
                elemIndex = parentIndex;
            }
            
        }catch(IndexOutOfHeapException e){
            //do nothing - node is root
        }
    }
    
    
    /**
     * Restituisce l'indice del parent node se esiste.
     * @param childIndex indice del child node.
     * @return indice del parent node.
     * @throws IndexOutOfHeapException 
     */
    private int getParentIndex(int childIndex) throws IndexOutOfHeapException{
        if(childIndex < 2 || childIndex >= this.elements.size())
            throw new IndexOutOfHeapException("To get the parent node"
                    + " index cannot be less than 2 or "
                    + "greater than the size of the array.");
        if(childIndex%2 == 1) childIndex--; //se dispari
        return childIndex / 2;
    }
    
    
    /**
     * Restituisce il parent node senza rimuoverlo.
     * @param index indice del nodo considerato
     * @return indice del parent node del nodo di indice 'index'
     * @throws IndexOutOfHeapException
     */
    public HeapElement parent(int childIndex) throws IndexOutOfHeapException{
        try{
            return this.elements.get(this.getParentIndex(childIndex));
        }catch(IndexOutOfHeapException e){
            return null;
        }        
    }
    
    
    /**
     * Restituisce l'indice del figlio sinistro se esiste.
     * @param parentIndex indice del parent node
     * @throws IndexOutOfHeapException se non ha figlio sinistro
     */
    public int left(int parentIndex) throws IndexOutOfHeapException{
        if(2*parentIndex >= this.elements.size())
            throw new IndexOutOfHeapException();
        return 2*parentIndex;
    }
    
    
    /**
     * Restituisce l'indice del figlio destro del nodo.
     * in posizione 'index' se esiste.
     * @param index indice del parent node
     * @throws IndexOutOfHeapException se non ha figlio destro
     */
    public int right(int index) throws IndexOutOfHeapException{
        if(2*index + 1 >= this.elements.size())
            throw new IndexOutOfHeapException();
        return 2*index + 1;
    }
    
    
    /**
     * @return l'elemento di priorita' maggiore, quello in cima all'albero.
     */
    public HeapElement head() throws IndexOutOfHeapException{
        if(elements.size() > 1)
            return elements.get(1);
        throw new IndexOutOfHeapException();
    }
    
    
    
    public ArrayList<HeapElement> heapSort(){
        
        ArrayList<HeapElement> result = new ArrayList<HeapElement>();
        try{
            int length = this.elements.size();
            for(int i = 1; i < length; i++){
                System.out.println(toString());
                HeapElement elem = this.heapExtract();
                System.out.println("Ho estratto " + elem.toString());
                result.add(elem);
            }
                
        }catch(IndexOutOfHeapException e){
            System.err.println(this.elements.size() + " -- " + e.getMessage());
        }
        return result;
    }
    
    
    
    
    
    /**
     * Restituisce il numero di elementi nello heap ignorando il null node.
     */
    public int size(){
        return this.elements.size()-1; // non considera il null node
    }
    
    
    /**
     * Estrae il primo elemento dallo heap senza romperne la struttura e 
     * mantenendo la relazione d'ordinamento.
     * @return
     * @throws IndexOutOfHeapException 
     */
    public HeapElement extractFirst() throws IndexOutOfHeapException{
        //il primo elemento e' sempre vuoto e corregge gli indici
        if(this.elements.size() <= 1)   throw new IndexOutOfHeapException();
        
        //ci sono due elementi (nullNode e primo vero elemento)
        if(this.elements.size() == 2){
            HeapElement elem = this.elements.get(1);
            this.elements.remove(1);
            return elem;
        }
        
        //ci sono tre elementi (null, primo, secondo)
        //in questo caso non ha senso ragionare come un albero
        if(this.elements.size() == 3){
            HeapElement elem = this.elements.get(1);
            this.elements.remove(1);
            return elem;
        }
        
        //ci sono piu' di 3 elementi veri: e' un albero
        HeapElement head = this.elements.get(1);
        int parentIndex = 1; // inizialmente coincide con root (non conta il null node iniziale)
        this.swap(parentIndex, this.elements.size()-1); // scambia primo e ultimo
        //sale il figlio piu' prioritario
        boolean stop = false;
        while(hasLeftChild(parentIndex) && !stop){
            
            int leftIndex = left(parentIndex);
//            System.out.println("left index: " + leftIndex);
//            System.out.println("parent index: " + parentIndex);
            HeapElement leftChild = this.elements.get(leftIndex);
            HeapElement parent = this.elements.get(parentIndex);
            //caso 1. ci sono entrambi i figli --> controlla entrambi e prendi quello prioritario per il confronto col parent
            if(hasRightChild(parentIndex)){
                //faccio salire il figlio piu' prioritario
                int rightIndex = right(parentIndex);
//                System.out.println("if right index: " + rightIndex);
                HeapElement rightChild = this.elements.get(rightIndex);
                HeapElement priorChild = prior(leftChild, rightChild);
                int indexPrior = (priorChild == leftChild) ? leftIndex : rightIndex;
                if(prior(priorChild, parent) == priorChild){
                    swap(parentIndex, indexPrior);
                    parentIndex = indexPrior;
                }
                else stop = true;
            }
            else{
            //caso 2. c'e' solo il figlio sinistro --> controlla il sinistro ed eventualmente scambia
                if(prior(leftChild, parent) == leftChild){
                    swap(parentIndex, leftIndex);
                    parentIndex = leftIndex;
                    stop = true;
                }
            }
        }
        //caso 3. non ha figli --> do nothing
        
        return head;
    }

    
    
    public HeapElement heapExtract()throws IndexOutOfHeapException{
        System.out.println("Extract");
        if(size() == 0 )    throw new IndexOutOfHeapException();
        HeapElement elem;
        if(size() <= 2) {
            elem = this.elements.get(1);
            this.elements.remove(1);
            return elem;
        }else{ // ci sono piu' di due HeapElement validi
            swap(1, size()); // scambia primo e ultimo
            elem = this.elements.get(size()); // legge in fondo allo heap
            this.elements.remove(size()); // cancella il valore
            heapifyDown(1); // ricostruisce heap
            return elem; 
        }
    }
    
    
    
    private void heapifyDown(int parent){
        int left,right;
        try{
            left = left(parent);
        }catch(IndexOutOfHeapException e){
            left=0;
        }
        try{
            right = right(parent);
        }catch(IndexOutOfHeapException e){
            right=0;
        }
        
        int priorIndex = prior(parent, right, left);
        if(priorIndex != parent){
            swap(parent, priorIndex);
            heapifyDown(priorIndex);
        }
    }
    

    /**
     * Restituisce true se il nodo ha un figlio sinistro.
     * @param parentIndex indice del nodo padre.
     * @return 
     */
    private boolean hasLeftChild(int parentIndex){
        try{
           left(parentIndex);
           return true;
       }catch(IndexOutOfHeapException e){
           return false;
       }
    }
    
    
    /**
     * Restituisce true se il nodo ha un figlio destro.
     * @param parentIndex indice del nodo padre.
     * @return 
     */
    private boolean hasRightChild(int parentIndex){
        try{
           right(parentIndex);
           return true;
       }catch(IndexOutOfHeapException e){
           return false;
       }
    }
    
    /**
     * Scambia di posizione gli elementi agli indici indicati nello heap.
     * @param child indice del primo elemento
     * @param second indice del secondo elemento da shiftare
     */
    private void swap(int child, int parent){
        System.out.println("Swap " + this.elements.get(child).getContent()
                        + " con " + this.elements.get(parent).getContent());
        HeapElement backup = this.elements.get(parent);
        this.elements.set(parent, this.elements.get(child));
        this.elements.set(child, backup);
    }
    
    
    /**
     * Restituisce l'indice dell'elemento di priorità maggiore.
     * @param x indice del primo elemento.
     * @param y indice del secondo elemento.
     * @param z indice del terzo elemento.
     * @return 
     */
    public int prior(int x, int y, int z){
        HeapElement first, second, third;
            first = this.elements.get(x);
            second = this.elements.get(y);
            third = this.elements.get(z);
        
        HeapElement priorElem = prior(first, second);
        priorElem = prior(priorElem, third);
        if(priorElem == first)  return x;
        if(priorElem == second) return y;
        return z;        
    }
    
    
    /**
     * Confonta i due elementi passati come parametri e restituisce quello di
     * priorita' maggiore, cioe' quello che si muove verso l'alto nello heap.
     * A seconda dello heap implementato (Max o Min heap) cambia il calcolo
     * della priorita'.
     * @param first 
     * @param second
     * @return l'elemento di priorita' maggiore.
     */
    public abstract HeapElement prior(HeapElement first, HeapElement second);
    
    
    
    @Override
    public String toString(){
        String s = "";
        for(int i = 1; i <= size(); i++){
            s += this.elements.get(i) + " ";
        }
        return s;
    }
}
