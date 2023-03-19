package rpg.rpgapi.objects;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.json.JSONObject;

import java.util.UUID;

@Getter
@Setter
public class Os {
    private final UUID uuid;
    private int gracze, moby, metiny, skrzynki, niesy, ulepszenia, drwal, rybak, gornik, czas, krysztaly, dungeony;
    private int graczeProgress, mobyProgress, metinyProgress, skrzynkiProgress, niesyProgress, ulepszeniaProgress, drwalProgress, rybakProgress, gornikProgress, krysztalyProgress, dungeonyProgress;
    private long czasProgress;

    public Os(final Document document) {
        this.uuid = UUID.fromString(document.getString("_id"));
        this.gracze = document.getInteger("gracze");
        this.moby = document.getInteger("moby");
        this.metiny = document.getInteger("metiny");
        this.skrzynki = document.getInteger("skrzynki");
        this.niesy = document.getInteger("niesy");
        this.ulepszenia = document.getInteger("ulepszenia");
        this.drwal = document.getInteger("drwal");
        this.rybak = document.getInteger("rybak");
        this.gornik = document.getInteger("gornik");
        this.czas = document.getInteger("czas");
        this.krysztaly = document.getInteger("krysztaly");
        this.dungeony = document.getInteger("dungeony");
        this.graczeProgress = document.getInteger("graczeProgress");
        this.mobyProgress = document.getInteger("mobyProgress");
        this.metinyProgress = document.getInteger("metinyProgress");
        this.skrzynkiProgress = document.getInteger("skrzynkiProgress");
        this.niesyProgress = document.getInteger("niesyProgress");
        this.ulepszeniaProgress = document.getInteger("ulepszeniaProgress");
        this.drwalProgress = document.getInteger("drwalProgress");
        this.rybakProgress = document.getInteger("rybakProgress");
        this.gornikProgress = document.getInteger("gornikProgress");
        this.czasProgress = document.getLong("czasProgress");
        this.krysztalyProgress = document.getInteger("krysztalyProgress");
        this.dungeonyProgress = document.getInteger("dungeonyProgress");
    }

    public JSONObject toDocument() {
        return new JSONObject()
                .put("gracze", this.gracze)
                .put("moby", this.moby)
                .put("metiny", this.metiny)
                .put("skrzynki", this.skrzynki)
                .put("niesy", this.niesy)
                .put("ulepszenia", this.ulepszenia)
                .put("drwal", this.drwal)
                .put("rybak", this.rybak)
                .put("gornik", this.gornik)
                .put("czas", this.czas)
                .put("krysztaly", this.krysztaly)
                .put("dungeony", this.dungeony)
                .put("graczeProgress", this.graczeProgress)
                .put("mobyProgress", this.mobyProgress)
                .put("metinyProgress", this.metinyProgress)
                .put("skrzynkiProgress", this.skrzynkiProgress)
                .put("niesyProgress", this.niesyProgress)
                .put("ulepszeniaProgress", this.ulepszeniaProgress)
                .put("drwalProgress", this.drwalProgress)
                .put("rybakProgress", this.rybakProgress)
                .put("gornikProgress", this.gornikProgress)
                .put("czasProgress", this.czasProgress)
                .put("krysztalyProgress", this.krysztalyProgress)
                .put("dungeonyProgress", this.dungeonyProgress);
    }
}
