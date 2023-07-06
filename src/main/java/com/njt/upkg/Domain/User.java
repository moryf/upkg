package com.njt.upkg.Domain;

import jakarta.persistence.*;

/**
 * Klasa koja predstavlja korisnika sistema
 */
@Entity
@Table(name = "users")
public class User {
    /**
     * id korisnika kao int
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     *  korsinicko ime
     */
    @Column(unique = true, nullable = false)
    private String username;
    /**
     * Sifra korisnika
     */
    @Column(nullable = false)
    private String password;
    /**
     * Uloga koju korisnik ima na sistemu
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    /**
     * Prazan konstruktor
     */
    public User() {
    }

    /**
     * Konstruktor sa svim atributima klase
     * @param id id korisnika
     * @param username korisnicko ime kaoString
     * @param password sifra kao String
     * @param role uloga kao {@link Role}
     * @see Role
     */
    public User(int id, String username, String password, Role role) {
        super();
        setId(id);
        setUsername(username);
        setPassword(password);
        setRole(role);
    }
    /**
     * Konstruktor sa svim atributima klase sem id-a
     * @param username korisnicko ime kaoString
     * @param password sifra kao String
     * @param role uloga kao {@link Role}
     * @see Role
     */
    public User(String username, String password, Role role) {
        super();
        setUsername(username);
        setPassword(password);
        setRole(role);
    }

    /**
     * Vraca id korisnika
     * @return id korisnika kao int
     */
    public int getId() {
        return id;
    }

    /**
     * Postavlja id korisnika
     * @param id id korisnika kao int
     *           @throws IllegalArgumentException ako je id postavljen manji ili jednak 0
     */
    public void setId(int id) {
        if (id<=0) throw new IllegalArgumentException("ID ne moze da bude manji ili jednak 0");
        this.id = id;
    }

    /**
     * Vraca korisnicko ime korisnika
     * @return korisnicko ime kao String
     */
    public String getUsername() {
        return username;
    }

    /**
     * Postavlja korisnicko ime korisnika
     * @param username novo korisnicko ime kao String
     * @throws IllegalArgumentException ako je uneto korisnicko ime prazno
     */
    public void setUsername(String username) {
        if(username==null||username=="") throw new IllegalArgumentException("Korisnicko ime ne moze da bude prazno");
        this.username = username;
    }

    /**
     * Vraca sifru korisnika
     * @return sifra korisnika kao String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Postavlja sifru korisnika
     * @param password sifra korisnika kao String
     * @throws IllegalArgumentException ako je uneta sifra prazna
     */
    public void setPassword(String password) {
        if(password==null||password=="") throw new IllegalArgumentException("Korisnicka sifra ne moze da bude prazna");
        this.password = password;
    }

    /**
     * Vraca ulogu korisnika na sistemu
     * @return uloga korisnika kao {@link Role}
     * @see Role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Postavlja ulogu korisnika
     * @param role uloga korisnika kao {@link Role}
     * @throws NullPointerException ako je unesena uloga null
     */
    public void setRole(Role role) {
        if (role==null) throw new IllegalArgumentException("Uloga ne moze da bude null");
        this.role = role;
    }

    /**
     * Vracca sve atribute objekta klase kao String
     * @return svi atributi objekta klase kao String
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
