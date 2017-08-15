package com.lingh.enumm;

enum Color {
    RED(0), GREEN(1), BLUE(2);
    int value;

    Color(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}

public class EnumTest {
    public static void main(String[] args) {
        System.out.println(Color.RED);
        System.out.println(Color.RED.value);
        System.out.println(Color.BLUE.getValue());
    }
}
