package yahoo.garg.sharad.springmockitojunit.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;

@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> search(@Email @RequestParam("email") String email) {
        System.out.println("Invoked");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
