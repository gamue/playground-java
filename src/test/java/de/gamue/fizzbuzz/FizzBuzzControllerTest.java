package de.gamue.fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FizzBuzzControllerTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void testValidRequest() {
    HttpHeaders headers = new HttpHeaders();
    headers.set("maxNumber", "10");
    HttpEntity<String> entity = new HttpEntity<>(null, headers);
    ResponseEntity<List> exchange = restTemplate.exchange("/fizzbuzz", HttpMethod.POST, entity, List.class);
    Assertions.assertEquals(HttpStatus.OK, exchange.getStatusCode());
  }

  @Test
  public void testParameterMissing() {
    HttpEntity<String> entity = new HttpEntity<>(null, null);
    ResponseEntity<Object> exchange = restTemplate.exchange("/fizzbuzz", HttpMethod.POST, entity, Object.class);
    Assertions.assertEquals(HttpStatus.BAD_REQUEST, exchange.getStatusCode());
  }

  @Test
  public void testInvalidParameter() {
    HttpHeaders headers = new HttpHeaders();
    headers.set("maxNumber", "-10");
    HttpEntity<String> entity = new HttpEntity<>(null, headers);
    ResponseEntity<Object> exchange = restTemplate.exchange("/fizzbuzz", HttpMethod.POST, entity, Object.class);
    Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, exchange.getStatusCode());
  }
}
