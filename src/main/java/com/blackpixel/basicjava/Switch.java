package com.blackpixel.basicjava;

public class Switch {

    private enum Weekend {
        SAT, SUN;
    }
    public static void main(String[] args) {
        Weekend theDay = Weekend.SAT;
        switch(theDay){
            case SAT:
                System.out.println("It's Sat, yay!");
                break;
            case SUN:
                System.out.println("It's Sun, lazy day!");
        }
    }
}
