package com.lingh.concurrency;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * http://blog.csdn.net/cutesource/article/details/6061229
 * http://hubingforever.blog.163.com/blog/static/1710405792010964339151/
 */
public class ThreadPoolExecutorTest {
    private static final Integer CORE_POOL_SIZE = 3;
    private static final Integer MAX_NUM_POOL_SIZE = 6;
    private static final Integer KEEP_ALIVE_TIME = 30;

    public static class TestTask implements Runnable {
        private int id;
        public TestTask(int id) {
            this.id = id;
        }
        @Override
        public void run() {
            String context = Thread.currentThread().getName() + "-" + id;
            System.out.println(context + " start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(context + " stop");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Runnable> threadQueue = new LinkedBlockingQueue<>(MAX_NUM_POOL_SIZE * 2);   // 异常是根据队列大小抛出的
        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_NUM_POOL_SIZE, KEEP_ALIVE_TIME,
                TimeUnit.MINUTES, threadQueue);   // CORE_POOL_SIZE是初始线程数, MAX_NUM_POOL_SIZE是最大线程数
        for (int i = 0; i < 40; i++) {
            TestTask testTask = new TestTask(i);
            executor.execute(testTask);
        }
        System.out.println("------------------");
        System.out.println(threadQueue.size());
        Thread.sleep(50000);
        System.out.println(threadQueue.size());

    }

}
