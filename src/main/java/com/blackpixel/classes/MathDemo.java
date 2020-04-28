package com.blackpixel.classes;

public class MathDemo {
    public static void main(String[] args) {
        double radius = 10.0;
        System.out.println("Circle area: " + Math.PI * radius * radius);

        double num = -10.5;

        System.out.println("Absolute value: " + Math.abs(num));
        System.out.println("Max of num,20:  " + Math.max(num, 20));
        System.out.println("Min of num,20:  " + Math.min(num, 20));
        System.out.println("Ceiling value:  " + Math.ceil(num));
        System.out.println("Floor value:    " + Math.floor(num));
        System.out.println("Rounded value:  " + Math.round(num));

        System.out.println("Random number: " + Math.random());

    }
}
