/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pillarkatas.dto;

/**
 *
 * @author Rob
 */
public class Numerals {
       
            
       private static int[]    numbers = { 1000,  900,  500,  400,  100,   90,  
                                             50,   40,   10,    9,    5,    4,    1 };
                                          
       private static String[] letters = { "M",  "CM",  "D",  "CD", "C",  "XC",
                                           "L",  "XL",  "X",  "IX", "V",  "IV", "I" };
          
    
    public static int[] getNumbers() {
        return numbers;
    }

    public static void setNumbers(int[] aNumbers) {
        numbers = aNumbers;
    }

    public static String[] getLetters() {
        return letters;
    }

    public static void setLetters(String[] aLetters) {
        letters = aLetters;
    }
}
