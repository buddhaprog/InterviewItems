/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.luckysevens.controller;

import java.text.DecimalFormat;
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
public class FlooringCalculatorController
  {

    @RequestMapping(value = "/displayFlooringCalculatorForm", method = RequestMethod.GET)
    public String displayFlooringCalculatorForm() {

        return "flooringCalculatorForm";

    }

    @RequestMapping(value = "/calculateCost", method = RequestMethod.POST)
    public String calculateCost(HttpServletRequest req, Model model) {
        String floorAreaWidthString = req.getParameter("floorAreaWidth");
        String floorAreaLengthString = req.getParameter("floorAreaLength");
        String costPerUnitString = req.getParameter("costPerUnit");

        double floorAreaWidthDouble = Double.parseDouble(floorAreaWidthString);
        double floorAreaWidth = floorAreaWidthDouble;
        double floorAreaLengthDouble = Double.parseDouble(floorAreaLengthString);
        double floorAreaLength = floorAreaLengthDouble;
        double costPerUnitDouble = Double.parseDouble(costPerUnitString);
        double costPerUnit = costPerUnitDouble;
        double laborCostPerHour = 86;
        double laborSpeed = 20;
        double laborTime;
        double laborCost;

        double floorArea = floorAreaWidth * floorAreaLength;
        double floorAreaCost = floorArea * costPerUnit;
        laborTime = floorArea / laborSpeed;

        long laborTimeInt = (long) laborTime;
        double remainderLaborTime = laborTime - laborTimeInt;
        double secondRemainderLaborTime = (remainderLaborTime + 100) / 4;
        long secondRemainderLaborTimeInt = (long) secondRemainderLaborTime;
        secondRemainderLaborTimeInt++;
        double fractionalTime = (secondRemainderLaborTime / 4);

        Double installationCost = (laborTimeInt + fractionalTime) * laborCostPerHour;
        double totalCost = installationCost + floorAreaCost;

        DecimalFormat df = new DecimalFormat("0.00");

        String roundedLengthString = df.format(floorAreaLength);
        String roundedWidthString = df.format(floorAreaWidth);
        String roundedAreaString = df.format(floorArea);
        String roundedInstallationCost = df.format(installationCost);
        String roundedTotal = df.format(totalCost);
        String roundedFloorAreaCost= df.format(floorAreaCost);

        String message = "A width of " + roundedWidthString + " and a length of" + roundedLengthString + "gives an area of " + roundedAreaString + " square feet." + "<br>"
                + "At a cost of " + costPerUnit + " per square foot." + "<br>"
                + "it is going to cost " + roundedFloorAreaCost + " dollars." + "<br>"
                + "That does not include labor, labor is going to run you an additional " + laborCostPerHour + " dollars per hour." + "<br>"
                + "which adds " + roundedInstallationCost + " dollars, bringing you to a pre tax total of " + roundedTotal + " dollars for the flooring and installation.";

        model.addAttribute("resultMessage", message);
        return "tipCalculatorResult";
    }
  }
