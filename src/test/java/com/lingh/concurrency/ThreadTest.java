package com.lingh.concurrency;

/*
 * http://mars914.iteye.com/blog/1508429
 */
class MyThread extends Thread {
	@Override
	public void run() {
		while (true) {
			System.out.println(this.getName());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyRunable implements Runnable {

	@Override
	public void run() {
		for (int i=0; i< 1000; i++) {
			System.out.println("Thread-33333333333333");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadTest {
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		t1.start();
		t2.start();
		Thread t3 = new Thread(new MyRunable());
		t3.start();
	}
}
