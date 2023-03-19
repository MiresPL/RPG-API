package rpg.rpgapi.objects;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.json.JSONObject;

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

    public JSONObject toDocument() {
        return new JSONObject()
                .put("mission", getMission())
                .put("missionProgress", getMissionProgress())
                .put("szczescie", getSzczescie())
                .put("silnyNaLudzi", getSilnyNaLudzi())
                .put("defNaLudzi", getDefNaLudzi());
    }
}
