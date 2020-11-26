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

