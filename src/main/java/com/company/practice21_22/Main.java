package com.company.practice21_22;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ItemsStore itemsStore = null;
        Scanner in = new Scanner(System.in);

        System.out.println("1-Server\n" +
                "2-Local");
        int method = in.nextInt();
        while(method != 1 && method != 2)
        {
            System.out.println("Error! Try again\n" +
                    "1-Server\n" +
                    "2-Local");
            method = in.nextInt();
        }
        if (method == 1){
            itemsStore = new HttpGson();
        } else if (method == 2) {
            itemsStore = new LocalGson();
        }

        int action;
        while (true) {
            System.out.println("\nSelect an action\n" +
                    "to get all write '1'\n" +
                    "to get one write '2'\n" +
                    "to add write '3'\n" +
                    "to edit write '4'\n" +
                    "to delete write '5'\n" +
                    "to exit write '0'");
            action = in.nextInt();
            Item item;
            int Id;
            if (action != 0) {
                switch (action) {
                    case 1:
                        List<Item> items = itemsStore.getAll();
                        for (int i = 0; i < items.size(); i++) {
                            System.out.println(items.get(i).toStringNotDes());
                        }
                        break;
                    case 2:
                        System.out.print("Enter item id: ");
                        Id = in.nextInt();
                        item = itemsStore.get(Id);
                        if (item == null) {
                            System.out.println("Error");
                        } else {
                            System.out.println(item.toString());
                        }
                        break;
                    case 3:
                        item = createItem(true, -1);
                        itemsStore.addItem(item);
                        System.out.println("Item added");
                        break;
                    case 4:
                        System.out.print("Enter item id: ");
                        Id = in.nextInt();
                        item = itemsStore.get(Id);
                        System.out.println(item);
                        Item newItem = createItem(false, Id);
                        itemsStore.editItem(newItem);
                        System.out.println("Item edited");
                        break;
                    case 5:
                        System.out.print("Enter item id: ");
                        Id = in.nextInt();
                        itemsStore.deleteItem(new Item(Id, "", true, ""));
                        System.out.println("Item deleted");
                        break;
                }
            } else break;
        }
    }

    private static Item createItem(boolean ifAdd, int Id) {
        Scanner in = new Scanner(System.in);
        int id;
        if (ifAdd) {
            System.out.println("Write id:");
            id = in.nextInt();
            in.nextLine();
        }
        else id = Id;
        System.out.println("Write data:");
        String name = in.nextLine();
        System.out.println("Good or not?(true/false)");
        boolean isGood = in.nextBoolean();
        System.out.println("Write description:");
        in.nextLine();
        String description = in.nextLine();
        Item item = new Item(id, name, isGood, description);
        return item;
    }

}

