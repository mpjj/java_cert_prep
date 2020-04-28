package com.blackpixel.completablefuture;

import java.util.concurrent.CompletableFuture;

public class Comp4 {
	public static void main(String[] args) {
		
		CompletableFuture<Integer> future1 = NumberService.getIntegerAsync();
		
		CompletableFuture<Integer> future2 = future1.thenComposeAsync(
				i -> NumberService.squareItAsync(i));

		//  The code below does not compile because it returns a CompletableFuture<CompletableFuture<Integer>>
		//  ie it is operating as map() rather than flatMap()
//		CompletableFuture<Integer> future4 = future1.thenApplyAsync(
//				(Integer i) -> NumberService.squareItAsync(i));

		CompletableFuture<Integer> future3 = future2.thenComposeAsync(
				i -> NumberService.cubeItAsync(i));


		System.out.println(future3.join());

	}
}
