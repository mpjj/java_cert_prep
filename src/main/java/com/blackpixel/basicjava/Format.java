package com.blackpixel.basicjava;

public class Format {
    public static void main(String[] args) {
        int intValue = 4;
        double dblValue1 = 10_000.987;
        double dblValue2 = -12_345.6789;
        System.out.format("Total is: £%,.2f%n", dblValue1);
        System.out.format("Total is: %-12.2f: %n", dblValue2);
        System.out.format("%04d%n", intValue);
    }
}
