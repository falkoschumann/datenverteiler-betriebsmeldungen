/*
 * Copyright (c) 2015 Falko Schumann
 * Released under the terms of the MIT License.
 */

package de.muspellheim.datenverteiler.betriebsmeldungen;

import de.bsvrz.dav.daf.main.config.SystemObject;

/**
 * Fabrik zur Erzeugung einer Betriebsmeldung mit verketteten Methoden.
 * <p>
 * Die Fabrik verwendet Defaultwerte, um möglichst wenig Angaben manuell machen
 * zu müssen. Details sind bei den jeweiligen Methoden dokumentiert.
 * </p>
 *
 * @author Falko Schumann
 * @since 1.0
 */
public class BetriebsmeldungFabrik {

    /*
    ApplikationsID -> automatisch vergeben
    LaufendeNummer -> automatisch vergeben
    ApplikationsTyp -> automatisch vergeben
    ApplikationsKennung -> automatisch vergeben, bzw. manuell initialisieren
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

    protected BetriebsmeldungFabrik() {
        id("");
        typzusatz("");
        status(Meldungsstatus.MELDUNG);
    }

    /**
     * Erstellt eine fachliche Meldung mit der Klasse <em>Information</em>. Die
     * Betriebsmeldung hat den Status <em>Meldung</em> und den Leerstring für ID
     * und Typzusatz.
     */
    public static BetriebsmeldungFabrik fach() {
        return new BetriebsmeldungFabrik().typ(Meldungstyp.FACH).klasse(Meldungsklasse.INFORMATION);
    }

    /**
     * Erstellt eine Systemmeldung mit der Klasse <em>Warnung</em>. Die
     * Betriebsmeldung hat den Status <em>Meldung</em> und den Leerstring für ID
     * und Typzusatz.
     */
    public static BetriebsmeldungFabrik system() {
        return new BetriebsmeldungFabrik().typ(Meldungstyp.SYSTEM).klasse(Meldungsklasse.WARNUNG);
    }

    public BetriebsmeldungFabrik id(String id) {
        betriebsmeldung.setId(id);
        return this;
    }

    public BetriebsmeldungFabrik typ(Meldungstyp typ) {
        betriebsmeldung.setTyp(typ);
        return this;
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

    /**
     * Legt Referenz und ID der Meldung fest. Als ID der Meldung wird die PID,
     * oder falls nicht vorhanden die ID, des referenzierten Objekts gesetzt.
     */
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

    public Betriebsmeldung erzeuge() {
        return betriebsmeldung.clone();
    }

    @Override
    public String toString() {
        return "BetriebsmeldungFabrik{" +
                "betriebsmeldung=" + betriebsmeldung +
                '}';
    }

}
