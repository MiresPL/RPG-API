package rpg.rpgapi.objects;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.json.JSONObject;

import java.util.UUID;

@Getter
@Setter
public class Wyslannik {
    private final UUID uuid;

    private int killMobsMission;
    private int killMobsMissionProgress;
    private int killBossMission;
    private int killBossMissionProgress;
    private int openChestMission;
    private int openChestMissionProgress;

    public Wyslannik(final Document document) {
        this.uuid = UUID.fromString(document.getString("_id"));
        this.killMobsMission = document.getInteger("killMobsMission");
        this.killMobsMissionProgress = document.getInteger("killMobsMissionProgress");
        this.killBossMission = document.getInteger("killBossMission");
        this.killBossMissionProgress = document.getInteger("killBossMissionProgress");
        this.openChestMission = document.getInteger("openChestMission");
        this.openChestMissionProgress = document.getInteger("openChestMissionProgress");
    }

    public JSONObject toDocument() {
        return new JSONObject()
                .put("killMobsMission", getKillMobsMission())
                .put("killMobsMissionProgress", getKillMobsMissionProgress())
                .put("killBossMission", getKillBossMission())
                .put("killBossMissionProgress", getKillBossMissionProgress())
                .put("openChestMission", getOpenChestMission())
                .put("openChestMissionProgress", getOpenChestMissionProgress());
    }

}
