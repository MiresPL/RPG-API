package rpg.rpgapi.objects.pety;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.json.JSONObject;

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
        this.item = document.getString("item");
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

    public JSONObject toDocument() {
        return new JSONObject()
                .put("item", getItem())
                .put("name", getName())
                .put("lvl", getLvl())
                .put("exp", getExp())
                .put("reqExp", getReqExp())
                .put("totalExp", getTotalExp())
                .put("rarity", getRarity())
                .put("value1", getValue1())
                .put("value2", getValue2())
                .put("value3", getValue3())
                .put("value4", getValue4())
                .put("ultimateAbility", getUltimateAbility());
    }
}
