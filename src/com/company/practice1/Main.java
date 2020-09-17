package com.company.practice1;

import java.util.Arrays;
import java.util.Random;

public class Main {
    //5
    public static int Factorial(int k) {
        int res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * i;
        }
        return res;
    }

    public static void main(String[] args) {
        //1
        int arr[] = {1, 3, 6, 8, 10, 15, 19, 24};
        int s = 0;
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
        }
        System.out.println(s);
        s = 0;
        int a = 0;
        while (a < arr.length) {
            s += arr[a];
            a++;
        }
        System.out.println(s);
        s = 0;
        a = 0;
        do {
            s += arr[a];
            a++;
        } while (a < arr.length);
        System.out.println(s);
        //2
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        //3
        for (int i = 1; i < 11; i++) {
            System.out.println(1. / i);
        }
        //4.1
        int[] ar = new int[10];
        for (int i = 0; i < 10; i++) {
            Random rand = new Random();
            ar[i] = rand.nextInt(100);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(ar[i]);
        }
        Arrays.sort(ar);
        for (int i = 0; i < 10; i++) {
            System.out.println(ar[i]);
        }
        //4.2

        for (int i = 0; i < 10; i++) {
            ar[i] = (int) (10 + Math.random() * 90);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(ar[i]);
        }
        Arrays.sort(ar);
        for (int i = 0; i < 10; i++) {
            System.out.println(ar[i]);
        }
        //5
        System.out.println(Factorial(5));
    }
}