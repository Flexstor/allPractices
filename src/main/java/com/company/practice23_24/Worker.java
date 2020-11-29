package com.company.practice23_24;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Worker {
    private Gson gson = new Gson();
    private HttpClient httpClient = HttpClient.newHttpClient();
    private final String surname = "Mikhaylov";
    private final String urlTasks = "http://gitlessons2020.rtuitlab.ru:3000/tasks";
    private final String urlReports = "http://gitlessons2020.rtuitlab.ru:3000/reports";
    private String path = "src\\main\\java\\com\\company\\practice23_24\\db.json";
    private File file = new File(path);

    public Worker() {
        try (PrintWriter writer = new PrintWriter(file)){
            file.createNewFile();
            writer.write("[\n]");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void work() {
        while (true) {
            Thread thread = new Thread(() -> {
                try {
                    taskCompletion(getTasks());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            try {
                thread.join();
                Thread.sleep((long) (1000 + Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Task> getTasks() throws IOException, InterruptedException {
        Type collectionType = new TypeToken<Collection<Task>>() {
        }.getType();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(urlTasks))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        List<Task> tasksList = gson.fromJson(response.body(), collectionType);
        return tasksList;
    }

    public void taskCompletion(List<Task> tasks) throws IOException, InterruptedException {
        List<Integer> taskIDs = new ArrayList<>();
        double result = 0;
        for (Task task : tasks) {
            taskIDs.add(task.getId());
            if (!completedTasks().contains(task.getId())) {
                String expression = task.getExpression();
                expression = expression.replace(" ", "");
                Pattern pattern = Pattern.compile("([-]*\\d+)([*+/-])([-]*\\d+)");
                Matcher matcher = pattern.matcher(expression);
                if (matcher.find()) {
                    int first = Integer.parseInt(matcher.group(1));
                    String operator = matcher.group(2);
                    int second = Integer.parseInt(matcher.group(3));
                    switch (operator) {
                        case "+":
                            result = first + second;
                            break;
                        case "-":
                            result = first - second;
                            break;
                        case "*":
                            result = first * second;
                            break;
                        case "/":
                            result = Math.round(((double) first / (double) second) * 100.0) / 100.0;
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + operator);
                    }
                }
                Report report = new Report(0, task.getId(), surname, result);
                postReports(report);
                System.out.println(task.getTaskDescription() + " solved, solution sent.");
            } else {
                System.out.println("Task " + task.getId() + " has already been solved.");
            }
        }
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(gson.toJson(taskIDs));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void postReports(Report report) throws IOException, InterruptedException {
        String body = gson.toJson(report);
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create(urlReports))
                .setHeader("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public List<Integer> completedTasks() {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Integer> tasks = new ArrayList<>();
        String line;
        Type collectionType = new TypeToken<Collection<Integer>>() {
        }.getType();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line + "\n");
                line = reader.readLine();
            }
            tasks = gson.fromJson(stringBuilder.toString(), collectionType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    /*public void deleteRepost(Integer id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .DELETE()
                .uri(URI.create(urlReports + "/" + id))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }*/


}
