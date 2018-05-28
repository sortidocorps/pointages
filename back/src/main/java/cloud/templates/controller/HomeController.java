package cloud.templates.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHome() {
        return "Home";
    }

}
