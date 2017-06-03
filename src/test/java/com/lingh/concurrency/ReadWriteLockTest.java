package com.lingh.concurrency;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    // why static?
    // https://stackoverflow.com/questions/9560600/java-no-enclosing-instance-of-type-foo-is-accessible
    static class Reader implements Runnable {
        public void run() {
            String name = Thread.currentThread().getName();
            lock.readLock().lock();
            Long duration = (long) (Math.random() * 10000);
            System.out.println(name + " sleep " + (duration / 1000) + "seconds.");
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(name + " realse read lock");
                lock.readLock().unlock();
            }
        }
    }

    static class Writer implements Runnable {

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            // lock.writeLock().lock();
            try {
                Long duration = (long) (Math.random() * 10000);
                System.out.println(name + "  Time Taken " + (duration / 1000) + " seconds.");
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(name + " realse write lock");
                // lock.writeLock().unlock();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Writer(), "writer-1").start();
        new Thread(new Writer(), "writer-2").start();
        new Thread(new Reader(), "reader-1").start();
        new Thread(new Reader(), "reader-2").start();
        new Thread(new Writer(), "writer-3").start();
    }

}
