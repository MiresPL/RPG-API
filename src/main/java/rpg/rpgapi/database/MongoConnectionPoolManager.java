package rpg.rpgapi.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

public class MongoConnectionPoolManager {

    private final MongoCollection<Document> hellrpg_gracze;
    private final MongoCollection<Document> hellrpg_gildie;
    private final MongoCollection<Document> hellrpg_dodatki;
    private final MongoCollection<Document> hellrpg_osiagniecia;
    private final MongoCollection<Document> hellrpg_bao;
    private final MongoCollection<Document> hellrpg_rybak;
    private final MongoCollection<Document> hellrpg_kolekcjoner;
    private final MongoCollection<Document> hellrpg_magazynier;
    private final MongoCollection<Document> hellrpg_metinolog;
    private final MongoCollection<Document> hellrpg_medyk;
    private final MongoCollection<Document> hellrpg_gornik;
    private final MongoCollection<Document> hellrpg_duszolog;
    private final MongoCollection<Document> hellrpg_przyrodnik;
    private final MongoCollection<Document> hellrpg_bonuses;
    private final MongoCollection<Document> hellrpg_lowca;
    private final MongoCollection<Document> hellrpg_lesnik;
    private final MongoCollection<Document> hellrpg_pety;
    private final MongoCollection<Document> hellrpg_userPets;
    private final MongoCollection<Document> hellrpg_wyslannik;
    //private final MongoCollection<Document> hellrpg_przykladowyNPC; // TU TWORZYSZ ZMIENNA DO KOLEKCJI ZEBY MOC SIE DO NIEJ ODOWLAC !!!!
    private final MongoCollection<Document> hellrpg_handlarz;
    private final MongoCollection<Document> hellrpg_wyszkolenie;

    private final MongoCollection<Document> hellrpg_www_tokens;


    public MongoConnectionPoolManager() {
        final MongoClient client = MongoClients.create("mongodb://localhost/minecraft"); //mongodb://u7id5em5uspjam4butns:3ws4TKngK0iIgoE0lMSY@n1-c2-mongodb-clevercloud-customers.services.clever-cloud.com:27017,n2-c2-mongodb-clevercloud-customers.services.clever-cloud.com:27017/biyowrjyqcvr1sa?replicaSet=rs0
        final MongoDatabase database = client.getDatabase("minecraft");
        final ArrayList<String> collections = database.listCollectionNames().into(new ArrayList<>());
        if (!collections.contains("hellrpg_gracze")) {
            database.createCollection("hellrpg_gracze");
        }
        if (!collections.contains("hellrpg_gildie")) {
            database.createCollection("hellrpg_gildie");
        }
        if (!collections.contains("hellrpg_dodatki")) {
            database.createCollection("hellrpg_dodatki");
        }
        if (!collections.contains("hellrpg_magazyny")) {
            database.createCollection("hellrpg_magazyny");
        }
        if (!collections.contains("hellrpg_osiagniecia")) {
            database.createCollection("hellrpg_osiagniecia");
        }
        if (!collections.contains("hellrpg_bao")) {
            database.createCollection("hellrpg_bao");
        }
        if (!collections.contains("hellrpg_rybak")) {
            database.createCollection("hellrpg_rybak");
        }
        if (!collections.contains("hellrpg_kolekcjoner")) {
            database.createCollection("hellrpg_kolekcjoner");
        }
        if (!collections.contains("hellrpg_magazynier")) {
            database.createCollection("hellrpg_magazynier");
        }
        if (!collections.contains("hellrpg_metinolog")) {
            database.createCollection("hellrpg_metinolog");
        }
        if (!collections.contains("hellrpg_medyk")) {
            database.createCollection("hellrpg_medyk");
        }
        if (!collections.contains("hellrpg_gornik")) {
            database.createCollection("hellrpg_gornik");
        }
        if (!collections.contains("hellrpg_duszolog")) {
            database.createCollection("hellrpg_duszolog");
        }
        if (!collections.contains("hellrpg_przyrodnik")) {
            database.createCollection("hellrpg_przyrodnik");
        }
        if (!collections.contains("hellrpg_bonuses")) {
            database.createCollection("hellrpg_bonuses");
        }
        if (!collections.contains("hellrpg_lowca")) {
            database.createCollection("hellrpg_lowca");
        }
        if (!collections.contains("hellrpg_lesnik")) {
            database.createCollection("hellrpg_lesnik");
        }
        if (!collections.contains("hellrpg_pety")) {
            database.createCollection("hellrpg_pety");
        }
        if (!collections.contains("hellrpg_userPets")) {
            database.createCollection("hellrpg_userPets");
        }
        if (!collections.contains("hellrpg_wyslannik")) {
            database.createCollection("hellrpg_wyslannik");
        }
        if (!collections.contains("hellrpg_handlarz")) {
            database.createCollection("hellrpg_handlarz");
        }
        if (!collections.contains("hellrpg_wyszkolenie")) {
            database.createCollection("hellrpg_wyszkolenie");
        }
        if (!collections.contains("hellrpg_www_tokens")) {
            database.createCollection("hellrpg_www_tokens");
        }
        // TU TWORZYSZ KOLEKCJE JESLI JEJ NIE MA W BAZIE DANYCH (TAKA SZUFLADA NA UZYTKOWNIKOW)
        /*if (!collections.contains("hellrpg_przykladowyNPC")) {
            database.createCollection("hellrpg_przykladowyNPC");
        }*/
        this.hellrpg_gracze = database.getCollection("hellrpg_gracze");
        this.hellrpg_gildie = database.getCollection("hellrpg_gildie");
        this.hellrpg_dodatki = database.getCollection("hellrpg_dodatki");
        this.hellrpg_osiagniecia = database.getCollection("hellrpg_osiagniecia");
        this.hellrpg_bao = database.getCollection("hellrpg_bao");
        this.hellrpg_rybak = database.getCollection("hellrpg_rybak");
        this.hellrpg_kolekcjoner = database.getCollection("hellrpg_kolekcjoner");
        this.hellrpg_magazynier = database.getCollection("hellrpg_magazynier");
        this.hellrpg_metinolog = database.getCollection("hellrpg_metinolog");
        this.hellrpg_medyk = database.getCollection("hellrpg_medyk");
        this.hellrpg_gornik = database.getCollection("hellrpg_gornik");
        this.hellrpg_duszolog = database.getCollection("hellrpg_duszolog");
        this.hellrpg_przyrodnik = database.getCollection("hellrpg_przyrodnik");
        this.hellrpg_bonuses = database.getCollection("hellrpg_bonuses");
        this.hellrpg_lowca = database.getCollection("hellrpg_lowca");
        this.hellrpg_lesnik = database.getCollection("hellrpg_lesnik");
        this.hellrpg_pety = database.getCollection("hellrpg_pety");
        this.hellrpg_userPets = database.getCollection("hellrpg_userPets");
        this.hellrpg_wyslannik = database.getCollection("hellrpg_wyslannik");
        this.hellrpg_handlarz = database.getCollection("hellrpg_handlarz");
        this.hellrpg_wyszkolenie = database.getCollection("hellrpg_wyszkolenie");
        this.hellrpg_www_tokens = database.getCollection("hellrpg_www_tokens");
        // TU PRZYPISUJESZ KOLEKCJE DO ZMIENNEJ
        //this.hellrpg_przykladowyNPC = database.getCollection("hellrpg_przykladowyNPC");
        System.out.println("Connected to database!");
    }

    public MongoCollection<Document> getGracze() {
        return this.hellrpg_gracze;
    }
    public MongoCollection<Document> getGildie() {
        return this.hellrpg_gildie;
    }
    public MongoCollection<Document> getDodatki() {
        return this.hellrpg_dodatki;
    }
    public MongoCollection<Document> getOsiagniecia() {
        return this.hellrpg_osiagniecia;
    }
    public MongoCollection<Document> getBao() {
        return this.hellrpg_bao;
    }
    public MongoCollection<Document> getRybak() {
        return this.hellrpg_rybak;
    }
    public MongoCollection<Document> getKolekcjoner() {
        return this.hellrpg_kolekcjoner;
    }
    public MongoCollection<Document> getMagazynier() {
        return this.hellrpg_magazynier;
    }
    public MongoCollection<Document> getMetinolog() {
        return this.hellrpg_metinolog;
    }
    public MongoCollection<Document> getMedyk() {
        return this.hellrpg_medyk;
    }
    public MongoCollection<Document> getGornik() {
        return this.hellrpg_gornik;
    }
    public MongoCollection<Document> getDuszolog() {
        return this.hellrpg_duszolog;
    }
    public MongoCollection<Document> getPrzyrodnik() {
        return this.hellrpg_przyrodnik;
    }
    public MongoCollection<Document> getBonuses() {
        return this.hellrpg_bonuses;
    }
    public MongoCollection<Document> getLowca() {
        return this.hellrpg_lowca;
    }
    public MongoCollection<Document> getLesnik() {
        return this.hellrpg_lesnik;
    }
    public MongoCollection<Document> getPety() {
        return this.hellrpg_pety;
    }
    public MongoCollection<Document> getUserPets() {
        return this.hellrpg_userPets;
    }
    public MongoCollection<Document> getWyslannik() {
        return this.hellrpg_wyslannik;
    }
    public MongoCollection<Document> getWyszkolenie() {
        return hellrpg_wyszkolenie;
    }

    public MongoCollection<Document> getWWWTokens() {
        return hellrpg_www_tokens;
    }

    // TU ROBISZ MOZWLIOSC ODWOLANIA SIE DO KOLEKCJI
    /*public MongoCollection<Document> getPrzykladowyNPC() {
        return hellrpg_przykladowyNPC;
    }*/

}
