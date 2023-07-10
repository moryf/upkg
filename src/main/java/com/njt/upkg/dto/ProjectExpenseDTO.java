package com.njt.upkg.dto;

/**
 * Pomocna klasa za rad sa klasom {@link com.njt.upkg.domain.ProjectExpense}
 */
public class ProjectExpenseDTO {
    /**
     * id troska
     */
    Long id;
    /**
     * id projekta na kome je trosak nastao
     */
    Long projectID;
    /**
     * Id pozicije na kojoj je trosak nastao
     */
    Long positionID;
    /**
     * Id operacije na kojoj je trosak nastao
     */
    Long operationID;
    /**
     * Vrednost troska
     */
    float value;

    /**
     * Prazan konstruktor
     */
    public ProjectExpenseDTO() {
    }

    /**
     * Vraca id troska
     * @return id troska kao Long
     */
    public Long getId() {
        return id;
    }
    /**
     * Postavlja id troska
     * @param id  id troska kao Long
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Vraca id projekta
     * @return id projekta kao Long
     */
    public Long getProjectID() {
        return projectID;
    }
    /**
     * Postavlja id projekta
     * @param projectID  id projekta kao Long
     */
    public void setProjectID(Long projectID) {
        this.projectID = projectID;
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
     * vraca id operacije
     * @return id operacije kao Long
     */
    public Long getOperationID() {
        return operationID;
    }
    /**
     * Postavlja id operacije
     * @param operationID  id operacije kao Long
     */
    public void setOperationID(Long operationID) {
        this.operationID = operationID;
    }

    /**
     * Vraca vrednost troska
     * @return vrednost troska kao float
     */
    public float getValue() {
        return value;
    }
    /**
     * Postavlja vrednost troska
     * @param value  vrednost troska kao float
     */
    public void setValue(float value) {
        this.value = value;
    }
}
