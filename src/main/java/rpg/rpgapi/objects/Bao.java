package rpg.rpgapi.objects;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

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

    public Document toDocument() {
        return new Document("_id", uuid.toString())
                .append("bonus1", getBonus1())
                .append("value1", getValue1())
                .append("bonus2", getBonus2())
                .append("value2", getValue2())
                .append("bonus3", getBonus3())
                .append("value3", getValue3())
                .append("bonus4", getBonus4())
                .append("value4", getValue4())
                .append("bonus5", getBonus5())
                .append("value5", getValue5());
    }
}
