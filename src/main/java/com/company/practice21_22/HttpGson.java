package com.company.practice21_22;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.lang.reflect.Type;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collection;
import java.util.List;

public class HttpGson implements ItemsStore {
    private Gson gson = new Gson();
    private HttpClient httpClient = HttpClient.newHttpClient();
    private String url = "http://80.87.199.76:3000/objects";

    @Override
    public List<Item> getAll() throws IOException, InterruptedException {
        Type collectionType = new TypeToken<Collection<Item>>() {
        }.getType();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        List<Item> itemsList = gson.fromJson(response.body(), collectionType);
        return itemsList;
    }

    @Override
    public Item get(int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url + "/" + id))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response.body(),Item.class);
    }

    @Override
    public String addItem(Item item) throws IOException, InterruptedException {
        String body = gson.toJson(item);
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create(url))
                .setHeader("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.body().startsWith("Error"))
            return "not added";
        return "added";
    }

    @Override
    public Item editItem(Item item) throws IOException, InterruptedException {
        int id = item.getId();
        System.out.println(gson.toJson(item));
        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(gson.toJson(item)))
                .uri(URI.create(url + "/" + id))
                .setHeader("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return item;
    }

    @Override
    public void deleteItem(Item item) throws IOException, InterruptedException {
        int id = item.getId();
        HttpRequest request = HttpRequest.newBuilder()
                .DELETE()
                .uri(URI.create(url + "/" + id))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
