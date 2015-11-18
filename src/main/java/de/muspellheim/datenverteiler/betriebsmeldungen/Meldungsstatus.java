/*
 * Copyright (c) 2015 Falko Schumann
 * Released under the terms of the MIT License.
 */

package de.muspellheim.datenverteiler.betriebsmeldungen;

/**
 * Der Status einer Meldung.
 * <p>
 * Mit den Status {@link #NEUE_MELDUNG}, {@link #WIEDERHOLUNGSMELDUNG},
 * {@link #AENDERUNGSMELDUNG} und {@link #GUTMELDUNG} wird ein Prozess für
 * Betriebsmeldungen definiert. Für Meldungen, die nicht einem Prozess
 * unterliegen, kann der allgemeine Status {@link #MELDUNG} verwendet werden.
 * </p>
 *
 * @author Falko Schumann
 * @since 1.0
 */
public enum Meldungsstatus {

    MELDUNG("Meldung"),

    GUTMELDUNG("Gutmeldung"),

    NEUE_MELDUNG("Neue Meldung"),

    WIEDERHOLUNGSMELDUNG("Wiederholungsmeldung"),

    AENDERUNGSMELDUNG("Änderungsmeldung");

    private String name;

    Meldungsstatus(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
