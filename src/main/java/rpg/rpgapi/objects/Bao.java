package rpg.rpgapi.objects;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.json.JSONObject;

import java.util.UUID;

@Getter
@Setter
public class Bao {
    private final UUID uuid;
    private String bonus1, bonus2, bonus3, bonus4, bonus5;
    private int value1, value2, value3, value4, value5;

    public Bao(final Document document) {
        this.uuid = UUID.fromString(document.getString("_id"));
        this.bonus1 = document.getString("bonus1");
        this.value1 = document.getInteger("value1");
        this.bonus2 = document.getString("bonus2");
        this.value2 = document.getInteger("value2");
        this.bonus3 = document.getString("bonus3");
        this.value3 = document.getInteger("value3");
        this.bonus4 = document.getString("bonus4");
        this.value4 = document.getInteger("value4");
        this.bonus5 = document.getString("bonus5");
        this.value5 = document.getInteger("value5");
    }

    public JSONObject toDocument() {
        return new JSONObject()
                .put("bonus1", getBonus1())
                .put("value1", getValue1())
                .put("bonus2", getBonus2())
                .put("value2", getValue2())
                .put("bonus3", getBonus3())
                .put("value3", getValue3())
                .put("bonus4", getBonus4())
                .put("value4", getValue4())
                .put("bonus5", getBonus5())
                .put("value5", getValue5());
    }
}
