package ru.homework.task2.models.lotteryStuff;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Dropper {
    private final Random random;
    private final int[] intSet;

    public Dropper() {
        this.random = new Random();
        this.intSet = new int[10];
    }

    private void seed() {
        for (int i = 0; i < intSet.length; i++) {
            intSet[i] = random.nextInt(0, 2);
        }
    }

    public int[] getIntSet() {
        this.seed();
        return intSet;
    }

    public Double check(int[] values) {
        double guessRate = 0.0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == intSet[i]) {
                guessRate += 0.1;
            }
        }
        guessRate = Math.round(guessRate * 10);
        return guessRate / 10;
    }
}
