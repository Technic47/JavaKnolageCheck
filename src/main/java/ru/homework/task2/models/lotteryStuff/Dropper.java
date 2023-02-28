package ru.homework.task2.models.lotteryStuff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Random;

@Component
public class Dropper {
    private final Random random;
    private ArrayHolder arrayHolder;

    @Autowired
    public Dropper(ArrayHolder arrayHolder) {
        this.arrayHolder = arrayHolder;
        this.random = new Random();
    }

    private void seed() {
        this.arrayHolder = new ArrayHolder(Arrays.stream(new int[10])
                .map(n -> n = random.nextInt(0, 2))
                .toArray());
    }

    public int[] getNewIntSet() {
        this.seed();
        return this.arrayHolder.getArray();
    }

    public int[] getIntSet() {
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

    public ArrayHolder getArrayHolder() {
        return arrayHolder;
    }
}
