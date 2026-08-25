package com.app4;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String string = "animals";
System.out.println(string.indexOf("al"));
System.out.println(string.indexOf("al", 5));

StringBuilder sb = new StringBuilder("ABC");
sb.reverse();
System.out.println(sb);
    }
}