package de.gamue.fizzbuzz;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(IllegalArgumentException e){
        ErrorResponse response = new ErrorResponse();
        response.setMessage(e.getMessage());
        return response;
    }
}
