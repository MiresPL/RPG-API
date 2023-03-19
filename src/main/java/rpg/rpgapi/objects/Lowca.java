package rpg.rpgapi.objects;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.json.JSONObject;

import java.util.UUID;

@Getter
@Setter
public class Lowca {
    private final UUID uuid;
    private int mission;
    private int progress;
    private int szczescie, szybkosc, truedmg;

    public Lowca(final Document document) {
        this.uuid = UUID.fromString(document.getString("_id"));
        this.mission = document.getInteger("mission");
        this.progress = document.getInteger("progress");
        this.szczescie = document.getInteger("szczescie");
        this.szybkosc = document.getInteger("szybkosc");
        this.truedmg = document.getInteger("truedmg");
    }

    public JSONObject toDocument() {
        return new JSONObject()
                .put("mission", getMission())
                .put("progress", getProgress())
                .put("szczescie", getSzczescie())
                .put("szybkosc", getSzybkosc())
                .put("truedmg", getTruedmg());
    }
}
