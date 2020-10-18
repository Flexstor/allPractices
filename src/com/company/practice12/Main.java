package com.company.practice12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner str = new Scanner(System.in);
        printText(str.nextLine(), Enums.CYAN);
    }

    private static void printText(String text, Enums color){
        System.out.println(color.getColorCode()+text);
    }

}
