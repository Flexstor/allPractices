package com.company.practice21_22;

import java.io.IOException;
import java.util.List;

public interface ItemsStore {
    List<Item> getAll() throws IOException, InterruptedException;
    Item get(int id) throws IOException, InterruptedException;
    String addItem(Item item) throws IOException, InterruptedException;
    Item editItem(Item item) throws IOException, InterruptedException;
    void deleteItem(Item item) throws IOException, InterruptedException;
}
