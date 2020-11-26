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
