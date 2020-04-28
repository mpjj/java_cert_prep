package com.blackpixel.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompException1 {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);

		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
			throw new RuntimeException("Noooo");
			//return "Hello";
		}, executor);
	
		CompletableFuture<String> future2 = future1.exceptionally(
				ex -> "We have a problem " + ex.getMessage());
		
		future2.thenAccept(System.out::println);
		
		executor.shutdown();
		try {
			executor.awaitTermination(2, TimeUnit.SECONDS);
			executor.shutdownNow();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
