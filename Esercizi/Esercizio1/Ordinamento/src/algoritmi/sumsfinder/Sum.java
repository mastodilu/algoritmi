/*
 * Questa classe permette di rappresentare un oggetto somma come composto
 * da 3 numeri: un long risultato e due long addendi.
 * Nel costruttore si controlla la correttezza della somma specificata.
 */
package algoritmi.sumsfinder;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class Sum {
    public final Long RESULT, FIRST, SECOND;
    
    public Sum(Long r, Long f, Long s) throws SumException{
        if( r != (f+s) )
            throw new SumException(r, f, s);
        this.RESULT = r;
        this.FIRST = f;
        this.SECOND = s;
    }
    
    public boolean isEqual(Sum other){
        return (    (this.RESULT.compareTo(other.RESULT) == 0)
                    && (this.FIRST.compareTo(other.FIRST) == 0)
                    && (this.SECOND.compareTo(other.SECOND) == 0)
                );
    }
    
    @Override
    public String toString(){
        return  this.RESULT + " "
                + " = " + this.FIRST
                + " + " + this.SECOND;
    }
}
