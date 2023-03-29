package rpg.rpgapi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rpg.rpgapi.RpgApiApplication;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
//@CrossOrigin(origins = {"https://www.hellrpg.pl", "https://hellrpg.pl"}, allowedHeaders = "*")
@CrossOrigin(origins = {"*"}, allowedHeaders = "*")
@RequestMapping(path = "/api/profile", method = POST)
public class NickController {
    @RequestMapping(path = "/nick", method = POST, produces = "application/json", consumes = "application/json")
    public String getNick(@RequestBody Map<String, Object> postData) {
        final String uuid = String.valueOf(postData.get("uuid"));
        final String token = String.valueOf(postData.get("token"));
        return RpgApiApplication.getMongoManager().getNick(uuid, token);
    }

}
