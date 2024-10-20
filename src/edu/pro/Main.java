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
        String content = Files.lines(Paths.get(url))
                .collect(Collectors.joining(" "))
                .replaceAll("[^A-Za-z ]", " ")
                .toLowerCase(Locale.ROOT);
        return content;
    }

    public static void main(String[] args) throws IOException {

        LocalDateTime start = LocalDateTime.now();

        // Читання файлу построково для економії пам'яті
        String content = Files.lines(Paths.get("src/edu/pro/txt/harry.txt"))
                .collect(Collectors.joining(" "))
                .replaceAll("[^A-Za-z ]", " ")
                .toLowerCase(Locale.ROOT);

        // Розділення на слова
        String[] words = content.split(" +");

        // Підрахунок частоти кожного слова за допомогою HashMap
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        // Формування списку рядків, що містять слово та частоту
        List<String> distincts = wordCountMap.entrySet().stream()
                .map(entry -> entry.getKey() + " " + entry.getValue())
                .collect(Collectors.toList());

        // Сортування за частотою
        distincts.sort(Comparator.comparingInt(str
                -> Integer.parseInt(str.replaceAll("[^0-9]", ""))));

        // Виведення 30 найпоширеніших слів
        for (int i = 0; i < 30; i++) {
            System.out.println(distincts.get(distincts.size() - 1 - i));
        }

        LocalDateTime finish = LocalDateTime.now();

        // Виведення часу виконання
        System.out.println("------");
        System.out.println(ChronoUnit.MILLIS.between(start, finish));
    }
}
