package lesson4;

class MyClass implements Runnable {
	
	public void run() {
		
		
	}
}

public class Demo {

	private static int count = 0;

	public static synchronized void incCount() {
		count++;
	}
	
	public static void main(String [] args)  {
		Thread t1 = new Thread (new Runnable(){
			
			public void run() {
				System.out.println(Thread.currentThread().getId());
				
				for (int i=0;i<10000;i++) {
					incCount();
					//count++;
					//if(count % 10 == 0) 
					//	System.out.println(Thread.currentThread().getId() + " Count inside: " + count);
					
				}
			}
			
		});
		t1.start();
		Thread t2 = new Thread (new Runnable(){
			
			public void run() {
				System.out.println();
				
				for (int i=0;i<10000;i++) {
					incCount();
					//if(count % 10 == 0) 
					//	System.out.println(Thread.currentThread().getId() + " Count inside: " + count);
				}
			}
			
		});
		t2.start();
		
		try {
			t1.join();
			System.out.println("joined");
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Count outside: " + count);
	}
}
