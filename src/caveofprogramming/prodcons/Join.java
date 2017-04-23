package caveofprogramming.prodcons;

import java.util.logging.Level;
import java.util.logging.Logger;


class Task implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " is started");
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " is completed");
		} catch (InterruptedException ex) {
			Logger.getLogger(Join.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}
	
	
	
}


public class Join {

	
	public static void main(String [] args) throws InterruptedException {
		
		System.out.println(Thread.currentThread().getName() + " is started");
		
		Thread exampleThread = new Thread(new Runnable() {

			@Override
			public void run() {
				Thread embeddedThread = new Thread(new Task());
				embeddedThread.start();
				
				// TODO Auto-generated method stub
				try {
					System.out.println(Thread.currentThread().getName() + " is started");
					Thread.sleep(2000);
				} catch (InterruptedException ex) {
					Logger.getLogger(Join.class.getName()).log(Level.SEVERE, null, ex);
				}
				
				try {
					embeddedThread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

				System.out.println(Thread.currentThread().getName() + " is completed");
			}
			
			
			
		});
		
		exampleThread.start();
		exampleThread.join();
		
		System.out.println(Thread.currentThread().getName() + " is Completed");
		
	}
	
	
}
