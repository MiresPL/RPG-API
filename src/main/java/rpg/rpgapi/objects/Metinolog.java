package rpg.rpgapi.objects;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.json.JSONObject;

import java.util.UUID;

@Getter
@Setter
public class Metinolog {
    private final UUID uuid;
    private int postepKill;
    private int postepMisjiKill;
    private int postepGive;
    private int postepMisjiGive;
    private double przeszycie;
    private double srOdpo;
    private int dodatkowedmg;

    public Metinolog(final Document document) {
        this.uuid = UUID.fromString(document.getString("_id"));
        this.postepKill = document.getInteger("postepKill");
        this.postepMisjiKill = document.getInteger("postepMisjiKill");
        this.postepGive = document.getInteger("postepGive");
        this.postepMisjiGive = document.getInteger("postepMisjiGive");
        this.przeszycie = document.getDouble("przeszywka");
        this.srOdpo = document.getDouble("srOdpo");
        this.dodatkowedmg = document.getInteger("dodatkowedmg");
    }

    public JSONObject toDocument() {
        return new JSONObject()
                .put("postepKill", getPostepKill())
                .put("postepMisjiKill", getPostepMisjiKill())
                .put("postepGive", getPostepGive())
                .put("postepMisjiGive", getPostepMisjiGive())
                .put("przeszywka", getPrzeszycie())
                .put("srOdpo", getSrOdpo())
                .put("dodatkowedmg", getDodatkowedmg());
    }
}
