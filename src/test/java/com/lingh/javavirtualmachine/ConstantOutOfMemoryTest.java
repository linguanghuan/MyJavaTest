package com.lingh.javavirtualmachine;

import java.util.ArrayList;
import java.util.List;

/**
 * 常量池内存溢出探究 http://www.cnblogs.com/dingyingsi/p/3760447.h
 * @VM args : -XX:PermSize=10K -XX:MaxPermSize=10K
 * @author test
 *
 */
public class ConstantOutOfMemoryTest {

	public static void main(String[] args) {
		try {
			List<String> strings = new ArrayList<String>();
			int i = 0;
			while (true) {
				strings.add(String.valueOf(i++).intern());
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}

/**
 1.7的java版本下没效果
Java HotSpot(TM) 64-Bit Server VM warning: ignoring option PermSize=10K; support was removed in 8.0
Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=10K; support was removed in 8.0
*/