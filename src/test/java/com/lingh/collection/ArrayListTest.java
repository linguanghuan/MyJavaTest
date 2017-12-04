package com.lingh.collection;

import java.util.ArrayList;

public class ArrayListTest {
	// http://yikun.github.io/2015/04/04/Java-ArrayList%E5%B7%A5%E4%BD%9C%E5%8E%9F%E7%90%86%E5%8F%8A%E5%AE%9E%E7%8E%B0/
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("语文: 99");
		list.add("数学: 98");
		list.add("英语: 100");
		list.remove(0);
	}

}
