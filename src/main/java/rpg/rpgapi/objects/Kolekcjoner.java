package rpg.rpgapi.objects;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Kolekcjoner {
    private final UUID uuid;
    private int mission;
    private List<Boolean> missionProgress;
    private int szczescie;
    private double silnyNaLudzi, defNaLudzi;

    public Kolekcjoner(final Document document) {
        this.uuid = UUID.fromString(document.getString("_id"));
        this.mission = document.getInteger("mission");
        this.missionProgress = document.getList("missionProgress", Boolean.class);
        this.szczescie = document.getInteger("szczescie");
        this.silnyNaLudzi = document.getDouble("silnyNaLudzi");
        this.defNaLudzi = document.getDouble("defNaLudzi");
    }

    public Document toDocument() {
        return new Document("_id", this.uuid.toString())
                .append("mission", getMission())
                .append("missionProgress", getMissionProgress())
                .append("szczescie", getSzczescie())
                .append("silnyNaLudzi", getSilnyNaLudzi())
                .append("defNaLudzi", getDefNaLudzi());
    }
}
