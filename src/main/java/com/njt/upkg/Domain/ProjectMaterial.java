package com.njt.upkg.Domain;
import jakarta.persistence.*;

@Entity
public class ProjectMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "project")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "position")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "material")
    private Material material;

    private int amount;

    public ProjectMaterial(int id, Project project, Position position, Material material, int amount) {
        this.id = id;
        this.project = project;
        this.position = position;
        this.material = material;
        this.amount = amount;
    }

    public ProjectMaterial() {
    }

    public ProjectMaterial(Project project, Position position, Material material, int amount) {
        this.project = project;
        this.position = position;
        this.material = material;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

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
