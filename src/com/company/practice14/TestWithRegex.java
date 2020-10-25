package com.company.practice14;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestWithRegex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Входные данные
        System.out.println("Введите количество правил - N (1 <= N <= 300):");
        int N = scanner.nextInt();
        if (N < 1 || N > 300)
            throw new IllegalArgumentException("Неверное N. Должно выполняться условие: 1 <= N <= 300!!!");
        HashMap<String, String> rules = new HashMap<>(); // создаем словарь с правилами и заполняем его (удобно использовать, т.к. по его ключам можно легко находить элементы для изменения в тексте)
        for (int i = 0; i < N; i++) {
            System.out.println("Введите " + (i+1) + "-e правило:");
            rules.put(scanner.next(), scanner.next());
        }
        System.out.println("Введите текст:");
        String str = scanner.next();

        StringBuilder strBuilder = new StringBuilder(); // здесь мы будем собирать те элементы из правил, которые нужно заменить
        for (int i = 0; i < rules.size(); i++) {
            strBuilder.append(rules.keySet().toArray()[i]);
            if (i != rules.size() - 1){
                strBuilder.append("|"); // используется в синтаксисе РВ как ИЛИ
            }
        }
        Pattern pattern = Pattern.compile(strBuilder.toString());
        Matcher matcher = pattern.matcher(str);

        System.out.println("Текст с заменами по правилам: " + "\u001B[36m" + matcher.replaceAll(x -> rules.get(x.group()))); // Выводим текст с заменой по правилам
    }
}
