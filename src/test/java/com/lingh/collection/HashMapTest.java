package com.lingh.collection;

import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapTest {

	public static void main(String[] args) {
		// http://yikun.github.io/2015/04/01/Java-HashMap%E5%B7%A5%E4%BD%9C%E5%8E%9F%E7%90%86%E5%8F%8A%E5%AE%9E%E7%8E%B0/
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("����", 1);
		map.put("��ѧ", 2);
		map.put("Ӣ��", 3);
		map.put("��ʷ", 4);
		map.put("����", 5);
		map.put("����", 6);
		map.put("����", 7);
		map.put("��ѧ", 8);
		for(Entry<String, Integer> entry : map.entrySet()) {
		    System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

}
