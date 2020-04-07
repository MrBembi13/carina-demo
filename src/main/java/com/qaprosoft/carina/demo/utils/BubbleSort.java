package com.qaprosoft.carina.demo.utils;

import java.util.Arrays;
import java.util.List;

public class BubbleSort {

    private static List<Integer> numbers = Arrays.asList(7, 8, 1, 4, 5, 2, 9, 3, 6);
    private static List<Integer> numbers2 = Arrays.asList(21, 48, 14, 4, 2, 8, 18, 39, 99, 12, 5);

    public static void sort(List<Integer> integerList) {
        System.out.println(integerList);
        for (int j = 0; j < integerList.size(); j++) {
            for (int i = 1; i < integerList.size() - j; i++) {
                if (!(integerList.get(i - 1) <= integerList.get(i))) {
                    int x = integerList.get(i - 1);
                    integerList.set(i - 1, integerList.get(i));
                    integerList.set(i, x);
                }
            }
        }
        System.out.println(integerList);
    }

    public static String verifyNumbers(List<Integer> integerList) {
        for (int i = 0; i < integerList.size() - 1; i++) {
            if (integerList.get(i) > integerList.get(i + 1)) {
                return "Method wasn't sorted.";
            }
        }
        return "Method was sorted.";
    }

    public static int sumNumbers(List<Integer> integerList) {
        int sum = 0;
        for (int i : integerList) {
            sum += i;
        }
        return sum;
    }

    public static int maxNumberInList(List<Integer> integerList) {
        int max = 0;
        for (int i : integerList) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }

    public static String twoMinNumbersInList(List<Integer> integerList) {
        int min1 = 100, min2 = 100;
        int index = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < integerList.size(); j++) {
                if (i == 1) {
                    if ((min2 > integerList.get(j)) && !(index == j)) {
                        min2 = integerList.get(j);
                    }
                }
                if (min1 > integerList.get(j)) {
                    min1 = integerList.get(j);
                    index = j;
                }
            }
        }
        return "min1 = " + min1 + "\nmin2 = " + min2;
    }

    public static float arithmeticMean(List<Integer> integerList) {
        float average = 0;
        float sum = 0;
        for (int i : integerList) {
            sum += i;
        }
        average = sum / integerList.size();
        return average;
    }

    public static int maxNumberAmongEvenIndexes(List<Integer> integerList) {
        int max = 0;
        for (int i = 2; i < integerList.size(); i++) {
            if ((max < integerList.get(i)) && (i % 2 == 0)) {
                max = integerList.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        sort(numbers2);
        System.out.println(verifyNumbers(numbers2));

        System.out.println("sum = " + sumNumbers(numbers2));

        System.out.println("max number = " + maxNumberInList(numbers2));

        System.out.println(twoMinNumbersInList(numbers2));

        System.out.println("Arithmetic mean = " + arithmeticMean(numbers2));

        System.out.println("max number among even indexes = " + maxNumberAmongEvenIndexes(numbers2));
    }
}
