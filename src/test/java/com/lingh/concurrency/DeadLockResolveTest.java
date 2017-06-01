package com.lingh.concurrency;

/**
 * https://www.tutorialspoint.com/java_concurrency/concurrency_deadlock.htm
 * 请求资源顺序一致
 */
public class DeadLockResolveTest {
	public static Object lock1 = new Object();
	public static Object lock2 = new Object();

	public static void main(String[] args) {
		ThreadDemo1 t1 = new ThreadDemo1();
		ThreadDemo2 t2 = new ThreadDemo2();
		t1.start();
		t2.start();
	}
	
	/*
	why static?
	http://www.cnblogs.com/activity-life/p/3622850.html
	内部static类只能访问外部类的static对象和方法, lock1 lock2是静态变量可以访问
	*/
	private static class ThreadDemo1 extends Thread {
		public void run() {
			synchronized (lock1) {
				System.out.println("Thread 1: holding lock 1");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread 1: waiting for lock 2");
				synchronized (lock2) {
					System.out.println("Thread 1: holding lock 1&2");
				}
			}
		}
	}
	
	private static class ThreadDemo2 extends Thread{
		public void run() {
			synchronized (lock1) {
				System.out.println("Thread 2: holding lock 2");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread 2: watiging for lock 1");
				synchronized (lock2) {
					System.out.println("Thread 2: holding lock 1&2");	
				}
				
			}
		}
	}

}
