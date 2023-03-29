package rpg.rpgapi.controllers;

import org.springframework.web.bind.annotation.*;
import rpg.rpgapi.RpgApiApplication;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin(origins = {"https://www.hellrpg.pl", "https://hellrpg.pl"}, allowedHeaders = "*")
@RequestMapping(path = "/api", method = POST)
public class UserController {
    @RequestMapping(path = "/users/profile", method = POST, produces = "application/json")
    public String requestProfile(@RequestBody Map<String, Object> postData) {
        final String token = String.valueOf(postData.get("token"));
        final String uuid = String.valueOf(postData.get("uuid"));
        return RpgApiApplication.getMongoManager().getProfile(token, uuid);
    }
}
