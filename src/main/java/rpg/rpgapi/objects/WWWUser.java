package rpg.rpgapi.objects;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.json.JSONObject;

import java.util.UUID;

@Getter
@Setter
public class WWWUser {
    private final UUID uuid;
    private String inventoryJSON;
    private String armorJSON;
    private String enderchestJSON;
    private String akcesoriaPodstawoweJSON;
    private String akcesoriaDodatkoweJSON;
    private String bonyJSON;
    private String userPetyJSON;
    private String activePet;

    public WWWUser(final Document document) {
        this.uuid = UUID.fromString(document.getString("_id"));
        this.inventoryJSON = document.getString("inventoryJSON");
        this.armorJSON = document.getString("armorJSON");
        this.enderchestJSON = document.getString("enderchestJSON");
        this.akcesoriaPodstawoweJSON = document.getString("akcesoriaPodstawoweJSON");
        this.akcesoriaDodatkoweJSON = document.getString("akcesoriaDodatkoweJSON");
        this.bonyJSON = document.getString("bonyJSON");
        this.userPetyJSON = document.getString("userPetyJSON");
        this.activePet = document.getString("activePet");
    }

    public JSONObject toDocument() {
        return new JSONObject("_id", this.uuid.toString())
                .put("inventoryJSON", this.inventoryJSON)
                .put("armorJSON", this.armorJSON)
                .put("enderchestJSON", this.enderchestJSON)
                .put("akcesoriaPodstawoweJSON", this.akcesoriaPodstawoweJSON)
                .put("akcesoriaDodatkoweJSON", this.akcesoriaDodatkoweJSON)
                .put("bonyJSON", this.bonyJSON)
                .put("userPetyJSON", this.userPetyJSON)
                .put("activePet", this.activePet);
    }
}
