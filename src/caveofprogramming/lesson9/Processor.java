package caveofprogramming.lesson9;

import java.util.LinkedList;
import java.util.Random;

public class Processor {

	private LinkedList<Integer> list = new LinkedList<Integer>();
	private final int LIMIT = 10;
	private Object lock = new Object();
	
	
	public void produce() throws InterruptedException {
		
		int value = 0;
		
		while(true) {
			synchronized(lock) {
				
				while(list.size() == LIMIT) {
					lock.wait();
				}
				System.out.println("Adding value: " + value + " to queue");
				list.add(value++);
				lock.notifyAll();
			}
		}
		
		
	}
	
	public void producer2() throws InterruptedException {
		
		int value = 0;
		
		while(true) {
			synchronized(lock) {
				
				while(list.size() == LIMIT) {
					lock.wait();
				}
				System.out.println("Adding value: " + value + " to queue");
				list.add(value--);
				lock.notifyAll();
			}
		}
		
	}
	
	
	public void consume() throws InterruptedException {
		
		
		Random random = new Random();
		
		while(true) {
			
			synchronized(lock) {
				
				while(list.size() == 0) {
					lock.wait();
				}
				System.out.print("C1... List size is: " + list.size());
				int value = list.removeFirst();
				System.out.println("; value is: " + value);
				lock.notifyAll();
			}
			
			Thread.sleep(random.nextInt(1000));
			
		}
		
	}
	
	public void consumer2() throws InterruptedException {
		
		
		Random random = new Random();
		
		while(true) {
			
			synchronized(lock) {
				
				while(list.size() == 0) {
					lock.wait();
				}
				System.out.print("C2... List size is: " + list.size());
				int value = list.removeFirst();
				System.out.println("; value is: " + value);
				lock.notifyAll();
			}
			
			Thread.sleep(random.nextInt(1000));
			
		}
		
	}

	
	
	
}
