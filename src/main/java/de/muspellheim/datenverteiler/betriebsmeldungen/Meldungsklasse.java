/*
 * Copyright (c) 2015 Falko Schumann
 * Released under the terms of the MIT License.
 */

package de.muspellheim.datenverteiler.betriebsmeldungen;

/**
 * Die Klasse einer Meldung.
 *
 * @author Falko Schumann
 * @since 1.0
 */
public enum Meldungsklasse {

    FATAL("Fatal"),

    FEHLER("Fehler"),

    WARNUNG("Warnung"),

    INFORMATION("Information");

    private String name;

    Meldungsklasse(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
