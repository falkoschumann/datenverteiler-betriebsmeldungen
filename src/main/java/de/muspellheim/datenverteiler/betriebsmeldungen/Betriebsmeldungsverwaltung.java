/*
 * Copyright (c) 2015 Falko Schumann
 * Released under the terms of the MIT License.
 */

package de.muspellheim.datenverteiler.betriebsmeldungen;

/**
 * Schnittstelle zur Betriebsmeldungsverwaltung.
 *
 * @author Falko Schumann
 * @since 1.0
 */
public interface Betriebsmeldungsverwaltung {

    void sende(Betriebsmeldung betriebsmeldung);

}
