package com.njt.upkg.dto;

import com.njt.upkg.domain.ProjectState;

import java.util.Date;

/**
 * Pomocna klasa za rad sa {@link com.njt.upkg.domain.Project} klasom
 */
public class ProjectDTO {
    /**
     * Id kupca za projekat
     */
    Long buyerID;
    /**
     * id korisnika koji je otvorio projekat
     */
    Long createdByID;
    /**
     * rok za projekat
     */
    Date deadline;
    /**
     * Pocetak projekta
     */
    Date start;
    /**
     * Naziv projekta
     */
    String name;
    /**
     * Status projekta
     */
    ProjectState state;
    /**
     * Vrednost projekta
     */

    float value;

    /**
     * Prazan konstruktor
     */
    public ProjectDTO() {
    }

    /**
     * Vraca id kupca projekta
     * @return id kupca kao Long
     */
    public Long getBuyerID() {
        return buyerID;
    }

    /**
     * Postavlja id kupca projekta
     * @param buyerID id kupca projekta kao Long
     */
    public void setBuyerID(Long buyerID) {
        this.buyerID = buyerID;
    }

    /**
     * Vraca id korisnika koji je otvorio projekat
     * @return id korisnika kao Long
     */
    public Long getCreatedByID() {
        return createdByID;
    }

    /**
     * postavlja id korisnika koji je otvorio projekat
     * @param createdByID id korisnika kao Long
     */
    public void setCreatedByID(Long createdByID) {
        this.createdByID = createdByID;
    }

    /**
     * Vraca rok za projekat
     * @return rok za projekat kao Date
     */
    public Date getDeadline() {
        return deadline;
    }
    /**
     * Postavlja rok za projekat
     * @param deadliDate rok za projekat kao Date
     */
    public void setDeadline(Date deadliDate) {
        this.deadline = deadliDate;
    }

    /**
     * Vraca datum pocetka projekta
     * @return pocetak projekta kao Date
     */
    public Date getStart() {
        return start;
    }
    /**
     * Postavlja datum pocetka projekta
     * @param start pocetak projekta kao Date
     */
    public void setStart(Date start) {
        this.start = start;
    }

    /**
     * Vraca naziv projekta
     * @return naziv projekta kao String
     */
    public String getName() {
        return name;
    }
    /**
     * Postavlja naziv projekta
     * @param name  naziv projekta kao String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Vraca status projekta
     * @return status projekta kao {@link ProjectState}
     */
    public ProjectState getState() {
        return state;
    }
    /**
     * Postavlja status projekta
     * @param state  status projekta kao {@link ProjectState}
     */
    public void setState(ProjectState state) {
        this.state = state;
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
     * @param value  vrednost projekta kao float
     */
    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "buyerID=" + buyerID +
                ", createdByID=" + createdByID +
                ", deadline=" + deadline +
                ", start=" + start +
                ", name='" + name + '\'' +
                ", state=" + state +
                ", value=" + value +
                '}';
    }
}
