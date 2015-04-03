/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pillarkatas.dao;

import com.mycompany.pillarkatas.dto.Numerals;
import com.mycompany.pillarkatas.ui.ConsoleIO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rob
 */
public class NumeralsDaoTest {
    Numerals numeral;
    NumeralsDao dao;
    ConsoleIO io;
    char V;
    public NumeralsDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testLetterToNumber() {
        System.out.println("letterToNumber");
        //char letter = 'V';
        NumeralsDao instance = new NumeralsDaoImpl();
        int expResult = 5;
        int result = instance.letterToNumber('V');
        assertEquals(expResult, result);
    }
//    
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        NumeralsDao instance = new NumeralsDaoImpl();
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testToInt() {
//        System.out.println("toInt");
//        NumeralsDao instance = new NumeralsDaoImpl();
//        int expResult = 0;
//        int result = instance.toInt();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    public class NumeralsDaoImpl implements NumeralsDao {

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
            return "";
        }

        @Override
        public int toInt() {
            return 0;
        }
    }
    
    
    
    
}
