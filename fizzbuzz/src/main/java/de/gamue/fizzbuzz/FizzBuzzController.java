package de.gamue.fizzbuzz;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fizzbuzz")
@Tag(name = "FizzBuzz", description = "The well-known fizz buzz word game")
public class FizzBuzzController {

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Operation(summary = "Execute the logic")
    public List<String> execute(@RequestHeader @Parameter(description = "The maximum number") int maxNumber) {
        return FizzBuzz.getEntries(maxNumber);
    }
}
