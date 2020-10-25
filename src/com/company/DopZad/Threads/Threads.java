package com.company.DopZad.Threads;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Threads {
    //    static AtomicInteger totalSum = new AtomicInteger();
    static int[] sumFlows = new int[4];
    static int totalSum;
    // static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            final int localI = i;
            Thread thread = new Thread(() -> work(localI));
            thread.start();
            threads.add(thread);
        }

        for (Thread t : threads) {
            t.join();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        for(int x: sumFlows) {
            totalSum += x;
        }
        System.out.println("total sum: " + totalSum);
    }

    private static void work(int i) {
        long startTime = System.currentTimeMillis();
        long result = doHardWork(i * 1000, 100_000_000, i);
        long endTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endTime-startTime));
    }

    private static long doHardWork(int start, int count, int k) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (start + i) * (start + i) * Math.sqrt(start + i);
            sumFlows[k]++;
        }
        return a;
    }
}