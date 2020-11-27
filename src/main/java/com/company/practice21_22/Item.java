package com.company.practice21_22;

public class Item {
    private int id;
    private String data;
    private boolean isGood;
    private String description;

    public Item(int id, String data, boolean isGood, String description) {
        this.id = id;
        this.data = data;
        this.isGood = isGood;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean getIsGood() {
        return isGood;
    }

    public void setIsGood(boolean isGood) {
        isGood = isGood;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", isGood=" + isGood +
                ", description='" + description + '\'' +
                '}';
    }

    public String toStringNotDes() {
        return "Item{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", isGood=" + isGood +
                '}';
    }

    public String toStringLocal()
    {
        return "  {" +
                "\n    \"id\": " + id + "," +
                "\n    \"data\": " + "\"" + data +"\"" + "," +
                "\n    \"isGood\": " + isGood + "," +
                "\n    \"description\": " + "\"" + description + "\"" +
                "\n  }";
    }
}