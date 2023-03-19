package rpg.rpgapi.objects.wyszkolenie;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.json.JSONObject;

@Getter
public class DrzewkoWyszkolenia {
    private final D1 d1;
    private final D2 d2;
    private final DL1 dl1;
    private final DL2 dl2;
    private final DL3 dl3;
    private final DL4 dl4;
    private final DL5 dl5;
    private final DL6 dl6;
    private final DP1 dp1;
    private final DP2 dp2;
    private final DP3 dp3;
    private final DP4 dp4;
    private final DP5 dp5;
    private final DP6 dp6;
    private final DG1 dg1;
    private final DG2 dg2;
    private final DG3 dg3;

    public DrzewkoWyszkolenia(final Document document) {
        this.d1 = new D1(document.get("d1", Document.class));
        this.d2 = new D2(document.get("d2", Document.class));
        this.dl1 = new DL1(document.get("dl1", Document.class));
        this.dl2 = new DL2(document.get("dl2", Document.class));
        this.dl3 = new DL3(document.get("dl3", Document.class));
        this.dl4 = new DL4(document.get("dl4", Document.class));
        this.dl5 = new DL5(document.get("dl5", Document.class));
        this.dl6 = new DL6(document.get("dl6", Document.class));
        this.dp1 = new DP1(document.get("dp1", Document.class));
        this.dp2 = new DP2(document.get("dp2", Document.class));
        this.dp3 = new DP3(document.get("dp3", Document.class));
        this.dp4 = new DP4(document.get("dp4", Document.class));
        this.dp5 = new DP5(document.get("dp5", Document.class));
        this.dp6 = new DP6(document.get("dp6", Document.class));
        this.dg1 = new DG1(document.get("dg1", Document.class));
        this.dg2 = new DG2(document.get("dg2", Document.class));
        this.dg3 = new DG3(document.get("dg3", Document.class));
    }

    public JSONObject toDocument() {
        return new JSONObject()
                .put("d1", this.d1.toDocument())
                .put("d2", this.d2.toDocument())
                .put("dl1", this.dl1.toDocument())
                .put("dl2", this.dl2.toDocument())
                .put("dl3", this.dl3.toDocument())
                .put("dl4", this.dl4.toDocument())
                .put("dl5", this.dl5.toDocument())
                .put("dl6", this.dl6.toDocument())
                .put("dp1", this.dp1.toDocument())
                .put("dp2", this.dp2.toDocument())
                .put("dp3", this.dp3.toDocument())
                .put("dp4", this.dp4.toDocument())
                .put("dp5", this.dp5.toDocument())
                .put("dp6", this.dp6.toDocument())
                .put("dg1", this.dg1.toDocument())
                .put("dg2", this.dg2.toDocument())
                .put("dg3", this.dg3.toDocument());
    }


    @Getter
    @Setter
    public static class D1 {
        private final String name = "&6Niewzruszona Potega";
        private final int reqLvl = 50;
        private final String reqItem = "I1";
        private final int maxUpgradeLvl = 5;
        private final double perLvl = 1;
        private boolean unlocked;
        private int upgradeLvl;
        private double srDmg;

        public D1(final Document document) {
            this.unlocked = document.getBoolean("unlocked");
            this.upgradeLvl = document.getInteger("upgradeLvl");
            this.srDmg = document.getDouble("srDmg");
        }

        public JSONObject toDocument() {
            return new JSONObject()
                    .put("unlocked", this.unlocked)
                    .put("upgradeLvl", this.upgradeLvl)
                    .put("srDmg", this.srDmg);
        }
    }

    @Getter
    @Setter
    public static class D2 {
        private final String name = "&6Ukryty Talent";
        private final int reqLvl = 55;
        private final String reqItem = "I2";
        private final int maxUpgradeLvl = 5;
        private final int perLvl = 1;
        private boolean unlocked;
        private int upgradeLvl;
        private int szczescie;

        public D2(final Document document) {
            this.unlocked = document.getBoolean("unlocked");
            this.upgradeLvl = document.getInteger("upgradeLvl");
            this.szczescie = document.getInteger("szczescie");
        }

        public JSONObject toDocument() {
            return new JSONObject()
                    .put("unlocked", this.unlocked)
                    .put("upgradeLvl", this.upgradeLvl)
                    .put("szczescie", this.szczescie);
        }
    }

    @Getter
    @Setter
    public static class DP1 {
        private final String name = "&6Silne Cialo";
        private final int reqLvl = 60;
        private final String reqItem = "I3";
        private final int maxUpgradeLvl = 5;
        private final int perLvl = 1;
        private boolean unlocked;
        private int upgradeLvl;
        private int hp;

        public DP1(final Document document) {
            this.unlocked = document.getBoolean("unlocked");
            this.upgradeLvl = document.getInteger("upgradeLvl");
            this.hp = document.getInteger("hp");
        }

        public JSONObject toDocument() {
            return new JSONObject()
                    .put("unlocked", this.unlocked)
                    .put("upgradeLvl", this.upgradeLvl)
                    .put("hp", this.hp);
        }
    }

    @Getter
    @Setter
    public static class DP2 {
        private final String name = "&6Wyzwalajaca Sila";
        private final int reqLvl = 75;
        private final String reqItem = "I4";
        private final int maxUpgradeLvl = 5;
        private final int perLvl = 1;
        private boolean unlocked;
        private int upgradeLvl;
        private int dodatkowyDmg;

        public DP2(final Document document) {
            this.unlocked = document.getBoolean("unlocked");
            this.upgradeLvl = document.getInteger("upgradeLvl");
            this.dodatkowyDmg = document.getInteger("dodatkowyDmg");
        }

        public JSONObject toDocument() {
            return new JSONObject()
                    .put("unlocked", this.unlocked)
                    .put("upgradeLvl", this.upgradeLvl)
                    .put("dodatkowyDmg", this.dodatkowyDmg);
        }
    }

    @Getter
    @Setter
    public static class DP3 {
        private final String name = "&6Pogromca Potworow";
        private final int reqLvl = 90;
        private final String reqItem = "I5";
        private final int maxUpgradeLvl = 5;
        private final double perLvl = 1;
        private boolean unlocked;
        private int upgradeLvl;
        private double silnyNaMoby;

        public DP3(final Document document) {
            this.unlocked = document.getBoolean("unlocked");
            this.upgradeLvl = document.getInteger("upgradeLvl");
            this.silnyNaMoby = document.getDouble("silnyNaMoby");
        }

        public JSONObject toDocument() {
            return new JSONObject()
                    .put("unlocked", this.unlocked)
                    .put("upgradeLvl", this.upgradeLvl)
                    .put("silnyNaMoby", this.silnyNaMoby);
        }
    }

    @Getter
    @Setter
    public static class DP4 {
        private final String name = "&6Niewzruszona Stal";
        private final int reqLvl = 105;
        private final String reqItem = "I6";
        private final int maxUpgradeLvl = 5;
        private final double perLvl = 1;
        private boolean unlocked;
        private int upgradeLvl;
        private double odpornoscNaGraczy;

        public DP4(final Document document) {
            this.unlocked = document.getBoolean("unlocked");
            this.upgradeLvl = document.getInteger("upgradeLvl");
            this.odpornoscNaGraczy = document.getDouble("odpornoscNaGraczy");
        }

        public JSONObject toDocument() {
            return new JSONObject()
                    .put("unlocked", this.unlocked)
                    .put("upgradeLvl", this.upgradeLvl)
                    .put("odpornoscNaGraczy", this.odpornoscNaGraczy);
        }
    }

    @Getter
    @Setter
    public static class DP5 {
        private final String name = "&6Szlachecki Talent";
        private final int reqLvl = 115;
        private final String reqItem = "I7";
        private final int maxUpgradeLvl = 5;
        private final int perLvl = 1;
        private boolean unlocked;
        private int upgradeLvl;
        private int szczescie;

        public DP5(final Document document) {
            this.unlocked = document.getBoolean("unlocked");
            this.upgradeLvl = document.getInteger("upgradeLvl");
            this.szczescie = document.getInteger("szczescie");
        }

        public JSONObject toDocument() {
            return new JSONObject()
                    .put("unlocked", this.unlocked)
                    .put("upgradeLvl", this.upgradeLvl)
                    .put("szczescie", this.szczescie);
        }
    }

    @Getter
    @Setter
    public static class DP6 {
        private final String name = "&6Szlachecka Defensywa";
        private final int reqLvl = 125;
        private final String reqItem = "I8";
        private final int maxUpgradeLvl = 5;
        private final double perLvl = 1;
        private boolean unlocked;
        private int upgradeLvl;
        private double srDef;

        public DP6(final Document document) {
            this.unlocked = document.getBoolean("unlocked");
            this.upgradeLvl = document.getInteger("upgradeLvl");
            this.srDef = document.getDouble("srDef");
        }

        public JSONObject toDocument() {
            return new JSONObject()
                    .put("unlocked", this.unlocked)
                    .put("upgradeLvl", this.upgradeLvl)
                    .put("srDef", this.srDef);
        }
    }

    @Getter
    @Setter
    public static class DG1 {
        private final String name = "&6Niepokonany Wojownik";
        private final int reqLvl = 65;
        private final String reqItem = "I9";
        private final int maxUpgradeLvl = 5;
        private final double perLvl = 1;
        private boolean unlocked;
        private int upgradeLvl;
        private double odpornoscNaMoby;

        public DG1(final Document document) {
            this.unlocked = document.getBoolean("unlocked");
            this.upgradeLvl = document.getInteger("upgradeLvl");
            this.odpornoscNaMoby = document.getDouble("odpornoscNaMoby");
        }

        public JSONObject toDocument() {
            return new JSONObject()
                    .put("unlocked", this.unlocked)
                    .put("upgradeLvl", this.upgradeLvl)
                    .put("odpornoscNaMoby", this.odpornoscNaMoby);
        }
    }

    @Getter
    @Setter
    public static class DG2 {
        private final String name = "&6Niszczyciel Tarcz";
        private final int reqLvl = 80;
        private final String reqItem = "I10";
        private final int maxUpgradeLvl = 5;
        private final double perLvl = 1;
        private boolean unlocked;
        private int upgradeLvl;
        private double przeszywka;

        public DG2(final Document document) {
            this.unlocked = document.getBoolean("unlocked");
            this.upgradeLvl = document.getInteger("upgradeLvl");
            this.przeszywka = document.getDouble("przeszywka");
        }

        public JSONObject toDocument() {
            return new JSONObject()
                    .put("unlocked", this.unlocked)
                    .put("upgradeLvl", this.upgradeLvl)
                    .put("przeszywka", this.przeszywka);
        }
    }

    @Getter
    @Setter
    public static class DG3 {
        private final String name = "&6Szlachecki Blok";
        private final int reqLvl = 95;
        private final String reqItem = "I11";
        private final int maxUpgradeLvl = 5;
        private final double perLvl = 1;
        private boolean unlocked;
        private int upgradeLvl;
        private double blok;

        public DG3(final Document document) {
            this.unlocked = document.getBoolean("unlocked");
            this.upgradeLvl = document.getInteger("upgradeLvl");
            this.blok = document.getDouble("blok");
        }

        public JSONObject toDocument() {
            return new JSONObject()
                    .put("unlocked", this.unlocked)
                    .put("upgradeLvl", this.upgradeLvl)
                    .put("blok", this.blok);
        }
    }

    @Getter
    @Setter
    public static class DL1 {
        private final String name = "&6Barbarzynca";
        private final int reqLvl = 70;
        private final String reqItem = "I12";
        private final int maxUpgradeLvl = 5;
        private final double perLvl = 1;
        private boolean unlocked;
        private int upgradeLvl;
        private double krytyk;

        public DL1(final Document document) {
            this.unlocked = document.getBoolean("unlocked");
            this.upgradeLvl = document.getInteger("upgradeLvl");
            this.krytyk = document.getDouble("krytyk");
        }

        public JSONObject toDocument() {
            return new JSONObject()
                    .put("unlocked", this.unlocked)
                    .put("upgradeLvl", this.upgradeLvl)
                    .put("krytyk", this.krytyk);
        }
    }

    @Getter
    @Setter
    public static class DL2 {
        private final String name = "&6Stalowy Wojownik";
        private final int reqLvl = 85;
        private final String reqItem = "I13";
        private final int maxUpgradeLvl = 5;
        private final double perLvl = 1;
        private boolean unlocked;
        private int upgradeLvl;
        private double srDef;

        public DL2(final Document document) {
            this.unlocked = document.getBoolean("unlocked");
            this.upgradeLvl = document.getInteger("upgradeLvl");
            this.srDef = document.getDouble("srDef");
        }

        public JSONObject toDocument() {
            return new JSONObject()
                    .put("unlocked", this.unlocked)
                    .put("upgradeLvl", this.upgradeLvl)
                    .put("srDef", this.srDef);
        }
    }

    @Getter
    @Setter
    public static class DL3 {
        private final String name = "&6Zabójcze Ostrze";
        private final int reqLvl = 100;
        private final String reqItem = "I14";
        private final int maxUpgradeLvl = 5;
        private final double perLvl = 1;
        private boolean unlocked;
        private int upgradeLvl;
        private double silnyNaLudzi;

        public DL3(final Document document) {
            this.unlocked = document.getBoolean("unlocked");
            this.upgradeLvl = document.getInteger("upgradeLvl");
            this.silnyNaLudzi = document.getDouble("silnyNaLudzi");
        }

        public JSONObject toDocument() {
            return new JSONObject()
                    .put("unlocked", this.unlocked)
                    .put("upgradeLvl", this.upgradeLvl)
                    .put("silnyNaLudzi", this.silnyNaLudzi);
        }
    }

    @Getter
    @Setter
    public static class DL4 {
        private final String name = "&6Niezniszczalny Mur";
        private final int reqLvl = 110;
        private final String reqItem = "I15";
        private final int maxUpgradeLvl = 5;
        private final double perLvl = 1;
        private boolean unlocked;
        private int upgradeLvl;
        private double blok;

        public DL4(final Document document) {
            this.unlocked = document.getBoolean("unlocked");
            this.upgradeLvl = document.getInteger("upgradeLvl");
            this.blok = document.getDouble("blok");
        }

        public JSONObject toDocument() {
            return new JSONObject()
                    .put("unlocked", this.unlocked)
                    .put("upgradeLvl", this.upgradeLvl)
                    .put("blok", this.blok);
        }
    }

    @Getter
    @Setter
    public static class DL5 {
        private final String name = "&6Szlacheckie Zdrowie";
        private final int reqLvl = 120;
        private final String reqItem = "I16";
        private final int maxUpgradeLvl = 5;
        private final int perLvl = 1;
        private boolean unlocked;
        private int upgradeLvl;
        private int hp;

        public DL5(final Document document) {
            this.unlocked = document.getBoolean("unlocked");
            this.upgradeLvl = document.getInteger("upgradeLvl");
            this.hp = document.getInteger("hp");
        }

        public JSONObject toDocument() {
            return new JSONObject()
                    .put("unlocked", this.unlocked)
                    .put("upgradeLvl", this.upgradeLvl)
                    .put("hp", this.hp);
        }
    }

    @Getter
    @Setter
    public static class DL6 {
        private final String name = "&6Szlacheckie Obrazenia";
        private final int reqLvl = 130;
        private final String reqItem = "I17";
        private final int maxUpgradeLvl = 5;
        private final double perLvl = 1;
        private boolean unlocked;
        private int upgradeLvl;
        private double srDmg;

        public DL6(final Document document) {
            this.unlocked = document.getBoolean("unlocked");
            this.upgradeLvl = document.getInteger("upgradeLvl");
            this.srDmg = document.getDouble("srDmg");
        }

        public JSONObject toDocument() {
            return new JSONObject()
                    .put("unlocked", this.unlocked)
                    .put("upgradeLvl", this.upgradeLvl)
                    .put("srDmg", this.srDmg);
        }
    }
}
