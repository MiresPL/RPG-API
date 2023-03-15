package rpg.rpgapi.objects.guild;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

import java.util.*;

@Getter
@Setter
public class GuildObject {
    private final String tag;
    private String description;
    private final UUID owner;
    private final Guild guild;

    public GuildObject(Document document) {
        this.tag = document.getString("_id");
        this.description = document.getString("description");
        this.owner = UUID.fromString(document.getString("owner"));
        this.guild = new Guild(tag, description, owner, document.getString("coOwner"),
                getMemebrsFromDocument(document), document.getInteger("points"), document.getInteger("level"), document.getDouble("exp"),
                document.getInteger("balance"), document.getBoolean("pvp"), document.getDouble("dodatkowyExp"), document.getDouble("sredniDmg"),
                document.getDouble("sredniDef"), document.getDouble("silnyNaLudzi"), document.getDouble("defNaLudzi"), getKillsMapFromDocument(document), getDeathsMapFromDocument(document),
                getExpEarnedMapFromDocument(document), getLastSeenMapFromDocument(document));
    }

    private List<UUID> getMemebrsFromDocument(final Document document) {
        final List<UUID> members = new ArrayList<>();

        for (final String member : String.valueOf(document.get("members")).split(",")) {
            members.add(UUID.fromString(member));
        }
        return members;
    }

    private Map<UUID, Integer> getKillsMapFromDocument(final Document document) {
        final Map<UUID, Integer> killsMap = new HashMap<>();
        Document kills = (Document) document.get("killsMap");
        for (final String key : kills.keySet()) {
            killsMap.put(UUID.fromString(key), kills.getInteger(key));
        }
        return killsMap;
    }

    private Map<UUID, Integer> getDeathsMapFromDocument(final Document document) {
        final Map<UUID, Integer> deathsMap = new HashMap<>();
        Document deaths = (Document) document.get("deathsMap");
        for (final String key : deaths.keySet()) {
            deathsMap.put(UUID.fromString(key), deaths.getInteger(key));
        }
        return deathsMap;
    }

    private Map<UUID, Double> getExpEarnedMapFromDocument(final Document document) {
        final Map<UUID, Double> expEarnedMap = new HashMap<>();
        Document expEarned = (Document) document.get("expEarnedMap");
        for (final String key : expEarned.keySet()) {
            expEarnedMap.put(UUID.fromString(key), expEarned.getDouble(key));
        }
        return expEarnedMap;
    }

    private Map<UUID, Date> getLastSeenMapFromDocument(final Document document) {
        final Map<UUID, Date> lastOnlineMap = new HashMap<>();
        Document lastOnline = (Document) document.get("lastOnlineMap");
        for (final String key : lastOnline.keySet()) {
            lastOnlineMap.put(UUID.fromString(key), new Date(lastOnline.getLong(key)));
        }
        return lastOnlineMap;
    }

    public Document toDocument() {
        Document document = new Document("_id", tag)
                .append("description", description)
                .append("owner", String.valueOf(owner))
                .append("coOwner", guild.getCoOwner());
        final StringBuilder sb = new StringBuilder();
        for (UUID uuid : guild.getMembers()) {
            sb.append(uuid.toString());
            sb.append(",");
        }
        String members = String.valueOf(sb);
        int lastIndex = members.lastIndexOf(",");
        members = members.substring(0, lastIndex);

        document.append("members", members)
                .append("points", guild.getPoints())
                .append("level", guild.getLevel())
                .append("exp", guild.getExp())
                .append("balance", guild.getBalance())
                .append("pvp", guild.isPvp())
                .append("dodatkowyExp", guild.getDodatkowyExp())
                .append("sredniDmg", guild.getSredniDmg())
                .append("sredniDef", guild.getSredniDef())
                .append("silnyNaLudzi", guild.getSilnyNaLudzi())
                .append("defNaLudzi", guild.getDefNaLudzi());

        Document killsMap = new Document();
        for (Map.Entry<UUID, Integer> entry : guild.getKills().entrySet()) {
            killsMap.put(String.valueOf(entry.getKey()), entry.getValue());
        }

        document.append("killsMap", killsMap);

        Document deathsMap = new Document();
        for (Map.Entry<UUID, Integer> entry : guild.getDeaths().entrySet()) {
            deathsMap.put(String.valueOf(entry.getKey()), entry.getValue());
        }

        document.append("deathsMap", deathsMap);

        Document expEarnedMap = new Document();
        for (Map.Entry<UUID, Double> entry : guild.getExpEarned().entrySet()) {
            expEarnedMap.put(String.valueOf(entry.getKey()), entry.getValue());
        }

        document.append("expEarnedMap", expEarnedMap);

        Document lastOnlineMap = new Document();
        for (Map.Entry<UUID, Date> entry : guild.getLastOnline().entrySet()) {
            lastOnlineMap.put(String.valueOf(entry.getKey()), entry.getValue().getTime());
        }

        document.append("lastOnlineMap", lastOnlineMap);

        return document;
    }
}
