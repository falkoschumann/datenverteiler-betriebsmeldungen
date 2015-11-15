package de.muspellheim.datenverteiler.betriebsmeldungen;

public enum Meldungsklasse {

    FATAL("Fatal"),

    FEHLER("Fehler"),

    WARNUNG("Warnung"),

    INFORMATION("Information");

    private String name;

    Meldungsklasse(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
