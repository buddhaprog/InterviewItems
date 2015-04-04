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
public class InterestCalculatorController
  {

    @RequestMapping(value = "/displayInterestCalculatorForm", method = RequestMethod.GET)
    public String displayInterestCalculatorForm() {

        return "interestCalculatorForm";

    }

    @RequestMapping(value = "/calculateInterest", method = RequestMethod.POST)
    public String calculateInterest(HttpServletRequest req, Model model) {
        String startAmountString = req.getParameter("startAmount");
        String yearCountString = req.getParameter("yearCount");
        String interestRateString = req.getParameter("interestRate");
        String timeString = req.getParameter("time");

        String yearCountMessage;
        String beginYearMessage;
        String interestEarnedMessage;
        String endOfYearMessage;

        double interestRateDouble = Double.parseDouble(interestRateString);
        double interestRate = interestRateDouble;
        String time = timeString;
        int yearCountInt = Integer.parseInt(yearCountString);
        int yearCount = yearCountInt;
        double startAmountDouble = Double.parseDouble(startAmountString);
        double startAmount = startAmountDouble;
        double prinEnd = 0;
        double intCurrentEarned = 0;
        double compoundNumber = 0;
        int currentYear = 0;
        List<String> messageList = new ArrayList<>();

        if (time.equalsIgnoreCase("yearly")) {
            compoundNumber = 1;
        } else if (time.equalsIgnoreCase("Quarterly")) {
            compoundNumber = 4;
        } else if (time.equalsIgnoreCase("Monthly")) {
            compoundNumber = 12;
        } else if (time.equalsIgnoreCase("Daily")) {
            compoundNumber = 365;
        } else {
            System.out.println("Please enter a valid time parameter");
        }
        String message = "You have chosen to invest: " + startAmount + " for " + yearCount
                + " years, compounding " + compoundNumber + " times a year" + " at " + (interestRate * 100) + "percent interest.";
        model.addAttribute("resultMessage", message);
        do {

            for (currentYear = 1;
                    currentYear <= yearCount;
                    currentYear++) {
                prinEnd = startAmount * Math.pow(1 + (interestRate / compoundNumber), 1 * compoundNumber);

                intCurrentEarned = Math.round((prinEnd - startAmount)*100)/100;

                double endRound = Math.round(prinEnd * 100.0) / 100.0;
                yearCountMessage = "Year: " + currentYear + " of " + yearCount + "<br>";
                beginYearMessage = "Princple at beginning of year: " + startAmount + "<br>";
                interestEarnedMessage = "Interest Earned : " + intCurrentEarned + "<br>";
                endOfYearMessage = "end of current year investment amount: " + endRound + "<br>";

                startAmount = endRound;

                messageList.add(yearCountMessage + beginYearMessage + interestEarnedMessage + endOfYearMessage+ "<br>");
           
            }

        } while (currentYear <= yearCount);
        
        String formattedMessageList = messageList.toString()
    .replace(",", "")  //remove the commas
    .replace("[", "")  //remove the right bracket
    .replace("]", "")  //remove the left bracket
    .trim();           //remove trailing spaces from partially initialized arrays
        
model.addAttribute("formattedMessageList", formattedMessageList);
        return "interestCalculatorResult";
    }
  }
