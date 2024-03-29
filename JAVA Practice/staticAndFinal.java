package com.advancedJava;

class Demo1 {
    static int x = 10;
    static int y;
    static void func() {
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
    static {
        System.out.println("Running static initialization block.");
        y = x + 5;
    }
    public static void main(String[] args) {
        Demo1 obj;
        func();
        x++;
        y = 3;

    }
}
