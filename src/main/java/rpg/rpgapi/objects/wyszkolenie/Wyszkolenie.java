package rpg.rpgapi.objects.wyszkolenie;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.json.JSONObject;

import java.util.UUID;

@Getter
@Setter
public class Wyszkolenie {
    private final UUID uuid;
    private int punkty, totalPoints, srDmg, srDef, kryt, szczescie, blok, hp;
    private long resetCooldown;
    private final DrzewkoWyszkolenia drzewkoWyszkolenia;

    public Wyszkolenie(final Document document) {
        this.uuid = UUID.fromString(document.getString("_id"));
        this.punkty = document.getInteger("punkty");
        this.totalPoints = document.getInteger("totalPoints");
        this.srDmg = document.getInteger("srDmg");
        this.srDef = document.getInteger("srDef");
        this.kryt = document.getInteger("kryt");
        this.szczescie = document.getInteger("szczescie");
        this.blok = document.getInteger("blok");
        this.hp = document.getInteger("hp");
        this.drzewkoWyszkolenia = new DrzewkoWyszkolenia(document.get("drzewkoWyszkolenia", Document.class));
    }

    public JSONObject toDocument() {
        return new JSONObject()
                .put("punkty", this.punkty)
                .put("totalPoints", this.totalPoints)
                .put("srDmg", this.srDmg)
                .put("srDef", this.srDef)
                .put("kryt", this.kryt)
                .put("szczescie", this.szczescie)
                .put("blok", this.blok)
                .put("hp", this.hp)
                .put("drzewkoWyszkolenia", this.drzewkoWyszkolenia.toDocument());
    }
}
