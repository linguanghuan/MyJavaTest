package com.lingh.javavirtualmachine;

public class StackOverFlowTest {
	private int i;

	public void plus() {
		i++;
		plus();
	}

	public static void main(String[] args) {
		// http://www.cnblogs.com/dingyingsi/p/3760447.html
		// -Xss128k
		StackOverFlowTest stackOverFlow = new StackOverFlowTest();
		try {
			stackOverFlow.plus();
		} catch (Exception e) {
			System.out.println("Exception:stack length:" + stackOverFlow.i);
			e.printStackTrace();
		} catch (Error e) {
			System.out.println("Error:stack length:" + stackOverFlow.i);
			e.printStackTrace();
		}
	}
}
