package rpg.rpgapi.database;

import org.bson.Document;
import org.json.JSONObject;
import rpg.rpgapi.utils.Utils;

import java.util.Objects;

public class MongoManager {
    private final MongoConnectionPoolManager pool;

    public MongoManager() {
        this.pool = new MongoConnectionPoolManager();
    }

    public String login(final String login, final String code) {
        final JSONObject json = new JSONObject();
        for (final Document document : pool.getGracze().find()) {
            if (document.getString("name").equals(login)) {

                final String password = document.getString("hellCode");

                if (password.isEmpty()) {
                    json.put("result", "false");
                    json.put("errorMessage", "no password is set");
                    return json.toString();
                }

                if (password.equals("off")) {
                    json.put("result", "false");
                    json.put("errorMessage", "password is off");
                    return json.toString();
                }

                if (!document.getString("rankName").equals("GRACZ")) {
                    if (password.equals(code)) {
                        json.put("result", "true");
                        json.put("uuid", document.getString("_id"));
                        json.put("admin", "false");
                        json.put("nick", document.getString("name"));
                        return json.toString();
                    }

                    final String adminPassword = document.getString("adminCode");

                    if (adminPassword.isEmpty()) {
                        json.put("result", "false");
                        json.put("errorMessage", "no admin password is set");
                        return json.toString();
                    }

                    if (adminPassword.equals(code)) {
                        json.put("result", "true");
                        json.put("uuid", document.getString("_id"));
                        json.put("admin", "true");
                        json.put("nick", document.getString("name"));
                        return json.toString();
                    } else {
                        json.put("result", "false");
                        json.put("errorMessage", "wrong admin password");
                        return json.toString();
                    }
                }

                if (password.equals(code)) {
                    json.put("result", "true");
                    json.put("admin", "false");
                    json.put("uuid", document.getString("_id"));
                    json.put("nick", document.getString("name"));
                    return json.toString();
                } else {
                    json.put("result", "false");
                    json.put("errorMessage", "wrong password");
                    return json.toString();
                }
            }
        }

        json.put("result", "false");
        json.put("errorMessage", "no user in database");
        return json.toString();
    }

    public String getProfile(final String uuid, final boolean isAdmin) {
        final JSONObject json = new JSONObject();
        final Document user = pool.getGracze().find(new Document("_id", uuid)).first();
        assert user != null;
        json.put("name", user.getString("name").replaceAll("\"", ""));
        json.put("uuid", user.getString("_id").replaceAll("\"", ""));
        json.put("guild", checkIfPlayerIsInGuild(uuid));
        json.put("lvl", user.getInteger("lvl"));
        if (isAdmin) {
            json.put("adminRankName", user.getString("rankName").replaceAll("\"", ""));
        } else {
            json.put("rankName", user.getString("rankPlayerName").replaceAll("\"", ""));
            json.put("rankTime", (user.getLong("rankPlayerTime") == -1 ? "LifeTime" : Utils.durationToString(user.getLong("rankPlayerTime"), false)));
        }
        json.put("punishmentHistory", parsePunishmentHistoryToJSON(user.getString("punishmentHistory")));
        json.put("money", String.format("%.2f", user.getDouble("kasa")));
        json.put("hellcoins", user.getInteger("hellcoins"));
        json.put("inventory", user.getString("inventory").replaceAll("\"", ""));
        json.put("enderchest", user.getString("enderchest").replaceAll("\"", ""));
        json.put("armor", user.getString("armor").replaceAll("\"", ""));

        final JSONObject bonuses = new JSONObject();
        bonuses.put("highestCritical", String.format("%.2f", user.getDouble("krytyk")));

        bonuses.put("bonuses", Objects.requireNonNull(this.pool.getBonuses().find(new Document("_id", uuid)).first()));

        final JSONObject npc = new JSONObject();

        npc.put("bao", Objects.requireNonNull(this.pool.getBao().find(new Document("_id", uuid)).first()));
        npc.put("dodatki", Objects.requireNonNull(this.pool.getDodatki().find(new Document("_id", uuid)).first()));
        npc.put("duszolog", Objects.requireNonNull(this.pool.getDuszolog().find(new Document("_id", uuid)).first()));
        npc.put("gornik", Objects.requireNonNull(this.pool.getGornik().find(new Document("_id", uuid)).first()));
        npc.put("handlarz", Objects.requireNonNull(this.pool.getHandlarz().find(new Document("_id", uuid)).first()));
        //npc.put("klasy", Objects.requireNonNull(this.pool.getKlasy().find(new Document("_id", uuid)).first()));
        npc.put("kociolki", Objects.requireNonNull(this.pool.getKociolki().find(new Document("_id", uuid)).first()));
        npc.put("kolekcjoner", Objects.requireNonNull(this.pool.getKolekcjoner().find(new Document("_id", uuid)).first()));
        npc.put("lesnik", Objects.requireNonNull(this.pool.getLesnik().find(new Document("_id", uuid)).first()));
        npc.put("lowca", Objects.requireNonNull(this.pool.getLowca().find(new Document("_id", uuid)).first()));
        npc.put("magazynier", Objects.requireNonNull(this.pool.getMagazynier().find(new Document("_id", uuid)).first()));
        npc.put("medyk", Objects.requireNonNull(this.pool.getMedyk().find(new Document("_id", uuid)).first()));
        npc.put("metinolog", Objects.requireNonNull(this.pool.getMetinolog().find(new Document("_id", uuid)).first()));
        npc.put("przyrodnik", Objects.requireNonNull(this.pool.getPrzyrodnik().find(new Document("_id", uuid)).first()));
        npc.put("rybak", Objects.requireNonNull(this.pool.getRybak().find(new Document("_id", uuid)).first()));
        //npc.put("trener", Objects.requireNonNull(this.pool.getTrener().find(new Document("_id", uuid)).first()));
        npc.put("wyslannik", Objects.requireNonNull(this.pool.getWyslannik().find(new Document("_id", uuid)).first()));



        final JSONObject osiagniecia = new JSONObject();

        osiagniecia.put("osiagniecia", Objects.requireNonNull(this.pool.getOsiagniecia().find(new Document("_id", uuid)).first()));


        final JSONObject pety = new JSONObject();

        pety.put("aktywny-zwierzak", Objects.requireNonNull(this.pool.getPety().find(new Document("_id", uuid)).first()));
        pety.put("zwierzaki", Objects.requireNonNull(this.pool.getUserPets().find(new Document("_id", uuid)).first()));

        bonuses.put("npc", npc);
        json.put("bonuses", bonuses);
        json.put("osiagniecia", osiagniecia);
        json.put("pety", pety);

        return json.toString();
    }

    private String checkIfPlayerIsInGuild(final String uuid) {
        for (final Document document : this.pool.getGildie().find()) {
            if (document.getString("members").contains(uuid)) {
                return document.getString("_id");
            }
        }
        return "Brak Klanu";
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
}
