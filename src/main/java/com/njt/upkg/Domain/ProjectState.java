package com.njt.upkg.Domain;


/**
 * Enumeracija stanja u kojima projekat moze da se nadje
 *
 * @author moryf
 */

public enum ProjectState {
    /**
     * Projekat je u fazi projetktovanja
     */
    Projektovanje,
    /**
     * Projekat je u fazi izrade
     */
    Izrada,
    /**
     * Projekat je u fazi montiranja
     */
    Montaza,
    /**
     * Projekat je zavrsen
     */
    Gotov
}
