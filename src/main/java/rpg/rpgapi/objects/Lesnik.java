package rpg.rpgapi.objects;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

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

    public Document toDocument() {
        return new Document("_id", uuid.toString())
                .append("mission", getMission())
                .append("progress", getProgress())
                .append("przeszycie", getPrzeszycie())
                .append("wzmKryta", getWzmKryta())
                .append("defNaLudzi", getDefNaLudzi())
                .append("cooldown", getCooldown());
    }
}
