package com.njt.upkg.Domain;
import jakarta.persistence.*;

@Entity
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(EnumType.STRING)
    private MaterialType type;

    private int inDepo;
    private float weight;
    private float area;
    private boolean zinked;
    private boolean painted;

    @Enumerated(EnumType.STRING)
    private MeasuringUnit measuringUnit;

    private float price;

    public Material(int id, String name, MaterialType type, int inDepo, float weight, float area, boolean zinked, boolean painted, MeasuringUnit measuringUnit, float price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.inDepo = inDepo;
        this.weight = weight;
        this.area = area;
        this.zinked = zinked;
        this.painted = painted;
        this.measuringUnit = measuringUnit;
        this.price = price;
    }

    public Material() {
    }

    public Material(String name, MaterialType type, int inDepo, float weight, float area, boolean zinked, boolean painted, MeasuringUnit measuringUnit, float price) {
        this.name = name;
        this.type = type;
        this.inDepo = inDepo;
        this.weight = weight;
        this.area = area;
        this.zinked = zinked;
        this.painted = painted;
        this.measuringUnit = measuringUnit;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MaterialType getType() {
        return type;
    }

    public void setType(MaterialType type) {
        this.type = type;
    }

    public int getInDepo() {
        return inDepo;
    }

    public void setInDepo(int inDepo) {
        this.inDepo = inDepo;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public boolean isZinked() {
        return zinked;
    }

    public void setZinked(boolean zinked) {
        this.zinked = zinked;
    }

    public boolean isPainted() {
        return painted;
    }

    public void setPainted(boolean painted) {
        this.painted = painted;
    }

    public MeasuringUnit getMeasuringUnit() {
        return measuringUnit;
    }

    public void setMeasuringUnit(MeasuringUnit measuringUnit) {
        this.measuringUnit = measuringUnit;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

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
