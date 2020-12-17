package com.company.practice27_28;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Worker {
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private Type type = new TypeToken<List <TasksWithType>>(){}.getType();
    private HttpClient httpClient = HttpClient.newHttpClient();
    private final String urlTasks = "http://gitlessons2020.rtuitlab.ru:3000/reflectionTasks";

    @AnnotationForOperation(s = "sum")
    public void sum(Data data)
    {
        int sum = 0;
        for (int x : data.getNumbers())
        {
            sum += x;
        }
        System.out.println(sum);
    }
    @AnnotationForOperation(s = "print")
    public void print(Data data)
    {
        for (int i = 0; i < data.getWords().size(); i++)
        {
            if (i == data.getWords().size() - 1)
            {
                System.out.print(data.getWords().get(i));
            }
            else System.out.print(data.getWords().get(i) + " " + data.getDelimeter() + " ");
        }
    }

    public List<TasksWithType> getTasks() {
        List<TasksWithType> tasksList = null;
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(urlTasks))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            tasksList = gson.fromJson(response.body(), type);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return tasksList;
    }
}
