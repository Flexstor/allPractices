## practice1
**Main.java**
```java
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
```
## practice10
**Main.java**
```java
package com.company.practice10;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyApp app = new MyApp();
            app.setVisible(true);
        });
    }
}
```
**MyApp.java**
```java
package com.company.practice10;

import javax.swing.*;
import java.awt.*;
import static javax.swing.GroupLayout.Alignment.*;

public class MyApp extends JFrame {

    private JTextField textFieldA = new JTextField(15);
    private JTextField textFieldB = new JTextField(15);
    private JLabel label = new JLabel("", SwingConstants.CENTER);
    private JButton buttonP = new JButton("+");
    private JButton buttonM = new JButton("-");
    private JButton buttonS = new JButton("*");
    private JButton buttonD = new JButton("/");
    double scale = Math.pow(10, 4);

    public MyApp() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(buttonP)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(CENTER)
                                .addComponent(textFieldA)
                                .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonM)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonS)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(textFieldB)
                                .addComponent(label)))
                .addComponent(buttonD)
        );

        layout.linkSize(SwingConstants.HORIZONTAL, buttonP, buttonM, buttonS, buttonD);
        layout.linkSize(SwingConstants.VERTICAL, buttonP, buttonM, buttonS, buttonD);

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textFieldA)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(CENTER)
                                .addComponent(buttonP)
                                .addComponent(buttonM)
                                .addComponent(buttonS)
                                .addComponent(buttonD)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textFieldB)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label)
        );

        textFieldA.setToolTipText("Первое число");
        textFieldA.setFont(new Font("Dialog", Font.PLAIN, 25));
        textFieldB.setToolTipText("Второе число");
        textFieldB.setFont(new Font("Dialog", Font.PLAIN, 25));
        buttonP.setPreferredSize(new Dimension(45, 45));
        label.setFont(new Font("Helvetica-Light", Font.PLAIN, 16));

        setTitle("Калькулятор");
        setSize(400, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addListener();
    }

    private void addListener() {

        buttonP.addActionListener((ev) -> {
            if (checkField(textFieldA) && checkField(textFieldB))
                label.setText("Результат: " + String.valueOf(Math.round((Float.parseFloat(textFieldA.getText()) + Float.parseFloat(textFieldB.getText())) * scale)/scale));
            else
                JOptionPane.showMessageDialog(MyApp.this,
                        "Введите числа!");
        });

        buttonM.addActionListener((ev) -> {
            if (checkField(textFieldA) && checkField(textFieldB))
                label.setText("Результат: " + String.valueOf(Math.round((Float.parseFloat(textFieldA.getText()) - Float.parseFloat(textFieldB.getText())) * scale)/scale));
            else
                JOptionPane.showMessageDialog(MyApp.this,
                        "Введите числа!");
        });

        buttonS.addActionListener((ev) -> {
            if (checkField(textFieldA) && checkField(textFieldB))
                label.setText("Результат: " + String.valueOf(Math.round((Float.parseFloat(textFieldA.getText()) * Float.parseFloat(textFieldB.getText())) * scale)/scale));
            else
                JOptionPane.showMessageDialog(MyApp.this,
                        "Введите числа!");
        });

        buttonD.addActionListener((ev) -> {
            if (checkField(textFieldA) && checkField(textFieldB))
                if (Float.parseFloat(textFieldB.getText()) != 0)
                    label.setText("Результат: " + String.valueOf(Math.round((Float.parseFloat(textFieldA.getText()) / Float.parseFloat(textFieldB.getText())) * scale)/scale));
                else label.setText("Результат: не определен(Ꝏ)");
            else
                JOptionPane.showMessageDialog(MyApp.this,
                        "Введите числа!");
        });
    }

    private boolean checkField(JTextField textField) {
        return !textField.getText().equals("") && textField.getText().matches("(-|\\+)?\\d+\\.?\\d*");
    }
}
```
## practice11
**Main.java**
```java
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
```
## practice12
**Enums.java**
```java
package com.company.practice12;

public enum Enums {
    DEFAULT("\u001B[0m"),
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN ( "\u001B[32m"),
    YELLOW ( "\u001B[33m"),
    BLUE ( "\u001B[34m"),
    MAGENTA ( "\u001B[35m"),
    CYAN ( "\u001B[36m"),
    WHITE ( "\u001B[37m");

    private final String colorCode;

    Enums(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getColorCode() {
        return colorCode;
    }
}
```
**Main.java**
```java
package com.company.practice12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner str = new Scanner(System.in);
        System.out.println("Введите текст: ");
        printText(str.nextLine(), Enums.CYAN);
    }

    private static void printText(String text, Enums color){
        System.out.println(color.getColorCode()+text);
    }

}
```
## practice13
**Bottle.java**
```java
package com.company.practice13;

public class Bottle {
    private int bottleVolume;
    private int liquidVolume;

    public int getBottleVolume() {
        return bottleVolume;
    }

    public void setBottleVolume(int bottleVolume) throws Exception {
        if (bottleVolume <= 0)
            throw new Exception();
        this.bottleVolume = bottleVolume;
    }

    public int getLiquidVolume() {
        return liquidVolume;
    }

    public void addLiquidVolume(int liquidVolume) throws IncorrectLiquidVolumeException {
        if (liquidVolume < 0 || liquidVolume > bottleVolume)
            throw new IncorrectLiquidVolumeException();
        this.liquidVolume += liquidVolume;
    }

    @Override
    public String toString() {
        return "Bottle(" + bottleVolume + "){" +
                "liquidVolume=" + liquidVolume +
                '}';
    }
}
```
**IncorrectLiquidVolumeException.java**
```java
package com.company.practice13;

public class IncorrectLiquidVolumeException extends Exception {
}
```
**Main.java**
```java
package com.company.practice13;

public class Main {
    public static void main(String[] args){
        Bottle bottle = new Bottle();
        try{
            bottle.setBottleVolume(5);
            bottle.addLiquidVolume(2);
        } catch (IncorrectLiquidVolumeException iex) {
            System.out.println("Некорректные данные объема жидкости");
        } catch (Exception e) {
            System.out.println("Неккоректные данные объема бутылки");
        } finally {
            System.out.println(bottle);
        }
        throw new MyRuntimeException();
    }
}
```
**MyRuntimeException.java**
```java
package com.company.practice13;

public class MyRuntimeException extends RuntimeException{
}
```
## practice14
**TestWithoutRegex.java**
```java
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
```
**TestWithRegex.java**
```java
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
```
## practice15_16
**Graph.java**
```java
package com.company.practice15_16;

import java.util.HashMap;
import java.util.ArrayList;

public class Graph {
    private final ArrayList<State> stateList = new ArrayList<>();
    private final HashMap<Integer, String> transitionAction = new HashMap<>();
    private State S1 = new State(0, 1, 1, 4);
    private State S2 = new State(3, 2, 5, 3);
    private State S3 = new State(5, 3, 1, 4);
    private State S4 = new State(2, 2, 4, 4);
    private State S5 = new State(4, 0, 2, 2);
    private Integer currentState = 0;

    public Graph() {
        setTransitActionMap();
        setStateList();
    }

    public void work(ArrayList<Integer> transitions) {
        for (int i = 0; i < transitions.size(); i++) {
            System.out.println(transitionAction.get(stateList.get(currentState).getActions().get(transitions.get(i))));
            currentState = stateList.get(currentState).getStates().get(transitions.get(i));
        }
    }

    private void setStateList(){
        stateList.add(S1);
        stateList.add(S2);
        stateList.add(S3);
        stateList.add(S4);
        stateList.add(S5);
    }

    private void setTransitActionMap(){
        transitionAction.put(0, "create_project");
        transitionAction.put(1, "add_library");
        transitionAction.put(2, "restart");
        transitionAction.put(3, "test");
        transitionAction.put(4, "deploy");
        transitionAction.put(5, "drop_db");
    }
}
```
**Main.java**
```java
package com.company.practice15_16;

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
```
**State.java**
```java
package com.company.practice15_16;

import java.util.ArrayList;

public class State {
    private ArrayList<Integer> transitions = new ArrayList<>();
    private ArrayList<Integer> actions = new ArrayList<>();
    private ArrayList<Integer> states = new ArrayList<>();

    public State (int actAt0, int stateAt0, int actAt1, int stateAt1)
    {
        actions.add(actAt0);
        actions.add(actAt1);
        states.add(stateAt0);
        states.add(stateAt1);
    }

    public ArrayList<Integer> getActions() {
        return actions;
    }

    public ArrayList<Integer> getStates() {
        return states;
    }
}
```
## practice17_18
**Main.java**
```java
package com.company.practice17_18;

import java.io.*;

public class Main {
    private static final String basePath = "src/com/company";
    private static final String mdFilePath = basePath + "/practice17_18/result.md";

    public static void main(String[] args) {
        File file = new File(basePath);
        File mdFile = new File(mdFilePath);

        try {
            mdFile.createNewFile();
        } catch (IOException exception) {
            exception.getStackTrace();
        }

        if (file.isDirectory()) {
            File[] fileList = file.listFiles();

            if (fileList != null)
                for (File fi: fileList)
                    reportCreator(fi.getPath());
        }
    }

    public static void reportCreator(String path) {
        File file = new File(path);
        String line;
        String[] files = null;

        if (file.isDirectory())
            files = file.list();

        try (FileWriter writer = new FileWriter(mdFilePath, true)) {
            writer.write("## " + path.substring(path.lastIndexOf("\\") + 1) + "\n");

            if (files != null)
                for (String str : files)
                    if (str.endsWith(".java")) {
                        writer.write("**" + str + "**" + "\n");
                        writer.write("```java" + "\n");

                        try (BufferedReader reader = new BufferedReader(new FileReader(path + "/" + str))) {
                            line = reader.readLine();

                            while (line != null) {
                                writer.write(line + "\n");
                                line = reader.readLine();
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }

                        writer.write("```" + "\n");
                    }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
```
## practice2
**Ball.java**
```java
package com.company.practice2;

public class Ball {
    private int radius;
    private int volume;

    @Override
    public String toString() {
        return ("Радиус - " + radius +
                "\nОбъем - " + volume);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }
}
```
**Book.java**
```java
package com.company.practice2;

public class Book {
    private int pages;
    private int price;

    @Override
    public String toString() {
        return ("Страницы - " + pages +
                "\nЦена - " + price);
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
```
**Dog.java**
```java
package com.company.practice2;

public class Dog {
    private int age;
    private String name;

    public Dog() {
        age = 0;
        name = "";
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int age_to_human() {
        return (age * 7);
    }

    @Override
    public String toString() {
        return ("Возраст - " + age +
                "\tКличка - " + name);
    }
}
```
**Dog_nursery.java**
```java
package com.company.practice2;

public class Dog_nursery {
    int place = 0;
    Dog[] arr = new Dog[10];

    public void add(Dog dog) {
        arr[place] = dog;
        place++;
        System.out.println("Succes!");
    }
}
```
**Main.java**
```java
package com.company.practice2;

public class Main {
    public static void main(String[] args) {
        //1
        Shape triangle = new Shape();
        triangle.setLength(10);
        triangle.setWidth(20);
        System.out.println("Фигура:\n" +
                triangle.getLength() +
                "\n" + triangle.getWidth() +
                "\n" + triangle.toString());

        //2
        Ball football = new Ball();
        football.setRadius(5);
        football.setVolume(15);
        System.out.println("Мяч:\n" +
                football.getRadius() +
                "\n" + football.getVolume() +
                "\n" + football.toString());

        //3
        Book tutorial = new Book();
        tutorial.setPages(75);
        tutorial.setPrice(150);
        System.out.println("Книга:\n" +
                tutorial.getPages() +
                "\n" + tutorial.getPrice() +
                "\n" + tutorial.toString());

        //4
        Dog a = new Dog();
        a.setAge(4);
        a.setName("Ponchik");
        System.out.println(a.toString());
        System.out.println(a.age_to_human());
        Dog_nursery b = new Dog_nursery();
        b.add(a);

    }
}
```
**Shape.java**
```java
package com.company.practice2;

public class Shape {
    private int length;
    private int width;

    @Override
    public String toString() {
        return ("Длина - " + length +
                "\nШирина - " + width);
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }
}

```
## practice3
**Book.java**
```java
package com.company.practice3;

public class Book {
    private String author;
    private String name;
    private int year;

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }
}
```
**BookTest.java**
```java
package com.company.practice3;

public class BookTest {
    public static void main(String[] args) {
        Book fantastic = new Book();
        fantastic.setAuthor("Стивен Кинг");
        fantastic.setName("Сияние");
        fantastic.setYear(1977);

        System.out.println("Книга:\n" + "Автор: " + fantastic.getAuthor() + "\nНазвание: " + fantastic.getName() + "\nГод издания: " + fantastic.getYear());
    }
}
```
**Circle.java**
```java
package com.company.practice3;

public class Circle {
    private int radius;
    private double area;

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getArea() {
        area = 3.14 * (radius * radius);
        return area;
    }
}
```
**CircleTest.java**
```java
package com.company.practice3;

public class CircleTest {
    public static void main(String[] args)
    {
        Circle a = new Circle();
        a.setRadius(5);
        System.out.println("Радиус = " + a.getRadius() + "\nПлощадь = " + a.getArea());
    }
}
```
**Human.java**
```java
package com.company.practice3;

public class Human {

    Head head;
    Leg legLeft;
    Leg legRight;
    Hand handLeft;
    Hand handRight;

    public Human(Head head, Leg legLeft, Leg legRight, Hand handLeft, Hand handRight) {
        this.head = head;
        this.legLeft = legLeft;
        this.legRight = legRight;
        this.handLeft = handLeft;
        this.handRight = handRight;

    }

    public static class Head {
        private String eyes;
        private String hair;

        public Head(String eyes, String hair) {
            this.eyes = eyes;
            this.hair = hair;
        }

        public void setEyes(String eyes) {
            this.eyes = eyes;
        }

        public String getEyes() {
            return eyes;
        }

        public void setHair(String hair) {
            this.hair = hair;
        }

        public String getHair() {
            return hair;
        }

        @Override
        public String toString() {
            return ("глаза = " + eyes +
                    ", волосы = " + hair);
        }
    }

    public static class Leg {
        private int length;
        private int width;

        public Leg(int length, int width) {
            this.length = length;
            this.width = width;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getLength() {
            return length;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getWidth() {
            return width;
        }

        @Override
        public String toString() {
            return ("длина = " + length +
                    ", ширина = " + width);
        }
    }

    public static class Hand {
        private int length;
        private int width;

        public Hand(int length, int width) {
            this.length = length;
            this.width = width;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getLength() {
            return length;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getWidth() {
            return width;
        }

        @Override
        public String toString() {
            return ("длина = " + length +
                    ", ширина = " + width);
        }
    }

        @Override
        public String toString() {
            return ("Human: " +
                    "\nГолова: " + head +
                    "\nЛевая нога: " + legLeft +
                    "\nПравая нога: " + legRight +
                    "\nЛевая рука: " + handLeft +
                    "\nПравая рука: " + handRight);
        }
}

```
**Main.java**
```java
package com.company.practice3;

public class Main {

    public static void main(String[] args)
    {
        Human.Head head = new Human.Head("карие", "черные");
        Human.Leg legLeft = new Human.Leg(80, 15);
        Human.Leg legRight = new Human.Leg(79, 15);
        Human.Hand handLeft = new Human.Hand(60, 10);
        Human.Hand handRight = new Human.Hand(60, 10);

        Human a = new Human(head, legLeft, legRight, handLeft, handRight);
        System.out.println(a.toString());
    }
}
```
## practice4
**Circle.java**
```java
package com.company.practice4;

public class Circle extends Shape{
    protected double radius;

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public Circle(double radius) {this.radius = radius;}
    public Circle() {}

    public double getRadius() {return radius;}
    public void setRadius(double radius) {this.radius = radius;}

    @Override
    public double getArea() {return (3.14 * 3.14 * radius);}

    @Override
    public double getPerimeter() {return (2 * 3.14 * radius);}

    @Override
    public String toString() {
        return ("Circle:\n" +
                "radius = " + radius +
                ", color = '" + color + '\'' +
                ", filled = " + filled);
    }
}
```
**Main.java**
```java
package com.company.practice4;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(7, "green", true);
        Rectangle rectangle = new Rectangle(3, 7, "yellow", true);
        Square square = new Square(2,  "black", false);
        System.out.println(circle.toString() + ", area = " + circle.getArea() + ", perimeter = " + circle.getPerimeter());
        System.out.println(rectangle.toString() + ", area = " + rectangle.getArea() + ", perimeter = " + rectangle.getPerimeter());
        System.out.println(square.toString() + ", area = " + square.getArea() + ", perimeter = " + square.getPerimeter());
    }
}
```
**Rectangle.java**
```java
package com.company.practice4;

public class Rectangle extends Shape {
    protected double width = 1;
    protected double length = 1;

    public Rectangle(double width, double length, String color, boolean filled){
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle() {}

    public double getWidth() {return width;}
    public void setWidth(double width) {this.width = width;}

    public double getLength() {return length;}
    public void setLength(double length) {this.length = length;}

    @Override
    public double getArea() {return (width * length);}
    @Override
    public double getPerimeter() {return ((width + length) * 2);}

    @Override
    public  String toString() {
        return ("Rectangle:\n" +
                "width = " + width +
                ", length = " + length +
                ", color = '" + color + '\'' +
                ", filled = " + filled);
    }
}
```
**Shape.java**
```java
package com.company.practice4;

public abstract class Shape {
    protected String color = "red";
    protected boolean filled = true;

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public Shape(){}

    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}

    public boolean isFilled() {return filled;}
    public void setFilled(boolean filled) {this.filled = filled;}

    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public String toString(){
        return ("Shape:\n" +
                "color = '" + color + '\'' +
                ", filled = " + filled);
    }
}
```
**Square.java**
```java
package com.company.practice4;

public class Square extends Shape{
    protected double side;

    public Square(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(){}

    @Override
    public double getArea() {return (side*side);}
    @Override
    public double getPerimeter() {return (side*4);}


    public void setSide(double side) {this.side = side;}
    public double getSide() {return side;}

    @Override
    public String toString() {
        return ("Square:\n" +
                "side = " + side +
                ", color = '" + color + '\'' +
                ", filled = " + filled);
    }
}
```
## practice5
**Main.java**
```java
package com.company.practice5;

public class Main {
    public static void main(String[] args) {
        MovablePoint a = new MovablePoint(7, 10);
        System.out.println(a);
        a.moveLeft(12);
        a.moveRight(15);
        a.moveUp(4);
        a.moveDown(5);
        System.out.println(a);
        MovableCircle b = new MovableCircle(2, 10, 16);
        System.out.println(b);
        b.moveLeft(11);
        b.moveRight(0);
        b.moveUp(15);
        b.moveDown(20);
        System.out.println(b);
        MovableRectangle c = new MovableRectangle(new MovablePoint(12, 23),new MovablePoint(20,15));
        System.out.println(c);
        c.moveUp(20);
        c.moveRight(50);
        System.out.println(c.getLength());
        System.out.println(c);
    }
}

```
**Movable.java**
```java
package com.company.practice5;

public interface Movable {
    void moveUp(double y);
    void moveDown(double y);
    void moveLeft(double x);
    void moveRight(double x);
}
```
**MovableCircle.java**
```java
package com.company.practice5;

import com.company.practice4.Circle;

public class MovableCircle extends Circle implements Movable {
    private MovablePoint center;

    public MovableCircle(int radius, double x, double y) {
        center = new MovablePoint(x, y);
        this.radius = radius;
    }

    public MovablePoint getCenter() {
        return center;
    }

    public void setCenter(MovablePoint center) {
        this.center = center;
    }

    @Override
    public void moveUp(double y) {
        center.y += y;
    }

    @Override
    public void moveDown(double y) {
        center.y -= y;
    }

    @Override
    public void moveLeft(double x) {
        center.x -= x;
    }

    @Override
    public void moveRight(double x) {
        center.x += x;
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }
}
```
**MovablePoint.java**
```java
package com.company.practice5;

public class MovablePoint implements Movable {
    protected double x;
    protected double y;

    public MovablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void moveUp ( double y){
        this.y += y;
    }

    public void moveDown ( double y){
        this.y -= y;
    }

    public void moveLeft ( double x){
        this.x -= x;
    }


    public void moveRight ( double x){
        this.x += x;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
```
**MovableRectangle.java**
```java
package com.company.practice5;

        import com.company.practice4.Rectangle;

public class MovableRectangle extends Rectangle implements Movable{
    private MovablePoint LeftUp;
    private MovablePoint RightDown;

    public MovableRectangle(MovablePoint LeftUp, MovablePoint RightDown){
        this.LeftUp = LeftUp;
        this.RightDown = RightDown;
    }

    public MovablePoint getLeftUp() {
        return LeftUp;
    }

    public MovablePoint getRightDown() {
        return RightDown;
    }

    public double getLength() {
        return Math.abs(LeftUp.getX() - RightDown.getX());
    }

    public double getWidth() {
        return Math.abs(LeftUp.getY() - RightDown.getY());
    }


    @Override
    public void moveUp(double y) {
        LeftUp.moveUp(y);
        RightDown.moveUp(y);
    }

    @Override
    public void moveDown(double y) {
        LeftUp.moveDown(y);
        RightDown.moveDown(y);
    }

    @Override
    public void moveLeft(double x) {
        LeftUp.moveLeft(x);
        RightDown.moveLeft(x);
    }

    @Override
    public void moveRight(double x) {
        LeftUp.moveRight(x);
        RightDown.moveRight(x);
    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "LeftUp=" + LeftUp +
                ", RightDown=" + RightDown +
                '}';
    }
}

```
## practice6
**Main.java**
```java
package com.company.practice6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[][] square = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                square[i][j] = in.nextInt();
            }
        }


        for (int i = size - 1; i >= 0; i--) {
            for (int j = size - 1; j >= 0; j--) {
                if (i == size - 1 && j != size - 1) {
                    square[i][j] += square[i][j+1];
                }
                else if (i != size - 1 && j == size - 1) {
                    square[i][j] += square[i+1][j];
                }
                else if (i != size - 1 && j != size - 1) {
                    if (square[i][j + 1] > square[i + 1][j]) {
                        square[i][j] += square[i][j + 1];
                    } else {
                        square[i][j] += square[i + 1][j];
                    }
                }
            }
        }
        System.out.println(square[0][0]);
    }
}
```
## practice7_8
**Company.java**
```java
package com.company.practice7_8;

import  java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Company {
    private List <Employee> employees = new ArrayList<>();

    public void hire(Employee employee){
        employees.add(employee);
    }

    public void hireAll(List<Employee> employeeList){
        for(Employee employee: employeeList){
            hire(employee);
        }
    }

    public Employee searchForFire(String name, String surname, String position){

        for(Employee employee: employees){
            if(employee.getName().equals(name) && employee.getSurname().equals(surname) && employee.getPosition().getJobTitle() == position){
                return employee;
            }
        }
        return null;
    }

    public void fire(String surname, String name, String position){
        employees.remove(searchForFire(name, surname, position));
    }

    public void fire(int indexOfEmployee){
        employees.remove(indexOfEmployee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double getIncome(){
        double income = 0;
        for (Employee employee: employees) {
            if(employee.getPosition().getJobTitle().equals("Manager")) {
                income += ((Manager)employee.getPosition()).getCount();
            }
        }
        return income;
    }

    public void sortEmployeesTop(){
        employees.sort(Comparator.comparing(Employee::getSalary).reversed());
    }

    public void sortEmployeesLowest(){
        employees.sort(Comparator.comparing(Employee::getSalary));
    }

    public List<Employee> getTopSalaryStaff(int count){
        if(count > 0 && employees.size() > count){

            this.sortEmployeesTop();
            return employees.subList(0, count);
        }
        else
            return null;

    }

    public List<Employee> getLowestSalaryStaff(int count){
        if(count > 0 && employees.size() > count){

            this.sortEmployeesLowest();
            return employees.subList(0, count);
        }
        else
            return null;
    }

    public void PrintList(){
        for(Employee employee: employees){
            System.out.println(employee.getSurname() + " " + employee.getName() + " - " + employee.getPosition().getJobTitle() + " " +
                    (int)employee.getPosition().calcSalary(employee.getFixSalary()) + " рублей");
        }
    }

    public void PrintList(List<Employee> list){
        for(Employee employee: list){
            System.out.println(employee.getSurname() + " " + employee.getName() + " - " + employee.getPosition().getJobTitle() + " " +
                    (int)employee.getPosition().calcSalary(employee.getFixSalary()) + " рублей");
        }
    }
}
```
**Employee.java**
```java
package com.company.practice7_8;

public class Employee {
    private String surname;
    private String name;
    private double fixSalary;
    private double salary;
    private EmployeePosition Position;

    public Employee(String surname, String name, double fixSalary, EmployeePosition position) {
        this.surname = surname;
        this.name = name;
        this.fixSalary = fixSalary;
        Position = position;
        this.salary = Position.calcSalary(fixSalary);
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFixSalary(double fixSalary) { this.fixSalary = fixSalary; }

    public double getFixSalary() { return fixSalary; }

    public void setPosition(EmployeePosition position) {
        Position = position;
    }

    public EmployeePosition getPosition() {
        return Position;
    }

    public double getSalary() { return salary; }
}
```
**EmployeePosition.java**
```java
package com.company.practice7_8;

public interface EmployeePosition {
    String getJobTitle();
    double calcSalary(double baseSalary);
}
```
**Main.java**
```java
package com.company.practice7_8;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();

        for (int i = 1; i <= 180 ; i++) {
            company.hire(new Employee("Operator ", Integer.toString(i),
                    2000 + (Math.random() * 3000), new Operator()));
        }

        for (int i = 1; i <= 80 ; i++) {
            company.hire(new Employee("Manager", Integer.toString(i),
                    7000 + (Math.random() * 3000), new Manager()));
        }

        for (int i = 1; i <= 80 ; i++) {
            company.hire(new Employee("TopManager", Integer.toString(i),
                    15000 + (Math.random() * 10000), new TopManager(company)));
        }

        company.getIncome();
        company.PrintList(company.getTopSalaryStaff(10));
        System.out.println("*************************************************");
        company.PrintList(company.getLowestSalaryStaff(30));

        for (int i = 0; i < company.getEmployees().size()/2; i++) {
            company.fire((int)Math.random() * 340);
        }

        System.out.println("\nПосле увольнения: \n");
        company.PrintList(company.getTopSalaryStaff(10));
        System.out.println("*************************************************");
        company.PrintList(company.getLowestSalaryStaff(30));

        System.out.println();
        Company company1 = new Company();
        company1.hire(new Employee("Shikalov", "Danila", 2000, new Manager()));
        company1.PrintList();
        company1.fire("Shikalov", "Danila", "Manager");
        company1.PrintList();
    }
}
```
**Manager.java**
```java
package com.company.practice7_8;

public class Manager implements EmployeePosition {
    private double count = 115000 + (Math.random() * 25000);

    public double getCount() {
        return count;
    }

    @Override
    public String getJobTitle() {
        return "Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary + 0.05 * count;
    }
}
```
**Operator.java**
```java
package com.company.practice7_8;

public class Operator implements EmployeePosition {

    @Override
    public String getJobTitle() {
        return "Operator";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary;
    }
}
```
**TopManager.java**
```java
package com.company.practice7_8;

public class TopManager implements EmployeePosition{

    private Company company;

    public TopManager(Company company)
    {
        this.company = company;
    }

    @Override
    public String getJobTitle() {
        return "TopManager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        if(company.getIncome() > 10000000)
            return 2.5 * baseSalary;
        else
            return baseSalary;
    }
}
```
## practice9
**Company.java**
```java
package com.company.practice9;

import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> employees = new ArrayList<>();

    public void hire(Employee employee){
        employees.add(employee);
    }

    public void fire(int index){
        employees.remove(index);
    }

    public void doSomethingWithEmployees(EmployeeSelector selector, EmployeeHandler handler){
        int count = 0;
        for(Employee employee : employees){
            if (selector.isNeedEmployee(employee)){
                handler.handleEmployee(employee, count);
                count++;
            }
        }
        System.out.println(count);
        System.out.println("*******************************************************\n");
    }

    public void printList(){
        for (Employee employee:
             employees) {
            System.out.println(employee);
        }
        System.out.println("*******************************************************");
    }

    @Override
    public String toString() {
        return "Company{" +
                "employees=" + employees +
                '}';
    }
}
```
**Employee.java**
```java
package com.company.practice9;

import java.time.LocalDate;

public class Employee {
    private String name;
    private String surname;
    private final LocalDate dateOfBirth;
    private String location;
    private String phoneNumber;
    private int salary;

    public Employee(String name, String surname, LocalDate dateOfBirth, String location, String phoneNumber, int salary) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", location='" + location + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary +
                '}';
    }
}
```
**EmployeeHandler.java**
```java
package com.company.practice9;

public interface EmployeeHandler {
    void handleEmployee(Employee employee, int index);
}
```
**EmployeeSelector.java**
```java
package com.company.practice9;

public interface EmployeeSelector {
    boolean isNeedEmployee(Employee employee);
}
```
**Main.java**
```java
package com.company.practice9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        Random random = new Random();

        for (int i = 0; i < 15; i++){
            company.hire(new Employee(
                    "Employee",
                    "" + Integer.toString(i+1),
                    LocalDate.of(1955 + random.nextInt(49), random.nextInt(11) + 1, random.nextInt(28) + 1),
                    "Moscow",
                    "8900-900-20-22",
                    (int)(1000 + Math.random() * 99_000)));
        }

        System.out.println("Сотрудники, зарплата которых колеблется от 10000 до 20000:");
        company.doSomethingWithEmployees(
                new SalarySelector(10_000, 20_000),
                (employee, index) -> System.out.println(employee));

        System.out.println("Повышаем зарплату сотрудникам на 3000, зарплата которых меньше 5000: ");
        int a = 3_000;
        company.printList();
        company.doSomethingWithEmployees(new EmployeeSelector() {
            @Override
            public boolean isNeedEmployee(Employee employee) {
                return employee.getSalary() < a;
            }
        }, new EmployeeHandler() {
            @Override
            public void handleEmployee(Employee employee, int index) {
                employee.setSalary(employee.getSalary() + 5000);
                System.out.println(employee);
            }
        });
    }
}
```
**SalarySelector.java**
```java
package com.company.practice9;

public class SalarySelector implements EmployeeSelector{

    private int salaryStart;
    private int salaryEnd;

    public SalarySelector(int salaryStart, int salaryEnd) {
        this.salaryStart = salaryStart;
        this.salaryEnd = salaryEnd;
    }

    @Override
    public boolean isNeedEmployee(Employee employee) {
        return employee.getSalary() >= salaryStart && employee.getSalary() <= salaryEnd;
    }
}
```
## practice1
**Main.java**
```java
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
```
## practice10
**Main.java**
```java
package com.company.practice10;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyApp app = new MyApp();
            app.setVisible(true);
        });
    }
}
```
**MyApp.java**
```java
package com.company.practice10;

import javax.swing.*;
import java.awt.*;
import static javax.swing.GroupLayout.Alignment.*;

public class MyApp extends JFrame {

    private JTextField textFieldA = new JTextField(15);
    private JTextField textFieldB = new JTextField(15);
    private JLabel label = new JLabel("", SwingConstants.CENTER);
    private JButton buttonP = new JButton("+");
    private JButton buttonM = new JButton("-");
    private JButton buttonS = new JButton("*");
    private JButton buttonD = new JButton("/");
    double scale = Math.pow(10, 4);

    public MyApp() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(buttonP)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(CENTER)
                                .addComponent(textFieldA)
                                .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonM)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonS)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(textFieldB)
                                .addComponent(label)))
                .addComponent(buttonD)
        );

        layout.linkSize(SwingConstants.HORIZONTAL, buttonP, buttonM, buttonS, buttonD);
        layout.linkSize(SwingConstants.VERTICAL, buttonP, buttonM, buttonS, buttonD);

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textFieldA)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(CENTER)
                                .addComponent(buttonP)
                                .addComponent(buttonM)
                                .addComponent(buttonS)
                                .addComponent(buttonD)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textFieldB)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label)
        );

        textFieldA.setToolTipText("Первое число");
        textFieldA.setFont(new Font("Dialog", Font.PLAIN, 25));
        textFieldB.setToolTipText("Второе число");
        textFieldB.setFont(new Font("Dialog", Font.PLAIN, 25));
        buttonP.setPreferredSize(new Dimension(45, 45));
        label.setFont(new Font("Helvetica-Light", Font.PLAIN, 16));

        setTitle("Калькулятор");
        setSize(400, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addListener();
    }

    private void addListener() {

        buttonP.addActionListener((ev) -> {
            if (checkField(textFieldA) && checkField(textFieldB))
                label.setText("Результат: " + String.valueOf(Math.round((Float.parseFloat(textFieldA.getText()) + Float.parseFloat(textFieldB.getText())) * scale)/scale));
            else
                JOptionPane.showMessageDialog(MyApp.this,
                        "Введите числа!");
        });

        buttonM.addActionListener((ev) -> {
            if (checkField(textFieldA) && checkField(textFieldB))
                label.setText("Результат: " + String.valueOf(Math.round((Float.parseFloat(textFieldA.getText()) - Float.parseFloat(textFieldB.getText())) * scale)/scale));
            else
                JOptionPane.showMessageDialog(MyApp.this,
                        "Введите числа!");
        });

        buttonS.addActionListener((ev) -> {
            if (checkField(textFieldA) && checkField(textFieldB))
                label.setText("Результат: " + String.valueOf(Math.round((Float.parseFloat(textFieldA.getText()) * Float.parseFloat(textFieldB.getText())) * scale)/scale));
            else
                JOptionPane.showMessageDialog(MyApp.this,
                        "Введите числа!");
        });

        buttonD.addActionListener((ev) -> {
            if (checkField(textFieldA) && checkField(textFieldB))
                if (Float.parseFloat(textFieldB.getText()) != 0)
                    label.setText("Результат: " + String.valueOf(Math.round((Float.parseFloat(textFieldA.getText()) / Float.parseFloat(textFieldB.getText())) * scale)/scale));
                else label.setText("Результат: не определен(Ꝏ)");
            else
                JOptionPane.showMessageDialog(MyApp.this,
                        "Введите числа!");
        });
    }

    private boolean checkField(JTextField textField) {
        return !textField.getText().equals("") && textField.getText().matches("(-|\\+)?\\d+\\.?\\d*");
    }
}
```
## practice11
**Main.java**
```java
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
```
## practice12
**Enums.java**
```java
package com.company.practice12;

public enum Enums {
    DEFAULT("\u001B[0m"),
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN ( "\u001B[32m"),
    YELLOW ( "\u001B[33m"),
    BLUE ( "\u001B[34m"),
    MAGENTA ( "\u001B[35m"),
    CYAN ( "\u001B[36m"),
    WHITE ( "\u001B[37m");

    private final String colorCode;

    Enums(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getColorCode() {
        return colorCode;
    }
}
```
**Main.java**
```java
package com.company.practice12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner str = new Scanner(System.in);
        System.out.println("Введите текст: ");
        printText(str.nextLine(), Enums.CYAN);
    }

    private static void printText(String text, Enums color){
        System.out.println(color.getColorCode()+text);
    }

}
```
## practice13
**Bottle.java**
```java
package com.company.practice13;

public class Bottle {
    private int bottleVolume;
    private int liquidVolume;

    public int getBottleVolume() {
        return bottleVolume;
    }

    public void setBottleVolume(int bottleVolume) throws Exception {
        if (bottleVolume <= 0)
            throw new Exception();
        this.bottleVolume = bottleVolume;
    }

    public int getLiquidVolume() {
        return liquidVolume;
    }

    public void addLiquidVolume(int liquidVolume) throws IncorrectLiquidVolumeException {
        if (liquidVolume < 0 || liquidVolume > bottleVolume)
            throw new IncorrectLiquidVolumeException();
        this.liquidVolume += liquidVolume;
    }

    @Override
    public String toString() {
        return "Bottle(" + bottleVolume + "){" +
                "liquidVolume=" + liquidVolume +
                '}';
    }
}
```
**IncorrectLiquidVolumeException.java**
```java
package com.company.practice13;

public class IncorrectLiquidVolumeException extends Exception {
}
```
**Main.java**
```java
package com.company.practice13;

public class Main {
    public static void main(String[] args){
        Bottle bottle = new Bottle();
        try{
            bottle.setBottleVolume(5);
            bottle.addLiquidVolume(2);
        } catch (IncorrectLiquidVolumeException iex) {
            System.out.println("Некорректные данные объема жидкости");
        } catch (Exception e) {
            System.out.println("Неккоректные данные объема бутылки");
        } finally {
            System.out.println(bottle);
        }
        throw new MyRuntimeException();
    }
}
```
**MyRuntimeException.java**
```java
package com.company.practice13;

public class MyRuntimeException extends RuntimeException{
}
```
## practice14
**TestWithoutRegex.java**
```java
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
```
**TestWithRegex.java**
```java
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
```
## practice15_16
**Graph.java**
```java
package com.company.practice15_16;

import java.util.HashMap;
import java.util.ArrayList;

public class Graph {
    private final ArrayList<State> stateList = new ArrayList<>();
    private final HashMap<Integer, String> transitionAction = new HashMap<>();
    private State S1 = new State(0, 1, 1, 4);
    private State S2 = new State(3, 2, 5, 3);
    private State S3 = new State(5, 3, 1, 4);
    private State S4 = new State(2, 2, 4, 4);
    private State S5 = new State(4, 0, 2, 2);
    private Integer currentState = 0;

    public Graph() {
        setTransitActionMap();
        setStateList();
    }

    public void work(ArrayList<Integer> transitions) {
        for (int i = 0; i < transitions.size(); i++) {
            System.out.println(transitionAction.get(stateList.get(currentState).getActions().get(transitions.get(i))));
            currentState = stateList.get(currentState).getStates().get(transitions.get(i));
        }
    }

    private void setStateList(){
        stateList.add(S1);
        stateList.add(S2);
        stateList.add(S3);
        stateList.add(S4);
        stateList.add(S5);
    }

    private void setTransitActionMap(){
        transitionAction.put(0, "create_project");
        transitionAction.put(1, "add_library");
        transitionAction.put(2, "restart");
        transitionAction.put(3, "test");
        transitionAction.put(4, "deploy");
        transitionAction.put(5, "drop_db");
    }
}
```
**Main.java**
```java
package com.company.practice15_16;

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
```
**State.java**
```java
package com.company.practice15_16;

import java.util.ArrayList;

public class State {
    private ArrayList<Integer> transitions = new ArrayList<>();
    private ArrayList<Integer> actions = new ArrayList<>();
    private ArrayList<Integer> states = new ArrayList<>();

    public State (int actAt0, int stateAt0, int actAt1, int stateAt1)
    {
        actions.add(actAt0);
        actions.add(actAt1);
        states.add(stateAt0);
        states.add(stateAt1);
    }

    public ArrayList<Integer> getActions() {
        return actions;
    }

    public ArrayList<Integer> getStates() {
        return states;
    }
}
```
## practice17_18
**Main.java**
```java
package com.company.practice17_18;

import java.io.*;

public class Main {
    private static final String basePath = "src/com/company";
    private static final String mdFilePath = basePath + "/practice17_18/result.md";

    public static void creatorMD(String path) {
        File file = new File(path);
        String line;
        String[] files = null;

        if (file.isDirectory())
            files = file.list();

        try (FileWriter writer = new FileWriter(mdFilePath, true)) {
            writer.write("## " + path.substring(path.lastIndexOf("\\") + 1) + "\n");

            if (files != null)
                for (String str : files)
                    if (str.endsWith(".java")) {
                        writer.write("**" + str + "**" + "\n");
                        writer.write("```java" + "\n");

                        try (BufferedReader reader = new BufferedReader(new FileReader(path + "/" + str))) {
                            line = reader.readLine();

                            while (line != null) {
                                writer.write(line + "\n");
                                line = reader.readLine();
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }

                        writer.write("```" + "\n");
                    }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file = new File(basePath);
        File mdFile = new File(mdFilePath);

        try {
            mdFile.createNewFile();
        } catch (IOException exception) {
            exception.getStackTrace();
        }

        if (file.isDirectory()) {
            File[] fileList = file.listFiles();

            if (fileList != null)
                for (File fi: fileList)
                    creatorMD(fi.getPath());
        }
    }
}
```
## practice2
**Ball.java**
```java
package com.company.practice2;

public class Ball {
    private int radius;
    private int volume;

    @Override
    public String toString() {
        return ("Радиус - " + radius +
                "\nОбъем - " + volume);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }
}
```
**Book.java**
```java
package com.company.practice2;

public class Book {
    private int pages;
    private int price;

    @Override
    public String toString() {
        return ("Страницы - " + pages +
                "\nЦена - " + price);
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
```
**Dog.java**
```java
package com.company.practice2;

public class Dog {
    private int age;
    private String name;

    public Dog() {
        age = 0;
        name = "";
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int age_to_human() {
        return (age * 7);
    }

    @Override
    public String toString() {
        return ("Возраст - " + age +
                "\tКличка - " + name);
    }
}
```
**Dog_nursery.java**
```java
package com.company.practice2;

public class Dog_nursery {
    int place = 0;
    Dog[] arr = new Dog[10];

    public void add(Dog dog) {
        arr[place] = dog;
        place++;
        System.out.println("Succes!");
    }
}
```
**Main.java**
```java
package com.company.practice2;

public class Main {
    public static void main(String[] args) {
        //1
        Shape triangle = new Shape();
        triangle.setLength(10);
        triangle.setWidth(20);
        System.out.println("Фигура:\n" +
                triangle.getLength() +
                "\n" + triangle.getWidth() +
                "\n" + triangle.toString());

        //2
        Ball football = new Ball();
        football.setRadius(5);
        football.setVolume(15);
        System.out.println("Мяч:\n" +
                football.getRadius() +
                "\n" + football.getVolume() +
                "\n" + football.toString());

        //3
        Book tutorial = new Book();
        tutorial.setPages(75);
        tutorial.setPrice(150);
        System.out.println("Книга:\n" +
                tutorial.getPages() +
                "\n" + tutorial.getPrice() +
                "\n" + tutorial.toString());

        //4
        Dog a = new Dog();
        a.setAge(4);
        a.setName("Ponchik");
        System.out.println(a.toString());
        System.out.println(a.age_to_human());
        Dog_nursery b = new Dog_nursery();
        b.add(a);

    }
}
```
**Shape.java**
```java
package com.company.practice2;

public class Shape {
    private int length;
    private int width;

    @Override
    public String toString() {
        return ("Длина - " + length +
                "\nШирина - " + width);
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }
}

```
## practice3
**Book.java**
```java
package com.company.practice3;

public class Book {
    private String author;
    private String name;
    private int year;

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }
}
```
**BookTest.java**
```java
package com.company.practice3;

public class BookTest {
    public static void main(String[] args) {
        Book fantastic = new Book();
        fantastic.setAuthor("Стивен Кинг");
        fantastic.setName("Сияние");
        fantastic.setYear(1977);

        System.out.println("Книга:\n" + "Автор: " + fantastic.getAuthor() + "\nНазвание: " + fantastic.getName() + "\nГод издания: " + fantastic.getYear());
    }
}
```
**Circle.java**
```java
package com.company.practice3;

public class Circle {
    private int radius;
    private double area;

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getArea() {
        area = 3.14 * (radius * radius);
        return area;
    }
}
```
**CircleTest.java**
```java
package com.company.practice3;

public class CircleTest {
    public static void main(String[] args)
    {
        Circle a = new Circle();
        a.setRadius(5);
        System.out.println("Радиус = " + a.getRadius() + "\nПлощадь = " + a.getArea());
    }
}
```
**Human.java**
```java
package com.company.practice3;

public class Human {

    Head head;
    Leg legLeft;
    Leg legRight;
    Hand handLeft;
    Hand handRight;

    public Human(Head head, Leg legLeft, Leg legRight, Hand handLeft, Hand handRight) {
        this.head = head;
        this.legLeft = legLeft;
        this.legRight = legRight;
        this.handLeft = handLeft;
        this.handRight = handRight;

    }

    public static class Head {
        private String eyes;
        private String hair;

        public Head(String eyes, String hair) {
            this.eyes = eyes;
            this.hair = hair;
        }

        public void setEyes(String eyes) {
            this.eyes = eyes;
        }

        public String getEyes() {
            return eyes;
        }

        public void setHair(String hair) {
            this.hair = hair;
        }

        public String getHair() {
            return hair;
        }

        @Override
        public String toString() {
            return ("глаза = " + eyes +
                    ", волосы = " + hair);
        }
    }

    public static class Leg {
        private int length;
        private int width;

        public Leg(int length, int width) {
            this.length = length;
            this.width = width;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getLength() {
            return length;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getWidth() {
            return width;
        }

        @Override
        public String toString() {
            return ("длина = " + length +
                    ", ширина = " + width);
        }
    }

    public static class Hand {
        private int length;
        private int width;

        public Hand(int length, int width) {
            this.length = length;
            this.width = width;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getLength() {
            return length;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getWidth() {
            return width;
        }

        @Override
        public String toString() {
            return ("длина = " + length +
                    ", ширина = " + width);
        }
    }

        @Override
        public String toString() {
            return ("Human: " +
                    "\nГолова: " + head +
                    "\nЛевая нога: " + legLeft +
                    "\nПравая нога: " + legRight +
                    "\nЛевая рука: " + handLeft +
                    "\nПравая рука: " + handRight);
        }
}

```
**Main.java**
```java
package com.company.practice3;

public class Main {

    public static void main(String[] args)
    {
        Human.Head head = new Human.Head("карие", "черные");
        Human.Leg legLeft = new Human.Leg(80, 15);
        Human.Leg legRight = new Human.Leg(79, 15);
        Human.Hand handLeft = new Human.Hand(60, 10);
        Human.Hand handRight = new Human.Hand(60, 10);

        Human a = new Human(head, legLeft, legRight, handLeft, handRight);
        System.out.println(a.toString());
    }
}
```
## practice4
**Circle.java**
```java
package com.company.practice4;

public class Circle extends Shape{
    protected double radius;

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public Circle(double radius) {this.radius = radius;}
    public Circle() {}

    public double getRadius() {return radius;}
    public void setRadius(double radius) {this.radius = radius;}

    @Override
    public double getArea() {return (3.14 * 3.14 * radius);}

    @Override
    public double getPerimeter() {return (2 * 3.14 * radius);}

    @Override
    public String toString() {
        return ("Circle:\n" +
                "radius = " + radius +
                ", color = '" + color + '\'' +
                ", filled = " + filled);
    }
}
```
**Main.java**
```java
package com.company.practice4;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(7, "green", true);
        Rectangle rectangle = new Rectangle(3, 7, "yellow", true);
        Square square = new Square(2,  "black", false);
        System.out.println(circle.toString() + ", area = " + circle.getArea() + ", perimeter = " + circle.getPerimeter());
        System.out.println(rectangle.toString() + ", area = " + rectangle.getArea() + ", perimeter = " + rectangle.getPerimeter());
        System.out.println(square.toString() + ", area = " + square.getArea() + ", perimeter = " + square.getPerimeter());
    }
}
```
**Rectangle.java**
```java
package com.company.practice4;

public class Rectangle extends Shape {
    protected double width = 1;
    protected double length = 1;

    public Rectangle(double width, double length, String color, boolean filled){
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle() {}

    public double getWidth() {return width;}
    public void setWidth(double width) {this.width = width;}

    public double getLength() {return length;}
    public void setLength(double length) {this.length = length;}

    @Override
    public double getArea() {return (width * length);}
    @Override
    public double getPerimeter() {return ((width + length) * 2);}

    @Override
    public  String toString() {
        return ("Rectangle:\n" +
                "width = " + width +
                ", length = " + length +
                ", color = '" + color + '\'' +
                ", filled = " + filled);
    }
}
```
**Shape.java**
```java
package com.company.practice4;

public abstract class Shape {
    protected String color = "red";
    protected boolean filled = true;

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public Shape(){}

    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}

    public boolean isFilled() {return filled;}
    public void setFilled(boolean filled) {this.filled = filled;}

    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public String toString(){
        return ("Shape:\n" +
                "color = '" + color + '\'' +
                ", filled = " + filled);
    }
}
```
**Square.java**
```java
package com.company.practice4;

public class Square extends Shape{
    protected double side;

    public Square(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(){}

    @Override
    public double getArea() {return (side*side);}
    @Override
    public double getPerimeter() {return (side*4);}


    public void setSide(double side) {this.side = side;}
    public double getSide() {return side;}

    @Override
    public String toString() {
        return ("Square:\n" +
                "side = " + side +
                ", color = '" + color + '\'' +
                ", filled = " + filled);
    }
}
```
## practice5
**Main.java**
```java
package com.company.practice5;

public class Main {
    public static void main(String[] args) {
        MovablePoint a = new MovablePoint(7, 10);
        System.out.println(a);
        a.moveLeft(12);
        a.moveRight(15);
        a.moveUp(4);
        a.moveDown(5);
        System.out.println(a);
        MovableCircle b = new MovableCircle(2, 10, 16);
        System.out.println(b);
        b.moveLeft(11);
        b.moveRight(0);
        b.moveUp(15);
        b.moveDown(20);
        System.out.println(b);
        MovableRectangle c = new MovableRectangle(new MovablePoint(12, 23),new MovablePoint(20,15));
        System.out.println(c);
        c.moveUp(20);
        c.moveRight(50);
        System.out.println(c.getLength());
        System.out.println(c);
    }
}

```
**Movable.java**
```java
package com.company.practice5;

public interface Movable {
    void moveUp(double y);
    void moveDown(double y);
    void moveLeft(double x);
    void moveRight(double x);
}
```
**MovableCircle.java**
```java
package com.company.practice5;

import com.company.practice4.Circle;

public class MovableCircle extends Circle implements Movable {
    private MovablePoint center;

    public MovableCircle(int radius, double x, double y) {
        center = new MovablePoint(x, y);
        this.radius = radius;
    }

    public MovablePoint getCenter() {
        return center;
    }

    public void setCenter(MovablePoint center) {
        this.center = center;
    }

    @Override
    public void moveUp(double y) {
        center.y += y;
    }

    @Override
    public void moveDown(double y) {
        center.y -= y;
    }

    @Override
    public void moveLeft(double x) {
        center.x -= x;
    }

    @Override
    public void moveRight(double x) {
        center.x += x;
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }
}
```
**MovablePoint.java**
```java
package com.company.practice5;

public class MovablePoint implements Movable {
    protected double x;
    protected double y;

    public MovablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void moveUp ( double y){
        this.y += y;
    }

    public void moveDown ( double y){
        this.y -= y;
    }

    public void moveLeft ( double x){
        this.x -= x;
    }


    public void moveRight ( double x){
        this.x += x;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
```
**MovableRectangle.java**
```java
package com.company.practice5;

        import com.company.practice4.Rectangle;

public class MovableRectangle extends Rectangle implements Movable{
    private MovablePoint LeftUp;
    private MovablePoint RightDown;

    public MovableRectangle(MovablePoint LeftUp, MovablePoint RightDown){
        this.LeftUp = LeftUp;
        this.RightDown = RightDown;
    }

    public MovablePoint getLeftUp() {
        return LeftUp;
    }

    public MovablePoint getRightDown() {
        return RightDown;
    }

    public double getLength() {
        return Math.abs(LeftUp.getX() - RightDown.getX());
    }

    public double getWidth() {
        return Math.abs(LeftUp.getY() - RightDown.getY());
    }


    @Override
    public void moveUp(double y) {
        LeftUp.moveUp(y);
        RightDown.moveUp(y);
    }

    @Override
    public void moveDown(double y) {
        LeftUp.moveDown(y);
        RightDown.moveDown(y);
    }

    @Override
    public void moveLeft(double x) {
        LeftUp.moveLeft(x);
        RightDown.moveLeft(x);
    }

    @Override
    public void moveRight(double x) {
        LeftUp.moveRight(x);
        RightDown.moveRight(x);
    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "LeftUp=" + LeftUp +
                ", RightDown=" + RightDown +
                '}';
    }
}

```
## practice6
**Main.java**
```java
package com.company.practice6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[][] square = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                square[i][j] = in.nextInt();
            }
        }


        for (int i = size - 1; i >= 0; i--) {
            for (int j = size - 1; j >= 0; j--) {
                if (i == size - 1 && j != size - 1) {
                    square[i][j] += square[i][j+1];
                }
                else if (i != size - 1 && j == size - 1) {
                    square[i][j] += square[i+1][j];
                }
                else if (i != size - 1 && j != size - 1) {
                    if (square[i][j + 1] > square[i + 1][j]) {
                        square[i][j] += square[i][j + 1];
                    } else {
                        square[i][j] += square[i + 1][j];
                    }
                }
            }
        }
        System.out.println(square[0][0]);
    }
}
```
## practice7_8
**Company.java**
```java
package com.company.practice7_8;

import  java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Company {
    private List <Employee> employees = new ArrayList<>();

    public void hire(Employee employee){
        employees.add(employee);
    }

    public void hireAll(List<Employee> employeeList){
        for(Employee employee: employeeList){
            hire(employee);
        }
    }

    public Employee searchForFire(String name, String surname, String position){

        for(Employee employee: employees){
            if(employee.getName().equals(name) && employee.getSurname().equals(surname) && employee.getPosition().getJobTitle() == position){
                return employee;
            }
        }
        return null;
    }

    public void fire(String surname, String name, String position){
        employees.remove(searchForFire(name, surname, position));
    }

    public void fire(int indexOfEmployee){
        employees.remove(indexOfEmployee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double getIncome(){
        double income = 0;
        for (Employee employee: employees) {
            if(employee.getPosition().getJobTitle().equals("Manager")) {
                income += ((Manager)employee.getPosition()).getCount();
            }
        }
        return income;
    }

    public void sortEmployeesTop(){
        employees.sort(Comparator.comparing(Employee::getSalary).reversed());
    }

    public void sortEmployeesLowest(){
        employees.sort(Comparator.comparing(Employee::getSalary));
    }

    public List<Employee> getTopSalaryStaff(int count){
        if(count > 0 && employees.size() > count){

            this.sortEmployeesTop();
            return employees.subList(0, count);
        }
        else
            return null;

    }

    public List<Employee> getLowestSalaryStaff(int count){
        if(count > 0 && employees.size() > count){

            this.sortEmployeesLowest();
            return employees.subList(0, count);
        }
        else
            return null;
    }

    public void PrintList(){
        for(Employee employee: employees){
            System.out.println(employee.getSurname() + " " + employee.getName() + " - " + employee.getPosition().getJobTitle() + " " +
                    (int)employee.getPosition().calcSalary(employee.getFixSalary()) + " рублей");
        }
    }

    public void PrintList(List<Employee> list){
        for(Employee employee: list){
            System.out.println(employee.getSurname() + " " + employee.getName() + " - " + employee.getPosition().getJobTitle() + " " +
                    (int)employee.getPosition().calcSalary(employee.getFixSalary()) + " рублей");
        }
    }
}
```
**Employee.java**
```java
package com.company.practice7_8;

public class Employee {
    private String surname;
    private String name;
    private double fixSalary;
    private double salary;
    private EmployeePosition Position;

    public Employee(String surname, String name, double fixSalary, EmployeePosition position) {
        this.surname = surname;
        this.name = name;
        this.fixSalary = fixSalary;
        Position = position;
        this.salary = Position.calcSalary(fixSalary);
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFixSalary(double fixSalary) { this.fixSalary = fixSalary; }

    public double getFixSalary() { return fixSalary; }

    public void setPosition(EmployeePosition position) {
        Position = position;
    }

    public EmployeePosition getPosition() {
        return Position;
    }

    public double getSalary() { return salary; }
}
```
**EmployeePosition.java**
```java
package com.company.practice7_8;

public interface EmployeePosition {
    String getJobTitle();
    double calcSalary(double baseSalary);
}
```
**Main.java**
```java
package com.company.practice7_8;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();

        for (int i = 1; i <= 180 ; i++) {
            company.hire(new Employee("Operator ", Integer.toString(i),
                    2000 + (Math.random() * 3000), new Operator()));
        }

        for (int i = 1; i <= 80 ; i++) {
            company.hire(new Employee("Manager", Integer.toString(i),
                    7000 + (Math.random() * 3000), new Manager()));
        }

        for (int i = 1; i <= 80 ; i++) {
            company.hire(new Employee("TopManager", Integer.toString(i),
                    15000 + (Math.random() * 10000), new TopManager(company)));
        }

        company.getIncome();
        company.PrintList(company.getTopSalaryStaff(10));
        System.out.println("*************************************************");
        company.PrintList(company.getLowestSalaryStaff(30));

        for (int i = 0; i < company.getEmployees().size()/2; i++) {
            company.fire((int)Math.random() * 340);
        }

        System.out.println("\nПосле увольнения: \n");
        company.PrintList(company.getTopSalaryStaff(10));
        System.out.println("*************************************************");
        company.PrintList(company.getLowestSalaryStaff(30));

        System.out.println();
        Company company1 = new Company();
        company1.hire(new Employee("Shikalov", "Danila", 2000, new Manager()));
        company1.PrintList();
        company1.fire("Shikalov", "Danila", "Manager");
        company1.PrintList();
    }
}
```
**Manager.java**
```java
package com.company.practice7_8;

public class Manager implements EmployeePosition {
    private double count = 115000 + (Math.random() * 25000);

    public double getCount() {
        return count;
    }

    @Override
    public String getJobTitle() {
        return "Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary + 0.05 * count;
    }
}
```
**Operator.java**
```java
package com.company.practice7_8;

public class Operator implements EmployeePosition {

    @Override
    public String getJobTitle() {
        return "Operator";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary;
    }
}
```
**TopManager.java**
```java
package com.company.practice7_8;

public class TopManager implements EmployeePosition{

    private Company company;

    public TopManager(Company company)
    {
        this.company = company;
    }

    @Override
    public String getJobTitle() {
        return "TopManager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        if(company.getIncome() > 10000000)
            return 2.5 * baseSalary;
        else
            return baseSalary;
    }
}
```
## practice9
**Company.java**
```java
package com.company.practice9;

import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> employees = new ArrayList<>();

    public void hire(Employee employee){
        employees.add(employee);
    }

    public void fire(int index){
        employees.remove(index);
    }

    public void doSomethingWithEmployees(EmployeeSelector selector, EmployeeHandler handler){
        int count = 0;
        for(Employee employee : employees){
            if (selector.isNeedEmployee(employee)){
                handler.handleEmployee(employee, count);
                count++;
            }
        }
        System.out.println(count);
        System.out.println("*******************************************************\n");
    }

    public void printList(){
        for (Employee employee:
             employees) {
            System.out.println(employee);
        }
        System.out.println("*******************************************************");
    }

    @Override
    public String toString() {
        return "Company{" +
                "employees=" + employees +
                '}';
    }
}
```
**Employee.java**
```java
package com.company.practice9;

import java.time.LocalDate;

public class Employee {
    private String name;
    private String surname;
    private final LocalDate dateOfBirth;
    private String location;
    private String phoneNumber;
    private int salary;

    public Employee(String name, String surname, LocalDate dateOfBirth, String location, String phoneNumber, int salary) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", location='" + location + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary +
                '}';
    }
}
```
**EmployeeHandler.java**
```java
package com.company.practice9;

public interface EmployeeHandler {
    void handleEmployee(Employee employee, int index);
}
```
**EmployeeSelector.java**
```java
package com.company.practice9;

public interface EmployeeSelector {
    boolean isNeedEmployee(Employee employee);
}
```
**Main.java**
```java
package com.company.practice9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        Random random = new Random();

        for (int i = 0; i < 15; i++){
            company.hire(new Employee(
                    "Employee",
                    "" + Integer.toString(i+1),
                    LocalDate.of(1955 + random.nextInt(49), random.nextInt(11) + 1, random.nextInt(28) + 1),
                    "Moscow",
                    "8900-900-20-22",
                    (int)(1000 + Math.random() * 99_000)));
        }

        System.out.println("Сотрудники, зарплата которых колеблется от 10000 до 20000:");
        company.doSomethingWithEmployees(
                new SalarySelector(10_000, 20_000),
                (employee, index) -> System.out.println(employee));

        System.out.println("Повышаем зарплату сотрудникам на 3000, зарплата которых меньше 5000: ");
        int a = 3_000;
        company.printList();
        company.doSomethingWithEmployees(new EmployeeSelector() {
            @Override
            public boolean isNeedEmployee(Employee employee) {
                return employee.getSalary() < a;
            }
        }, new EmployeeHandler() {
            @Override
            public void handleEmployee(Employee employee, int index) {
                employee.setSalary(employee.getSalary() + 5000);
                System.out.println(employee);
            }
        });
    }
}
```
**SalarySelector.java**
```java
package com.company.practice9;

public class SalarySelector implements EmployeeSelector{

    private int salaryStart;
    private int salaryEnd;

    public SalarySelector(int salaryStart, int salaryEnd) {
        this.salaryStart = salaryStart;
        this.salaryEnd = salaryEnd;
    }

    @Override
    public boolean isNeedEmployee(Employee employee) {
        return employee.getSalary() >= salaryStart && employee.getSalary() <= salaryEnd;
    }
}
```
