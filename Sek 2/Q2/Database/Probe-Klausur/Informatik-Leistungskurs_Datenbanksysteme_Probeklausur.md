# Informatik-Leistungskurs Datenbanksysteme

## Aufgabe 1:

- Skalierbarkeit, Datenbanken können dynamisch mit größerer Anzahl an Datennmängen/Nutzern wachsen.
- Zugriffkontrolle, mit Datenbanken kann der Zugriff beschränkt werden, sodass nur gewisse Personen Daten ändern und/oder einsehen können.
- Eindeutigkeit, Datenbanken stellen sicher, dass Datensätze eindeutig sind und keine Duplikate entstehen.

## Aufgabe 2:

*a)*

- Entität:
    - Ist ein eindeutiges Objekt oder Konzept, das in der Datenbank modelliert wird. In diesem Beispiel wären "Schüler", "Kurs" und "Lehrer" Entitäten.
- Attribut:
    - Ein Attribut ist eine Eigenschaft oder ein Merkmal das einer Entität zugeordnet wird. In diesem Beispiel wären das für die Entität "Schüler" die Attribute "stufe", "name" und "schülernummer", welcher als Primärschlüssel fungiert.
- Beziehung:
    - Eine Beziehung beschreibt, wie Entitäten miteinander in Verbindung stehen. In diesem Beispiel gibt es die Beziehung 1 Leher "ist Tutor" zu n Schülern, was bedeutet, dass ein Lehrer mehrere Schüler betreuen kann, aber jeder Schüler nur von einem Lehrer betreut wird.

*b)*

Schüler (stufe, name, <u>schülernummer</u>, ↑kürzel)
Kurs (fach, art, bezeichnung, <u>kursnummer</u>, ↑kürzel)
Lehrer (name, fächer, <u>kürzel</u>)
belegt (<u>↑kursnummer</u>, <u>↑schülernummer</u>, noten)

*c)*

Ich habe die erste Regel angewandt, die besagt das jede Entität in eine Tabelle überführt wird. Dann hab eich die zweite Regel angewandt, die besagt, dass jede n:m Beziehung in eine eigene Tabelle überführt wird. Die dritte Regel besagt, dass jede 1:n Beziehung in der Tabelle der n-Seite den Primärschlüssel der Tabelle der 1 Seite als Fremdschlüssel abbildet.

*d)*

Die Wahl des Primärschlüssels der Tabelle "Lehrer" ist nicht sinvoll, da eine Schule mehrere Lehrer haben kann, die den gleichen Namen haben und somit das gleiche Kürzel bilden würden. Daher sollte der Primärschlüssel der Tabelle "Lehrer" nicht das Attribut "kürzel" sein, sondern ein eindeutiges Attribut wie z.B. eine Lehrer-ID.

## Aufgabe 3:

*a)*

```sql
SELECT COUNT(*) AS Anzahl_Lehrer FROM LehrkraftGGL
```

*b)*

```sql
SELECT PersID, Name FROM LehrkraftGGL WHERE Funktion = 'Beamter'
```

*c)*

```sql
SELECT PersID AS LehrkraftID, Vorname FROM LehrkraftGGL WHERE Name = 'Müller'
```

*d)*

```sql
SELECT Name, Unterrichsstunden FROM LehrkraftGGL WHERE Unterrichtsstunden BETWEEN 20 AND 26
```

*e)*

```sql
SELECT PersID, Name FROM LehrkraftGGL WHERE Name Like '%R'
```

*f)*

```sql
SELECT Vorname, Name FROM LehrkraftGGL WHERE Name LIKE 'H%' OR Name Like 'I%'
```

*g)*

```sql
SELECT l.Name, l.Vorname FROM LehrkraftGGL l, Fach f WHERE l.FachID = 2 ORDER BY l.Name ASC
```

*Korrektur:*

```sql
SELECT l.Name, l.Vorname FROM LehrkraftGGL l JOIN unterrichtet u ON l.PersID = u.PersID WHERE u.FachID = 2 ORDER BY l.Name;
```

*h)*

```sql
SELECT AVG(Unterrichtsstunden) AS DurchschnittsUnterrichtsstunden FROM LehrkraftGGL
```

*i)*

```sql
SELECT MAX(Stufe), Fachname FROM Fach
```

*Korrektur:*

```sql
SELECT MAX(Stufe) AS Max_Stufe, Fachname FROM Fach GROUP BY Fachname
```

*j)*

```sql
SELECT PersID, Name FROM LehrkraftGGL UNION SELECT PersID, Name FROM LehrkraftLILI
```

## Aufgabe 4:

*a)*

- Die erste Normalform (1NF) besagt, dass alle Attribute atomar sein müssen.
- Die zweite Normalform verlangt, dass bei zusammengesetzten Primärschlüsseln alle Attribute vom Gesamtschlüssel abhängen. Anders gesagt, ein Datenbankschema ist in der zweiten Normalform, wenn es in der ersten Normalform (1NF) ist und zusätzlich jedes Nichtschlüsselattribut vom Primärschlüssel voll funktional abhängig ist und nicht bereits von einem Teil der Schlüsselattribute.
- Ein Datenbankschema ist in der dritten Normalform, wenn es in der 2NF ist und es zusätzlich kein Nichtschlüsselattribut gibt, das transitiv abhängig von einem Schlüsselattribut ist. Es darf also keine funktionalen Abhängigkeiten zwischen Nichtschlüsselattributen geben.

*b)*

| Vater | Mutter | Kinder |
|-------|--------|--------|
| Johann | Martha | Else |
| Johann | Martha | Lucia |
| Johann | Maria | Theo |
| Johann | Maria | Josef |
| Heinz | Martha | Cleo |

*c)*

- Da die erste Normalform (1NF) verlangt, dass alle Attribute atomar sind, müssen wir die Tabelle so umgestalten, dass das Attribut "Kinder" nur einen Wert enthält.

## Aufgabe 5:

*a)*

Kunde (<u>KundenNr</u>, KundenName, KundenVorname, KundenGebDatum)
Video (<u>VideoNr</u>, VideoArt, VideoRegisseur)
Ausleihe (<u>↑VideoNr</u>, <u>↑KundenNr</u>, <u>AusleiheDatum</u>, RückgabeDatum)

*b)*

- Da die zweite Normalform (2NF) verlangt, dass alle Nichtschlüsselattribute voll funktional abhängig vom Primärschlüssel sind, müssen wir die Tabelle "Ausleihe" so umgestalten, dass sie nur die Attribute enthält, die direkt von den Primärschlüsseln abhängen.

## Aufgabe 6:

*a)*

ΠName(σAutor='Thomas Mann' ∧ Buch.VID=Verlag.VID(Buch × Verlag))

*b)*

- Das Kreuzprodukt (auch kartesisches Produkt genannt) ist eine Operation, die zwei Relationen (Tabellen) miteinander verknüpft. Dabei wird jede Zeile der ersten Relation mit jeder Zeile der zweiten Relation kombiniert. Das Ergebnis ist eine neue Relation, die alle möglichen Kombinationen von Zeilen aus beiden Ausgangsrelationen enthält.
- 1000 Datensätze in der Tabelle "Buch" und 5 Datensätze in der Tabelle "Verlag" ergeben 5000 Schritte zur Berechnug des Kreuzprodukts.

*c)*

ΠName(σ(Autor='Thomas Mann') (σ(Buch.VID=Verlag.VID) (Buch) × Verlag))

*Korrektur:*

π Name (σ Buch.VID=Verlag.VID (σ Autor='Thomas Mann'(Buch) × Verlag))

*d)*

- Ich habe die Optimierung angewandt, indem ich die Selektion (σ) vor dem Kreuzprodukt (×) durchgeführt habe. Dadurch wird die Anzahl der Datensätze, die im Kreuzprodukt verarbeitet werden müssen, reduziert, was die Effizienz der Abfrage verbessert.

## Aufgabe 7:

*a)*

- JDBC (Java Database Connectivity) ist eine API, die es ermöglicht, auf relationale Datenbanken in Java zuzugreifen. Sie bietet eine standardisierte Schnittstelle für den Zugriff auf Datenbanken und ermöglicht es Entwicklern, SQL-Abfragen auszuführen und Ergebnisse zu verarbeiten.

*b) - e)*

```java
import java.sql.*;

public class  DatabaseConnectionExample{
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:derby:C:\\datenbanken\\derby";
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();

        String sql_create = "CREATE TABLE Mitarbeiter (ID INT PRIMARY KEY, Vorname VARCHAR(50), Nachname VARCHAR(50))";
        stmt.executeUpdate(sql_create);

        String sql_insert = "INSERT INTO Mitarbeiter (ID, Vorname, Nachname) VALUES"
            + "(1, 'Max', 'Mustermann'),"
            + "(2, 'Erika', 'Mustermann'),"
        stmt.executeUpdate(sql_insert);

        String sql_select = "SELECT * FROM Mitarbeiter";
        ResultSet rs = stmt.executeQuery(sql_select);
        while (rs.next()) {
            int id = rs.getInt("ID");
            String vorname = rs.getString("Vorname");
            String nachname = rs.getString("Nachname");
            System.out.println("ID: " + id + ", Vorname: " + vorname + ", Nachname: " + nachname);
        }
    }
}
```
