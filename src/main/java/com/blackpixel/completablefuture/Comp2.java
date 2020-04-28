package com.blackpixel.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Comp2 {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		System.out.println("Setting up Future");

		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Hello Completable World!";
		}, executor);

		System.out.println("Get value from CompletableFuture");

		//join() doesn't throw checked exceptions. Throws unchecked CompletionException. Not try/catch block needed
		// you can utilise exceptionally() method if necessary
		System.out.println(future.join());
		
		executor.shutdown();
		try {
			executor.awaitTermination(1, TimeUnit.SECONDS);
			executor.shutdownNow();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
