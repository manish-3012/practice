package com.advancedJava;

public class Threading extends Thread{
    @Override
    public void run() {
        System.out.println("Thread ran!");
    }

    public static void main(String[] args) {
        Thread obj = new Threading();
        obj.start();
    }
}
