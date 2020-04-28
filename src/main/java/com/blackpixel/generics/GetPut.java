package com.blackpixel.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetPut {
    public static void main(String[] args) {
        List<A> aList = Arrays.asList(
                new A(),
                new A()
        );
        List<B> bList = Arrays.asList(
                new B(),
                new B()
        );
        

    }
}

class A{}

class B extends A{}

class C extends B{}

