package com.njt.upkg.dto;

import com.njt.upkg.domain.OperationType;

import java.util.Date;

/**
 * Pomocna klasa za radd sa klasom {@link com.njt.upkg.domain.ProjectOperation}
 */
public class ProjectOperationDTO {
    /**
     * id operacije
     */
    Long id;
    /**
     * id projekta
     */
    Long prrojectID;
    /**
     * id pozicije
     */
    Long positionID;
    /**
     * id radnika
     */
    Long workerID;
    /**
     * tip operacije
     */
    OperationType type;
    /**
     * Pocetak operacije
     */
    Date start;
    /**
     * Kraj operacije
     */
    Date ended;
    /**
     * Da li je opreacija aktivna
     */
    boolean active;

    /**
     * Prazan konstruktor
     */
    public ProjectOperationDTO() {
    }

    /**
     * Vraca id operacije
     * @return id operaccije kao Long
     */
    public Long getId() {
        return id;
    }
    /**
     * Postavlja id operacije
     * @param id  id operaccije kao Long
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Vraca id projekta
     * @return id projekta kao Long
     */
    public Long getPrrojectID() {
        return prrojectID;
    }
    /**
     * Postavlja id projekta
     * @param prrojectID  id projekta kao Long
     */
    public void setPrrojectID(Long prrojectID) {
        this.prrojectID = prrojectID;
    }

    /**
     * Vraca id pozicije
     * @return id pozicije kao Long
     */
    public Long getPositionID() {
        return positionID;
    }
    /**
     * Postavlja id pozicije
     * @param positionID  id pozicije kao Long
     */
    public void setPositionID(Long positionID) {
        this.positionID = positionID;
    }

    /**
     * Vraca id radnika
     * @return id radnika kao Long
     */
    public Long getWorkerID() {
        return workerID;
    }
    /**
     * Postavlja id radnika
     * @param workerID  id radnika kao Long
     */
    public void setWorkerID(Long workerID) {
        this.workerID = workerID;
    }

    /**
     * Vraca tip operacije
     * @return tio operacije kao {@link OperationType}
     */
    public OperationType getType() {
        return type;
    }
    /**
     * Postavlja tip operacije
     * @param type  tio operacije kao {@link OperationType}
     */
    public void setType(OperationType type) {
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
     * Vraca kraj operacije
     * @return kraj operacije kao {@link Date}
     */
    public Date getEnded() {
        return ended;
    }
    /**
     * postavlja kraj operacije
     * @param ended  kraj operacije kao {@link Date}
     */
    public void setEnded(Date ended) {
        this.ended = ended;
    }

    /**
     * Vraca da li je operacija aktivna
     * @return da li je operacija aktivna tipa boolean
     */
    public boolean isActive() {
        return active;
    }
    /**
     * postavlja da li je operacija aktivna
     * @param active  da li je operacija aktivna tipa boolean
     */
    public void setActive(boolean active) {
        this.active = active;
    }
}
