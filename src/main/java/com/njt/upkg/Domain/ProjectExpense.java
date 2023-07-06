package com.njt.upkg.Domain;
import jakarta.persistence.*;

/**
 * Klasa koja predstavlja troskove na projektu
 *
 * @author moryf
 */
@Entity
public class ProjectExpense {
    /**
     * id Troska kao int
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Projekat kome trosak pripada klase {@link Project}
     * @see Project
     */
    @ManyToOne
    @JoinColumn(name = "project",nullable = false)
    private Project project;
    /**
     * Pozicija kojoj trosak pripada klase {@link Position}
     * @see Position
     */
    @ManyToOne
    @JoinColumn(name = "position")
    private Position position;
    /**
     * Operacija kojoj trosak pripada klase {@link ProjectOperation}
     * @see ProjectOperation
     */
    @ManyToOne
    @JoinColumn(name = "operation")
    private ProjectOperation operation;
    /**
     * Vrednost roska kao float
     */
    @Column(nullable = false)
    private float value;

    /**
     * Prazan kosntruktor
     */
    public ProjectExpense() {
    }

    /**
     * Konstruktor sa svim atributima klase
     * @param id id troskova
     * @param project Projekat koem troskovi pripadaju klase {@link Project}
     * @param position Pozicija kojoj roskovi pripadaju klase {@link Position}
     * @param operation Operacija kojoj troskovi pripadaju klase {@link ProjectOperation}
     * @param value vrednost troskova kao float
     * @see Project
     * @see Position
     * @see ProjectOperation
     */
    public ProjectExpense(int id, Project project, Position position, ProjectOperation operation, float value) {
        super();
        setId(id);
        setProject(project);
        setPosition(position);
        setOperation(operation);
        setValue(value);
    }

    /**
     * Konstruktor sa svim atributima klase sem id-a
     * @param project Projekat koem troskovi pripadaju klase {@link Project}
     * @param position Pozicija kojoj roskovi pripadaju klase {@link Position}
     * @param operation Operacija kojoj troskovi pripadaju klase {@link ProjectOperation}
     * @param value vrednost troskova kao float
     *  @see Project
     * @see Position
     *@see ProjectOperation
     */
    public ProjectExpense(Project project, Position position, ProjectOperation operation, float value) {
        super();
        setProject(project);
        setPosition(position);
        setOperation(operation);
        setValue(value);
    }

    /**
     * Vraca id troska
     * @return id troska kao int
     */
    public int getId() {
        return id;
    }

    /**
     * Postavlja id troska
     * @param id id troska kao int
     *           @throws IllegalArgumentException ako je id postavljen manji ili jednak 0
     */
    public void setId(int id) {
        if (id<=0) throw new IllegalArgumentException("ID ne moze da bude manji ili jednak 0");
        this.id = id;
    }

    /**
     * Vraca projekat kome troskovi pripadaju klase {@link Project}
     * @return projekat kome troskovi pripadaju klase {@link Project}
     * @see Project
     *
     */
    public Project getProject() {
        return project;
    }

    /**
     * Postavlja projekat kome trosak pripada
     * @param project Projekat kome trosak pripada klase {@link Project}
     * @see Project
     * @throws NullPointerException ako je projekat koji se postavlja null
     */
    public void setProject(Project project) {
        if (project==null) throw new NullPointerException("Projekat ne moze da bude prazan");
        this.project = project;
    }

    /**
     * Vraca poziciju kojoj trosak pripada
     * @return pozicija kojoj trosak pripada klase {@link Position}
     * @see Position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Postavlja poziciju kojoj trosak pripada
     * @param position Pozicija klase {@link Position}
     * @see Position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     *Vraca Operaciju kojoj trosak pripada
     * @return operacija kojoj trosak pripada klase {@link ProjectOperation}
     * @see ProjectOperation
     */
    public ProjectOperation getOperation() {
        return operation;
    }

    /**
     * Postavlja operaciju kojoj trosak pripada
     * @param operation operacija kojoj trosak pripada klase {@link ProjectOperation}
     * @see ProjectOperation
     */
    public void setOperation(ProjectOperation operation) {
        this.operation = operation;
    }

    /**
     * Vraca vrednost troska
     * @return vrednost troska kao float
     */
    public float getValue() {
        return value;
    }

    /**
     * Postavlja vrefnost troska
     * @param value vrednost troska kao float
     */
    public void setValue(float value) {
        if (value<=0) throw new IllegalArgumentException("Vrednost troska ne moze da bude manja ili jednaka 0");
        this.value = value;
    }

    /**
     * Vraca atribute objekta klase kao String
     * @return atributi objekta klase kao String
     */
    @Override
    public String toString() {
        return "ProjectExpense{" +
                "id=" + id +
                ", project=" + project +
                ", position=" + position +
                ", operation=" + operation +
                ", value=" + value +
                '}';
    }
}
