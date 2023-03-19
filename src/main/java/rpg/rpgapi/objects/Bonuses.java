package rpg.rpgapi.objects;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.json.JSONObject;

import java.util.UUID;

@Getter
@Setter
public class Bonuses {
    private final UUID uuid;
    private int dodatkowehp, dodatkowezlotehp, dodatkoweobrazenia, truedamage, szczescie, szybkosc, dmgMetiny;
    private double srednieobrazenia, silnynaludzi, silnynapotwory, sredniadefensywa, defnaludzi, defnamoby, szansanakryta, szansanawzmocnieniekryta, blokciosu,
            przeszyciebloku, szansanakrwawienie, minussrednieobrazenia, minussredniadefensywa, minusdefnaludzi, minusdefnamoby, minusobrazenianaludzi, minusobrazenianamoby,
            spowolnienie, dodatkowyExp, oslepienie, przebiciePancerza, wampiryzm, wzmocnienieKryta;

    public Bonuses(final Document document) {
        this.uuid = UUID.fromString(document.getString("_id"));
        this.dodatkowehp = document.getInteger("dodatkowehp");
        this.dodatkowezlotehp = document.getInteger("dodatkowezlotehp");
        this.dodatkoweobrazenia = document.getInteger("dodatkoweobrazenia");
        this.truedamage = document.getInteger("truedamage");
        this.srednieobrazenia = document.getDouble("srednieobrazenia");
        this.silnynaludzi = document.getDouble("silnynaludzi");
        this.silnynapotwory = document.getDouble("silnynapotwory");
        this.sredniadefensywa =  document.getDouble("sredniadefensywa");
        this.defnaludzi = document.getDouble("defnaludzi");
        this.defnamoby = document.getDouble("defnamoby");
        this.szansanakryta = document.getDouble("szansanakryta");
        this.szansanawzmocnieniekryta = document.getDouble("szansanawzmocnieniekryta");
        this.blokciosu = document.getDouble("blokciosu");
        this.przeszyciebloku = document.getDouble("przeszyciebloku");
        this.szansanakrwawienie = document.getDouble("szansanakrwawienie");
        this.minussrednieobrazenia = document.getDouble("minussrednieobrazenia");
        this.minussredniadefensywa = document.getDouble("minussredniadefensywa");
        this.minusdefnaludzi = document.getDouble("minusdefnaludzi");
        this.minusdefnamoby = document.getDouble("minusdefnamoby");
        this.minusobrazenianaludzi = document.getDouble("minusobrazenianaludzi");
        this.minusobrazenianamoby = document.getDouble("minusobrazenianamoby");
        this.szczescie = document.getInteger("szczescie");
        this.szybkosc = document.getInteger("szybkosc");
        this.spowolnienie = document.getDouble("spowolnienie");
        this.dodatkowyExp = document.getDouble("dodatkowyExp");
        this.oslepienie = document.getDouble("oslepienie");
        this.przebiciePancerza = document.getDouble("przebiciePancerza");
        this.wampiryzm = document.getDouble("wampiryzm");
        this.wzmocnienieKryta = document.getDouble("wzmocnienieKryta");
        this.dmgMetiny = document.getInteger("dmgMetiny");
    }

    public JSONObject toDocument() {
        return new JSONObject()
                .put("dodatkowehp", getDodatkowehp())
                .put("dodatkowezlotehp", getDodatkowezlotehp())
                .put("dodatkoweobrazenia", getDodatkoweobrazenia())
                .put("truedamage", getTruedamage())
                .put("srednieobrazenia", getSrednieobrazenia())
                .put("silnynaludzi", getSilnynaludzi())
                .put("silnynapotwory", getSilnynapotwory())
                .put("sredniadefensywa", getSredniadefensywa())
                .put("defnaludzi", getDefnaludzi())
                .put("defnamoby", getDefnamoby())
                .put("szansanakryta", getSzansanakryta())
                .put("szansanawzmocnieniekryta", getSzansanawzmocnieniekryta())
                .put("blokciosu", getBlokciosu())
                .put("przeszyciebloku", getPrzeszyciebloku())
                .put("szansanakrwawienie", getSzansanakrwawienie())
                .put("minussrednieobrazenia", getMinussrednieobrazenia())
                .put("minussredniadefensywa", getMinussredniadefensywa())
                .put("minusdefnaludzi", getMinusdefnaludzi())
                .put("minusdefnamoby", getMinusdefnamoby())
                .put("minusobrazenianaludzi", getMinusobrazenianaludzi())
                .put("minusobrazenianamoby", getMinusobrazenianamoby())
                .put("szczescie", getSzczescie())
                .put("szybkosc", getSzybkosc())
                .put("spowolnienie", getSpowolnienie())
                .put("dodatkowyExp", getDodatkowyExp())
                .put("oslepienie", getOslepienie())
                .put("przebiciePancerza", getPrzebiciePancerza())
                .put("wampiryzm", getWampiryzm())
                .put("wzmocnienieKryta", getWzmocnienieKryta())
                .put("dmgMetiny", getDmgMetiny());
    }
}
