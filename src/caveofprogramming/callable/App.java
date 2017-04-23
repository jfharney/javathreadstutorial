package caveofprogramming.callable;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {

	
	public static void main(String [] args) {
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		Future<?> future = executor.submit(new Callable<Void>() {
			
			@Override
			public Void call() throws Exception {
				// TODO Auto-generated method stub
				
				Random random = new Random();
				int duration = random.nextInt(4000);
				
				if (duration > 2000) {
					throw new IOException("Sleeping for too long");
				}
				
				try {
					Thread.sleep(duration);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("starting...");
				
				System.out.println("finished.");
				
				return null;
			}
		});
		
		executor.shutdown();
		
		
		try {
			System.out.println("result is: " + future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			IOException ex = (IOException)e.getCause();
			System.out.println(ex.getMessage());
			System.out.println(e.getMessage());
		}
		
	}
	
}
