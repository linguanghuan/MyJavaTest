package com.lingh.serialization;

import java.io.Serializable;

public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2407156421728500923L;
	
	public String name;
	public String address;
//	All of the fields in the class must be serializable. If a field is not serializable, it must be marked transient.
	public transient int SSN;
	public int number;
	
	public void mailCheck() {
		System.out.println("mailing a check to " + name + " " + address);
	}

}
