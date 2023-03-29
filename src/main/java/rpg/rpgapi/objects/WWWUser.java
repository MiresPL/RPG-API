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
    private String magazyn1JSON, magazyn2JSON, magazyn3JSON, magazyn4JSON, magazyn5JSON;

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
        this.magazyn1JSON = document.get("magazyny", Document.class).getString("magazyn1JSON");
        this.magazyn2JSON = document.get("magazyny", Document.class).getString("magazyn2JSON");
        this.magazyn3JSON = document.get("magazyny", Document.class).getString("magazyn3JSON");
        this.magazyn4JSON = document.get("magazyny", Document.class).getString("magazyn4JSON");
        this.magazyn5JSON = document.get("magazyny", Document.class).getString("magazyn5JSON");
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
                .put("activePet", this.activePet)
                .put("magazyny", new JSONObject()
                        .put("magazyn1JSON", this.magazyn1JSON)
                        .put("magazyn2JSON", this.magazyn2JSON)
                        .put("magazyn3JSON", this.magazyn3JSON)
                        .put("magazyn4JSON", this.magazyn4JSON)
                        .put("magazyn5JSON", this.magazyn5JSON)
                );
    }
}
