package com.example.coursefx.lab5;

import com.example.coursefx.lab5.Exceptions.EmptyCollectionException;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamMethods {
    public static double getAverageValue(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public static List<String> transformStrings(List<String> list) {
        return list.stream().map(str -> "_new_" + str.toUpperCase()).collect(Collectors.toList());
    }

    public static List<Double> getUniqueSquares(List<Double> list) {
        return list.stream().distinct().map(n -> n * n).toList();
    }

    public static List<String> getStringsStartingWithLetter(Collection<String> collection, char letter) {
        return collection.stream()
                .filter(str -> !str.isEmpty() && str.charAt(0) == letter)
                .sorted()
                .collect(Collectors.toList());
    }

    public static <T> T getLastElement(Collection<T> collection) throws EmptyCollectionException {
        return collection.stream().reduce((first, second) -> second).orElseThrow(EmptyCollectionException::new);
    }

    public static int getSumOFEvens(int [] arr) {
        return Arrays.stream(arr).filter(n -> n % 2 == 0).reduce(Integer::sum).orElse(0);
    }

    public static Map<Character, List<String>> convertListToMap(List<String> list) {
        return list.stream()
                .filter(str -> !str.isEmpty())
                .collect(Collectors.groupingBy(c -> c.charAt(0), Collectors.mapping(v -> v.substring(1), Collectors.toList())));
    }
}
