package com.lingh.collection;

import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapTest {
	// http://yikun.github.io/2015/04/06/Java-TreeMap%E5%B7%A5%E4%BD%9C%E5%8E%9F%E7%90%86%E5%8F%8A%E5%AE%9E%E7%8E%B0/
	public static void main(String[] args) {
		TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();
		tmap.put(1, "语文");
		tmap.put(3, "英语");
		tmap.put(2, "数学");
		tmap.put(4, "政治");
		tmap.put(5, "历史");
		tmap.put(6, "地理");
		tmap.put(7, "生物");
		tmap.put(8, "化学");
		for (Entry<Integer, String> entry : tmap.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

}
