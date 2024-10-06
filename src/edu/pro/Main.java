package edu.pro;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.stream.Collectors;

public class Main {

    // Метод для очищення тексту і приведення його до нижнього регістру
    public static String cleanText(String url) throws IOException {
        // Використовуємо StringBuilder для ефективнішого маніпулювання рядками
        StringBuilder content = new StringBuilder(new String(Files.readAllBytes(Paths.get(url))));
        // Замінюємо всі символи, які не є літерами, на пробіли
        return content.toString().replaceAll("[^A-Za-z ]", " ").toLowerCase(Locale.ROOT);
    }

    // Метод для підрахунку частоти кожного слова
    public static Map<String, Integer> countWordFrequencies(String[] words) {
        Map<String, Integer> wordFrequencies = new HashMap<>();
        for (String word : words) {
            wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
        }
        return wordFrequencies;
    }

    public static void main(String[] args) throws IOException {

        LocalDateTime start = LocalDateTime.now();
        String content = cleanText("src/edu/pro/txt/harry.txt"); // Використання методу для очищення тексту

        String[] words = content.split(" +"); // 400 000 слів, поділених пробілами

        Map<String, Integer> wordFrequencies = countWordFrequencies(words); // Підрахунок частот слів

        // Сортуємо карту за частотою слів
        List<Map.Entry<String, Integer>> sortedEntries = wordFrequencies.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toList());

        // Виводимо топ-30 найбільш частих слів
        sortedEntries.stream().limit(30).forEach(entry -> 
                System.out.println(entry.getKey() + " " + entry.getValue()));

        LocalDateTime finish = LocalDateTime.now();
        System.out.println("------");
        System.out.println(ChronoUnit.MILLIS.between(start, finish));

    }
}
