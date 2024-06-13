package com.juaracoding;

public class Main {
    public static void main(String[] args) {
        String captcha = "5 + 9";
        int num1 = Integer.parseInt(captcha.substring(0,2).trim());
        int num2 = Integer.parseInt(captcha.substring(captcha.length()-1));
        System.out.println(num1+num2);
    }
}