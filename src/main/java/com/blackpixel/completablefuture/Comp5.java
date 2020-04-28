package com.blackpixel.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Comp5 {
	// Combining the output of two CompletableFutures into one
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);

		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
			System.out.println("future1 Thread ID: " + Thread.currentThread().getId());
			return "Hello";
		}, executor);
	
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
			System.out.println("future2 Thread ID: " + Thread.currentThread().getId());
			return "World";
		}, executor);

		//supply a function that takes the two outputs as arguments
		CompletableFuture<String> future3 = future1.thenCombine(future2, 
				(string1, string2) -> string1 + " " + string2);
		
		future3.thenAccept(System.out::println);
		
		executor.shutdown();
		try {
			executor.awaitTermination(2, TimeUnit.SECONDS);
			executor.shutdownNow();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
