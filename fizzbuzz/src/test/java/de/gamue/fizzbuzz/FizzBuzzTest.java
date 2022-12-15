package de.gamue.fizzbuzz;

import java.util.ArrayList;
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
    List<String> expected = new ArrayList<>();
    expected.add("1");
    expected.add("2");
    expected.add("fizz");
    expected.add("4");
    expected.add("buzz");
    expected.add("fizz");
    expected.add("7");
    expected.add("8");
    expected.add("fizz");
    expected.add("buzz");
    expected.add("11");
    expected.add("fizz");
    expected.add("13");
    expected.add("14");
    expected.add("fizzbuzz");

    List<String> result = FizzBuzz.getEntries(15);

    Assertions.assertEquals(expected, result);
  }
}
