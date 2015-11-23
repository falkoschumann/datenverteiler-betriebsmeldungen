/*
 * Copyright (c) 2015 Falko Schumann
 * Released under the terms of the MIT License.
 */

package de.muspellheim.datenverteiler.betriebsmeldungen;

import de.bsvrz.dav.daf.main.config.SystemObject;

import java.util.Objects;

/**
 * Die Urlasserinformation einer Betriebsmeldung.
 *
 * @author Falko Schumann
 * @since 1.0
 */
public class Urlasser implements Cloneable {

    public static final Urlasser NULL = new Urlasser();

    private SystemObject benutzer;
    private String ursache;
    private String veranlasser;

    public SystemObject getBenutzer() {
        return benutzer;
    }

    public void setBenutzer(SystemObject benutzer) {
        this.benutzer = benutzer;
    }

    public String getUrsache() {
        return ursache;
    }

    public void setUrsache(String ursache) {
        this.ursache = ursache;
    }

    public String getVeranlasser() {
        return veranlasser;
    }

    public void setVeranlasser(String veranlasser) {
        this.veranlasser = veranlasser;
    }

    public boolean isNull() {
        return Objects.isNull(benutzer) && Objects.isNull(ursache) && Objects.isNull(veranlasser);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Urlasser urlasser = (Urlasser) o;
        return Objects.equals(benutzer, urlasser.benutzer) &&
                Objects.equals(ursache, urlasser.ursache) &&
                Objects.equals(veranlasser, urlasser.veranlasser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(benutzer, ursache, veranlasser);
    }

    @Override
    public String toString() {
        return "Urlasser{" +
                "benutzer=" + benutzer +
                ", ursache='" + ursache + '\'' +
                ", veranlasser='" + veranlasser + '\'' +
                '}';
    }

    @Override
    public Urlasser clone() {
        try {
            return (Urlasser) super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new IllegalStateException("Ein Urlasser muss klonbar sein.", ex);
        }
    }

}
