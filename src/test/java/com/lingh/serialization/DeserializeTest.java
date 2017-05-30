package com.lingh.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee e = null;
		FileInputStream fileIn = null;
		ObjectInputStream in = null;
		try {
			fileIn = new FileInputStream("employee.ser");
			in = new ObjectInputStream(fileIn);
			e = (Employee)in.readObject();
			System.out.println("deserialized success");
			System.out.println("Name:" + e.name);
			System.out.println("Address:" + e.address);
			System.out.println("SSN:" + e.SSN);   //SSN:0, 因为SSN声明为transient
			System.out.println("Number:" + e.number);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (fileIn != null) {
					fileIn.close();	
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}

	}

}
