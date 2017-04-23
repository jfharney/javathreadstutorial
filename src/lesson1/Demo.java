package lesson1;

class MyClass extends Thread {
	
	@Override
	public void run() {
		System.out.println("In MyClass run");
		for (int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getId() + " Value: " + i);
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

public class Demo {

	public static void main(String [] args) {
		System.out.println("Demo1");

		MyClass myClass1 = new MyClass();
		myClass1.start();
		MyClass myClass2 = new MyClass();
		myClass2.start();
		
	}
	
}
