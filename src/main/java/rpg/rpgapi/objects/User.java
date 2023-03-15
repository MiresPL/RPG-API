package rpg.rpgapi.objects;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class User {
    private final UUID uuid;
    private String nick;


    public User(final UUID uuid) {
        this.uuid = uuid;
    }
}


/*
const profile = {
    uuid: "dd3d637b-aff4-4fa5-8484-d120ed492d43",
    admin: "true"
};

const url = "https://api.hellrpg.pl/api/users/profile/" + profile['uuid'];


var request2 = new XMLHttpRequest();
request2.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        console.log(JSON.parse(request2.responseText));
    }
};
request2.open("POST", url);
request2.setRequestHeader("Content-Type", "application/json");
request2.send(JSON.stringify(profile));
 */