package com.njt.upkg.domain;
import jakarta.persistence.*;

/**
 * Klasa koja predstavlja Radnika
 *
 * @author moryf
 */
@Entity
public class Worker {
    /**
     * Id radnika kao Long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Ime radnika kao string
     */
    @Column(nullable = false)
    private String name;
    /**
     * Adresa radnika kao String
     */
    private String address;
    /**
     * Broj telefona radnika kao String
     */
    private String phone;
    /**
     * Email radnika kao string
     */
    private String email;
    /**
     * Tip radnika kao {@link WorkerType}
     * @see WorkerType
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WorkerType type;
    /**
     * Plata radnika u dinarima na sat(satnica)
     */
    @Column(nullable = false)
    private float pricePerHour;

    /**
     * Prazan konstruktor
     */
    public Worker() {
    }

    /**
     * Kontruktor sa svim atributima klase
     * @param id id Radnika kai Long
     * @param name ime radnika kao String
     * @param address adresa radnika kao String
     * @param phone broj telefona radnika kao String
     * @param email email radnika kao String
     * @param type tip radnika kao {@link WorkerType}
     * @param pricePerHour satnica radnika kao float
     * @see WorkerType
     */
    public Worker(Long id, String name, String address, String phone, String email, WorkerType type, float pricePerHour) {
        super();
        setId(id);
        setName(name);
        setAddress(address);
        setPhone(phone);
        setEmail(email);
        setType(type);
        setPricePerHour(pricePerHour);
    }
    /**
     * Kontruktor sa svim atributima klase sem id-a
     * @param name ime radnika kao String
     * @param address adresa radnika kao String
     * @param phone broj telefona radnika kao String
     * @param email email radnika kao String
     * @param type tip radnika kao {@link WorkerType}
     * @param pricePerHour satnica radnika kao float
     * @see WorkerType
     */
    public Worker(String name, String address, String phone, String email, WorkerType type, float pricePerHour) {
        super();
        setName(name);
        setAddress(address);
        setPhone(phone);
        setEmail(email);
        setType(type);
        setPricePerHour(pricePerHour);
    }

    /**
     * vraca id radnika
     * @return id radnika kao Long
     */
    public Long getId() {
        return id;
    }

    /**
     * Postavlja id radnika
     * @param id radnika kao Long
     * @throws IllegalArgumentException ako je id postavljen manji ili jednak 0
     */
    public void setId(Long id) {
        if (id<=0) throw new IllegalArgumentException("ID ne moze da bude manji ili jednak 0");
        this.id = id;
    }

    /**
     * vraca ime radnika
     * @return ime radnika kao String
     */
    public String getName() {
        return name;
    }

    /**
     * Postavlja ime radnika
     * @param name ime radnika kao String
     * @throws IllegalArgumentException ako je uneto ime null ili prazan string
     */
    public void setName(String name) {
        if (name==null||name=="") throw new IllegalArgumentException("Ime ne moze a bude prazno");
        this.name = name;
    }

    /**
     * Vraca adresu radnika
     * @return adresa radnika kao String
     */
    public String getAddress() {
        return address;
    }

    /**
     * Postavlja novu adresu radnika
     * @param address adresa radnika kao String
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Vraca broj telefona radnika
     * @return broj telefona radnika kao String
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Postavlja broj telefona radnika
     * @param phone novi broj telefona radnika kao String
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Vraca email radnika
     * @return email radnika kao String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Postavlja novi email radnika
     * @param email novi email radnika kao String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Vraca tip radnika
     * @return tip radnika kao {@link WorkerType}
     * @see WorkerType
     */
    public WorkerType getType() {
        return type;
    }

    /**
     * Postavlja novi tip radnika
     * @param type tip radnika kao {@link WorkerType}
     * @throws NullPointerException ako je unesen tip null
     * @see WorkerType
     */
    public void setType(WorkerType type) {
        if (type==null) throw new NullPointerException("Tip ne moze da bude prazan");
        this.type = type;
    }

    /**
     * Vraca satnicu radnika
     * @return satnica kao float
     */
    public float getPricePerHour() {
        return pricePerHour;
    }

    /**
     * Postavlja novu satnicu radnika
     * @param pricePerHour satnica radnika kao float
     * @throws IllegalArgumentException ako je unesena satnica manja ili jednaka 0
     */
    public void setPricePerHour(float pricePerHour) {
        if (pricePerHour<=0) throw new IllegalArgumentException("Satnica mora da bude veca od 0");
        this.pricePerHour = pricePerHour;
    }

    /**
     *Vraca sve atribute klase kao STring
     * @return atributi klase kao String
     */
    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                ", pricePerHour=" + pricePerHour +
                '}';
    }
}
