/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.luckysevens.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Rob
 */
@Controller
public class RomanConverterController {
    @RequestMapping(value="/displayRomanConverterForm", method=RequestMethod.GET)
    public String displayRomanConverterForm(){
    
        return "romanConverterForm";}
    
//    @RequestMapping(value = "/enterNumberToBeFactored", method = RequestMethod.POST)
//    public String convertNumeral(HttpServletRequest req, Model model) {
//        String numeralConvertString = req.getParameter("numeralConverted");
//    
//        
//    }
        
}
