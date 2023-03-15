package rpg.rpgapi.objects;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.json.JSONObject;
import rpg.rpgapi.objects.dodatki.AkcesoriaDodatkowe;
import rpg.rpgapi.objects.dodatki.AkcesoriaPodstawowe;
import rpg.rpgapi.objects.dodatki.Bony;
import rpg.rpgapi.objects.magazynier.MagazynierUser;
import rpg.rpgapi.objects.pety.Pet;
import rpg.rpgapi.objects.pety.UserPets;
import rpg.rpgapi.objects.wyszkolenie.Wyszkolenie;
import rpg.rpgapi.utils.Utils;

import java.util.UUID;

@Getter
@Setter
public class User {
    private final UUID uuid;
    private final String name;
    private final String banInfo;
    private final String muteInfo;
    private final String punishmentHistory;
    private final String rankName;
    private final String rankPlayerName;
    private final long rankPlayerTime;
    private final int lvl;
    private final double exp;
    private final double kasa;
    private final int hellcoins;
    private final boolean verify = false;
    private final boolean click = false;
    private final boolean msgOff;
    private final double polimorfiabonus = 0.0;
    private final long polimorfiaTime = 0L;
    private final String adminCode;
    private final boolean adminCodeLogin;
    private final String hellCode;
    private final boolean hellCodeLogin;
    private final String enderchest;
    private final String inventory;
    private final String armor;
    private final int pierscienDoswiadczenia;
    private final long pierscienDoswiadczeniaTime;
    private final double krytyk;
    private final long kitCooldown;
    private final boolean tworca;
    private AkcesoriaPodstawowe akcesoriaPodstawowe;
    private AkcesoriaDodatkowe akcesoriaDodatkowe;
    private Bony bony;
    private MagazynierUser magazynierUser;
    private Bao bao;
    private Bonuses bonuses;
    private Duszolog duszolog;
    private Gornik gornik;
    private Handlarz handlarz;
    private Kolekcjoner kolekcjoner;
    private Lesnik lesnik;
    private Lowca lowca;
    private Medrzec medrzec;
    private Metinolog metinolog;
    private Os os;
    private Przyrodnik przyrodnik;
    private Rybak rybak;
    private Wyslannik wyslannik;
    private Pet pet;
    private UserPets userPets;
    private Wyszkolenie wyszkolenie;


    public User(final Document document) {
        this.uuid = UUID.fromString(document.getString("_id"));
        this.name = document.getString("name");
        this.banInfo = document.getString("banInfo");
        this.muteInfo = document.getString("muteInfo");
        this.punishmentHistory = document.getString("punishmentHistory");
        this.rankName = document.getString("rankName");
        this.rankPlayerName = document.getString("rankPlayerName");
        this.rankPlayerTime = document.getLong("rankPlayerTime");
        this.lvl = document.getInteger("lvl");
        this.exp = document.getDouble("exp");
        this.kasa = document.getDouble("kasa");
        this.hellcoins = document.getInteger("hellcoins");
        this.msgOff = document.getBoolean("msgOff");
        this.adminCode = document.getString("adminCode");
        this.adminCodeLogin = document.getBoolean("adminCodeLogin");
        this.hellCode = document.getString("hellCode");
        this.hellCodeLogin = document.getBoolean("hellCodeLogin");
        this.enderchest = document.getString("enderchest");
        this.inventory = document.getString("inventory");
        this.armor = document.getString("armor");
        this.pierscienDoswiadczenia = document.getInteger("pierscienDoswiadczenia");
        this.pierscienDoswiadczeniaTime = document.getLong("pierscienDoswiadczeniaTime");
        this.krytyk = document.getDouble("krytyk");
        this.kitCooldown = document.getLong("kitCooldown");
        this.tworca = document.getBoolean("tworca");
        this.akcesoriaPodstawowe = null;
        this.akcesoriaDodatkowe = null;
        this.bony = null;
        this.magazynierUser = null;
        this.bao = null;
        this.bonuses = null;
        this.duszolog = null;
        this.gornik = null;
        this.handlarz = null;
        this.kolekcjoner = null;
        this.lesnik = null;
        this.lowca = null;
        this.medrzec = null;
        this.metinolog = null;
        this.os = null;
        this.przyrodnik = null;
        this.rybak = null;
        this.wyslannik = null;
        this.pet = null;
        this.userPets = null;
        this.wyszkolenie = null;
    }

    private JSONObject parsePunishmentHistoryToJSON(final String punishmentHistory) {
        final JSONObject json = new JSONObject();
        int count = 1;
        for (String s : punishmentHistory.split(",")) {
            final String[] punishment = s.split(";");
            final JSONObject punishmentJSON = new JSONObject();

            punishmentJSON.put("type", punishment[0]);

            if (punishment.length == 3) {
                punishmentJSON.put("adminNick", punishment[1]);
                punishmentJSON.put("date", punishment[2]);
            } else if (punishment.length == 4) {
                punishmentJSON.put("adminNick", punishment[1]);
                punishmentJSON.put("reason", punishment[2]);
                punishmentJSON.put("punishmentDate", punishment[3]);
            } else if (punishment.length == 5) {
                punishmentJSON.put("adminNick", punishment[1]);
                punishmentJSON.put("reason", punishment[2]);
                punishmentJSON.put("expiresAt", punishment[3]);
                punishmentJSON.put("punishmentDate", punishment[4]);
            }

            json.put("Punishment - " + count, punishmentJSON);
            count++;
        }
        return json;
    }

    public Document toDocument() {
        return new Document().append("_id", this.uuid.toString())
                .append("name", this.name)
                .append("banInfo", this.banInfo)
                .append("muteInfo", this.muteInfo)
                .append("punishmentHistory", this.parsePunishmentHistoryToJSON(this.punishmentHistory))
                .append("rankName", this.rankName)
                .append("rankPlayerName", this.rankPlayerName)
                .append("rankPlayerTime", (this.rankPlayerTime == -1 ? "LifeTime" : Utils.durationToString(rankPlayerTime, false)))
                .append("lvl", this.lvl)
                .append("exp", this.exp)
                .append("kasa", String.format("%.2f", this.kasa))
                .append("hellcoins", this.hellcoins)
                .append("msgOff", this.msgOff)
                .append("adminCode", this.adminCode)
                .append("adminCodeLogin", this.adminCodeLogin)
                .append("hellCode", this.hellCode)
                .append("hellCodeLogin", this.hellCodeLogin)
                .append("inventory", this.getInventory())
                .append("enderchest", this.getEnderchest())
                .append("armor", this.getArmor())
                .append("pierscienDoswiadczenia", this.pierscienDoswiadczenia)
                .append("pierscienDoswiadczeniaTime", this.pierscienDoswiadczeniaTime)
                .append("krytyk", String.format("%.2f", this.krytyk))
                .append("kitCooldown", this.kitCooldown)
                .append("tworca", this.tworca)
                .append("akcesoriaPodstawowe", this.akcesoriaPodstawowe.toDocument())
                .append("akcesoriaDodatkowe", this.akcesoriaDodatkowe.toDocument())
                .append("bony", this.bony.toDocument())
                .append("magazynier", this.magazynierUser.toDocument())
                .append("bao", this.bao.toDocument())
                .append("bonuses", this.bonuses.toDocument())
                .append("duszolog", this.duszolog.toDocument())
                .append("gornik", this.gornik.toDocument())
                //.append("handlarz", this.handlarz.toDocument())
                .append("kolekcjoner", this.kolekcjoner.toDocument())
                .append("lesnik", this.lesnik.toDocument())
                .append("lowca", this.lowca.toDocument())
                .append("medrzec", this.medrzec.toDocument())
                .append("metinolog", this.metinolog.toDocument())
                .append("os", this.os.toDocument())
                .append("przyrodnik", this.przyrodnik.toDocument())
                .append("rybak", this.rybak.toDocument())
                .append("wyslannik", this.wyslannik.toDocument())
                .append("pet", this.pet.toDocument())
                .append("userPets", this.userPets.toDocument())
                .append("wyszkolenie", this.wyszkolenie.toDocument());
    }

}


/*
const profile = {
    uuid: "dd3d637b-aff4-4fa5-8484-d120ed492d43",
    admin: "true"
};

const url = "https://api.hellrpg.pl/api/users/profile/" + profile['uuid'];


var request2 = new XMLHttpRequest();
request2.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        console.log(JSON.parse(request2.responseText));
    }
};
request2.open("POST", url);
request2.setRequestHeader("Content-Type", "application/json");
request2.send(JSON.stringify(profile));
 */