package rpg.rpgapi.objects.dodatki;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

import java.util.UUID;

@Getter
@Setter
public class AkcesoriaPodstawowe {
    private final UUID uuid;
    private String tarcza, naszyjnik, kolczyki, pierscien, diadem;

    public AkcesoriaPodstawowe(final Document document) {
        this.uuid = UUID.fromString(document.getString("_id").replace("-akceP", ""));
        this.tarcza = document.getString("tarcza");
        this.naszyjnik = document.getString("naszyjnik");
        this.kolczyki = document.getString("kolczyki");
        this.pierscien = document.getString("pierscien");
        this.diadem = document.getString("diadem");
    }

    public Document toDocument() {
        return new Document("_id", this.uuid.toString() + "-akceP")
                .append("tarcza", this.tarcza)
                .append("naszyjnik", this.naszyjnik)
                .append("kolczyki", this.kolczyki)
                .append("pierscien", this.pierscien)
                .append("diadem", this.diadem);
    }
}
