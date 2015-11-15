package de.muspellheim.datenverteiler.betriebsmeldungen;

import de.bsvrz.dav.daf.main.config.SystemObject;

public class BetriebsmeldungFabrik {

    /*
    ApplikationsID -> automatisch vergeben
    LaufendeNummer -> automatisch vergeben
    ApplikationsTyp -> automatisch vergeben
    ApplikationsKennung -> automatisch vergeben, bzw. manull initialisieren
    ID -> Sollte dem referenzierten Objekt entsprechen
    MeldungsTyp
    MeldungsTypZusatz -> Default vorhanden: erster Eintrag im Stacktrace
    MeldungsKlasse
    Referenz -> optional
    Status
    MeldungsText
    Urlasser -> Defaultwert vorhanden
        BenutzerReferenz -> Defaultwert: aktueller Benutzer
        Ursache -> Defaultwert: Leerstring
        Veranlasser -> Defaultwert: Leerstring
    */

    private final Betriebsmeldung betriebsmeldung = new Betriebsmeldung();

    public BetriebsmeldungFabrik() {
        id("");
        typzusatz("");
        status(Meldungsstatus.MELDUNG);
    }

    public BetriebsmeldungFabrik id(String id) {
        betriebsmeldung.setId(id);
        return this;
    }

    public BetriebsmeldungFabrik typ(Meldungstyp typ) {
        betriebsmeldung.setTyp(typ);
        return this;
    }

    public BetriebsmeldungFabrik fach() {
        return typ(Meldungstyp.FACH).klasse(Meldungsklasse.INFORMATION);
    }

    public BetriebsmeldungFabrik system() {
        return typ(Meldungstyp.SYSTEM).klasse(Meldungsklasse.WARNUNG);
    }


    public BetriebsmeldungFabrik typzusatz(String typzusatz) {
        betriebsmeldung.setTypzusatz(typzusatz);
        return this;
    }

    public BetriebsmeldungFabrik klasse(Meldungsklasse klasse) {
        betriebsmeldung.setKlasse(klasse);
        return this;
    }

    public BetriebsmeldungFabrik fatal() {
        return klasse(Meldungsklasse.FATAL);
    }

    public BetriebsmeldungFabrik fehler() {
        return klasse(Meldungsklasse.FEHLER);
    }

    public BetriebsmeldungFabrik warnung() {
        return klasse(Meldungsklasse.WARNUNG);
    }

    public BetriebsmeldungFabrik information() {
        return klasse(Meldungsklasse.INFORMATION);
    }

    public BetriebsmeldungFabrik referenz(SystemObject referenz) {
        betriebsmeldung.setReferenz(referenz);
        betriebsmeldung.setId(referenz.getPidOrId());
        return this;
    }

    public BetriebsmeldungFabrik status(Meldungsstatus status) {
        betriebsmeldung.setStatus(status);
        return this;
    }

    public BetriebsmeldungFabrik meldung() {
        return status(Meldungsstatus.MELDUNG);
    }

    public BetriebsmeldungFabrik neueMeldung() {
        return status(Meldungsstatus.NEUE_MELDUNG);
    }

    public BetriebsmeldungFabrik wiederholungsmeldung() {
        return status(Meldungsstatus.WIEDERHOLUNGSMELDUNG);
    }

    public BetriebsmeldungFabrik aenderungsmeldung() {
        return status(Meldungsstatus.AENDERUNGSMELDUNG);
    }

    public BetriebsmeldungFabrik gutmeldung() {
        return status(Meldungsstatus.GUTMELDUNG);
    }

    public BetriebsmeldungFabrik text(String text) {
        betriebsmeldung.setText(text);
        return this;
    }

    public Betriebsmeldung erzeugeBetriebsmeldung() {
        return betriebsmeldung.clone();
    }

}
