/*
 * Copyright (c) 2015 Falko Schumann
 * Released under the terms of the MIT License.
 */

package de.muspellheim.datenverteiler.betriebsmeldungen;

import de.bsvrz.dav.daf.main.config.SystemObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Mockito.mock;

public class BetriebsmeldungTest {

    @Test
    public void testCloneEqualsHashcode() {
        Betriebsmeldung meldung = new Betriebsmeldung();
        meldung.setApplikationsId(1);
        meldung.setLaufendeNummer(2);
        SystemObject applikationstyp = mock(SystemObject.class, "typ.applikation");
        meldung.setApplikationstyp(applikationstyp);
        meldung.setApplikationskennung("Foo");
        meldung.setId("mq.mq0001");
        meldung.setTyp(Meldungstyp.FACH);
        meldung.setTypzusatz("-");
        meldung.setKlasse(Meldungsklasse.INFORMATION);
        SystemObject mq = mock(SystemObject.class, "typ.messQuerschnitt");
        meldung.setReferenz(mq);
        meldung.setStatus(Meldungsstatus.MELDUNG);
        meldung.setText("");
        SystemObject benutzer = mock(SystemObject.class, "Tester");
        meldung.getUrlasser().setBenutzer(benutzer);
        meldung.getUrlasser().setUrsache("Test");
        meldung.getUrlasser().setVeranlasser("JUnit");

        Betriebsmeldung klon = meldung.clone();
        assertNotSame(klon, meldung);
        assertEquals(klon, meldung);
        assertEquals(klon.hashCode(), meldung.hashCode());
    }

}
