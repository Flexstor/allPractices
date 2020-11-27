package com.company.practice21_22;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class LocalGson implements ItemsStore{
    private Gson gson = new Gson();
    private String path = "src\\main\\java\\com\\company\\practice21_22\\data.json";
    private File file = new File(path);
    private FileWriter fileWriter;

    public LocalGson() {
        try (PrintWriter writer = new PrintWriter(file)) {
            file.createNewFile();
            writer.write("[\n]");
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    @Override
    public List<Item> getAll() throws FileNotFoundException {
        Type type = new TypeToken<List<Item>>(){}.getType();
        List<Item> itemsList;
        FileReader fileReader = new FileReader(file);
        itemsList = gson.fromJson(fileReader, type);
        return itemsList;
    }

    @Override
    public Item get(int id) throws FileNotFoundException {
        List<Item> itemsList = getAll();
        for (int i = 0; i < itemsList.size(); i++) {
            if(itemsList.get(i).getId() == id){
                return itemsList.get(i);
            }
        }
        return null;
    }

    @Override
    public String addItem(Item item) throws IOException {
        List<Item> itemsList = getAll();
        itemsList.add(item);
        fileWriter = new FileWriter(path);
        fileWriter.write("[\n");
        for (int i = 0; i < itemsList.size(); i++) {
            fileWriter.write(itemsList.get(i).toStringLocal());
            if (i != itemsList.size() - 1) fileWriter.write(",");
            fileWriter.write("\n");
        }
        fileWriter.write("]");
        fileWriter.close();
        return "added";
    }

    @Override
    public Item editItem(Item item) throws IOException {
        int id = item.getId();
        List<Item> itemsList = getAll();
        fileWriter = new FileWriter(path);
        for (Item i : itemsList) {
            if (i.getId() == id) {
                i.setId(item.getId());
                i.setData(item.getData());
                i.setIsGood(item.getIsGood());
                i.setDescription(item.getDescription());
            }
        }
        fileWriter.write("[\n");
        for (int i = 0; i < itemsList.size(); i++) {
            fileWriter.write(itemsList.get(i).toStringLocal());
            if (i != itemsList.size() - 1) fileWriter.write(",");
            fileWriter.write("\n");
        }
        fileWriter.write("]");
        fileWriter.close();
        return item;
    }

    @Override
    public void deleteItem(Item item) throws IOException {
        int id = item.getId();
        List<Item> itemsList = getAll();
        fileWriter = new FileWriter(path);
        for (int i = 0; i < itemsList.size(); i++) {
            if (itemsList.get(i).getId() == id) {
                itemsList.remove(i);
            }
        }
        fileWriter.write("[\n");
        for (int i = 0; i < itemsList.size(); i++) {
            fileWriter.write(itemsList.get(i).toStringLocal());
            if (i != itemsList.size() - 1) fileWriter.write(",");
            fileWriter.write("\n");
        }
        fileWriter.write("]");
        fileWriter.close();
    }
}
