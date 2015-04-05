/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.luckysevens.controller;

import com.swcguild.luckysevens.dao.NumeralsDao;
import com.swcguild.luckysevens.dao.NumeralsDaoInMemImpl;
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

    @RequestMapping(value = "/displayRomanConverterForm", method = RequestMethod.GET)
    public String displayRomanConverterForm() {

        return "romanConverterForm";
    }

    @RequestMapping(value = "/enterNumeralToBeConverted", method = RequestMethod.POST)
    public String convertNumeral(HttpServletRequest req, Model model) {
        String userInput = req.getParameter("numeralConverted");
        NumeralsDao dao = new NumeralsDaoInMemImpl();
        String messageResult = dao.convertNumeral(userInput);
        String messageResultOut = "You have chosen to convert: " + userInput;
        model.addAttribute("resultMessage", messageResult);
        model.addAttribute("resultMessagetwo", messageResultOut);
        return "romanConverterResult";
    }

}
