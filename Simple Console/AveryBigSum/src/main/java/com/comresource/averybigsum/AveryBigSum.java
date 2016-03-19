/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comresource.averybigsum;

import java.util.Scanner;

/**
 *
 * @author Rob
 */
public class AveryBigSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a number to get the sum of digits");
        int number = sc.nextInt();
        int sum = 0;
        int input = number;
        while (input != 0) {
            int lastDigit = input % 10;
            sum += lastDigit;
            input /= 10;

        }
        System.out.printf("Sum of digits of number is %d is %d", number, sum);
        sc.close();
    }

}
