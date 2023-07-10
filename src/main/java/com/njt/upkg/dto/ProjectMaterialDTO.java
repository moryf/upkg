package com.njt.upkg.dto;

/**
 * Pomocna klasa za rad sa klasom {@link com.njt.upkg.domain.ProjectMaterial}
 */
public class ProjectMaterialDTO {
    /**
     * id utroska materijala
     */
    Long id;
    /**
     * id projekta na kome je materijal utrosen
     */
    Long projectID;
    /**
     * Id pozicije na kojoj je materijal utrosen
     */
    Long positionID;
    /**
     * id materijala koji je utrosen
     */
    Long materialID;
    /**
     * Kolicina materijala koji je utrosen
     */
    int amount;

    /**
     * Prazan konstruktor
     */
    public ProjectMaterialDTO() {
    }
    /**
     * Vraca id troska
     * @return  id troska kao Long
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
     * Vraca id mateijala koji je utrosen
     * @return id materijala kao Long
     */
    public Long getMaterialID() {
        return materialID;
    }
    /**
     * Postavlja id mateijala koji je utrosen
     * @param materialID  id materijala kao Long
     */
    public void setMaterialID(Long materialID) {
        this.materialID = materialID;
    }

    /**
     * Vraca kolicinu utrosenog materijala
     * @return kolicina utrosenog materijala kao int
     */
    public int getAmount() {
        return amount;
    }
    /**
     * Postavlja kolicinu utrosenog materijala
     * @param amount  kolicina utrosenog materijala kao int
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
