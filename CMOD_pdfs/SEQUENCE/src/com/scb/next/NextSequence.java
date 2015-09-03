/**
 * NextSequence.java
 * © Copyright 2011 Scope International
 */
package com.scb.next;


/**
 * @author 1414588
 *
 */
public class NextSequence {
    
    public static void main(String[] args) {
        for (int i = 1; i < 1000; i++) {
            String sequence = String.format("%08d", i);
            System.out.println(sequence);
        }
    }

}
