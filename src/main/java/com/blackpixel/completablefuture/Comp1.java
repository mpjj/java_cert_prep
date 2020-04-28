package com.blackpixel.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Comp1 {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		System.out.println("Setting up Future in main. Thread ID: " + Thread.currentThread().getId());

		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			System.out.println("Thread spawned by supplyAsync is working.  Thread ID: " + Thread.currentThread().getId());
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Hello Completable World!";
		}, executor);

		System.out.println("Getting value from CompletableFuture");

		try {
			while (!future.isDone()) {
				System.out.println("Waiting ...");
				Thread.sleep(250);
			}
			String msg = future.get();
			System.out.println("Obtained result: " + msg);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		
		executor.shutdown();
		try {
			executor.awaitTermination(2, TimeUnit.SECONDS);
			executor.shutdownNow();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
