package com.company.practice23_24;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.work();
        /*for (int i = 91; i <= 100; i++) {
            try {
                worker.deleteRepost(i);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }
}
