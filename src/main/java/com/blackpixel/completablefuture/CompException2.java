package com.blackpixel.completablefuture;

import java.util.concurrent.CompletableFuture;

public class CompException2 {
	public static void main(String[] args) {
		
		int age = -5;
		
		CompletableFuture<String> ageFuture = CompletableFuture.supplyAsync(() -> {
		    if(age < 0) {
		        throw new IllegalArgumentException("Age can not be negative");
		    }
		    if(age > 18) {
		        return "Adult";
		    } else {
		        return "Child";
		    }
		}).exceptionally(ex -> {
		    System.out.println("Oops! We have an exception - " + ex.getMessage());
		    return "Unknown!";
		});
		
		System.out.println(ageFuture.join());
	}
}
