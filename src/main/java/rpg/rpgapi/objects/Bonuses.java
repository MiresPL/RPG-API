package rpg.rpgapi.objects;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

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
        this.dodatkowyExp = document.getInteger("dodatkowyExp");
        this.oslepienie = document.getDouble("oslepienie");
        this.przebiciePancerza = document.getDouble("przebiciePancerza");
        this.wampiryzm = document.getDouble("wampiryzm");
        this.wzmocnienieKryta = document.getDouble("wzmocnienieKryta");
        this.dmgMetiny = document.getInteger("dmgMetiny");
    }

    public Document toDocument() {
        return new Document("_id", this.uuid.toString())
                .append("dodatkowehp", getDodatkowehp())
                .append("dodatkowezlotehp", getDodatkowezlotehp())
                .append("dodatkoweobrazenia", getDodatkoweobrazenia())
                .append("truedamage", getTruedamage())
                .append("srednieobrazenia", getSrednieobrazenia())
                .append("silnynaludzi", getSilnynaludzi())
                .append("silnynapotwory", getSilnynapotwory())
                .append("sredniadefensywa", getSredniadefensywa())
                .append("defnaludzi", getDefnaludzi())
                .append("defnamoby", getDefnamoby())
                .append("szansanakryta", getSzansanakryta())
                .append("szansanawzmocnieniekryta", getSzansanawzmocnieniekryta())
                .append("blokciosu", getBlokciosu())
                .append("przeszyciebloku", getPrzeszyciebloku())
                .append("szansanakrwawienie", getSzansanakrwawienie())
                .append("minussrednieobrazenia", getMinussrednieobrazenia())
                .append("minussredniadefensywa", getMinussredniadefensywa())
                .append("minusdefnaludzi", getMinusdefnaludzi())
                .append("minusdefnamoby", getMinusdefnamoby())
                .append("minusobrazenianaludzi", getMinusobrazenianaludzi())
                .append("minusobrazenianamoby", getMinusobrazenianamoby())
                .append("szczescie", getSzczescie())
                .append("szybkosc", getSzybkosc())
                .append("spowolnienie", getSpowolnienie())
                .append("dodatkowyExp", getDodatkowyExp())
                .append("oslepienie", getOslepienie())
                .append("przebiciePancerza", getPrzebiciePancerza())
                .append("wampiryzm", getWampiryzm())
                .append("wzmocnienieKryta", getWzmocnienieKryta())
                .append("dmgMetiny", getDmgMetiny());
    }
}
