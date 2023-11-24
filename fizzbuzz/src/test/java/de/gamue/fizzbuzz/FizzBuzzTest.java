package de.gamue.fizzbuzz;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FizzBuzzTest {

  @Test
  public void testNegativeInput() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> FizzBuzz.getEntries(-1));
  }

  @Test
  public void testZeroInput() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> FizzBuzz.getEntries(0));
  }

  @Test
  public void testValidOutput() {
    List<String> expected =
        List.of(
            "1",
            "2",
            "fizz",
            "4",
            "buzz",
            "fizz",
            "7",
            "8",
            "fizz",
            "buzz",
            "11",
            "fizz",
            "13",
            "14",
            "fizzbuzz");

    Assertions.assertEquals(expected, FizzBuzz.getEntries(15));
  }
}
