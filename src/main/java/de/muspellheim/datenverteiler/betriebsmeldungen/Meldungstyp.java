package de.muspellheim.datenverteiler.betriebsmeldungen;

public enum Meldungstyp {

    SYSTEM("System"),

    FACH("Fach");

    private String name;

    Meldungstyp(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
