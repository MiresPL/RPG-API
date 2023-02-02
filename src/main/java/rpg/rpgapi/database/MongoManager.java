package rpg.rpgapi.database;

import org.bson.Document;
import org.json.JSONObject;

public class MongoManager {
    private final MongoConnectionPoolManager pool;

    public MongoManager() {
        this.pool = new MongoConnectionPoolManager();
    }

    public String login(final String login, final String hellcode) {
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
                if (password.equals(hellcode)) {
                    json.put("result", "true");
                    json.put("uuid", document.getString("_id"));
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
}
