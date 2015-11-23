/*
 * Copyright (c) 2015 Falko Schumann
 * Released under the terms of the MIT License.
 */

package de.muspellheim.datenverteiler.betriebsmeldungen;

import de.bsvrz.dav.daf.main.ClientDavInterface;
import de.bsvrz.sys.funclib.application.StandardApplication;
import de.bsvrz.sys.funclib.application.StandardApplicationRunner;
import de.bsvrz.sys.funclib.commandLineArgs.ArgumentList;

/**
 * Testprogramm zum Senden von Beispielmeldungen.
 *
 * @author Falko Schumann
 * @since 1.0
 */
public class Betriebsmeldungssender implements StandardApplication {

    public static void main(String args[]) {
        StandardApplicationRunner.run(new Betriebsmeldungssender(), args);
    }

    @Override
    public void parseArguments(ArgumentList argumentList) throws Exception {
        // tut nix
    }

    @Override
    public void initialize(ClientDavInterface connection) throws Exception {
        Betriebsmeldungsverwaltung bmv = new BetriebsmeldungsverwaltungImpl(Betriebsmeldung.class, connection.getClientDavParameters());

        Betriebsmeldung fachmeldung = BetriebsmeldungFabrik.fach().
                referenz(connection.getLocalConfigurationAuthority()).
                text("Lorem ipsum.").
                erzeuge();
        bmv.sende(fachmeldung);

        Betriebsmeldung systemmeldung = BetriebsmeldungFabrik.system().
                aenderungsmeldung().
                referenz(connection.getLocalApplicationObject()).
                text("Lorem ipsum.").
                erzeuge();
        bmv.sende(systemmeldung);

        System.exit(0);
    }

}
