package rpg.rpgapi.objects.dodatki;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

import java.util.UUID;

@Getter
@Setter
public class AkcesoriaDodatkowe {
    private final UUID uuid;
    private String szarfa, pas, medalion, energia;


    public AkcesoriaDodatkowe(final Document document) {
        this.uuid = UUID.fromString(document.getString("_id").replace("-akceD", ""));
        this.szarfa = document.getString("szarfa");
        this.pas = document.getString("pas");
        this.medalion = document.getString("medalion");
        this.energia = document.getString("energia");
    }

    public Document toDocument() {
        return new Document("_id", this.uuid.toString() + "-akceD")
                .append("szarfa", this.szarfa)
                .append("pas", this.pas)
                .append("medalion", this.medalion)
                .append("energia", this.energia);
    }
}
