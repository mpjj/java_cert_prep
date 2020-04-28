package com.blackpixel.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Example2 {
    public static void main(String[] args) {

        Runnable func1 = () -> {};

        //lambda as expression
        Supplier<String> func2 = () -> "Dub";
        //lambda body has a statement
        Function<String, String> func3 = (String s) -> {return s + "lin";};
        //same behaviour but lambda as an expression
        Function<String, String> func4 = (String s) -> s + "lin";

        Function<Integer, Integer> func5 = i -> i + 9;

        List<String> strings = Arrays.asList("Mike", "Bob");
        strings.stream()
                .map((String s) -> s + "lin")
                .forEach(System.out::println);

        List<Integer> ints = Arrays.asList(1,2,3);
        ints.stream()
                .map((Integer i) -> {return i + 9;})
                .forEach(System.out::println);
    }
}
