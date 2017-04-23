package caveofprogramming.demo4;

import java.util.Scanner;

class Processor implements Runnable {
	private volatile boolean running = true;
	public void run() {
		while(running) {
			System.out.println("Hello");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void shutdown() {
		running = false;
	}
	
}
/*
class Processor extends Thread {
	
	private volatile boolean running = true;
	
	public void run() {
		
		while(running) {
			System.out.println("Hello");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown() {
		running = false;
	}
}
*/

class Processor2 extends Thread {
	public void run() {
		
	}
}

public class App {

	public static void main(String [] args) {
		
		Thread t1 = new Thread(new Processor());
		
		Thread t2 = new Thread(new Processor());
		
		t1.start();
		System.out.println("Press return to stop");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		Processor proc1 = new Processor();
		proc1.start();
		
		System.out.println("Press return to stop");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		proc1.shutdown();
		*/
		
	}
	
}
