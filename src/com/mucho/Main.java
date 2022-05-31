package com.mucho;

import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
	String str = "-a a a 22     bbb";
        StringTokenizer str2 = new StringTokenizer(str);
        System.out.println(str2.countTokens());

        while (str2.hasMoreTokens()){
            System.out.println(str2.nextToken());
        }
    }
}
