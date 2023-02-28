package ru.homework.task2.models.lotteryStuff;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Random;

@Component
public class Dropper {
    private final Random random;
//    private final int[] intSet;
    private ArrayHolder arrayHolder;

    public Dropper() {
        this.random = new Random();
//        this.intSet = new int[10];
    }

    private void seed() {
        int[] newIntSet = new int[10];
        Arrays.stream(newIntSet).forEach(n -> n = random.nextInt(0, 2));
        this.arrayHolder = new ArrayHolder(newIntSet);
    }

    public int[] getIntSet() {
        this.seed();
        return this.arrayHolder.getArray();
    }

    public Double check(int[] values) {
        double guessRate = 0.0;
        int[] generatedArray = this.arrayHolder.getArray();
        for (int i = 0; i < values.length; i++) {
            if (values[i] == generatedArray[i]) {
                guessRate += 0.1;
            }
        }
        guessRate = Math.round(guessRate * 10);
        return guessRate / 10;
    }
}
