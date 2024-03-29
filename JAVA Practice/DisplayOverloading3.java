package com.advancedJava;

class DisplayOverloading3
{
    public void disp(char c, int num)
    {
        System.out.println("char : int");
    }
    public void disp(int num, char c)
    {
        System.out.println("int : char" );
    }
    public void disp(int a, int b, int c)
    {
        System.out.println("int : int : int");
    }
}
class Test
{
    public static void main(String[] args)
    {
        DisplayOverloading3 obj = new DisplayOverloading3();
        obj.disp('x', 51 );
        obj.disp(52, 'y');
        obj.disp(2,3,4);
    }
}