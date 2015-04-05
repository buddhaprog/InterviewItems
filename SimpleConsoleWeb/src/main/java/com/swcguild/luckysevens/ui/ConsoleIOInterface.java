/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.luckysevens.ui;

import java.time.LocalDate;

/**
 *
 * @author apprentice
 */
public interface ConsoleIOInterface
  {
    public int askForInt(String prompt) ;

    public int askForIntRange(String prompt, int min, int max) ;

    public String askForString(String prompt);

    public float askForFloat(String prompt); 

    public float askForFloatRange(String prompt, float min, float max) ;

    public double askForDouble(String prompt); 

    public double askForDoubleRange(String prompt, double min, double max);
        

    public void print(String prompt);

    public void println(String prompt);
    public LocalDate readIsoDate(String prompt);
  }
