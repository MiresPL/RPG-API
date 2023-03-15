package rpg.rpgapi.objects;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

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

    public Document toDocument() {
        return new Document("_id", this.uuid.toString())
                .append("mission", getMission())
                .append("progress", getProgress())
                .append("szczescie", getSzczescie())
                .append("szybkosc", getSzybkosc())
                .append("truedmg", getTruedmg());
    }
}
