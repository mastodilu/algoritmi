/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Matteo Di Lucchio <matteo.dilucchio@edu.unito.it>
 */
public class TestClass {
    
    public static void main(String args[]){
//        int first = 0;
//        int second = 0;
//        int number = (first+second)/2;
//        System.out.println(number);

        ArrayList<Long> al = new ArrayList<Long>(Arrays.asList(5L,1L,2L,2L,2L,3L,3L,4L,4L,5L,6L,9L,8L));
        System.out.println(al.size());
        al.get(0);
        al.get(0);
        al.get(0);
        System.out.println(al.size());
    }
    
}
