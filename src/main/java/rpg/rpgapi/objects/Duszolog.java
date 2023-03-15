package rpg.rpgapi.objects;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

import java.util.UUID;

@Getter
@Setter
public class Duszolog {
    private final UUID uuid;
    private int mission, progress;
    private double value1, value2;

    public Duszolog(final Document document) {
        this.uuid = UUID.fromString(document.getString("_id"));
        this.mission = document.getInteger("mission");
        this.progress = document.getInteger("progress");
        this.value1 = document.getDouble("value1");
        this.value2 = document.getDouble("value2");
    }

    public Document toDocument() {
        return new Document("_id", this.uuid.toString())
                .append("mission", getMission())
                .append("progress", getProgress())
                .append("value1", getValue1())
                .append("value2", getValue2());
    }
}
