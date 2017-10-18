package com.lingh.waitVSsynchronized;

public class Consumer implements Runnable {

	@Override
	public synchronized void run() {
		int count = 10;
		while (count > 0) {
			synchronized (WaitVSSynchronizedTest.obj) {
				System.out.println("C");
				count--;
				WaitVSSynchronizedTest.obj.notify(); 
				try {
					WaitVSSynchronizedTest.obj.wait();
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
