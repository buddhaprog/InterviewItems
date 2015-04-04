/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.luckysevens.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Helvinator
 */
@Controller
public class FactorizorController
  {

    @RequestMapping(value = "/displayFactorizorForm", method = RequestMethod.GET)
    public String displayFactorizorForm() {

        return "factorizorForm";

    }

    @RequestMapping(value = "/enterNumberToBeFactored", method = RequestMethod.POST)
    public String factorNumber(HttpServletRequest req, Model model) {
        String numberFactoredString = req.getParameter("numberFactored");
        int userInput = Integer.parseInt(numberFactoredString);

        int factorSum = 0;
        String prime;
        String perfect;
        List<Integer> factorList = new ArrayList<>();

        for (int i = 1;
                i < userInput;
                i++) {
            if (userInput % i == 0) {
                factorSum += i;
                factorList.add(i);
            }
        }
        if (factorSum == userInput) {
            perfect = userInput + " is a perfect number";
        } else {
            perfect = userInput + " is not a perfect number";
        }
        if (factorSum == 1) {
            prime = userInput + " is a prime number";
        } else {
            prime = userInput + " is not a prime number";
        }

        String message = "You have chosen to factor the number " + userInput;
        model.addAttribute("resultMessage", message);
        model.addAttribute("myFactorList", factorList);
        model.addAttribute("resultPerfect", perfect);
        model.addAttribute("resultPrime", prime);
        return "factorizorResult";

    }

  }
