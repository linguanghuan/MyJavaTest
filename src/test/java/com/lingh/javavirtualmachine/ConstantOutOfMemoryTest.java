package com.lingh.javavirtualmachine;

import java.util.ArrayList;
import java.util.List;

/**
 * �������ڴ����̽�� http://www.cnblogs.com/dingyingsi/p/3760447.h
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
 1.7��java�汾��ûЧ��
Java HotSpot(TM) 64-Bit Server VM warning: ignoring option PermSize=10K; support was removed in 8.0
Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=10K; support was removed in 8.0
*/