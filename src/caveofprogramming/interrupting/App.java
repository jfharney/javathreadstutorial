package caveofprogramming.interrupting;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class App {

	
	public static void main(String [] args) throws InterruptedException {
		
		System.out.println("Starting...");
			
		ExecutorService exec = Executors.newCachedThreadPool();
		
		Future<?> fu = exec.submit(new Callable<Void> () {

			@Override
			public Void call() throws Exception {
				Random ran = new Random();
				
				for(int i=0;i<1E8;i++) {
					
					if(Thread.currentThread().isInterrupted()) {
						System.out.println("Interrupted");
						break;
					}
					/*
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						System.out.println("We've been interrupted");;
						break;
					}
					*/
					Math.sin(ran.nextDouble());
				}
				return null;
			}
			
		});
		
		exec.shutdown();
		
		Thread.sleep(500);
		
		//fu.cancel(true);
		
		exec.shutdownNow();
		
		exec.awaitTermination(1, TimeUnit.DAYS);
		
		/*
		Thread t = new Thread(new Runnable() {
			public void run() {
				Random ran = new Random();
				
				for(int i=0;i<1E8;i++) {
					
					if(Thread.currentThread().isInterrupted()) {
						System.out.println("Interrupted");
						break;
					}
					
					Math.sin(ran.nextDouble());
				}
			}
		});
		t.start();
		
		Thread.sleep(500);;
		
		t.interrupt();
		
		t.join();
		*/
		
				
		System.out.println("Finished");
		
	}
	
}
