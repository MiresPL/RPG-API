package rpg.rpgapi.objects.wyszkolenie;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

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

    public Document toDocument() {
        return new Document("_id", this.uuid.toString())
                .append("punkty", this.punkty)
                .append("totalPoints", this.totalPoints)
                .append("srDmg", this.srDmg)
                .append("srDef", this.srDef)
                .append("kryt", this.kryt)
                .append("szczescie", this.szczescie)
                .append("blok", this.blok)
                .append("hp", this.hp)
                .append("drzewkoWyszkolenia", this.drzewkoWyszkolenia.toDocument());
    }
}
