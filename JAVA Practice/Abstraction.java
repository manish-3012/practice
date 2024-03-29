package com.advancedJava;

abstract class Animal {
    abstract void makeSound();

}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("dog class");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("cat class ");
    }
}

class Abstraction {
    public static void main(String[] args) {
        Dog d1 = new Dog();
        d1.makeSound();

        Cat c1 = new Cat();
        c1.makeSound();
    }
}
