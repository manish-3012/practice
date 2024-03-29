package com.advancedJava;

import java.util.Scanner;

class ChkPalindrome
{
    public static void main(String[] args)
    {
        String str;
        StringBuilder rev = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        str = sc.nextLine();

        int length = str.length();

        for ( int i = length - 1; i >= 0; i-- )
            rev.append(str.charAt(i));

        if (str.equals(rev.toString()))
            System.out.println(str+" is a palindrome");
        else
            System.out.println(str+" is not a palindrome");

    }
}