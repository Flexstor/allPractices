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
