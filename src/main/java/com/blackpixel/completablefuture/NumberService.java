package com.blackpixel.completablefuture;

import java.util.concurrent.CompletableFuture;

public class NumberService {
	
	public static int squareIt(int i) {
		return i * i;
	}

	public static int cubeIt(int i) {
		return i * i * i;
	}
	
	
	public static CompletableFuture<Integer> getIntegerAsync(){
		return CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return 2;
		});
	}
	
	public static CompletableFuture<Integer> squareItAsync(int i){
		return CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return i * i;
		});
	}
	
	public static CompletableFuture<Integer> cubeItAsync(int i){
		return CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return i * i * i;
		});
	}
}
