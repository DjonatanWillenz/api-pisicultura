package br.com.api.utils;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class UtilsRandom {

    private Random random;

    private static UtilsRandom instance;

    public Long getNumberBetween(long min, long max) {
        return random.nextLong();
    }

    private UtilsRandom() {
        this.random = new Random();
    }

    public static UtilsRandom getInstance() {
        return instance == null ? new UtilsRandom() : instance;
    }
}
