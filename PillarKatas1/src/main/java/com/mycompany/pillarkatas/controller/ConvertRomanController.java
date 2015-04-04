/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pillarkatas.controller;

import com.mycompany.pillarkatas.dao.NumeralsDaoInMemImpl;
import com.mycompany.pillarkatas.dto.Numerals;
import com.mycompany.pillarkatas.ui.ConsoleIO;

/**
 *
 * @author Rob
 */
//SEE ALSO SIMPLECONSOLEWEBAPP hooking up a one page version of 
//roman converter as a webpage app
public class ConvertRomanController {
    Numerals numeral;
    NumeralsDaoInMemImpl dao;
    ConsoleIO io;
    char x;

    public void run() {

        ConsoleIO.putln("Enter a Roman numeral and I will convert it to an");
        ConsoleIO.putln("arabic integer.  OR an integer in the range 1 to 3999");
        ConsoleIO.putln("and I will convert it to a Roman numeral.  Press return when");
        ConsoleIO.putln("you want to Exit.");

        while (true) {

            ConsoleIO.putln();
            ConsoleIO.put("? ");

            System.out.println(ConsoleIO.peek());
            while (ConsoleIO.peek() == ' ' || ConsoleIO.peek() == '\t') {
                x = ConsoleIO.getAnyChar();
                System.out.println(x);
            }
            if (ConsoleIO.peek() == '\n') {
                break;
            }

            System.out.println("We have a non-empty, non-whitespace string.");
            System.out.println(ConsoleIO.peek());
            
            if (Character.isDigit(ConsoleIO.peek())) {
                //System.out.println("It's a digit.");
                int arabic = ConsoleIO.getlnInt();
                dao = new NumeralsDaoInMemImpl(arabic);
                try {

                    ConsoleIO.putln(dao.toInt() + " = " + dao.toString());
                } catch (NumberFormatException e) {
                    ConsoleIO.putln("Invalid input.");
                    ConsoleIO.putln(e.getMessage());
                }
            } else {
                //System.out.println("It's not a digit.");
                String roman = ConsoleIO.getln();
                dao = new NumeralsDaoInMemImpl(roman);
                try {
                    ConsoleIO.putln(dao.toString() + " = " + dao.toInt());
                } catch (NumberFormatException e) {
                    ConsoleIO.putln("Invalid input.");
                    ConsoleIO.putln(e.getMessage());
                }
            }
        }
        ConsoleIO.putln("Adios.");
    }
}
