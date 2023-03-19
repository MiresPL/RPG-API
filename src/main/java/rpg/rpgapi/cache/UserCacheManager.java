package rpg.rpgapi.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import rpg.rpgapi.RpgApiApplication;
import rpg.rpgapi.objects.User;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class UserCacheManager {
    private final Cache<UUID, User> USER_CACHE = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES).build(new CacheLoader<UUID, User>() {
        @Override
        public User load(UUID uuid) {
            return null;
        }
    });
    private final Cache<UUID, String> TOKEN_CACHE = CacheBuilder.newBuilder().expireAfterWrite(15, TimeUnit.SECONDS).build(new CacheLoader<UUID, String>() {
        @Override
        public String load(UUID uuid) {
            return null;
        }
    });

    private final Cache<String, String> NICK_CACHE = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES).build(new CacheLoader<String, String>() {
        @Override
        public String load(String s) {
            return null;
        }
    });

    public void addUser(User user) {
        USER_CACHE.asMap().put(user.getUuid(), user);
    }

    public boolean hasUser(final UUID uuid) {
        return USER_CACHE.asMap().containsKey(uuid);
    }

    public User getUser(final UUID uuid) {
        if (!hasUser(uuid)) {
            RpgApiApplication.getMongoManager().initProfile(uuid);
        }
        return USER_CACHE.asMap().get(uuid);
    }

    public void addToken(final UUID uuid, final String token) {
        TOKEN_CACHE.asMap().put(uuid, token);
    }


    public boolean hasToken(final UUID uuid) {
        return TOKEN_CACHE.asMap().containsKey(uuid);
    }

    public String getToken(final UUID uuid) {
        return TOKEN_CACHE.asMap().get(uuid);
    }

    public void addNick(final String token, final String nick) {
        NICK_CACHE.asMap().put(token, nick);
    }

    public boolean hasNick(final String token) {
        return NICK_CACHE.asMap().containsKey(token);
    }

    public String getNick(final String token) {
        return NICK_CACHE.asMap().get(token);
    }

}
