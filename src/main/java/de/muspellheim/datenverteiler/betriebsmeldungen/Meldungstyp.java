/*
 * Copyright (c) 2015 Falko Schumann
 * Released under the terms of the MIT License.
 */

package de.muspellheim.datenverteiler.betriebsmeldungen;

/**
 * Der Typ einer Meldung.
 * <p>
 * Für fachliche, z.&nbsp;B. verkehrliche, Meldungen wird der Typ {@link #FACH}
 * verwendet. Für Systemmeldungen, z.&nbsp;B. fehlende Parameter einer
 * Applikation oder TLS-Kommunikationsprobleme wird der Typ {@link #SYSTEM}
 * verwendet.
 * </p>
 *
 * @author Falko Schumann
 * @since 1.0
 */
public enum Meldungstyp {

    SYSTEM("System"),

    FACH("Fach");

    private String name;

    Meldungstyp(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
