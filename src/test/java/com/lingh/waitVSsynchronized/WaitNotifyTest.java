package com.lingh.waitVSsynchronized;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * http://blog.csdn.net/lsgqjh/article/details/61915074
 */
public class WaitNotifyTest {

	public static void main(String[] args) {
//		  final Object lock = new Object();
        final Lock lock = new ReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread A is waiting to get lock");
                synchronized (lock) {
                    try {
                        System.out.println("thread A get lock");
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println("thread A do wait method");
                        lock.wait();
                        System.out.println("thread A wait end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread B is waiting to get lock");
                synchronized (lock) {
                    System.out.println("thread B get lock");
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread B do notify method");
                    lock.notify();
                    System.out.println("thread A will be alive in five seconds");
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                try {
                    System.out.println("thread B aready notify thread A");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("特么我睡醒了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
	}

}
