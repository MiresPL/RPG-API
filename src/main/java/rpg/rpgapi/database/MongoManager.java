package rpg.rpgapi.database;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.mongodb.MongoException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.bson.Document;
import org.json.JSONObject;
import rpg.rpgapi.RpgApiApplication;
import rpg.rpgapi.objects.*;
import rpg.rpgapi.objects.dodatki.AkcesoriaDodatkowe;
import rpg.rpgapi.objects.dodatki.AkcesoriaPodstawowe;
import rpg.rpgapi.objects.dodatki.Bony;
import rpg.rpgapi.objects.magazynier.MagazynierUser;
import rpg.rpgapi.objects.pety.Pet;
import rpg.rpgapi.objects.pety.UserPets;
import rpg.rpgapi.objects.wyszkolenie.Wyszkolenie;


import java.security.Key;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

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
                    json.put("result", false);
                    json.put("errorMessage", "no password is set");
                    return json.toString();
                }

                if (password.equals("off")) {
                    json.put("result", false);
                    json.put("errorMessage", "password is off");
                    return json.toString();
                }

                if (password.equals(code)) {
                    json.put("result", true);
                    json.put("uuid", document.getString("_id"));
                    final String token = generateToken(document.getString("_id"));
                    json.put("token", token);
                    DecodedJWT decodedJWT = JWT.decode(token);
                    final JSONObject pushTokenResponse = this.pushToken(document.getString("_id"), token, decodedJWT.getExpiresAt().getTime());
                    return json.put("tokenResponse", pushTokenResponse).toString();
                } else {
                    json.put("result", false);
                    json.put("errorMessage", "wrong password");
                    return json.toString();
                }
            }
        }

        json.put("result", false);
        json.put("errorMessage", "no user in database");
        return json.toString();
    }

    private String generateToken(final String uuid) {
        final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        final long expirationTime = 3600 * 1000 * 2;
        return Jwts.builder()
                .setSubject(uuid)
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(key)
                .compact();

    }

    public JSONObject pushToken(final String uuid, final String token, final long expire) {
        try {
            this.pool.getWWWTokens().insertOne(new Document("_id", uuid).append("token", token).append("expire", expire));
            return new JSONObject().put("result", true);
        } catch (final MongoException e) {
            return new JSONObject().put("result", false);
        }
    }

    public void initProfile(final UUID uuid) {
        final User user = new User(Objects.requireNonNull(pool.getGracze().find(new Document("_id", uuid)).first()));
        final AkcesoriaPodstawowe akcesoriaPodstawowe = new AkcesoriaPodstawowe(Objects.requireNonNull(this.pool.getDodatki().find(new Document("_id", uuid)).first()).get("akcesoriaPodstawowe", Document.class));
        final AkcesoriaDodatkowe akcesoriaDodatkowe = new AkcesoriaDodatkowe(Objects.requireNonNull(this.pool.getDodatki().find(new Document("_id", uuid)).first()).get("akcesoriaDodatkowe", Document.class));
        final Bony bony = new Bony(Objects.requireNonNull(this.pool.getDodatki().find(new Document("_id", uuid)).first()).get("bony", Document.class));
        final MagazynierUser magazynierUser = new MagazynierUser(Objects.requireNonNull(this.pool.getMagazynier().find(new Document("_id", uuid)).first()));
        final Bao bao = new Bao(Objects.requireNonNull(this.pool.getBao().find(new Document("_id", uuid)).first()));
        final Bonuses bonuses = new Bonuses(Objects.requireNonNull(this.pool.getBonuses().find(new Document("_id", uuid)).first()));
        final Duszolog duszolog = new Duszolog(Objects.requireNonNull(this.pool.getDuszolog().find(new Document("_id", uuid)).first()));
        final Gornik gornik = new Gornik(Objects.requireNonNull(this.pool.getGornik().find(new Document("_id", uuid)).first()));
        //final Handlarz handlarz = new Handlarz(Objects.requireNonNull(this.pool.getHandlarz().find(new Document("_id", uuid)).first()));
        final Kolekcjoner kolekcjoner = new Kolekcjoner(Objects.requireNonNull(this.pool.getKolekcjoner().find(new Document("_id", uuid)).first()));
        final Lesnik lesnik = new Lesnik(Objects.requireNonNull(this.pool.getLesnik().find(new Document("_id", uuid)).first()));
        final Lowca lowca = new Lowca(Objects.requireNonNull(this.pool.getLowca().find(new Document("_id", uuid)).first()));
        final Medrzec medrzec = new Medrzec(Objects.requireNonNull(this.pool.getMedyk().find(new Document("_id", uuid)).first()));
        final Metinolog metinolog = new Metinolog(Objects.requireNonNull(this.pool.getMetinolog().find(new Document("_id", uuid)).first()));
        final Os os = new Os(Objects.requireNonNull(this.pool.getOsiagniecia().find(new Document("_id", uuid)).first()));
        final Przyrodnik przyrodnik = new Przyrodnik(Objects.requireNonNull(this.pool.getPrzyrodnik().find(new Document("_id", uuid)).first()));
        final Rybak rybak = new Rybak(Objects.requireNonNull(this.pool.getRybak().find(new Document("_id", uuid)).first()));
        final Wyslannik wyslannik = new Wyslannik(Objects.requireNonNull(this.pool.getWyslannik().find(new Document("_id", uuid)).first()));
        final Wyszkolenie wyszkolenie = new Wyszkolenie(Objects.requireNonNull(this.pool.getWyszkolenie().find(new Document("_id", uuid)).first()));
        final Pet pet = new Pet(Objects.requireNonNull(this.pool.getPety().find(new Document("_id", uuid)).first()));
        final UserPets userPets = new UserPets(Objects.requireNonNull(this.pool.getUserPets().find(new Document("_id", uuid)).first()));

        user.setAkcesoriaPodstawowe(akcesoriaPodstawowe);
        user.setAkcesoriaDodatkowe(akcesoriaDodatkowe);
        user.setBony(bony);
        user.setMagazynierUser(magazynierUser);
        user.setBao(bao);
        user.setBonuses(bonuses);
        user.setDuszolog(duszolog);
        user.setGornik(gornik);
        //user.setHandlarz(handlarz);
        user.setKolekcjoner(kolekcjoner);
        user.setLesnik(lesnik);
        user.setLowca(lowca);
        user.setMedrzec(medrzec);
        user.setMetinolog(metinolog);
        user.setOs(os);
        user.setPrzyrodnik(przyrodnik);
        user.setRybak(rybak);
        user.setWyslannik(wyslannik);
        user.setWyszkolenie(wyszkolenie);
        user.setPet(pet);
        user.setUserPets(userPets);

        RpgApiApplication.getUserCacheManager().addUser(user);
    }

    public String getProfile(final String token) {
        //TODO ZROBIC SPRAWDZANIE WAZNOSCI TOKENU ORAZ SAMEGO TOKENU Z BAZA
        final UUID uuid = this.getUUIDFromToken(token);

        /*
        DecodedJWT decodedJWT = JWT.decode(token);
        long expirationTimeInSeconds = decodedJWT.getExpiresAt().getTime() / 1000; // Get expiration time in seconds
         */

        if (uuid == null) {
            return new JSONObject().put("result", false).put("errorMessage", "invalid token").toString();
        }

        return RpgApiApplication.getUserCacheManager().getUser(uuid).toDocument().append("klan", this.checkIfPlayerIsInGuild(uuid.toString())).toString();
    }

    private String checkIfPlayerIsInGuild(final String uuid) {
        for (final Document document : this.pool.getGildie().find()) {
            if (document.getString("members").contains(uuid)) {
                return document.getString("_id");
            }
        }
        return "Brak Klanu";
    }

    public UUID getUUIDFromToken(final String token) {
        for (final Document document : this.pool.getWWWTokens().find()) {
            if (document.getString("token").equals(token)) {
                if (document.getLong("expire") <= System.currentTimeMillis()) {
                    return null;
                }
                return UUID.fromString(document.getString("_id"));
            }
        }
        return null;
    }

    public JSONObject checkTokenAndUUID(final String uuid, final String token) {
        for (final Document document : this.pool.getWWWTokens().find()) {
            if (document.getString("_id").equals(uuid)) {
                if (document.getString("token").equals(token)) {
                    if (document.getLong("expire") <= System.currentTimeMillis()) {
                        final String newToken = this.generateToken(uuid);
                        return new JSONObject().put("result", false).put("errorMessage", "token expired").put("newToken", newToken).put("newTokenResponse", this.pushToken(uuid, token, JWT.decode(newToken).getExpiresAt().getTime()));
                    }
                    return new JSONObject().put("result", true);
                } else {
                    return new JSONObject().put("result", false).put("errorMessage", "invalid token");
                }
            }
        }
        return new JSONObject().put("result", false).put("errorMessage", "token not found");
    }

    public String getNick(final String uuid, final String token) {
        final JSONObject response = this.checkTokenAndUUID(uuid, token);

        if (response.getBoolean("result")) {
            return new JSONObject().put("result", true).put("nick", Objects.requireNonNull(this.pool.getGracze().find(new Document("_id", uuid)).first()).getString("name")).toString();
        } else {
            if (response.keySet().contains("newToken") && response.keySet().contains("newTokenResponse")) {
                return new JSONObject().put("result", true).put("nick", Objects.requireNonNull(this.pool.getGracze().find(new Document("_id", uuid)).first()).getString("name")).toString();
            }
            return response.toString();
        }
    }
}