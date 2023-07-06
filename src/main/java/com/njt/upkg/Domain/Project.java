package com.njt.upkg.Domain;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.*;

/**
 * Predstavlja projekat
 *
 * @author moryf
 */
@Entity
public class Project {
    /**
     * id Projekta kao int
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Naziv projekta kao String
     */
    @Column(nullable = false)
    private String name;
    /**
     * Datum pocetka projekta
     */
    @Column(nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date start;
    /**
     * Rok do kada projekat treba biti zavrsen
     */
    @Column(nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date deadline;
    /**
     * Kupac ,tj. klijent za projekat kalse {@link Buyer}
     * @see Buyer
     */
    @ManyToOne
    @JoinColumn(name = "buyer",nullable = false)
    private Buyer buyer;
    /**
     * Vrednost projekta, dogovorena cena u dinarima kao float
     */
    @Column(nullable = false)
    private float value;
    /**
     * Korisnik koji je kreirao projekat klase {@link User}
     * @see User
     */
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;
    /**
     * Status ili stanje u kome se projekat trenutno nalazi klase {@link ProjectState}
     * @see ProjectState
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProjectState state =ProjectState.Projektovanje;

    /**
     * Prazan konstruktor
     */
    public Project() {
    }

    /**
     * Konstruktor sa svim parametrima sem id-a
     *
     * @param name      naziv projekat
     * @param start pocetak projekta
     * @param deadline  rok za projekat
     * @param buyer     kupac za projekat
     * @param value     vrednost projekta
     * @param createdBy kreator projekta
     * @param state     stanje projekta
     */
    public Project(String name, Date start, Date deadline, Buyer buyer, float value, User createdBy, ProjectState state) {
        super();
        setName(name);
        setStart(start);
        setDeadline(deadline);
        setBuyer(buyer);
        setValue(value);
        setCreatedBy(createdBy);
        setState(state);
    }

    /**
     * Konstruktor sa svim poljima klase
     *
     * @param id        id projekta
     * @param name      naziv projekat
     * @param start pocetak projekta
     * @param deadline  rok za projekat
     * @param buyer     kupac za projekat
     * @param value     vrednost projekta
     * @param createdBy kreator projekta
     * @param state     stanje projekta
     */
    public Project(int id, String name, Date start, Date deadline, Buyer buyer, float value, User createdBy, ProjectState state) {
        super();
        setId(id);
        setName(name);
        setStart(start);
        setDeadline(deadline);
        setBuyer(buyer);
        setValue(value);
        setCreatedBy(createdBy);
        setState(state);
    }

    /**
     * Vraca id projekta
     * @return id projekta kao int
     */
    public int getId() {
        return id;
    }

    /**
     * postavlja id projekta
     * @param id id projekta
     *           @throws IllegalArgumentException ako je id postavljen manji ili jednak 0
     */
    public void setId(int id) {
        if (id<=0) throw new IllegalArgumentException("ID ne moze da bude manji ili jednak 0");
        this.id = id;
    }

    /**
     * Vraca naziv projekta
     * @return naziv projekta kao String
     */
    public String getName() {
        return name;
    }

    /**
     * postavlja naziv projekta
     * @param name naziv projekta
     * @throws IllegalArgumentException ako je String null ili prazan
     */
    public void setName(String name) {
        if (name==null|| name=="") throw new IllegalArgumentException("Ime ne moze da bude prazno");
        this.name = name;
    }

    /**
     * Vraca rok za projekat
     * @return rok za projekat kao datum
     */
    public Date getDeadline() {
        return deadline;
    }

    /**
     * postavlja rok za projekat
     * @param deadline rok za projekat
     * @throws NullPointerException ako je datum null
     */
    public void setDeadline(Date deadline) {
        if (deadline==null) throw new NullPointerException("Datum ne moze da bude null");
        this.deadline = deadline;
    }

    /**
     * Vraca kupca za projekat
     * @return kupac projekta kao klasa {@link Buyer}
     * @see Buyer
     */
    public Buyer getBuyer() {
        return buyer;
    }

    /**
     * Postavlja kupca za projekat
     * @param buyer kupac klase {@link Buyer}
     * @see Buyer
     * @throws NullPointerException ako je kupac koji  se unosi null
     */
    public void setBuyer(Buyer buyer) {
        if (buyer==null) throw  new NullPointerException("Kupac ne moze da bude null");
        this.buyer = buyer;
    }

    /**
     * Vraca vrednost projekta
     * @return vrednost projekta kao float
     */
    public float getValue() {
        return value;
    }

    /**
     * Postavlja vrednost projekta
     * @param value vrednost projekta
     * @throws IllegalArgumentException ako je vrednost koja see unosi manja od 0
     */
    public void setValue(float value) {
        if (value<0) throw new IllegalArgumentException("Vrednost projekta ne moze da bude manja od 0");
        this.value = value;
    }

    /**
     * Vraca kreatora projekta
     * @return kreator projekta klase {@link User}
     * @see User
     */
    public User getCreatedBy() {
        return createdBy;
    }

    /**
     * Postavlja Kreatora projekta
     * @param createdBy Kreator projekta klase {@link User}
     * @see User
     */
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Vraca Status projekta
     * @return status projekta klase {@link ProjectState}
     * @see ProjectState
     */
    public ProjectState getState() {
        return state;
    }

    /**
     * Postavlja stanje projekta
     * @param state status projekta klase {@link ProjectState}
     * @see ProjectState
     * @throws NullPointerException ako je stanje koje se unosi null
     */
    public void setState(ProjectState state) {
        if (state==null) throw new NullPointerException("Stanje projekta ne moze da bude prazno");
        this.state = state;
    }

    /**
     * Vraca polja klase kao jedan string
     * @return string sa vrednostima atributa klase
     */
    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deadline=" + deadline +
                ", buyer=" + buyer +
                ", value=" + value +
                ", createdBy=" + createdBy +
                ", state=" + state +
                '}';
    }

    /**
     * Vraca datum pocetka projekta
     * @return datum pocetka projekta klase Date
     */
    public Date getStart() {
        return start;
    }

    /**
     * Postavlja datum pocetetka projekta
     * @param start datum pocetka projekta klase {@link Date}
     */
    public void setStart(Date start) {
        this.start = start;
    }
}
