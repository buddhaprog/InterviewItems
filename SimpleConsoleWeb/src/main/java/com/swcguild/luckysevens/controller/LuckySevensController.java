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

public class LuckySevensController {

    @RequestMapping(value="/displayLuckySevensForm", method=RequestMethod.GET)
    public String displayLuckySevensForm(){
    
        return "luckySevensForm";
    
    }
    @RequestMapping(value="/placeBet", method=RequestMethod.POST)
    public String placeBet(HttpServletRequest req, Model model){
        String betAmountString= req.getParameter("betAmount");
        
        int betAmountInt= Integer.parseInt(betAmountString);
        int betAmount=betAmountInt;
        int die1;
        int die2;
        int played = 0;
        int maxMoney;
        int maxPlayed;
   
        maxMoney = betAmount;
        maxPlayed = played;

        while (betAmount > 0) {
            
            die1 = (int)(Math.random() * 6) + 1;
            die2 = (int)(Math.random() * 6) + 1;
            
            played++;

            if ((die1 + die2) == 7) {
                betAmount = betAmount + 4;
                if (betAmount > maxMoney) {
                    maxMoney = betAmount;
                    maxPlayed = played;
                }
            } else if ((die1 + die2) < 2 || (die1 + die2) > 12) {
                System.out.println("ERROR!!!"); 
            } else {
                betAmount--;
            }

        }
        
        String message=("You bet: " + betAmountInt + " dollars."+"<br>"+
        "You are broke after " + played + " rolls."+"<br>"+
        "You should have quit after " + maxPlayed
        +" rolls when you had $" + maxMoney);     
        
        model.addAttribute("resultMessage", message);
        return "luckySevensResult";
        
    }
    
} 

