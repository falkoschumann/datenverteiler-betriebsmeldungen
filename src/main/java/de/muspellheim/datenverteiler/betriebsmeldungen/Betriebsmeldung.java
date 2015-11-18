/*
 * Copyright (c) 2015 Falko Schumann
 * Released under the terms of the MIT License.
 */

package de.muspellheim.datenverteiler.betriebsmeldungen;

import de.bsvrz.dav.daf.main.config.SystemObject;

import java.util.Objects;

/**
 * Eine Betriebsmeldung.
 *
 * @author Falko Schumann
 * @since 1.0
 */
public class Betriebsmeldung implements Cloneable {

    private long applikationsId;
    private long laufendeNummer;
    private SystemObject applikationstyp;
    private String applikationskennung;
    private String id;
    private Meldungstyp typ;
    private String typzusatz;
    private Meldungsklasse klasse;
    private SystemObject referenz;
    private Meldungsstatus status;
    private String text;
    private Urlasser urlasser = new Urlasser();

    public long getApplikationsId() {
        return applikationsId;
    }

    public void setApplikationsId(long applikationsId) {
        this.applikationsId = applikationsId;
    }

    public long getLaufendeNummer() {
        return laufendeNummer;
    }

    public void setLaufendeNummer(long laufendeNummer) {
        this.laufendeNummer = laufendeNummer;
    }

    public SystemObject getApplikationstyp() {
        return applikationstyp;
    }

    public void setApplikationstyp(SystemObject applikationstyp) {
        this.applikationstyp = applikationstyp;
    }

    public String getApplikationskennung() {
        return applikationskennung;
    }

    public void setApplikationskennung(String applikationskennung) {
        this.applikationskennung = applikationskennung;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Meldungstyp getTyp() {
        return typ;
    }

    public void setTyp(Meldungstyp typ) {
        this.typ = typ;
    }

    public String getTypzusatz() {
        return typzusatz;
    }

    public void setTypzusatz(String typzusatz) {
        this.typzusatz = typzusatz;
    }

    public Meldungsklasse getKlasse() {
        return klasse;
    }

    public void setKlasse(Meldungsklasse klasse) {
        this.klasse = klasse;
    }

    public SystemObject getReferenz() {
        return referenz;
    }

    public void setReferenz(SystemObject referenz) {
        this.referenz = referenz;
    }

    public Meldungsstatus getStatus() {
        return status;
    }

    public void setStatus(Meldungsstatus status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Urlasser getUrlasser() {
        return urlasser;
    }

    public void setUrlasser(Urlasser urlasser) {
        this.urlasser = urlasser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Betriebsmeldung that = (Betriebsmeldung) o;
        return Objects.equals(applikationsId, that.applikationsId) &&
                Objects.equals(laufendeNummer, that.laufendeNummer) &&
                Objects.equals(applikationstyp, that.applikationstyp) &&
                Objects.equals(applikationskennung, that.applikationskennung) &&
                Objects.equals(id, that.id) &&
                typ == that.typ &&
                Objects.equals(typzusatz, that.typzusatz) &&
                klasse == that.klasse &&
                Objects.equals(referenz, that.referenz) &&
                status == that.status &&
                Objects.equals(text, that.text) &&
                Objects.equals(urlasser, that.urlasser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applikationsId, laufendeNummer, applikationstyp, applikationskennung, id, typ, typzusatz,
                klasse, referenz, status, text, urlasser);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Betriebsmeldung{");
        sb.append("applikationsId=").append(applikationsId);
        sb.append(", laufendeNummer=").append(laufendeNummer);
        sb.append(", applikationsTyp=").append(applikationstyp);
        sb.append(", applikationsKennung='").append(applikationskennung).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append(", typ=").append(typ);
        sb.append(", typzusatz='").append(typzusatz).append('\'');
        sb.append(", klasse=").append(klasse);
        sb.append(", referenz=").append(referenz);
        sb.append(", status=").append(status);
        sb.append(", text='").append(text).append('\'');
        sb.append(", urlasser=").append(urlasser);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Betriebsmeldung clone() {
        try {
            return (Betriebsmeldung) super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new IllegalStateException("Eine Betriebsmeldung muss klonbar sein.", ex);
        }
    }

}
