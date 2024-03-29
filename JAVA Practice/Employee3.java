package com.advancedJava;

public class Employee3 {
    public int eno;
    public String name;
    public float Salary;

    public Employee3(int eno, String name, float Salary) {
        this.eno = eno;
        this.name = name;
        this.Salary = Salary;
    }
    public void showData(){
        System.out.println("eno: "+eno);
        System.out.println("name: "+name);
        System.out.println("Salary: "+Salary+"k\n");
    }
    public static void main(String[] args){
        Employee3 obj = new Employee3(1, "Ashu", 23f);
        obj.showData();
    }
}


