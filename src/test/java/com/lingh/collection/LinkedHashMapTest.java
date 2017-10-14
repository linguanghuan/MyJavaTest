package com.lingh.collection;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LinkedHashMapTest {
	// http://yikun.github.io/2015/04/02/Java-LinkedHashMap%E5%B7%A5%E4%BD%9C%E5%8E%9F%E7%90%86%E5%8F%8A%E5%AE%9E%E7%8E%B0/
	public static void main(String[] args) {
		LinkedHashMap<String, Integer> lmap = new LinkedHashMap<String, Integer>();
		lmap.put("����", 1);
		lmap.put("��ѧ", 2);
		lmap.put("Ӣ��", 3);
		lmap.put("��ʷ", 4);
		lmap.put("����", 5);
		lmap.put("����", 6);
		lmap.put("����", 7);
		lmap.put("��ѧ", 8);
		for(Entry<String, Integer> entry : lmap.entrySet()) {
		    System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

}
