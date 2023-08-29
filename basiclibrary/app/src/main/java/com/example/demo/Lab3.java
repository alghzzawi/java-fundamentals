package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class Lab3 {
    public static void wither(int[][] arr){


        Set <Integer> unique = new HashSet<>();
        Set <Integer> temps = new HashSet<>();

        int max = arr[0][0];
        int min = arr[0][0];


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                unique.add(arr[i][j]);
                if (arr[i][j] > max){
                    max = arr[i][j];
                }
                if (arr[i][j] < min){
                    min = arr[i][j];
                }
            }
        }

        for (int i = min; i < max; i++) {
            temps.add(i);
        }

        System.out.println("High: " + max);
        System.out.println("Low: " + min);

        for (Integer temp : temps) {
            if (!unique.contains(temp)) {
                System.out.println("Never saw temperature: " + temp);
            }
        }
    }

    public static String tally(List<String> list){
        Map<String,Integer> countOfWinner = new HashMap<>();
        for (String word :
                list) {
            countOfWinner.put(word, countOfWinner.getOrDefault(word, 0) + 1);
        }
        String maxKey = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : countOfWinner.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxKey = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return maxKey;
    }
    public String linter(Path path) {
        int counter = 0;
        StringBuilder errorLine = new StringBuilder();
        try {
            File myFile = new File(path.toUri());
            Scanner scanner = new Scanner(myFile);

            while (scanner.hasNextLine()) {
                counter++;
                String data = scanner.nextLine();
                if (!data.endsWith(";") && !data.endsWith("}") && !data.endsWith("{") && !data.contains("else") && !data.contains("if") && !data.isEmpty() || data.contains("return") && !data.endsWith(";")) {
                    errorLine.append("Line ").append(counter).append(" : Missing semicolon.\n");
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        return errorLine.toString();
    }
}
