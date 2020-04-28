package com.blackpixel.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompException3 {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);

		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
			return "Value from future1";
		}, executor);
	
		CompletableFuture<String> future2 = future1.thenApply(
				v -> {throw new RuntimeException("Noooo - " + v);});

		// What happens when we have another Future in the pipeline that doesn't handle the exception?
		// You'll need to change the code below as well to future3.whenComplete((v, err)...
//		CompletableFuture<String> future3 = future2.thenApply(
//				v -> v + " Value from future3"
//		);
		
		future2.whenComplete((v, err) -> {
			if(v != null) {
				System.out.println(v);
			}else {
				System.out.println("Handling: " + err.getMessage());
			}
		});
		
		executor.shutdown();
		try {
			executor.awaitTermination(2, TimeUnit.SECONDS);
			executor.shutdownNow();
		} catch (InterruptedException e) {
			e.printStackTrace();
			executor.shutdownNow();
		}
	}
}
