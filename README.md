Funktionsbibliothek Betriebsmeldungen [![Build Status](https://travis-ci.org/falkoschumann/datenverteiler-betriebsmeldungen.svg?branch=develop)](https://travis-ci.org/falkoschumann/datenverteiler-betriebsmeldungen)
=====================================

Die Funktionsbibliothek Betriebsmeldungen soll die Nutzung der
Betriebsmeldungsverwaltung der BSVRZ-Software vereinfachen.

Die Projektseite befinden sich unter
https://github.com/falkoschumann/datenverteiler-betriebsmeldungen/.

Die Projektdokumentation befindet sich unter
http://falkoschumann.github.io/datenverteiler-betriebsmeldungen/


Enthaltene Funktionen
---------------------

  - Erstellen von Betriebsmeldungen als POJOs (Plain old Java Objects) direkt
    oder mit Hilfe einer Fabrik.
  - Senden von Betriebsmeldungen über eine Schnittstelle anstelle des Singletons
    der API der Datenverteiler-Applikationsfunktionen.


Geplante Funktionen
-------------------

  - Empfang von Betriebsmeldungen.
  - Lesen von Betriebsmeldungen aus dem Archiv.
  - Das Verwalten von Betriebsmeldungen.
  - Das Erstellen von Protokollen für Betriebsmeldungen.


Installation
------------

Die ZIP-Datei muss im Distributionspaketeordner eines BSVRZ-Projekts entpackt
werden. Applikationen, die die Funktionsbibliothek nutzen wollen, müssen um das
enthaltene Runtime-JAR im Classpath ergänzt werden.


---

Dieses Projekt ist nicht Teil des NERZ e.V. Die offizielle Software sowie
weitere Informationen zur bundeseinheitlichen Software für
Verkehrsrechnerzentralen (BSVRZ) finden Sie unter http://www.nerz-ev.de.
