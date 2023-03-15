package rpg.rpgapi.controllers;

import org.springframework.web.bind.annotation.*;
import rpg.rpgapi.RpgApiApplication;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin(origins = {"https://www.hellrpg.pl", "https://hellrpg.pl"}, allowedHeaders = "*")
@RequestMapping(path = "/api", method = POST)
public class UserController {
    @RequestMapping(path = "/users/profile/{token}", method = POST, produces = "application/json")
    public String requestProfile(@PathVariable("token") String token) {
        return RpgApiApplication.getMongoManager().getProfile(token);
    }
}
