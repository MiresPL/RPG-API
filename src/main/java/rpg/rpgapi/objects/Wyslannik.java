package rpg.rpgapi.objects;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

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

    public Document toDocument() {
        return new Document("_id", uuid.toString())
                .append("killMobsMission", getKillMobsMission())
                .append("killMobsMissionProgress", getKillMobsMissionProgress())
                .append("killBossMission", getKillBossMission())
                .append("killBossMissionProgress", getKillBossMissionProgress())
                .append("openChestMission", getOpenChestMission())
                .append("openChestMissionProgress", getOpenChestMissionProgress());
    }

}
