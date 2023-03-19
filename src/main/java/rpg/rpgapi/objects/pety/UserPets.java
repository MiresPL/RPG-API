package rpg.rpgapi.objects.pety;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.json.JSONObject;

import java.util.UUID;

@Getter
@Setter
public class UserPets {
    private final UUID uuid;
    private String pety;
    private String inventoryName;

    public UserPets(Document document) {
        this.uuid = UUID.fromString(document.getString("_id"));
        this.pety = document.getString("pety");
    }

    public JSONObject toDocument() {
        return new JSONObject()
                .put("pety", pety);
    }
}