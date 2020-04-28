package com.blackpixel.exceptions;

public class Example3 {
    public static void m1(){
        try{
            throw new MyExceptionA("Exception A");
        }finally{
            throw new MyExceptionB("Exception B");
        }
    }

    public static void main(String[] args) {
        m1();
    }
}

class MyExceptionA extends RuntimeException{
    public MyExceptionA(String message) {
        super(message);
    }
}

class MyExceptionB extends RuntimeException{
    public MyExceptionB(String message) {
        super(message);
    }}

