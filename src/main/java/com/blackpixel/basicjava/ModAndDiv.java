package com.blackpixel.basicjava;

public class ModAndDiv {
    public static void main(String[] args) {
        double valueOne = 14.0;
        double valueTwo = 5.0;
        double resultDouble = valueOne/valueTwo;
        System.out.println(resultDouble);

        int i = 15;
        int j = 4;
        int resultInt = i/j;
        int remainder = i%j;
        System.out.format("resultInt: %d, remainder %d", resultInt, remainder);
    }
}
