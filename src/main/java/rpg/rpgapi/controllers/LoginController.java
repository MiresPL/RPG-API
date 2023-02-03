package rpg.rpgapi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rpg.rpgapi.RpgApiApplication;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin(origins = {"https://www.hellrpg.pl", "https://hellrpg.pl"}, allowedHeaders = "*")
@RequestMapping(path = "/api", method = POST)
public class LoginController {
    @RequestMapping(path = "/login", method = POST, produces = "application/json", consumes = "application/json")
    public String login(@RequestBody Map<String, Object> postData) {
        final String login = String.valueOf(postData.get("login"));
        final String password = String.valueOf(postData.get("password"));
        return RpgApiApplication.getMongoManager().login(login, password);
    }

}
