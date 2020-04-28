package com.blackpixel.basicjava;

public class OperatorPrecedence {
        public static void main(String[] args) {

            int total1 = 10 + 30 / 5 -2;
            System.out.println(total1);

            int total2 = 10 + (30/5) -2;
            System.out.println(total2);

            int total3 = 20 - 30 + 50 -2;
            System.out.println(total3);


        }
}
