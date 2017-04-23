package caveofprogramming.prodcons;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


class ProducerThread implements Runnable {

	public ProducerThread(Object parameter) {
		Integer a = (Integer)parameter;
		System.out.println("In constructor Producer Thread " + a);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random random = new Random();
		
		
		while(true) {
			try {
				GlobalQ.queue.put(random.nextInt(100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
}


class ConsumerThread implements Runnable {

	public ConsumerThread(Object parameter) {
		Integer a = (Integer)parameter;
		System.out.println("In constructor Consumer Thread " + a);
	}
	
	@Override
	public void run() {
		Random random = new Random();
		
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(random.nextInt(10) == 0) {
				Integer value;
				try {
					value = GlobalQ.queue.take();
					System.out.println("Taken value: " + value + "; Queue size is: " + GlobalQ.queue.size());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		}
		
		
		
	}
	
}


public class App {

	
	
	
	public static void main(String [] args) throws InterruptedException {

		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				try {
					producer();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		});

		Thread t2 = new Thread(new Runnable() {
			
			public void run() {
				try {
					consumer();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		});

		Thread t3 = new Thread(new ProducerThread(2));
		Thread t4 = new Thread(new ConsumerThread(3));
		t3.start();
		t4.start();
		
		t3.join();
		//t4.join();
		
		//t1.start();
		//t2.start();
		
		//t1.join();
		//t2.join();
		
		
		
		
	}
	
	private static void producer() {
		Random random = new Random();
		
		while(true) {
			try {
				Thread.sleep(500);
				GlobalQ.queue.put(random.nextInt(100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void consumer() throws InterruptedException {
		Random random = new Random();
		
		while(true) {
			Thread.sleep(100);
			
			if(random.nextInt(10) == 0) {
				Integer value = GlobalQ.queue.take();
				
				System.out.println("Taken value: " + value + "; Queue size is: " + GlobalQ.queue.size());
			}
			
		}
	}
	
}
