package rpg.rpgapi.objects;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.json.JSONObject;

import java.util.UUID;

@Getter
@Setter
public class Lesnik {
    private final UUID uuid;
    private int mission, progress;
    private double przeszycie, wzmKryta, defNaLudzi;
    private long cooldown;

    public Lesnik(final Document document) {
        this.uuid = UUID.fromString(document.getString("_id"));
        this.mission = document.getInteger("mission");
        this.progress = document.getInteger("progress");
        this.przeszycie = document.getDouble("przeszycie");
        this.wzmKryta = document.getDouble("wzmKryta");
        this.defNaLudzi = document.getDouble("defNaLudzi");
        this.cooldown = document.getLong("cooldown");
    }

    public JSONObject toDocument() {
        return new JSONObject()
                .put("mission", getMission())
                .put("progress", getProgress())
                .put("przeszycie", getPrzeszycie())
                .put("wzmKryta", getWzmKryta())
                .put("defNaLudzi", getDefNaLudzi())
                .put("cooldown", getCooldown());
    }
}
