package lesson3;

public class Demo {

	public static void main(String [] args) {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
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
		});
		t1.start();
	}
	
}
