package com.lingh.collection;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LinkedHashMapTest {
	// http://yikun.github.io/2015/04/02/Java-LinkedHashMap%E5%B7%A5%E4%BD%9C%E5%8E%9F%E7%90%86%E5%8F%8A%E5%AE%9E%E7%8E%B0/
	public static void main(String[] args) {
		LinkedHashMap<String, Integer> lmap = new LinkedHashMap<String, Integer>();
		lmap.put("语文", 1);
		lmap.put("数学", 2);
		lmap.put("英语", 3);
		lmap.put("历史", 4);
		lmap.put("政治", 5);
		lmap.put("地理", 6);
		lmap.put("生物", 7);
		lmap.put("化学", 8);
		for(Entry<String, Integer> entry : lmap.entrySet()) {
		    System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

}
