package rpg.rpgapi.objects.pety;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import rpg.rpgapi.utils.Utils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UserPets {
    private final UUID uuid;
    private List<String> pety;
    private String inventoryName;

    public UserPets(Document document) {
        this.uuid = UUID.fromString(document.getString("_id"));
        try {
            this.pety = Arrays.asList(Utils.stringArrayFromBase64(document.getString("pety")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Document toDocument() {
        return new Document("_id", uuid.toString())
                .append("pety", pety);
    }
}