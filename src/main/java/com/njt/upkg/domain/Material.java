package com.njt.upkg.domain;
import jakarta.persistence.*;

/**
 * Materijali koji se koriste u projektima, obuhvata i elemente koji ulaze u sklop proizvoda
 *
 * @author moryf
 */
@Entity
public class Material {
    /**
     * id materijala
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Ime materijala
     */
    @Column(nullable = false)
    private String name;
    /**
     * Vrsta materijala kao {@link MaterialType} enum
     * @see MaterialType
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MaterialType type;
    /**
     * kolicina materijala u magacinu
     */
    @Column(nullable = false)
    private int inDepo;
    /**
     * Tezina materijala po jedinici mere u kg
     */
    private float weight;
    /**
     * Povrsina materijala po jedinici mere u m2, koristi se za racunanje troskova farbanja i cinkovanja
     */
    private float area;
    /**
     * bool Vrednost koja pokazuje a li se ovaj materijal cinkuje
     */
    private boolean zinked=false;
    /**
     * Bool vrednost koja pokazuje da li se ovaj materijal farba
     */
    private boolean painted=false;
    /**
     * Merna jedinica koja se koristi za ovaj materijal kao {@link MeasuringUnit}
     * @see MaterialType
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MeasuringUnit measuringUnit;
    /**
     * Cena materijala u dinarima po jedinici mere
     */
    @Column(nullable = false)
    private float price;
    /**
     * Prazan konstruktor
     */
    public Material() {
    }

    /**
     * Konstriktor sa svim atributima
     * @param id id materijala
     * @param name naziv materijala
     * @param type tip materijala
     * @param inDepo kolicnina materijala u magacinu
     * @param weight tazina materijala
     * @param area povrsina materijala
     * @param zinked da li se cinkuje materijal
     * @param painted da li se farba materijal
     * @param measuringUnit merna jedinica koja se koristi za materijal
     * @param price cena materijala po jedinici mere
     */
    public Material(Long id, String name, MaterialType type, int inDepo, float weight, float area, boolean zinked, boolean painted, MeasuringUnit measuringUnit, float price) {
        super();
        setId(id);
        setName(name);
        setType(type);
        setInDepo(inDepo);
        setWeight(weight);
        setArea(area);
        setZinked(zinked);
        setPainted(painted);
        setMeasuringUnit(measuringUnit);
        setPrice(price);
    }



    /**
     * Konstrktor sa svim atributima sem id-a materijala
     * @param name naziv materijala
     * @param type tip materijala
     * @param inDepo kolicnina materijala u magacinu
     * @param weight tazina materijala
     * @param area povrsina materijala
     * @param zinked da li se cinkuje materijal
     * @param painted da li se farba materijal
     * @param measuringUnit merna jedinica koja se koristi za materijal
     * @param price cena materijala po jedinici mere
     */

    public Material(String name, MaterialType type, int inDepo, float weight, float area, boolean zinked, boolean painted, MeasuringUnit measuringUnit, float price) {
        super();
        setName(name);
        setType(type);
        setInDepo(inDepo);
        setWeight(weight);
        setArea(area);
        setZinked(zinked);
        setPainted(painted);
        setMeasuringUnit(measuringUnit);
        setPrice(price);
    }

    /**
     * Vraca id materijala
     * @return id materijala
     */
    public Long getId() {
        return id;
    }

    /**
     * Postavlja novi id materijalu
     * @param id novi id materijala
     *           @throws IllegalArgumentException ako je id postavljen manji ili jednak 0
     */
    public void setId(Long id) {
        if (id<=0) throw new IllegalArgumentException("ID ne moze da bude manji ili jednak 0");
        this.id = id;
    }

    /**
     * Vraca naziv materijala
     * @return naziv materijala kao String
     */
    public String getName() {
        return name;
    }

    /**
     * Postavlja novi naziv materijala
     * @param name naziv materijala
     * @throws IllegalArgumentException ako je naziv mateijala null ili prazan String
     */
    public void setName(String name) {
        if(name==null||name=="") throw new IllegalArgumentException("Naziv ne moze da bude prazan");
        this.name = name;
    }

    /**
     * vraca tip materijala
     * @return tip materijala
     */
    public MaterialType getType() {
        return type;
    }

    /**
     * Postavlja novi tip materijala
     * @param type tip materijala kao {@link MaterialType}
     * @throws IllegalArgumentException ako je uneseni tip materijala null
     */
    public void setType(MaterialType type) {
        if (type==null) throw new IllegalArgumentException("Tip materijala ne moze da bude prazan");
        this.type = type;
    }

    /**
     * vraca kolicinu materijala u magacinu
     * @return kolicina materijala u magacinu
     */
    public int getInDepo() {
        return inDepo;
    }

    /**
     * postavlja novu kolicinu materijala u magacinu
     * @param inDepo nova kolicina materijala u magacinu
     * @throws IllegalArgumentException ako je unesena kolicina manja od 0
     */
    public void setInDepo(int inDepo) {
        if(inDepo<0) throw new IllegalArgumentException("Kolicina u magacinu ne moze da bude manja od 0");
        this.inDepo = inDepo;
    }

    /**
     * Vracca tezinu paterijala po mernoj jedinici u kg
     * @return tezina materijala po mernoj jedinici u kg
     */

    public float getWeight() {
        return weight;
    }

    /**
     * Postavlja tezinu materijala po jedinici mere u kg
     * @param weight tezina materijala po jedinici mere u kg
     * @throws IllegalArgumentException ako je tezina manja od 0
     */
    public void setWeight(float weight) {
        if (weight<0) throw new IllegalArgumentException("Masa ne moze da bude manja od 0");
        this.weight = weight;
    }

    /**
     * Vraca povrsinu materijala u m2
     * @return povrsina materijala kao float u m2
     */
    public float getArea() {
        return area;
    }

    /**
     * Postavlja novu povrsinu materijala
     * @param area povrsina materijala u m2
     * @throws IllegalArgumentException ako je povrsina manja od 0
     */
    public void setArea(float area) {
        if (area<0) throw new IllegalArgumentException("Povrsina ne moze da bude manja od 0");
        this.area = area;
    }

    /**
     * Vraca da li se materijal cinkuje kao boolean
     * @return da li se materijal cinkuje kao boolean
     */
    public boolean isZinked() {
        return zinked;
    }

    /**
     * postavlja da li je se materijal cinkuje kao boolea vrednost
     * @param zinked da li se materijal cinkuje kao boolean
     */
    public void setZinked(boolean zinked) {
        this.zinked = zinked;
    }

    /**
     * Vraca da li se materijal farba kao boolean vrednost
     * @return da li se materijal farba kao boolean vrednost
     */
    public boolean isPainted() {
        return painted;
    }

    /**
     * Postavlja da li se materijal farba kao boolean vrednost
     * @param painted da li se materijal farba kao boolean vrednost
     */
    public void setPainted(boolean painted) {
        this.painted = painted;
    }

    /**
     * Vraca mernu jedinicu za materijal
     * @return merna jedinica za materijal kao MeasuringUnit enum
     * @see MeasuringUnit
     */
    public MeasuringUnit getMeasuringUnit() {
        return measuringUnit;
    }

    /**
     * Postavlja mernu jedinicu za materijal kao {@link MeasuringUnit} enum
     * @param measuringUnit merna jedinica za materijal kao {@link MeasuringUnit}
     * @see MeasuringUnit
     */
    public void setMeasuringUnit(MeasuringUnit measuringUnit) {
        if (measuringUnit==null) throw new NullPointerException("Merna jedinica ne moze a bude prazna");
        this.measuringUnit = measuringUnit;
    }

    /**
     * Vraca cenu materijala u dinarima po jedinici mere
     * @return cena materijala u dinarima po jedinici mere kao float
     */
    public float getPrice() {
        return price;
    }

    /**
     * Postavlja novu cenu mateirjala u dinarima po jedinici mere kao float
     *
     * @param price noca cena materijala udinarima po jedinici mere kao float
     * @throws IllegalArgumentException ako je cena manja od 0
     */
    public void setPrice(float price) {
        if (price<0) throw new IllegalArgumentException("Cena ne moze da bude manja od 0");
        this.price = price;
    }

    /**
     * Vraca Sve atribute objekta klase kao String
     * @return atributi objekta klase kao String
     */
    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", inDepo=" + inDepo +
                ", weight=" + weight +
                ", area=" + area +
                ", zinked=" + zinked +
                ", painted=" + painted +
                ", measuringUnit=" + measuringUnit +
                ", price=" + price +
                '}';
    }
}
