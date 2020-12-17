package com.company.practice27_28;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Class<? extends Worker> aClass = worker.getClass();

        List<Method> methodsList = Arrays.stream(aClass.getDeclaredMethods())
                .filter(a -> Arrays.stream(a.getAnnotations())
                        .anyMatch(b -> b instanceof AnnotationForOperation))
                .collect(Collectors.toList());

        List<TasksWithType> tasksList = worker.getTasks();

        for (int i = 0; i < tasksList.size(); i++)
            for (int j = 0; j < methodsList.size(); j++)
                if (tasksList.get(i).getType().equals(methodsList.get(j).getAnnotation(AnnotationForOperation.class).s())) {
                    try {
                        methodsList.get(j).invoke(worker, tasksList.get(i).getData());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
    }
}

