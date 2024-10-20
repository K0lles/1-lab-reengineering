package edu.pro;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static String cleanText(String url) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(url)));
        content = content.replaceAll("[^A-Za-z ]"," ").toLowerCase(Locale.ROOT);
        return content;
    }

    public static void main(String[] args) throws IOException {

        LocalDateTime start = LocalDateTime.now();

        // Використання StringBuilder для уникнення конкатенації рядків
        StringBuilder contentBuilder = new StringBuilder(new String(Files.readAllBytes(Paths.get("src/edu/pro/txt/harry.txt"))));

        String content = contentBuilder.toString().replaceAll("[^A-Za-z ]"," ").toLowerCase(Locale.ROOT);

        // Використання HashMap для ефективного підрахунку частот
        String[] words = content.split(" +");
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        // Створення List з Map.Entry для сортування
        List<Map.Entry<String, Integer>> sortedEntries = wordCountMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toList());

        // Виведення топ-30 слів
        for (int i = 0; i < Math.min(30, sortedEntries.size()); i++) {
            Map.Entry<String, Integer> entry = sortedEntries.get(i);
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        LocalDateTime finish = LocalDateTime.now();
        System.out.println("------");
        System.out.println(ChronoUnit.MILLIS.between(start, finish));
    }
}
