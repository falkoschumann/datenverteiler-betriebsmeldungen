package de.muspellheim.datenverteiler.betriebsmeldungen;

import de.bsvrz.dav.daf.main.config.SystemObject;

import java.util.Objects;

public class Urlasser implements Cloneable {

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
        final StringBuilder sb = new StringBuilder("Urlasser{");
        sb.append("benutzer=").append(benutzer);
        sb.append(", ursache='").append(ursache).append('\'');
        sb.append(", veranlasser='").append(veranlasser).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Urlasser clone() {
        try {
            return (Urlasser) super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new IllegalStateException(ex);
        }
    }

}
