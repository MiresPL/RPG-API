package rpg.rpgapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import rpg.rpgapi.cache.UserCacheManager;
import rpg.rpgapi.database.MongoManager;

@SpringBootApplication
public class RpgApiApplication {

	private static MongoManager mongoManager;
	private static UserCacheManager userCacheManager;

	public static void main(String[] args) {
		mongoManager = new MongoManager();
		userCacheManager = new UserCacheManager();
		SpringApplication.run(RpgApiApplication.class, args);
	}

	public static MongoManager getMongoManager() {
		return mongoManager;
	}

	public static UserCacheManager getUserCacheManager() {
		return userCacheManager;
	}

}
