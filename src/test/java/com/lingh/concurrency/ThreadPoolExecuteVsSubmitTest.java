package com.lingh.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolExecuteVsSubmitTest {

	public static void main(String[] args) {
		// http://blog.csdn.net/u010458765/article/details/53063762
		ExecutorService pool = Executors.newFixedThreadPool(2);
		try {
			pool.execute(new TestTask("ExecuteTask"));
		} catch (Exception e) {
			// 捕获不到
			System.out.println(e.getMessage());
		}
		
		Future<?> future = pool.submit(new TestTask("SubmitTask"));
		try {
			if (future.get() == null) {
				System.out.println("任务完成");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			// 可以捕获
			System.out.println(e.getMessage());
		}
	}

}

class TestTask implements Runnable {
	private String taskName;

	public TestTask(final String taskName) {
		this.taskName = taskName;
	}

	@Override
	public void run() {
		System.out.println("run task:" + taskName);
		throw new RuntimeException("exception for:" + taskName);
	}

}
