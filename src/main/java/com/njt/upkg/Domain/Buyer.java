package com.njt.upkg.Domain;

import jakarta.persistence.*;

/**
 * Klasa koja predstavlja kupce za koje se rade projekti
 */
@Entity
@Table(name = "buyers")
public class Buyer {
    /**
     * Id kupca
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Ime kupca
     */
    @Column(nullable = false)
    private String name;
    /**
     * Broj telefona kupca
     */
    private String number;
    /**
     * eMail kupca
     */
    @Column(nullable = false)
    private String email;

    /**
     * Prazan konstruktor objekta
     */
    public Buyer() {
    }

    /**
     * Konstruktor sa svim parametrima klase
     * @param id id kupca
     * @param name ime kupca
     * @param number broj telefona kupca
     * @param email eMail kupca
     */
    public Buyer(int id, String name, String number, String email) {
        super();
        setId(id);
        setName(name);
        setNumber(number);
        setEmail(email);
    }

    /**
     * Konstruktor sa svim atributima sem id-a
     * @param name novo ime kupca
     * @param number novi broj telefona kupca
     * @param email novi email kupca
     */
    public Buyer(String name, String number, String email) {
        super();
        setName(name);
        setNumber(number);
        setEmail(email);
    }

    /**
     * Vraca id kupca
     * @return id kupca
     */
    public int getId() {
        return id;
    }

    /**
     * postavlja novi id kupca
     * @param id novi id kupca
     *           @throws IllegalArgumentException ako je id postavljen manji ili jednak 0
     */
    public void setId(int id) {
        if (id<=0) throw new IllegalArgumentException("ID ne moze da bude manji ili jednak 0");
        this.id = id;
    }

    /**
     * vraca ime kupca
     * @return ime kupca kao String
     */
    public String getName() {
        return name;
    }

    /**
     * Postavlja novo ime kupca
     * @param name novo ime kupca
     * @throws IllegalArgumentException ako je ime prazno
     */
    public void setName(String name) {
        if(name==null || name == "") {
            throw new IllegalArgumentException("Ime ne moze da bude prazno");
        }
        this.name = name;
    }

    /**
     * Vraca broj telefona kupca
     * @return broj telefona kao String
     */
    public String getNumber() {
        return number;
    }

    /**
     * Postavlja novi broj telefona kupca
     * @param number novi broj telefona kupca
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Vraca email kupca
     * @return email kupca kao String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Postavlja novi email kupca
     * @param email novi email kupca
     * @throws IllegalArgumentException ako je email prazan
     */
    public void setEmail(String email) {
        if(email==null|| email== "") throw new IllegalArgumentException("email ne moze da bude prazan");
        this.email = email;
    }

    /**
     * Vraca sve atribute klase kao String
     * @return String sa svim atributima objekta klase
     */
    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
