package com.njt.upkg.Domain;
import jakarta.persistence.*;

@Entity
@Table(name = "positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "project")
    private Project project;

    private String name;
    private boolean readyToMount;
    private boolean mounted;

    public Position() {
    }

    public Position(int id, Project project, String name, boolean readyToMount, boolean mounted) {
        this.id = id;
        this.project = project;
        this.name = name;
        this.readyToMount = readyToMount;
        this.mounted = mounted;
    }

    public Position(Project project, String name, boolean readyToMount, boolean mounted) {
        this.project = project;
        this.name = name;
        this.readyToMount = readyToMount;
        this.mounted = mounted;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isReadyToMount() {
        return readyToMount;
    }

    public void setReadyToMount(boolean readyToMount) {
        this.readyToMount = readyToMount;
    }

    public boolean isMounted() {
        return mounted;
    }

    public void setMounted(boolean mounted) {
        this.mounted = mounted;
    }

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
