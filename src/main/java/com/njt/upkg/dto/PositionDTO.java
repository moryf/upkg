package com.njt.upkg.dto;

/**
 * Pomocna klasa za rad sa klasom {@link com.njt.upkg.domain.Position}
 */
public class PositionDTO {
    /**
     * Id objekta
     */
    Long id;
    /**
     * ID projekta na kome se nalazi pozicija
     */
    Long projectId;
    /**
     * Naziv pozicije
     */
    String name;
    /**
     * Boolean da li je pozicija spremna za montazu
     */
    boolean redyToMount;
    /**
     * Boolean vrednost da li je pozicija montirana
     */
    boolean mounted;

    /**
     * Prazan konstruktor
     */
    public PositionDTO() {
    }

    /**
     * Vraca id pozicije
     * @return id kao Long
     */

    public Long getId() {
        return id;
    }

    /**
     * Postavlja id za poziciju
     * @param id nova vrednost id-a kao Long
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Vracca id projekta pozicije
     * @return id projekata kao Long
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * Postavlja id projekta pozicie
     * @param projectId id projekta kao Long
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    /**
     * Vraca da li je pozicija spremna za montazu
     * @return da li je pozicija spremna za montazu kao boolean
     */
    public boolean isRedyToMount() {
        return redyToMount;
    }

    /**
     * Postavlja da li je pozicija spremna za montazu
     * @param redyToMount da li je pozicija spremna za montazu kao boolean
     */
    public void setRedyToMount(boolean redyToMount) {
        this.redyToMount = redyToMount;
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
     * Vraca naziv pozicije
     * @return naziv pozicije kao String
     */
    public String getName() {
        return name;
    }

    /**
     * Postavlja naziv pozicije
     * @param name naziv pozicije kao String
     */
    public void setName(String name) {
        this.name = name;
    }
}
