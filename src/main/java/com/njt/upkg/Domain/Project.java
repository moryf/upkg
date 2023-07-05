package com.njt.upkg.Domain;

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
     * id Projekta, Generisan od strane baze
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Naziv projekta
     */
    @Column(nullable = false)
    private String name;
    /**
     * Rok do kada projekat treba biti zavrsen
     */
    @Column(nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date deadline;
    /**
     * Kupac ,tj. klijent za projekat
     */
    @ManyToOne
    @JoinColumn(name = "buyer")
    private Buyer buyer;
    /**
     * Vrednost projekta, dogovorena cena
     */
    private float value;
    /**
     * Korisnik koji je kreirao projekat
     */
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;
    /**
     * Status ili stanje u kome se projekat trenutno nalazi
     */
    @Enumerated(EnumType.STRING)
    private ProjectState state;

    /**
     * Prazan konstruktor
     */
    public Project() {
    }

    /**
     * Konstruktor sa svim parametrima sem id-a
     * @param name naziv projekat
     * @param deadline rok za projekat
     * @param buyer kupac za projekat
     * @param value vrednost projekta
     * @param createdBy kreator projekta
     * @param state stanje projekta
     */
    public Project(String name, Date deadline, Buyer buyer, float value, User createdBy, ProjectState state) {
        this.name = name;
        this.deadline = deadline;
        this.buyer = buyer;
        this.value = value;
        this.createdBy = createdBy;
        this.state = state;
    }

    /**
     * Konstruktor sa svim poljima klase
     * @param id id projekta
     * @param name naziv projekat
     * @param deadline rok za projekat
     * @param buyer kupac za projekat
     * @param value vrednost projekta
     * @param createdBy kreator projekta
     * @param state stanje projekta
     */
    public Project(int id, String name, Date deadline, Buyer buyer, float value, User createdBy, ProjectState state) {
        this.id = id;
        this.name = name;
        this.deadline = deadline;
        this.buyer = buyer;
        this.value = value;
        this.createdBy = createdBy;
        this.state = state;
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
     */
    public void setId(int id) {
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
     */
    public void setName(String name) {
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
     */
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    /**
     * Vraca kupca za projekat
     * @return kupac projekta kao klasa Buyer
     */
    public Buyer getBuyer() {
        return buyer;
    }

    /**
     * Postavlja kupca za projekat
     * @param buyer kupac klase Buyer
     */
    public void setBuyer(Buyer buyer) {
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
     */
    public void setValue(float value) {
        this.value = value;
    }

    /**
     * Vraca kreatora projekta
     * @return kreator projekta klase User
     */
    public User getCreatedBy() {
        return createdBy;
    }

    /**
     * Postavlja Kreatora projekta
     * @param createdBy Kreator projekta klase User
     */
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Vraca Status projekta
     * @return status projekta klase ProjectState
     */
    public ProjectState getState() {
        return state;
    }

    /**
     * Postavlja stanje projekta
     * @param state status projekta klase ProjectState
     */
    public void setState(ProjectState state) {
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
}
