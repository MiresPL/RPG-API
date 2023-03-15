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


}
