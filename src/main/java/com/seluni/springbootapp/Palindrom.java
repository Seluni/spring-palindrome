package com.seluni.springbootapp;

public class Palindrom {

    public static boolean isPalindrome(String str) {
        if (str == null)
            return false;
        str = str.replaceAll("\\s+", "").toLowerCase();
        StringBuilder strBuilder = new StringBuilder(str);
        strBuilder.reverse();
        return strBuilder.toString().equals(str);
    }

    public static int getPoints(String pal){
        return pal.replaceAll("\\s+", "").length();
    }

}
