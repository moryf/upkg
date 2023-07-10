package com.njt.upkg.domain;
import jakarta.persistence.*;

/**
 * Klasa koja predstavlja pozicije na projektu, mogu se posmatrati kao podprojekti
 *
 * @author moryf
 */
@Entity
@Table(name = "positions")
public class Position {
    /**
     * id Pozicije projekta
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Projekat kome pripada pozicija kao klasa {@link Project}
     * @see Project
     */
    @ManyToOne
    @JoinColumn(name = "project",nullable = false)
    private Project project;
    /**
     * Naziv pozicije projekta
     */
    @Column(nullable = false)
    private String name;
    /**
     * Da li je pozicija spremna za montazu kao boolean vrednsot
     */
    private boolean readyToMount=false;
    /**
     * da li je pozicija montirana
     */
    private boolean mounted=false;

    /**
     * Prazan konstruktor
     */
    public Position() {
    }

    /**
     * Konstruktor sa svim atributima
     * @param id id projekta kao Long
     * @param project projekat kome pozicija pripada klase {@link Project}
     * @see Project
     * @param name naziv porzicije kao String
     * @param readyToMount da li je pozicija spremna za montazu kao boolean
     * @param mounted da li je pozicija montirana kao boolean
     */
    public Position(Long id, Project project, String name, boolean readyToMount, boolean mounted) {
        super();
        setId(id);
        setProject(project);
        setName(name);
        setReadyToMount(readyToMount);
        setMounted(mounted);
    }
    /**
     * Konstruktor sa svim atributima sem ida
     * @param project projekat kome pozicija pripada klase {@link Project}
     * @see Project
     * @param name naziv porzicije kao String
     * @param readyToMount da li je pozicija spremna za montazu kao boolean
     * @param mounted da li je pozicija montirana kao boolean
     */
    public Position(Project project, String name, boolean readyToMount, boolean mounted) {
        super();
        setProject(project);
        setName(name);
        setReadyToMount(readyToMount);
        setMounted(mounted);
    }

    /**
     * Vraca id projekta
     * @return id projekta kao Long
     */
    public Long getId() {
        return id;
    }

    /**
     * Postavlja id projekta
     * @param id id projekta kao int
     *           @throws IllegalArgumentException ako je id postavljen manji ili jednak 0
     */
    public void setId(Long id) {
        if (id<=0) throw new IllegalArgumentException("ID ne moze da bude manji ili jednak 0");
        this.id = id;
    }

    /**
     * Vraca projekat kome pozicija pripada
     * @return projekat kome pozicija pripada kao {@link Project} klasa
     * @see Project
     *
     */
    public Project getProject() {
        return project;
    }

    /**
     * Postavlja projekat kome klasa pripada
     * @param project Projekat kome klasa pripada klase {@link Project}
     * @see Project
     */
    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * Vraca naziv pozicije kao String
     * @return naziv pozicije kao String
     */
    public String getName() {
        return name;
    }

    /**
     * Postavlja naziv pozicije
     * @param name naziv pozicije kao String
     * @throws IllegalArgumentException ako je String koji se postavlja null ili prazan
     */
    public void setName(String name) {
        if (name==null|| name=="") throw  new IllegalArgumentException("Ime ne moze da bude prazno");
        this.name = name;
    }

    /**
     * Vraca da li je pozicija spremna za montazu
     * @return da li je pozicija spremna za montazu kao boolean
     */
    public boolean isReadyToMount() {
        return readyToMount;
    }

    /**
     * Postavlja da li je pozicija spremna za montazu
     * @param readyToMount da li je pozicija spremna za montazu kao boolean
     */
    public void setReadyToMount(boolean readyToMount) {
        this.readyToMount = readyToMount;
    }

    /**
     * Vraca da li je pozicija montirana
     * @return da li je pozicija montirana kao boolean
     */
    public boolean isMounted() {
        return mounted;
    }
    /**
     * Postavlja da li je pozicija montirana
     * @param mounted da li je pozicija montirana kao boolean
     */
    public void setMounted(boolean mounted) {
        this.mounted = mounted;
    }

    /**
     * Vraca sve atribute objekta klase kao String
     * @return atributi objekta klase kao String
     */
    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", project=" + project +
                ", name='" + name + '\'' +
                ", readyToMount=" + readyToMount +
                ", mounted=" + mounted +
                '}';
    }
}
