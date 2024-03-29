package com.advancedJava;

interface A {
    void meth1();
    void meth2();
}

class interfaceExample implements  A{

    public static void main(String[] args) {
        interfaceExample obj = new interfaceExample();
        obj.meth1();
        obj.meth2();
    }

    @Override
    public void meth1() {
        System.out.println("Meth1 called");
    }

    @Override
    public void meth2() {
        System.out.println("meth2 called");
    }
}