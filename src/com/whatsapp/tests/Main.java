package com.whatsapp.tests;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        HashMap<Integer, String> numbers = new HashMap<Integer, String>();
        numbers.put(0, "zero");
        numbers.put(1, "one");
        numbers.put(2, "two");
        numbers.put(3, "three");
        numbers.put(4, "four");
        numbers.put(5, "five");
        numbers.put(6, "six");
        numbers.put(7, "seven");
        numbers.put(8, "eight");
        numbers.put(9, "nine");
        numbers.put(10, "ten");
        Scanner in = new Scanner(System.in);
        System.out.println("Type your number from 0 - 10: ");
        int num = in.nextInt();
        System.out.println("You are typed number - " + numbers.get(num));
    }
}
