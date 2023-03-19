package rpg.rpgapi.objects;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.json.JSONObject;

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

    public JSONObject toDocument() {
        return new JSONObject()
                .put("mission", getMission())
                .put("progress", getProgress())
                .put("value1", getValue1())
                .put("value2", getValue2());
    }
}
