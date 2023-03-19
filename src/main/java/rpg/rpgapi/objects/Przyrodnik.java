package rpg.rpgapi.objects;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.json.JSONObject;

import java.util.UUID;

@Getter
@Setter
public class Przyrodnik {
    private final UUID uuid;
    private int mission, progress;
    private double dmg, def;

    public Przyrodnik(final Document document) {
        this.uuid = UUID.fromString(document.getString("_id"));
        this.mission = document.getInteger("mission");
        this.progress = document.getInteger("progress");
        this.dmg = document.getDouble("dmg");
        this.def = document.getDouble("def");
    }

    public JSONObject toDocument() {
        return new JSONObject()
                .put("mission", getMission())
                .put("progress", getProgress())
                .put("dmg", getDmg())
                .put("def", getDef());
    }
}
