package com.lingh.concurrency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 父子线程不要用同一个线程池，否则可能导致子线程或父线程一直占用住线程池资源
 * 之前碰到的一个情况是信号量控制的线程池, 父线程把所有的信号量都控制满了之后，子线程要再创建线程池的时候阻塞，所以子线程一直都无法执行完
 * 父线程也就会长久占用该信号量
 *
 */
public class SpringThreadPoolDeadLockTest {
    private static ThreadPoolTaskExecutor taskExecutor;

    static class Task1 implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("task 111111111" + Thread.currentThread().getName());
                try {
                    taskExecutor.execute(new Task2());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Task2 implements Runnable {

        @Override
        public void run() {
            while (true) {
                System.out.println("task 222222222" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        taskExecutor = (ThreadPoolTaskExecutor) context.getBean("taskExecutor");
        taskExecutor.execute(new Task1());
        taskExecutor.execute(new Task1());
        taskExecutor.execute(new Task1());
        taskExecutor.execute(new Task1());
        taskExecutor.execute(new Task1());
        taskExecutor.execute(new Task1());
    }
}
