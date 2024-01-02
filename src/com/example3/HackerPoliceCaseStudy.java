package com.example3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HackerPoliceCaseStudy {
	public static final int MAX_PASSWORD = 9999;
	public static void main(String[] args) {
		
		Random random = new Random();
		Vault vault = new Vault(random.nextInt(MAX_PASSWORD));
		List<Thread> threads = new ArrayList<>();
		threads.add(new AscendingHackerThread(vault));
		threads.add(new DecendingHackerThread(vault));
		threads.add(new PoliceThread());
		
		for(Thread thread:threads) {
			thread.start();
		}
		
	}
	
	private static class Vault{
		private int passward;
		
		public Vault(int passward) {
			this.passward = passward;
		}
		
		public boolean isCorrectPassword(int guess) {
			try{
				Thread.sleep(5);
			}catch(InterruptedException e) {
				
			}
			
			return this.passward == guess;
		}
	}
	
	private static abstract class HackerThread extends Thread{
		protected Vault vault;
		public HackerThread(Vault vault) {
			this.vault = vault;
			this.setName(this.getClass().getSimpleName());
			this.setPriority(MAX_PRIORITY);
		}
		
		@Override
		public synchronized void start() {
			System.out.println("Starting Thread "+ this.getName());
			super.start();
		}
	}
	
	private static class AscendingHackerThread extends HackerThread{
		public AscendingHackerThread(Vault vault) {
			super(vault);
		}
		
		@Override
		public void run() {
			for(int guess=0; guess < MAX_PASSWORD ; guess++) {
				if(vault.isCorrectPassword(guess)){
					System.out.println(this.getName()+" guessed the password "+guess);
					System.exit(0);
				}
			}
		}
	}
	
	private static class DecendingHackerThread extends HackerThread{

		public DecendingHackerThread(Vault vault) {
			super(vault);
		}
		
		@Override
		public void run() {
			for(int guess=MAX_PASSWORD; guess >= 0 ; guess--) {
				if(vault.isCorrectPassword(guess)){
					System.out.println(this.getName()+" guessed the password "+guess);
					System.exit(0);
				}
			}
		}
	}
	
	private static class PoliceThread extends Thread{
		@Override
		public void run() {
			for(int i = 10 ; i> 0 ; i--) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(i);
			}
			System.out.println("Game over hackers...!");
			System.exit(0);
		}
	}
}
