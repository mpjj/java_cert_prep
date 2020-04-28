package com.blackpixel.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Comp3b {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		System.out.println("Setting up Future in main method. Thread ID: " + Thread.currentThread().getId());

		CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
			System.out.println("future1 Thread ID: " + Thread.currentThread().getId());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return 6;
		}, executor);
		
		CompletableFuture<Integer> future2 = future1.thenApplyAsync(v -> {
			System.out.println("future2 Thread ID: " + Thread.currentThread().getId());
			return v * 7;});

		//If we don't want to pass anything down the future chain thenAccept() takes a Consumer functional interface
//		CompletableFuture<Void> future3 = future2.thenAccept(v -> {
//				System.out.println("future3 Thread ID: " + Thread.currentThread().getId());
//				System.out.println(v);});
//
//		future3.join();

		// a more succinct way of doing the same thing - no need to call join()
		future2.thenAccept(System.out::println);
		
		executor.shutdown();
		try {
			executor.awaitTermination(4, TimeUnit.SECONDS);
			executor.shutdownNow();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
