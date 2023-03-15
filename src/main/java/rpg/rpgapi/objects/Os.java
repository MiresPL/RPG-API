package rpg.rpgapi.objects;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

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

    public Document toDocument() {
        return new Document("_id", this.uuid.toString())
                .append("gracze", this.gracze)
                .append("moby", this.moby)
                .append("metiny", this.metiny)
                .append("skrzynki", this.skrzynki)
                .append("niesy", this.niesy)
                .append("ulepszenia", this.ulepszenia)
                .append("drwal", this.drwal)
                .append("rybak", this.rybak)
                .append("gornik", this.gornik)
                .append("czas", this.czas)
                .append("krysztaly", this.krysztaly)
                .append("dungeony", this.dungeony)
                .append("graczeProgress", this.graczeProgress)
                .append("mobyProgress", this.mobyProgress)
                .append("metinyProgress", this.metinyProgress)
                .append("skrzynkiProgress", this.skrzynkiProgress)
                .append("niesyProgress", this.niesyProgress)
                .append("ulepszeniaProgress", this.ulepszeniaProgress)
                .append("drwalProgress", this.drwalProgress)
                .append("rybakProgress", this.rybakProgress)
                .append("gornikProgress", this.gornikProgress)
                .append("czasProgress", this.czasProgress)
                .append("krysztalyProgress", this.krysztalyProgress)
                .append("dungeonyProgress", this.dungeonyProgress);
    }
}
