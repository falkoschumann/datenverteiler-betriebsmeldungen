/*
 * Copyright (c) 2015 Falko Schumann
 * Released under the terms of the MIT License.
 */

package de.muspellheim.datenverteiler.betriebsmeldungen;

import de.bsvrz.dav.daf.main.config.SystemObject;
import org.junit.Test;

import static de.muspellheim.datenverteiler.betriebsmeldungen.BetriebsmeldungFabrik.system;
import static org.mockito.Mockito.mock;

public class CodeBeispieleInDokumentationTest {

    @Test
    public void verwendung() {
        Betriebsmeldungsverwaltung bmv = mock(Betriebsmeldungsverwaltung.class);
        SystemObject sm = mock(SystemObject.class);
        bmv.sende(system().referenz(sm).text("Steuermodul kaputt.").erzeuge());
    }


}
