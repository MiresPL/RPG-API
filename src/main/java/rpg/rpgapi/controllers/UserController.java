package rpg.rpgapi.controllers;

import org.springframework.web.bind.annotation.*;
import rpg.rpgapi.RpgApiApplication;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin(origins = {"https://www.hellrpg.pl", "https://hellrpg.pl"}, allowedHeaders = "*")
@RequestMapping(path = "/api", method = POST)
public class UserController {
    @RequestMapping(path = "/users/profile/{id}", method = POST, produces = "application/json")
    public String requestProfile(@PathVariable("id") String uuid, @RequestBody Map<String, Object> postData) {
        final boolean admin = Boolean.parseBoolean(String.valueOf(postData.get("admin")));
        return RpgApiApplication.getMongoManager().getProfile(uuid, admin);
    }
}
