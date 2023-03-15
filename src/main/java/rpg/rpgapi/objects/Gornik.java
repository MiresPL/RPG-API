package rpg.rpgapi.objects;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

import java.util.UUID;

@Getter
@Setter
public class Gornik {
    private final UUID uuid;
    private int mission;
    private int progress;
    private double sredniaOdpornosc, blokCiosu, przeszycieBloku;
    private boolean dalszeDone;
    private boolean d1, d2, d3_1, d3_2, d3_3, d4_1, d4_2, d4_3, d4_4, d4_5, d4_6, d4_7, d5_1, d5_2, d5_3, d5_4, d5_5, d6_1, d6_2, d6_3, d6_4, d6_5, d7_1, d7_2, d7_3, d7_4, d8_1, d8_2, d9_1, d9_2;

    public Gornik(final Document document) {
        this.uuid = UUID.fromString(document.getString("_id"));
        this.mission = document.getInteger("mission");
        this.progress = document.getInteger("progress");
        this.sredniaOdpornosc = document.getDouble("sredniaOdpornosc");
        this.blokCiosu = document.getDouble("blokCiosu");
        this.przeszycieBloku = document.getDouble("przeszycieBloku");
        this.dalszeDone = document.getBoolean("dalszeDone");
        this.d1 = document.getBoolean("d1");
        this.d2 = document.getBoolean("d2");
        this.d3_1 = document.getBoolean("d3_1");
        this.d3_2 = document.getBoolean("d3_2");
        this.d3_3 = document.getBoolean("d3_3");
        this.d4_1 = document.getBoolean("d4_1");
        this.d4_2 = document.getBoolean("d4_2");
        this.d4_3 = document.getBoolean("d4_3");
        this.d4_4 = document.getBoolean("d4_4");
        this.d4_5 = document.getBoolean("d4_5");
        this.d4_6 = document.getBoolean("d4_6");
        this.d4_7 = document.getBoolean("d4_7");
        this.d5_1 = document.getBoolean("d5_1");
        this.d5_2 = document.getBoolean("d5_2");
        this.d5_3 = document.getBoolean("d5_3");
        this.d5_4 = document.getBoolean("d5_4");
        this.d5_5 = document.getBoolean("d5_5");
        this.d6_1 = document.getBoolean("d6_1");
        this.d6_2 = document.getBoolean("d6_2");
        this.d6_3 = document.getBoolean("d6_3");
        this.d6_4 = document.getBoolean("d6_4");
        this.d6_5 = document.getBoolean("d6_5");
        this.d7_1 = document.getBoolean("d7_1");
        this.d7_2 = document.getBoolean("d7_2");
        this.d7_3 = document.getBoolean("d7_3");
        this.d7_4 = document.getBoolean("d7_4");
        this.d8_1 = document.getBoolean("d8_1");
        this.d8_2 = document.getBoolean("d8_2");
        this.d9_1 = document.getBoolean("d9_1");
        this.d9_2 = document.getBoolean("d9_2");
    }

    public Document toDocument() {
        return new Document("_id", this.uuid.toString())
                .append("mission", getMission())
                .append("progress", getProgress())
                .append("sredniaOdpornosc", getSredniaOdpornosc())
                .append("blokCiosu", getBlokCiosu())
                .append("przeszycieBloku", getPrzeszycieBloku())
                .append("dalszeDone", isDalszeDone())
                .append("d1", isD1())
                .append("d2", isD2())
                .append("d3_1", isD3_1())
                .append("d3_2", isD3_2())
                .append("d3_3", isD3_3())
                .append("d4_1", isD4_1())
                .append("d4_2", isD4_2())
                .append("d4_3", isD4_3())
                .append("d4_4", isD4_4())
                .append("d4_5", isD4_5())
                .append("d4_6", isD4_6())
                .append("d4_7", isD4_7())
                .append("d5_1", isD5_1())
                .append("d5_2", isD5_2())
                .append("d5_3", isD5_3())
                .append("d5_4", isD5_4())
                .append("d5_5", isD5_5())
                .append("d6_1", isD6_1())
                .append("d6_2", isD6_2())
                .append("d6_3", isD6_3())
                .append("d6_4", isD6_4())
                .append("d6_5", isD6_5())
                .append("d7_1", isD7_1())
                .append("d7_2", isD7_2())
                .append("d7_3", isD7_3())
                .append("d7_4", isD7_4())
                .append("d8_1", isD8_1())
                .append("d8_2", isD8_2())
                .append("d9_1", isD9_1())
                .append("d9_2", isD9_2());
    }
}
