package de.muspellheim.datenverteiler.betriebsmeldungen;

import de.bsvrz.sys.funclib.operatingMessage.*;

public class BetriebsmeldungsverwaltungImpl implements Betriebsmeldungsverwaltung {

    private final MessageSender sender;

    public BetriebsmeldungsverwaltungImpl(String applikationskennung) {
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
