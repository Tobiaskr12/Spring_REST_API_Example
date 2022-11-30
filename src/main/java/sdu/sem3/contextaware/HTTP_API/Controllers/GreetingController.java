package sdu.sem3.contextaware.HTTP_API.Controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sdu.sem3.contextaware.HTTP_API.POJO.Greeting;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting getGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping("/greeting")
    public Greeting createGreeting(@RequestBody Greeting newGreeting) {
        return newGreeting;
    }

    @GetMapping("/example400")
    public void example400() {
        throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST, "This endpoint returns status code 400"
        );
    }

    @GetMapping("/example500")
    public void example500() {
        throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR, "This endpoint returns status code 500"
        );
    }
}
