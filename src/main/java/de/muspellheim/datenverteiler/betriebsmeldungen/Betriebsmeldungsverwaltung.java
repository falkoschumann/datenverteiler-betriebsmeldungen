package de.muspellheim.datenverteiler.betriebsmeldungen;

public interface Betriebsmeldungsverwaltung {

    // TODO Applikationskennung mit Inkarnationsname initialisieren
    // TODO Erstes Referenzobjekt als ID verwenden oder alle?
    // TODO Umgang mit Meldungstyp: Fach und System?
    // TODO Umgang mit Meldungsstatus: Meldung, Gutmeldung, Neue Meldung, Wiederholungsmeldung, Änderungsmeldung?

    void sende(Betriebsmeldung betriebsmeldung);

}
