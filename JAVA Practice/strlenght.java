package com.advancedJava;

import java.util.*;

class stringLengthF
{
    public static void main(String[] args)
    {
        String str;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        str=sc.nextLine();

        int n=str.length();

        System.out.println("Length of the string(using length() method) = "+n);

        char[] ch =str.toCharArray();

        int n2 = ch.length;

        System.out.println("Length of the string(using length method) = "+n2);
    }
}