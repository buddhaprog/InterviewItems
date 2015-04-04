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
 * @author Helvinator
 */
@Controller
public class TipCalculatorController
  {

    @RequestMapping(value = "/displayTipCalculatorForm", method = RequestMethod.GET)
    public String displayTipCalculatorForm() {

        return "tipCalculatorForm";

    }

    @RequestMapping(value = "/calculateTip", method = RequestMethod.POST)
    public String calculateTip(HttpServletRequest req, Model model) {
        String billAmountString = req.getParameter("billAmount");
        String tipRateString = req.getParameter("tipRate");

        double tipRateDouble = Double.parseDouble(tipRateString);
        double tipRate = tipRateDouble;
        double billAmountDouble = Double.parseDouble(billAmountString);
        double billAmount = billAmountDouble;
        double tipAmount = billAmount * (tipRate / 100);
        double billPlusTip = billAmount + tipAmount;
        String message="";

        if (tipRate < 15) {
            message = "The bill was: " + billAmount + "<br>"
                    + "The Tip % you have decided on is: " + tipRate + "% " + "<br>"
                    + " Making the Tip: " + tipAmount + "<br>"
                    + "The Total Bill is: " + billPlusTip + "<br>"
                    + "huh, and you wonder why you get bad service, you know they make 2 bucks an hour, right?" + "<br";
        }
        else if (tipRate > 15 && tipRate < 20) {
            message = "The bill was: " + billAmount + "<br>"
                    + "The Tip % you have decided on is: " + tipRate + "% " + "<br>"
                    + " Making the Tip: " + tipAmount + "<br>"
                    + "The Total Bill is: " + billPlusTip + "<br>"
                    + "not a bad tip, but not a great one" + "<br";
        }
        else if (tipRate > 20) {
            message = "The bill was: " + billAmount + "<br>"
                    + "The Tip % you have decided on is: " + tipRate + "% " + "<br>"
                    + " Making the Tip: " + tipAmount + "<br>"
                    + "The Total Bill is: " + billPlusTip + "<br>"
                    + "nice to see you got good service and know how to tip" + "<br";
        }

        model.addAttribute("resultMessage", message);
        return "tipCalculatorResult";
    }
  }
