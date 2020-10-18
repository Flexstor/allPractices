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
