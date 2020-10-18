package com.company.practice11;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static int totalSum; //Общий ресурс
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        long startTime, endTime;
        ArrayList<Thread> threads = new ArrayList<>();

        System.out.println("Выполнение метода последовательно 10 раз:");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            work(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        System.out.println("total sum: " + totalSum);
        totalSum = 0;

        System.out.println("Выполнение метода через 10 отдельных потоков:");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            final int localI = i;
            Thread thread = new Thread(() -> work(localI));
            thread.start();
            threads.add(thread);
        }
        for (Thread t : threads) {

            System.out.println(t.getState());
            t.join();
        }
        endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        System.out.println("total sum: " + totalSum);
    }

    private static void work(int i) {
        long startTime = System.currentTimeMillis();
        long result = doHardWork(i * 1000, 100_000_000);
        long endTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endTime - startTime));
    }

    private static long doHardWork(int start, int count) {
        long a = 0;
        lock.lock();
        for (int i = 0; i < count; i++) {
            a += (start + i) * (start + i) * Math.sqrt(start + i);
            totalSum++;
        }
        lock.unlock();
        return a;
    }
}