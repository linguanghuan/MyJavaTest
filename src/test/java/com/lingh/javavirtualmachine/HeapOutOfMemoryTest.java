package com.lingh.javavirtualmachine;

import java.util.ArrayList;

class TestCase {

}

public class HeapOutOfMemoryTest {
	// http://www.cnblogs.com/dingyingsi/p/3760447.html
	// debug vm param: -verbose:gc -Xms20M -Xmx20M -XX:+PrintGCDetails
	public static void main(String[] args) {
		ArrayList<TestCase> cases = new ArrayList<TestCase>();
		while (true) {
			cases.add(new TestCase());
		}
	}
}
