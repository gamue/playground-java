package de.gamue.fizzbuzz;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fizzbuzz")
@Api(description = "The well-known fizz buzz word game", tags = {"FizzBuzz"})
public class FizzBuzzController {

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Execute the logic")
    public List<String> execute(@RequestHeader @ApiParam(value = "The maximum number") int maxNumber) {
        return FizzBuzz.getEntries(maxNumber);
    }
}
