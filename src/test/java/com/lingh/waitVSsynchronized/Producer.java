package com.lingh.waitVSsynchronized;

public class Producer implements Runnable {

	@Override
	public void run() {
		int count = 10;
		while (count > 0) {
			synchronized (WaitVSSynchronizedTest.obj) {
				// 获得锁
				System.out.println("count = " + count);
				System.out.println("P");
				count--;
				try {
					WaitVSSynchronizedTest.obj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				WaitVSSynchronizedTest.obj.notify();
			}
		}
	}
}