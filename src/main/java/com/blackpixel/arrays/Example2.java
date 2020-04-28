package com.blackpixel.arrays;

import java.util.Arrays;

public class Example2 {
    public static void main(String[] args) {
    int [][] array = {
            {7,8,9,10},
            {123},
            {4,5,6}};

        //Array doesn't implement Comparable
		Arrays.sort(array);

		for(int [] row: array){
            for(int i=0; i< row.length; i++){
            System.out.printf("%d ", row[i]);
            }
        }
    }

}
