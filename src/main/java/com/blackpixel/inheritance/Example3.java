package com.blackpixel.inheritance;

public class Example3 {

    public static void main(String[] args) {
        A aRef = new B();
        Derived d = (Derived)aRef.m1();
    }
}

class Base { }

class Derived extends Base{ }

class A{
    public Base m1(){  System.out.println("Base m1()");  return new Derived(); }
}

class B extends A{
    @Override
    public Base m1(){ System.out.println("Derived m1()");  return new Base(); }
}
