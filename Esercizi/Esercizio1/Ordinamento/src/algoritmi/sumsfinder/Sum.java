/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    public boolean sameFields(Sum other){
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
