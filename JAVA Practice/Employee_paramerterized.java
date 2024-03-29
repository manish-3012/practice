package com.advancedJava;

public class Employee_paramerterized {
    public int eno;
    public String name;
    public float Salary;

    public Employee_paramerterized(int eno_, String name_, float Salary_) {
        eno = eno_;
        name = name_;
        Salary = Salary_;
    }
    public void showData(){
        System.out.println("eno: "+eno);
        System.out.println("name: "+name);
        System.out.println("Salary: "+Salary+"k\n");
    }
    public static void main(String[] args){
        Employee_paramerterized obj = new Employee_paramerterized(1, "Ashu", 23f);
        obj.showData();
    }
}


