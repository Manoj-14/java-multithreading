package com.project;

public class MultiThreading {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("We are now in thread "+Thread.currentThread().getName());
				System.out.println(Thread.currentThread().getName()+" priority is "+Thread.currentThread().getPriority());
			}
		});
		thread.setName("New Worker Thread");
		thread.setPriority(Thread.MAX_PRIORITY);
		System.out.println("Before starting the thread "+ Thread.currentThread().getName());
		thread.start();
		System.out.println("After starting the thread "+ Thread.currentThread().getName());
		Thread.sleep(10000);
	}
}
