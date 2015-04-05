/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.luckysevens.dao;

/**
 *
 * @author Rob
 */
public interface NumeralsDao {

    public String convertNumeral(String userInput);

    public int letterToNumber(char letter);

    @Override
    public String toString();

    public int toInt();
}
