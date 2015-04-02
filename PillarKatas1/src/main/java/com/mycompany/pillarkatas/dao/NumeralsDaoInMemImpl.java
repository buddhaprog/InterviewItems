/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pillarkatas.dao;

import com.mycompany.pillarkatas.dto.Numerals;
import com.mycompany.pillarkatas.ui.ConsoleIO;

/**
 *
 * @author Rob
 */
public class NumeralsDaoInMemImpl implements NumeralsDao {
       private final int num;  

    NumeralsDao dao;
    ConsoleIO io;
    Numerals numeral;

    public NumeralsDaoInMemImpl(int arabic) {
    
        if (arabic < 1) {
            throw new NumberFormatException("Cannot be negative, sorry");
        }
        if (arabic > 3999) {
            throw new NumberFormatException("Apologies, must be less than 3999");
        }
        num = arabic;
    }


    public NumeralsDaoInMemImpl(String roman) {

        if (roman.length() == 0) {
            throw new NumberFormatException("An empty string does not define a Roman numeral.");
        }
        roman = roman.toUpperCase();  
        int i = 0;       
        int arabic = 0;  

        while (i < roman.length()) {

            char letter = roman.charAt(i);       
            int number = letterToNumber(letter); 

            if (number < 0) {
                throw new NumberFormatException("Illegal character \"" + letter + "\" in roman numeral.");
            }

            i++;  

            if (i == roman.length()) {
                    arabic += number;
            } else {
                int nextNumber = letterToNumber(roman.charAt(i));
                if (nextNumber > number) {
                    arabic += (nextNumber - number);
                    i++;
                } else {
                   arabic += number;
                }
            }

        }  

        if (arabic > 3999) {
            throw new NumberFormatException("Roman numeral must have value 3999 or less.");
        }

        num = arabic;

    } 
    @Override
    public int letterToNumber(char letter) {
       
        switch (letter) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }

    @Override
    public String toString() {
       
        String roman = "";  
        int N = num;        
         for (int i = 0; i < Numerals.getNumbers().length; i++) {
            while (N >= Numerals.getNumbers()[i]) {
                roman += Numerals.getLetters()[i];
                N -= Numerals.getNumbers()[i];
            }
        }
        return roman;
    }

    @Override
    public int toInt() {
        return num;
    }

}
