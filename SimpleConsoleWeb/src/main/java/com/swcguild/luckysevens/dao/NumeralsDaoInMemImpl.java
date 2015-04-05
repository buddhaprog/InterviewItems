/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.luckysevens.dao;

import com.swcguild.luckysevens.dto.Numerals;
import com.swcguild.luckysevens.ui.ConsoleIO;

/**
 *
 * @author Rob
 */
public class NumeralsDaoInMemImpl implements NumeralsDao {

    private boolean isArabic;
    private int num;
    

    @Override
    public void checkUserInput(String userInput) {

        if (userInput.matches("^[0-9]+$")) {
            this.num = Integer.parseInt(userInput);
            this.setIsArabic(true);
        } else if (userInput.toUpperCase().matches("^[MCXILDV]+$")) {
            this.num = this.romanToArabic(userInput);
            this.setIsArabic(false);
        } else {
            throw new NumberFormatException("Input was invalid, please enter either a roman numeral or arabic number.");
        }
        if (this.num > 3999){
                    throw new NumberFormatException("Input was invalid, input must be less than 3999");

        }
    }


    @Override
    public int romanToArabic(String roman) {

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
       
                return arabic;
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
        int N = this.num;
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

    @Override
    public String convertNumeral(String userInput) {

        String converterResult;
        try {
            this.checkUserInput(userInput);

            if (this.isIsArabic() == true) {
                converterResult = this.toInt() + " = " + this.toString();
                ConsoleIO.putln(this.toInt() + " = " + this.toString());
            } else {
                converterResult = this.toString() + " = " + this.toInt();
                ConsoleIO.putln(this.toString() + " = " + this.toInt());
            }
        } catch (NumberFormatException e) {
            ConsoleIO.putln("Invalid input.");
            ConsoleIO.putln(e.getMessage());
            converterResult=e.getMessage();
        }
        return converterResult;
    }

    /**
     * @return the isArabic
     */
    public boolean isIsArabic() {
        return isArabic;
    }

    /**
     * @param isArabic the isArabic to set
     */
    public void setIsArabic(boolean isArabic) {
        this.isArabic = isArabic;
    }
}
