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
