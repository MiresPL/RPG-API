package rpg.rpgapi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rpg.rpgapi.RpgApiApplication;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/api", method = POST)
public class LoginController {
    @RequestMapping(path = "/test", method = POST, produces = "plain/text")
    public String test() {
        return "test";
    }

    @RequestMapping(path = "/login", method = POST, produces = "application/json", consumes = "application/json")
    public String login(@RequestBody Map<String, Object> postData) {
        final String login = String.valueOf(postData.get("login"));
        final String password = String.valueOf(postData.get("password"));
        return RpgApiApplication.getMongoManager().login(login, password);
    }

}
