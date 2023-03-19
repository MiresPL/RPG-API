package rpg.rpgapi.objects.magazynier;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.json.JSONObject;

import java.util.UUID;

@Getter
@Setter
public class MagazynierUser {
    private final UUID uuid;
    private int points;
    private String magazyn1, magazyn2, magazyn3, magazyn4, magazyn5;
    private boolean unlocked1, unlocked2, unlocked3, unlocked4, unlocked5, remoteCommand;
    private MagazynierMissions missions;
    private long resetTime;

    public MagazynierUser(final Document document) {
        this.uuid = UUID.fromString(document.getString("_id"));
        this.points = document.getInteger("points");
        this.magazyn1 = document.getString("magazyn1");
        this.magazyn2 = document.getString("magazyn2");
        this.magazyn3 = document.getString("magazyn3");
        this.magazyn4 = document.getString("magazyn4");
        this.magazyn5 = document.getString("magazyn5");
        this.unlocked1 = document.getBoolean("unlocked1");
        this.unlocked2 = document.getBoolean("unlocked2");
        this.unlocked3 = document.getBoolean("unlocked3");
        this.unlocked4 = document.getBoolean("unlocked4");
        this.unlocked5 = document.getBoolean("unlocked5");
        this.remoteCommand = document.getBoolean("remoteCommand");
        this.missions = new MagazynierMissions(document.get("missions", Document.class));
        this.resetTime = document.getLong("resetTime");
    }

    public JSONObject toDocument() {
        return new JSONObject()
                .put("points", this.points)
                .put("magazyn1", this.magazyn1)
                .put("magazyn2", this.magazyn2)
                .put("magazyn3", this.magazyn3)
                .put("magazyn4", this.magazyn4)
                .put("magazyn5", this.magazyn5)
                .put("unlocked1", this.unlocked1)
                .put("unlocked2", this.unlocked2)
                .put("unlocked3", this.unlocked3)
                .put("unlocked4", this.unlocked4)
                .put("unlocked5", this.unlocked5)
                .put("remoteCommand", this.remoteCommand)
                .put("missions", this.missions.toDocument())
                .put("resetTime", this.resetTime);
    }

}
