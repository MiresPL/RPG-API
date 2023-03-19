package rpg.rpgapi.objects;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.json.JSONObject;

import java.util.UUID;

@Getter
@Setter
public class Medrzec {
    private final UUID uuid;
    private int bonus;

    public Medrzec(final Document document) {
        this.uuid = UUID.fromString(document.getString("_id"));
        this.bonus = document.getInteger("bonus");
    }

    public JSONObject toDocument() {
        return new JSONObject()
                .put("bonus", this.bonus);
    }
}
