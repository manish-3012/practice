package com.advancedJava;

public class Employee_default {
    public int eno;
    public String name;
    public float Salary;

    public Employee_default() {
        eno = 38;
        name = "Nawazuddin";
        Salary = 1e4f;
    }
    public void showData(){
        System.out.println("eno: "+eno);
        System.out.println("name: "+name);
        System.out.println("Salary: "+Salary+"k\n");
    }
    public static void main(String[] args){
        Employee_default obj = new Employee_default();
        obj.showData();
    }
}


