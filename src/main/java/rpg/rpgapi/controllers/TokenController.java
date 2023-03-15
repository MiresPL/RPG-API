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
public class TokenController {
    @RequestMapping(path = "/tokens", method = POST, produces = "application/json", consumes = "application/json")
    public String pushToken(@RequestBody Map<String, Object> postData) {
        final String uuid = String.valueOf(postData.get("uuid"));
        final String token = String.valueOf(postData.get("token"));
        return RpgApiApplication.getMongoManager().pushToken(uuid, token);
    }

}
