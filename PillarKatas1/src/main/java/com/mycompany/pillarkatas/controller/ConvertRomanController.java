/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pillarkatas.controller;

import com.mycompany.pillarkatas.dao.NumeralsDao;
import com.mycompany.pillarkatas.dto.Numerals;
import com.mycompany.pillarkatas.ui.ConsoleIO;

/**
 *
 * @author Rob
 */
public class ConvertRomanController {
    Numerals numeral;
    NumeralsDao dao;
    ConsoleIO io;

    public void run() {

        ConsoleIO.putln("Enter a Roman numeral and I will convert it to an");
        ConsoleIO.putln("arabic integer.  OR an integer in the range 1 to 3999");
        ConsoleIO.putln("and I will convert it to a Roman numeral.  Press return when");
        ConsoleIO.putln("you want to Exit.");

        while (true) {

            ConsoleIO.putln();
            ConsoleIO.put("? ");

            while (ConsoleIO.peek() == ' ' || ConsoleIO.peek() == '\t') {
                ConsoleIO.getAnyChar();
            }
            if (ConsoleIO.peek() == '\n') {
                break;
            }

            if (Character.isDigit(ConsoleIO.peek())) {
                int arabic = ConsoleIO.getlnInt();
                try {

                    ConsoleIO.putln(dao.toInt() + " = " + dao.toString());
                } catch (NumberFormatException e) {
                    ConsoleIO.putln("Invalid input.");
                    ConsoleIO.putln(e.getMessage());
                }
            } else {
                String roman = ConsoleIO.getln();
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
