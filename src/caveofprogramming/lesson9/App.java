package caveofprogramming.lesson9;

public class App {

	public static void main(String [] args) {
		
		final Processor processor = new Processor();
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
					processor.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});

		Thread t3 = new Thread(new Runnable() {
	
			public void run() {
				try {
					processor.producer2();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});

		Thread t4 = new Thread(new Runnable() {
	
			public void run() {
				try {
					processor.consumer2();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
	
}
