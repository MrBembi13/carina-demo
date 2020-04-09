package com.qaprosoft.carina.demo.utils;

import java.util.Random;

public class RandomUtil {
    private static Random random = new Random();

    public static String getRandomPhonesName() {
        int ranNumber = random.nextInt(PhonesName.values().length);
        String s = null;
        for (PhonesName n: PhonesName.values()) {
            if (ranNumber == n.ordinal()) {
                s = n.toString();
            }
        }
        return s;
    }
}
