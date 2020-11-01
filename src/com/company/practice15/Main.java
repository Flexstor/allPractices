package com.company.practice15;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Graph graph = new Graph();

        while (true) {
            int a = sc.nextInt();
            if (a == -1) {
                break;
            }
            input.add(a);
        }
        graph.work(input);
    }
}
