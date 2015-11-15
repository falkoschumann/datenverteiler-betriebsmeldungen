package de.muspellheim.datenverteiler.betriebsmeldungen;

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
