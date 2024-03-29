package com.advancedJava;

class Car {
    private int speed;
    private double regularPrice;
    private String color;

    public Car(int speed, double regularPrice, String color) {
        this.speed = speed;
        this.regularPrice = regularPrice;
        this.color = color;
    }

    public double getSalePrice() {
        return regularPrice;
    }
}
class Truck extends Car {
    private final int weight;

    public Truck(int speed, double regularPrice, String color, int weight) {
        super(speed, regularPrice, color);
        this.weight = weight;
    }

    public double getSalePrice() {
        return super.getSalePrice() * (weight > 2000 ? 0.10 : 0.20);
    }
}
class Sedan extends Car {
    private final int length;

    public Sedan(int speed, double regularPrice, String color, int length) {
        super(speed, regularPrice, color);
        this.length = length;
    }

    public double getSalePrice() {
        return super.getSalePrice() * (length < 20 ? 0.05 : 0.10);
    }
}
class Ford extends Car {
    public int manufacturerDiscount;

    public Ford(int speed, double regularPrice, String color, int year, int manufacturerDiscount) {
        super(speed, regularPrice, color);
        this.manufacturerDiscount = manufacturerDiscount;
    }

    public double getSalePrice() {
        return super.getSalePrice() - manufacturerDiscount;
    }
}
class MyShop {
    public static void main(String[] args) {
        Sedan toyota = new Sedan(500, 500, "red", 30);
        Ford nissanOne = new Ford(300, 300, "black", 2021, 35);
        Ford nissanTwo = new Ford(250, 250, "yellow", 2020, 40);
        Car car = new Car(100, 100, "white");
        System.out.println("toyota "+toyota.getSalePrice());
        System.out.println("nissanOne "+nissanOne.getSalePrice());
        System.out.println("nissanTwo "+nissanTwo.getSalePrice());
        System.out.println("car  "+car.getSalePrice());
    }
}
