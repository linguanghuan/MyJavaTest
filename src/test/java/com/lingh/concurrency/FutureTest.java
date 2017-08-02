package com.lingh.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * http://www.oschina.net/question/54100_83333
 * 试验 Java 的 Future 用法
 */
public class FutureTest {

    public static class Task implements Callable<String> {
        private int id;
        public Task (int id) {
            this.id = id;
        }
        
        @Override
        public String call() throws Exception {
            String threadName = String.valueOf(Thread.currentThread().getName()) + "_" + id;
            int random = new Random().nextInt(5);
            random++;
            System.out.printf("%s, %d : start\n", threadName, random);
            Thread.sleep(1000 * random);
            System.out.printf("%s : end\n", threadName);
            return threadName + ": future print";
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Future<String>> results = new ArrayList<Future<String>>();
//        ExecutorService es = Executors.newCachedThreadPool();
        ExecutorService es = Executors.newFixedThreadPool(5);
        for(int i=0; i<100;i++)
            results.add(es.submit(new Task(i)));

        for(Future<String> res : results)
            System.out.println("----" + res.get());
    }

}