package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Stream;


public class Main {


    public static void main(String[] args) {
// Функция детерминирована, но есть побочные эффекты в виде выражений ввода-вывода
        Function<Boolean, Boolean> function = d -> {
            System.out.println("Введите строку из слов, разделенных пробелами для составления словаря:");
            Stream.of(new Scanner(System.in)
                            .nextLine()
                            .split(" "))
                    .sorted(String::compareToIgnoreCase)
                    .collect(TreeMap::new, (map, word) -> map.put(word, word.substring(0, 1)), Map::putAll)
                    .forEach((key, value) -> {
                                System.out.println(value + " " + key);
                            }
                    );
            return true;
        };

        function.apply(false);

    }
}
