package rpg.rpgapi.objects.magazynier;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.json.JSONObject;

@Getter
@Setter
public class MagazynierMissions {
    private int mission1, mission2, mission3, mission4, mission5;
    private boolean mission1done, mission2done, mission3done, mission4done, mission5done;
    private int selectedMission;
    private double progress;

    public MagazynierMissions(final Document document) {
        this.mission1 = document.getInteger("mission1");
        this.mission2 = document.getInteger("mission2");
        this.mission3 = document.getInteger("mission3");
        this.mission4 = document.getInteger("mission4");
        this.mission5 = document.getInteger("mission5");
        this.selectedMission = document.getInteger("selectedMission");
        this.progress = document.getDouble("progress");
        this.mission1done = document.getBoolean("mission1done");
        this.mission2done = document.getBoolean("mission2done");
        this.mission3done = document.getBoolean("mission3done");
        this.mission4done = document.getBoolean("mission4done");
        this.mission5done = document.getBoolean("mission5done");
    }

    public JSONObject toDocument() {
        return new JSONObject()
                .put("mission1", this.mission1)
                .put("mission2", this.mission2)
                .put("mission3", this.mission3)
                .put("mission4", this.mission4)
                .put("mission5", this.mission5)
                .put("selectedMission", this.selectedMission)
                .put("progress", this.progress)
                .put("mission1done", this.mission1done)
                .put("mission2done", this.mission2done)
                .put("mission3done", this.mission3done)
                .put("mission4done", this.mission4done)
                .put("mission5done", this.mission5done);
    }
}
