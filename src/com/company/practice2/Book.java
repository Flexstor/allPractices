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
