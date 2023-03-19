package rpg.rpgapi.objects;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.json.JSONObject;

import java.util.UUID;

@Getter
@Setter
public class Rybak {
    private final UUID uuid;
    private int mission, progress;
    private double srDef, kryt, morskieSzczescie, blok;

    public Rybak(final Document document) {
        this.uuid = UUID.fromString(document.getString("_id"));
        this.mission = document.getInteger("mission");
        this.progress = document.getInteger("progress");
        this.srDef = document.getDouble("srDef");
        this.kryt = document.getDouble("kryt");
        this.morskieSzczescie = document.getDouble("morskieSzczescie");
        this.blok = document.getDouble("blok");
    }

    public JSONObject toDocument() {
        return new JSONObject()
                .put("mission", getMission())
                .put("progress", getProgress())
                .put("srDef", getSrDef())
                .put("kryt", getKryt())
                .put("morskieSzczescie", getMorskieSzczescie())
                .put("blok", getBlok());
    }
}
