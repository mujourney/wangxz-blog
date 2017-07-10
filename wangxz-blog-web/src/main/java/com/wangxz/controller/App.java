package com.wangxz.controller;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        int test = test();
        System.out.println(test);
    }

    public static int test() {
        int i = 0;
        try {
            i++;
            new Exception();
            return 10;
        } catch (Exception e) {
            e.printStackTrace();
            return 100;
        } finally {
            return 1000;
        }
    }
}
