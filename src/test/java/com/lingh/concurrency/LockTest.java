package com.lingh.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * https://www.tutorialspoint.com/java_concurrency/concurrency_lock.htm
 */
class PrintDemo {
    // reentrant [riː'entrənt] n.凹角,再进入 adj.再进去的,凹角的
    private final Lock queueLock = new ReentrantLock();

    public void print() {
        queueLock.lock();
        try {
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() + " Time Taken " + (duration / 1000) + " seconds.");
            Thread.sleep(duration);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.printf("%s print the ducument successfully.\n", Thread.currentThread().getName());
            queueLock.unlock();
        }
    }
}

class ThreadDemo extends Thread {
    private PrintDemo pd = null;

    public ThreadDemo(PrintDemo pd) {
        this.pd = pd;
    }

    @Override
    public void run() {
        System.out.printf("%s begin to print \n", Thread.currentThread().getName());
        pd.print();
    }
}

public class LockTest {

    public static void main(String[] args) {
        PrintDemo pd = new PrintDemo();

        ThreadDemo t1 = new ThreadDemo(pd);
        ThreadDemo t11 = new ThreadDemo(pd);
        ThreadDemo t111 = new ThreadDemo(pd);
        ThreadDemo t1111 = new ThreadDemo(pd);
        t1.start();
        t11.start();
        t111.start();
        t1111.start();
    }

}
