package com.lingh.baseknowledge;

public class FuncArgRefTest {

	public static String change(String s) {
		s = "222";
		return s;
	}
	
	public static void testString() {
		String s = "111";
		change(s);
		System.out.println(s); // 111
	}
	
	public static void changeStringBuffer(StringBuffer sb){
        sb.append(" new");
    }
	
	public static void testStringBuffer() {
		StringBuffer sb = new StringBuffer("org");
		changeStringBuffer(sb);
		System.out.println(sb.toString()); // org new
		
	}
	
	public static void main(String[] args) {
		testString(); 
		testStringBuffer();   
	}

}
