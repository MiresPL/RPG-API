package rpg.rpgapi.objects;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

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

    public Document toDocument() {
        return new Document("_id", this.uuid.toString())
                .append("bonus", this.bonus);
    }
}
