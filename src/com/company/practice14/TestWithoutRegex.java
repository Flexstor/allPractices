package com.company.practice14;

import java.util.HashMap;
import java.util.Scanner;

public class TestWithoutRegex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество правил - N (1 <= N <= 300):");
        int N = scanner.nextInt();
        if (N < 1 || N > 300)
            throw new IllegalArgumentException("Неверное N. Должно выполняться условие: 1 <= N <= 300!!!");
        HashMap<String, String> rules = new HashMap<>();
        for (int i = 0; i < N; i++) {
            System.out.println("Введите " + (i + 1) + "-e правило:");
            rules.put(scanner.next(), scanner.next());
        }
        System.out.println("Введите текст:");
        String str = scanner.next();

        String[] oldByRes = rules.keySet().toArray(new String[rules.size()]);
        String[] newByRes = rules.values().toArray(new String[rules.size()]);

        for (int i = 0; i < rules.size(); i++) {
            str = str.replaceAll(oldByRes[i], " " + newByRes[i] + " ");
        }
        System.out.println("Текст с заменами по правилам: "+ "\u001B[36m" + str.replace(" ", ""));
    }
}
