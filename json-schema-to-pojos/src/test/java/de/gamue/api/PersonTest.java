package de.gamue.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonTest {

    private static final Integer AGE = 23;
    private static final String NAME = "Peter Parker";

    @Test
    public void testExistence() {
        Person p = new Person();
        p.setAge(AGE);
        p.setName(NAME);

        Assertions.assertEquals(AGE, p.getAge());
        Assertions.assertEquals(NAME, p.getName());
    }

}
