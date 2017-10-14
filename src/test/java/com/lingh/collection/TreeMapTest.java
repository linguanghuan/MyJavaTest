package com.lingh.collection;

import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapTest {
	// http://yikun.github.io/2015/04/06/Java-TreeMap%E5%B7%A5%E4%BD%9C%E5%8E%9F%E7%90%86%E5%8F%8A%E5%AE%9E%E7%8E%B0/
	public static void main(String[] args) {
		TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();
		tmap.put(1, "����");
		tmap.put(3, "Ӣ��");
		tmap.put(2, "��ѧ");
		tmap.put(4, "����");
		tmap.put(5, "��ʷ");
		tmap.put(6, "����");
		tmap.put(7, "����");
		tmap.put(8, "��ѧ");
		for (Entry<Integer, String> entry : tmap.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

}
