package com.njt.upkg.Domain;
import jakarta.persistence.*;

/**
 * Klasa koja predstavlja materijal upotrebljen na nekom projektu
 *
 * @author moryf
 */
@Entity
public class ProjectMaterial {
    /**
     * Id utrosenog materijala
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Projekat na kom ej materijal utrosen
     * @see Project
     */
    @ManyToOne
    @JoinColumn(name = "project",nullable = false)
    private Project project;
    /**
     * Pozicija na kojoj je materijal utrosen
     * @see Position
     */
    @ManyToOne
    @JoinColumn(name = "position")
    private Position position;
    /**
     * Materijal koji je utrosen
     * @see Material
     */
    @ManyToOne
    @JoinColumn(name = "material",nullable = false)
    private Material material;
    /**
     * Kolicina materijala koja je utrosena kao integer
     */
    private int amount;

    /**
     * Prazan konstruktor
     */
    public ProjectMaterial() {
    }

    /**
     * Konstruktor sa svim atributima
     * @param id id projekta
     * @param project Projekat {@link Project}
     * @param position pozicija {@link Position}
     * @param material materijal {@link Material}
     * @param amount kolicina kao float
     * @see Project
     * @see Position
     * @see Material
     */
    public ProjectMaterial(Long id, Project project, Position position, Material material, int amount) {
        super();
        setId(id);
        setProject(project);
        setPosition(position);
        setMaterial(material);
        setAmount(amount);
    }


    /**
     * Konstruktor sa svim atributima sem id-a
     * @param project Projekat {@link Project}
     * @param position pozicija {@link Position}
     * @param material materijal {@link Material}
     * @param amount kolicina kao float
     * @see Project
     * @see Position
     * @see Material
     */
    public ProjectMaterial(Project project, Position position, Material material, int amount) {
        super();
        setProject(project);
        setPosition(position);
        setMaterial(material);
        setAmount(amount);
    }

    /**
     * Vraca id utrosenog materijala
     * @return id kao Long
     */
    public Long getId() {
        return id;
    }

    /**
     * Postavlja id utrosenog materijala
     * @param id novi id utrosenog materijala
     *           @throws IllegalArgumentException ako je id postavljen manji ili jednak 0
     */
    public void setId(Long id) {
        if (id<=0) throw new IllegalArgumentException("ID ne moze da bude manji ili jednak 0");
        this.id = id;
    }

    /**
     * Vraca projekat za koji je materijal utrosen
     * @return projekat {@link Project}
     * @see Project
     */
    public Project getProject() {
        return project;
    }

    /**
     * Postavlja novi projekat za koji je materijal utrosen
     * @param project novi projekat {@link Project}
     * @see Project
     * @throws NullPointerException ako je prosledjeni projekat null
     */
    public void setProject(Project project) {
        if (project== null) throw new NullPointerException("Projekat ne moze da bude prazan");
        this.project = project;
    }

    /**
     * Vraca poziciju za koju je materijal utrosen
     * @return pozicija klase {@link Position}
     * @see Position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Postavlja poziciju za koju je materijal utrosen
     * @param position nova pozicija klase {@link Position}
     * @see Position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Vraca materijal koji je utrosen
     * @return materijal koji je utrosen klase {@link Material}
     * @see Material
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * Postavlja materijal koji je utrosen
     * @param material materijal koji je utrosen
     * @throws NullPointerException ako je prosledjeni materijal null
     */
    public void setMaterial(Material material) {
        if (material==null) throw new NullPointerException("Materijal ne moze da bude null");
        this.material = material;
    }

    /**
     * Vraca utrosenu kolicinu materijala
     * @return utrosena kolicina kao int
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Postavlja utrosenu kolicinu materijala
     * @param amount kolicina materijala kao int
     * @throws IllegalArgumentException ako je unesena kolicina manja od 0 ili jednaka 0
     */
    public void setAmount(int amount) {
        if (amount<=0) throw new IllegalArgumentException("Kolicina ne moze biti manja ili jednaka 0");
        this.amount = amount;
    }

    /**
     * Vraca atribute kao string
     * @return atributi kao String
     */
    @Override
    public String toString() {
        return "ProjectMaterial{" +
                "id=" + id +
                ", project=" + project +
                ", position=" + position +
                ", material=" + material +
                ", amount=" + amount +
                '}';
    }
}
