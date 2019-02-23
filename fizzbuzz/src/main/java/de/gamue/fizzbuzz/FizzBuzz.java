package de.gamue.fizzbuzz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {

    private static final int DIVIDER_FIZZ = 3;
    private static final String TEXT_FIZZ = "fizz";
    private static final int DIVIDER_BUZZ = 5;
    private static final String TEXT_BUZZ = "buzz";
    private static final int DIVIDER_FIZZBUZZ = DIVIDER_FIZZ * DIVIDER_BUZZ;
    private static final String TEXT_FIZZBUZZ = TEXT_FIZZ + TEXT_BUZZ;

    private FizzBuzz() {
    }

    public static List<String> getEntries(int maxNumber) {
        if (maxNumber <= 0) {
            throw new IllegalArgumentException("maxNumber is smaller than 1.");
        }

        List<String> entries = new ArrayList<>();
        IntStream.range(1, maxNumber + 1).forEach(number -> entries.add(getValue(number)));
        return entries;
    }

    private static String getValue(int number) {
        if (number % DIVIDER_FIZZBUZZ == 0) {
            return TEXT_FIZZBUZZ;
        } else if (number % DIVIDER_BUZZ == 0) {
            return TEXT_BUZZ;
        } else if (number % DIVIDER_FIZZ == 0) {
            return TEXT_FIZZ;
        }
        return String.valueOf(number);
    }
}
