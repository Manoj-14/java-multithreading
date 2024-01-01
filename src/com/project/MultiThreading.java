package com.project;


public class MultiThreading {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				throw new RuntimeException("Intensional Exception");
			}
		});
		thread.setName("Misbehaving Thread");
		thread.setUncaughtExceptionHandler((t, e) -> System.out.println("An Critical exception happend in the "+Thread.currentThread().getName()+" error is "+e.getMessage()));
		thread.start();
	}
}
