package rpg.rpgapi.objects.pety;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.binary.Base64;
import org.bson.Document;

import java.util.UUID;

@Getter
@Setter
public class Pet {
    private final UUID uuid;
    private String item;
    private String name;
    private int lvl;
    private double exp, reqExp, totalExp;
    private String rarity;
    private double value1, value2, value3, value4;
    private String ultimateAbility;

    public Pet(final Document document) {
        this.uuid = UUID.fromString(document.getString("_id"));
        this.item = new String(Base64.decodeBase64(document.getString("item")));
        this.name = document.getString("name");
        this.lvl = document.getInteger("lvl");
        this.exp = document.getDouble("exp");
        this.reqExp = document.getDouble("reqExp");
        this.totalExp = document.getDouble("totalExp");
        this.rarity = document.getString("rarity");
        this.value1 = document.getDouble("value1");
        this.value2 = document.getDouble("value2");
        this.value3 = document.getDouble("value3");
        this.value4 = document.getDouble("value4");
        this.ultimateAbility = document.getString("ultimateAbility");
    }

    public Document toDocument() {
        return new Document("_id", uuid.toString())
                .append("item", getItem())
                .append("name", getName())
                .append("lvl", getLvl())
                .append("exp", getExp())
                .append("reqExp", getReqExp())
                .append("totalExp", getTotalExp())
                .append("rarity", getRarity())
                .append("value1", getValue1())
                .append("value2", getValue2())
                .append("value3", getValue3())
                .append("value4", getValue4())
                .append("ultimateAbility", getUltimateAbility());
    }
}
