package de.gamue.fizzbuzz;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fizzbuzz")
public class FizzBuzzController {

  @RequestMapping(method = RequestMethod.POST,
      produces = "application/json;charset=UTF-8")
  @ResponseBody
  public List<String> execute(@RequestHeader int maxNumber) {
    return FizzBuzz.getEntries(maxNumber);
  }
}
