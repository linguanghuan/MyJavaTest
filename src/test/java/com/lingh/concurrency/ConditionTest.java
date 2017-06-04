package com.lingh.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * https://www.tutorialspoint.com/java_concurrency/concurrency_condition.htm
 * https://my.oschina.net/004/blog/467286
 * 问题:lock后其他线程进入不了了不是?
 * 答案:await会释放锁吧，看官方Condition的文档, f2查看await和singal的说明
 */
public class ConditionTest {

    static class NumberWrapper {
        public int value = 1;
    }

    public static void main(String[] args) {
        // 初始化可重入锁
        final Lock lock = new ReentrantLock();

        // 第一个条件当屏幕上输出到3
        final Condition reachThreeCondition = lock.newCondition();
        // 第二个条件当屏幕上输出到6
        final Condition reachSixCondition = lock.newCondition();

        // NumberWrapper只是为了封装一个数字，一边可以将数字对象共享，并可以设置为final
        // 注意这里不要用Integer, Integer 是不可变对象
        final NumberWrapper num = new NumberWrapper();
        // 初始化A线程
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                // 需要先获得锁
                lock.lock();
                try {
                    System.out.println("threadA start write");
                    // A线程先输出前3个数
                    while (num.value <= 3) {
                        System.out.println(num.value);
                        num.value++;
                    }
                    // 输出到3时要signal，告诉B线程可以开始了
                    reachThreeCondition.signal();
                } finally {
                    lock.unlock();
                }
                lock.lock();
                try {
                    // 等待输出6的条件
                    // Causes the current thread to wait until it is signalled
                    // or interrupted.
                    // 【The lock associated with this Condition is atomically
                    // released】 and the current thread becomes disabled for
                    // thread scheduling purposes and lies dormant until one of
                    // four things happens:
                    reachSixCondition.await(); // f2查看await的说明, 这里调用的时候会自动释放锁,
                                               // 等singal通知条件满足的时候重获锁
                    System.out.println("threadA start write");
                    // 输出剩余数字
                    while (num.value <= 9) {
                        System.out.println(num.value);
                        num.value++;
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();

                    while (num.value <= 3) {
                        // 等待3输出完毕的信号
                        reachThreeCondition.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                try {
                    lock.lock();
                    // 已经收到信号，开始输出4，5，6
                    System.out.println("threadB start write");
                    while (num.value <= 6) {
                        System.out.println(num.value);
                        num.value++;
                    }
                    // 4，5，6输出完毕，告诉A线程6输出完了
                    // F2: If any threads are waiting on this condition then one
                    // is selected for waking up. That thread must then
                    // re-acquire the lock before returning from await
                    reachSixCondition.signal();
                } finally {
                    lock.unlock();
                }
            }

        });

        // 启动两个线程
        threadB.start();
        threadA.start();
    }

}
