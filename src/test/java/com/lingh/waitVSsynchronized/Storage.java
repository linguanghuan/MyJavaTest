package com.lingh.waitVSsynchronized;

import java.util.ArrayList;
import java.util.List;

public class Storage {
	private List<Object> foods;

	public final static int MAX_SIZE = 5;

	public Storage() {
		foods = new ArrayList<Object>();
	}

	public List<Object> getFoods() {
		return foods;
	}

	public void setFoods(List<Object> foods) {
		this.foods = foods;
	}
}
