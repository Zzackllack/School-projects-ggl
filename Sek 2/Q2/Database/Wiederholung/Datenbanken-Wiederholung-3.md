# DB-Wiederholung Arbeitsauftrag 3 : Seite 1

## Aufgabe 1:

a)

```sql
SELECT PersNr, Name, Vorname, Beruf, Gehalt, AbtNr, ProjektNr FROM Mitarbeiter WHERE AbtNr=20 ORDER BY Name
```

b)

```sql
SELECT AVG(Gehalt) FROM Mitarbeiter
```

c)

```sql
SELECT AbtNr, MAX(Gehalt) AS Hoechstgehalt FROM Mitarbeiter GROUP BY AbtNr;
```

d)

```sql
SELECT p.ProjektName, m.Name, m.PersNr FROM Projekt p JOIN Mitarbeiter m ON p.ProjektNr = m.ProjektNr;
```

e)

```sql
SELECT fx.PersNr, fx.Name FROM Mitarbeiter fx UNION SELECT fy.PersNr, fy.Name FROM Mitarbeiter fy;
```

## Aufgabe 10:

a)

### Erste Normalform (1NF)

- **Erklärung**

    Eine Relation befindet sich in der ersten Normalform, wenn alle Attribute atomare Wertebereiche haben, d. h. sie lassen sich nicht weiter in sinnvollere Einzelwerte zerlegen. Wiederholende Gruppen oder zusammengesetzte Felder sind nicht erlaubt.

- **Beispiel**

    In der Tabelle **Leser** stand ursprünglich ein Attribut `Adresse` mit Werten wie „Schleistraße 10, 12345 Beispielstadt“. Um 1NF zu erfüllen, muss man `Adresse` in `Straße`, `Hausnummer`, `PLZ` und `Ort` aufteilen; ebenso `Name` in `Vorname` und `Nachname`.

### Zweite Normalform (2NF)

- **Erklärung**

    Eine Relation ist in der zweiten Normalform, wenn

    1. sie in 1NF ist und
    2. jedes Nichtschlüsselattribut **voll** funktional vom **gesamten** (ggf. zusammengesetzten) Primärschlüssel abhängt – partielle Abhängigkeiten von nur einem Teil des Schlüssels sind verboten.
- **Beispiel**

    Tabelle **Mahnung** mit zusammengesetztem Primärschlüssel `(Datum, Leser-ID)` und dem Attribut `Name`:

    ```text
    Datum      Leser-ID   Name    Betrag
    02.02.2017 345        Müller  3,60
    ```

    Hier hängt `Name` nur von `Leser-ID` ab, nicht vom Gesamt-Schlüssel. Das verletzt 2NF. Durch Entfernen von `Name` (Auslagerung in `Leser`) wird die Teilabhängigkeit beseitigt.

b)
| Vater    | Mutter | Kinder |
| Johann   | Martha | Else |
| Johann   | Maria  | Lucia |
| Johann   | Maria  | Theo |
| Johann   | Maria  | Josef |
| Heinz   | Martha | Cleo |

c)
Da die erste Normalform besagt, dass alle Attribute atomar sein müssen, habe ich die Spalte Kinder atomisiert, indem ich statt mehrere Kinder in einer Zelle jede Kind-Paarung in eine eigene Zeile geschrieben habe. Dadurch wird die Tabelle in die erste Normalform überführt.