/*
 * Copyright (c) 2015 Falko Schumann
 * Released under the terms of the MIT License.
 */

package de.muspellheim.datenverteiler.betriebsmeldungen;

import de.bsvrz.dav.daf.main.ClientDavParameters;
import de.bsvrz.sys.funclib.operatingMessage.*;

import java.util.Objects;

/**
 * Die Defaultimplementierung der Betriebsmeldungsverwaltungsschnittstelle.
 *
 * @author Falko Schumann
 * @since 1.0
 */
public class BetriebsmeldungsverwaltungImpl implements Betriebsmeldungsverwaltung {

    /* TODO MessageSender ersetzen?
     * Der MessageSender sendet keine Meldungen, wenn er nicht initialisiert
     * ist, puffert sie aber auch nicht für ein späteres senden.
     */


    private final MessageSender sender;

    public BetriebsmeldungsverwaltungImpl(String applikationskennung) {
        Objects.requireNonNull(applikationskennung, "applikationskennung");

        sender = MessageSender.getInstance();
        sender.setApplicationLabel(applikationskennung);
    }

    public BetriebsmeldungsverwaltungImpl(Class<?> mainKlasse, ClientDavParameters parameter) {
        Objects.requireNonNull(mainKlasse, "mainKlasse");

        String applikationskennung = mainKlasse.getSimpleName();
        if (parameter != null && !parameter.getIncarnationName().isEmpty())
            applikationskennung += ": " + parameter.getIncarnationName();
        sender = MessageSender.getInstance();
        sender.setApplicationLabel(applikationskennung);
    }

    public void sende(Betriebsmeldung betriebsmeldung) {
        sender.sendMessage(
                betriebsmeldung.getId(),
                type(betriebsmeldung.getTyp()),
                betriebsmeldung.getTypzusatz(),
                grade(betriebsmeldung.getKlasse()),
                betriebsmeldung.getReferenz(),
                state(betriebsmeldung.getStatus()),
                causer(betriebsmeldung.getUrlasser()),
                betriebsmeldung.getText()
        );
    }

    private MessageType type(Meldungstyp typ) {
        switch (typ) {
            case FACH:
                return MessageType.APPLICATION_DOMAIN;
            case SYSTEM:
                return MessageType.SYSTEM_DOMAIN;
            default:
                throw new IllegalStateException("unreachable code: unbekannter Meldungstyp: " + typ);
        }
    }

    private MessageGrade grade(Meldungsklasse klasse) {
        switch (klasse) {
            case FATAL:
                return MessageGrade.FATAL;
            case FEHLER:
                return MessageGrade.ERROR;
            case WARNUNG:
                return MessageGrade.WARNING;
            case INFORMATION:
                return MessageGrade.INFORMATION;
            default:
                throw new IllegalStateException("unreachable code: unbekannte Meldungsklasse: " + klasse);
        }
    }

    private MessageState state(Meldungsstatus status) {
        switch (status) {
            case MELDUNG:
                return MessageState.MESSAGE;
            case NEUE_MELDUNG:
                return MessageState.NEW_MESSAGE;
            case WIEDERHOLUNGSMELDUNG:
                return MessageState.REPEAT_MESSAGE;
            case AENDERUNGSMELDUNG:
                return MessageState.CHANGE_MESSAGE;
            case GUTMELDUNG:
                return MessageState.GOOD_MESSAGE;
            default:
                throw new IllegalStateException("unreachable code: unbekannter Meldungsstatus: " + status);
        }
    }

    private MessageCauser causer(Urlasser urlasser) {
        if (urlasser == null) return null;
        return new MessageCauser(urlasser.getBenutzer(), urlasser.getUrsache(), urlasser.getVeranlasser());
    }

}
