package com.advancedJava;

public class Demo {
    public static int counter;
    static {
        System.out.println("Counter Inside static block: " + counter);
        counter++;
    }

    public static void display() {
        System.out.println("Counter Inside display: " + counter);
    }

    public static void main(String[] args) {
        Demo obj;
        Demo.counter = 23;
        Demo.display();
    }
}
