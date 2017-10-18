package com.lingh.waitVSsynchronized;

/**
 * http://www.cnblogs.com/benshan/p/3551987.html
 *
 */
public class WaitVSSynchronizedTest {
	public static final Object obj = new Object();
    
    public static void main(String[] args) {
           new Thread( new Producer()).start();
           new Thread( new Consumer()).start();
    }
}
