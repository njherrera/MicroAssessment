package com.mucho;

public class Main {

    public static void main(String[] args) {
	String str = "a a a     bbb";
	String str2 = str.replaceAll("\\s", "");
        System.out.println(str2);
    }
}
