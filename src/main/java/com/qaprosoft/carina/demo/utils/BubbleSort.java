package com.qaprosoft.carina.demo.utils;

import java.util.Arrays;
import java.util.List;

public class BubbleSort {

    private static List<Integer> numbers = Arrays.asList(7, 8, 1, 4, 5);

    public static void sort() {
        System.out.println(numbers);
        for (int j = 0; j < numbers.size(); j++) {
            for (int i = 1; i < numbers.size() - j; i++) {
                if (!(numbers.get(i-1) <= numbers.get(i))) {
                    int x = numbers.get(i - 1);
                    numbers.set(i - 1, numbers.get(i));
                    numbers.set(i, x);
                }
            }
        }
        System.out.println(numbers);
    }

    public static String verifyNumbers(List<Integer> integerList) {
        for (int i = 0; i < integerList.size() - 1; i++) {
            if (integerList.get(i) > integerList.get(i+1)) {
                return "Method wasn't sorted.";
            }
        }
        return "Method was sorted.";
    }

    public static void main(String[] args) {
        sort();
        System.out.println(verifyNumbers(numbers));
    }
}
