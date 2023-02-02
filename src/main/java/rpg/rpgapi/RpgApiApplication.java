package rpg.rpgapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import rpg.rpgapi.database.MongoManager;

@SpringBootApplication
public class RpgApiApplication {

	private static MongoManager mongoManager;

	public static void main(String[] args) {
		mongoManager = new MongoManager();
		SpringApplication.run(RpgApiApplication.class, args);
	}

	public static MongoManager getMongoManager() {
		return mongoManager;
	}

}
