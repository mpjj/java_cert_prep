package com.blackpixel.basicjava;

public class Example2 {
    public static void main(String[] args) {
        int count=3, total = 1;
        do{
            if(total % 2 == 0)
                continue;
            total += count;
        }while(++count <= 10);
        System.out.println(total);

    }
}
