# DB-Wiederholung - Arbeitsauftrag 1 : Seite 1

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
