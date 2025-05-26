# DB-Wiederholung - Arbeitsauftrag 1 : Seite 1

## Aufgabe 1.1:

*a) Entwerfen Sie ein vollständiges Entity-Relationship-Modell (ER-Modell). Hinweis: Es ist erlaubt, im ER-Modell verkürzte Namen zu verwenden.*

[ER-Modell-DrawIO](Sek%202/Q2/Database/Wiederholung/Datenbanken-Wiederholung-1/Datenbanken-Wiederholung-1.drawio)

*b) Erstellen Sie anhand des ER-Modells das relationale Datenbankmodell in der Form Tabellenname (Primärschlüssel, Attribute, …).*

Kurs (<u>KursNr</u>, KursName, Anzahl, Webseite, HTMLText) <br>
Standort (<u>Adresse</u>, RaumAnzahl) <br>
Kunde (<u>Vorname</u>, <u>Nachname</u>, Gewicht, Geburtsjahr, Adresse, Körpergröße, Geschlecht) <br>
Teilnahme (<u>↑KursNr</u>, <u>↑Vorname</u>, <u>↑Nachname</u>)

*c) Erläutern Sie Ihre Vorgehensweise aus b).*

Ich habe das ER-Modell in Tabellen umgewandelt, indem ich die Entitäten und deren Attribute in Tabellen umgewandelt habe. Die Primärschlüssel sind unterstrichen, und die Beziehungen zwischen den Entitäten sind durch die Verwendung von Fremdschlüsseln dargestellt. Die Teilnahme-Tabelle enthält die Primärschlüssel der Kurs- und Kunden-Tabellen als Fremdschlüssel, da sie im ER-Modell eine n:m-Beziehung darstellt.

## Aufgabe 1.2: Formulieren Sie folgende Anweisungen in SQL:

*a) Welche Kunden haben einen Nachnamen, der mit K oder L beginnt? Gefragt sind Vorname und Nachname.*

```sql
SELECT Vorname, Nachname
FROM   Kunde
WHERE  Nachname LIKE 'K%' 
   OR  Nachname LIKE 'L%';
```

*b) Wie viele Räume hat der Standort, in dem der Kurs mit der KursNr 66 stattfindet.*

```sql
SELECT RaumAnzahl
FROM   Standort
JOIN   Kurs
  ON   Adresse = StandortAdresse
WHERE  KursNr = 66;
```
