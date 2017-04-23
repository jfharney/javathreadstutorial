package caveofprogramming.demo5;

public class App {

	private int count = 0;
	
	public static void main(String [] args) {
		App app = new App();
		app.doWork();
	}
	
	public void doWork() {
		Thread t1 = new Thread(new Runnable() {
			public void run () {
				for (int i=0;i<10000;i++) {
					count++;
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run () {
				for (int i=0;i<10000;i++) {
					count++;
				}
			}
		});
		t1.start();
		t2.start();
		System.out.println("count is: " + count);
	}
	
}
