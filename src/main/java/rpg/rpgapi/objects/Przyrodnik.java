package rpg.rpgapi.objects;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

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

    public Document toDocument() {
        return new Document("_id", this.uuid.toString())
                .append("mission", getMission())
                .append("progress", getProgress())
                .append("dmg", getDmg())
                .append("def", getDef());
    }
}
