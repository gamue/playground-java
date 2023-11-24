package de.gamue.api;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.Set;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
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

  @Test
  public void testValidation() {
    Validator validator =
        Validation.byDefaultProvider()
            .configure()
            .messageInterpolator(new ParameterMessageInterpolator())
            .buildValidatorFactory()
            .getValidator();

    Set<ConstraintViolation<Person>> violations = validator.validate(new Person());
    Assertions.assertEquals(2, violations.size());
  }
}
