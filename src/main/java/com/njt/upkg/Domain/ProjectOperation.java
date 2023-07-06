package com.njt.upkg.Domain;
import jakarta.persistence.*;


import java.util.Date;

/**
 * Klasa koja predstavlja operacije koje se izvrsavaju na projektu
 *
 * @author moryf
 */
@Entity
public class ProjectOperation {
    /**
     * id Operacije kao int
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Projekat na kome se radi operacije klase {@link Project}
     * @see Project
     */
    @ManyToOne
    @JoinColumn(name = "project",nullable = false)
    private Project project;
    /**
     * Pozicija na kojoj se radi operaccija klase {@link Position}
     * @see Position
     */
    @ManyToOne
    @JoinColumn(name = "position")
    private Position position;

    /**
     * Radnik koji radi operaciju
     * @see Worker
     */
    @ManyToOne
    @JoinColumn(name = "worker")
    private Worker worker;
    /**
     * Tip operacije
     * @see OperationType
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OperationType type;
    /**
     * Pocetak rada operacije
     *
     */
    @Column(nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date start;
    /**
     * Datum zavrsetka operacije
     */
    @Column(nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date ended;
    /**
     * Da li se operacija trenutno radi
     */
    private boolean active=true;

    /**
     * Prazan konstruktor
     */
    public ProjectOperation() {
    }

    /**
     * Konstruktor sa svim atributima klase
     * @param id id operacije
     * @param project projekat za koji se radi operacija
     * @param position pozicija za koju se radi operacija
     * @param worker radnik koji radi operaciju
     * @param type tip operacije
     * @param start pocetak operacije
     * @param ended kraj operacije
     * @param active da li je operaccija aktivna
     * @see Project
     * @see Position
     * @see Worker
     * @see OperationType
     */
    public ProjectOperation(int id, Project project, Position position, Worker worker, OperationType type, Date start, Date ended, boolean active) {
        super();
        setProject(project);
        setId(id);
        setPosition(position);
        setWorker(worker);
        setType(type);
        setStart(start);
        setEnded(ended);
        setActive(active);
    }

    /**
     * Konstruktor sa svim atributima klase sem id-a
     * @param project projekat za koji se radi operacija
     * @param position pozicija za koju se radi operacija
     * @param worker radnik koji radi operaciju
     * @param type tip operacije
     * @param start pocetak operacije
     * @param ended kraj operacije
     * @param active da li je operaccija aktivna
     * @see Project
     * @see Position
     * @see Worker
     * @see OperationType
     */
    public ProjectOperation(Project project, Position position, Worker worker, OperationType type, Date start,  Date ended, boolean active) {
        super();
        setProject(project);
        setPosition(position);
        setWorker(worker);
        setType(type);
        setStart(start);
        setEnded(ended);
        setActive(active);
    }

    /**
     * Vraca id operacije
     * @return id operacije kao int
     */
    public int getId() {
        return id;
    }

    /**
     * Postavlja id operacije
     * @param id novi id kao int
     *           @throws IllegalArgumentException ako je id postavljen manji ili jednak 0
     */
    public void setId(int id) {
        if (id<=0) throw new IllegalArgumentException("ID ne moze da bude manji ili jednak 0");
        this.id = id;
    }

    /**
     * Vracca projekat za koji se radi operacija
     * @return projekat
     * @see Project
     */
    public Project getProject() {
        return project;
    }

    /**
     * Postavlja projekat za koji se radi operacija
     * @param project projekat za koj ise radi operacija
     * @see Project
     * @throws NullPointerException ako je projekat koji se postavlja null
     */
    public void setProject(Project project) {
        if (project==null) throw new NullPointerException("Projekat ne moze da bude prazan");
        this.project = project;
    }

    /**
     * Vraca poziciju za koju se radi operacija
     * @return pozicija
     * @see Position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Postavlja poziciju za koju se radi operacija
     * @param position pzocija
     * @see Position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Vraca radnika koji radi operaciju
     * @return radnik koji radi operaciju
     * @see Worker
     */
    public Worker getWorker() {
        return worker;
    }

    /**
     * Postavlja radnika koji radi operaciju
     * @param worker radmik koji radi operaciju
     * @see Worker
     *
     */
    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    /**
     * Vraca tip operacije
     * @return tip operacije kao {@link OperationType}
     * @see OperationType
     */
    public OperationType getType() {
        return type;
    }

    /**
     * Postavlja tip operacije
     * @param type tip operaccije kao {@link OperationType}
     * @throws IllegalArgumentException ako je tip koji se postavlja null
     * @see OperationType
     */
    public void setType(OperationType type) {
        if (type==null) throw new IllegalArgumentException("Tip operacije ne moze da bude prazan");
        this.type = type;
    }

    /**
     * Vraca pocetak operacije
     * @return pocetak operacije kao {@link Date}
     */
    public Date getStart() {
        return start;
    }

    /**
     * Postavlja pocetak operacije
     * @param start pocetak operacije kao {@link Date}
     */
    public void setStart(Date start) {
        this.start = start;
    }

    /**
     * Vraca kraj operacije kao {@link Date}
     * @return vreme kraja operacije kao {@link Date}
     */
    public Date getEnded() {
        return ended;
    }

    /**
     * Postavlja vreme kraja operacije
     * @param ended kraj operacije kao {@link Date}
     * @throws IllegalArgumentException ako je datup kraja postavljen pre pocetka
     */
    public void setEnded(Date ended) {
        if (ended.before(this.start)) throw new IllegalArgumentException("Kraj operacije ne moze biti pre njenog pocetka");
        this.ended = ended;
    }

    /**
     * Vraca da li je operacija aktivna
     * @return da li je operacija aktivna kao boolean
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Postavlja da li je operacija aktivna
     * @param active da li je operacija kativna kao boolean
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Vraca atribute objekta klase kao String
     * @return atributi objekta klase kao String
     */
    @Override
    public String toString() {
        return "ProjectOperation{" +
                "id=" + id +
                ", project=" + project +
                ", position=" + position +
                ", worker=" + worker +
                ", type=" + type +
                ", start=" + start +
                ", ended=" + ended +
                ", active=" + active +
                '}';
    }
}
