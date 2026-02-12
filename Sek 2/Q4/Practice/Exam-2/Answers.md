# Antworten/Versuch

## Aufgabe 1

Vorteile eines Datenbanksystems sind unter anderem die Möglichkeit der zentralen Benutzerverwaltung, 

## Aufgabe 2

a)

- Entität: Eine Entität ist ein eindeutig identifizierbares Objekt oder Konzept in der realen Welt, das in einem Datenbanksystem dargestellt wird. Im ER-Modell sind Entitäten durch Rechtecke dargestellt. In diesem Modell sind "Lehrer" und "Fach" Beispiele für Entitäten.
- Attribut: Ein Attribut ist eine Eigenschaft oder ein Merkmal einer Entität, das Informationen über die Entität speichert. Im ER-Modell sind Attribute durch Ellipsen dargestellt. Zum Beispiel hat die Entität "Lehrer" die Attribute "Name" und "Fächer".
- Beziehung: Eine Beziehung beschreibt die Verbindung oder Assoziation zwischen zwei oder mehr Entitäten. Im ER-Modell sind Beziehungen durch Rauten dargestellt. In diesem Modell gibt es eine Beziehung zwischen "Lehrer" und "Fach", die angibt, welche Lehrer welche Fächer unterrichten. Es gibt n zu m Beziehungen, 1 zu n Beziehungen und 1 zu 1 Beziehungen.

b)

Schüler (stufe, name, <u>schülernummer</u>, ↑kürzel) <br>
Kurs (fach, art, bezeichnung, <u>kursnummer</u>, ↑kürzel) <br>
Lehrer (name, fächer, <u>kürzel</u>) <br>
belegt (<u>↑kursnummer</u>, <u>↑schülernummer</u>, noten)

c)

- Jede Entität wird zu einer Tabelle. Die Attribute der Entität werden zu Spalten in der Tabelle.
- Primärschlüssel: Jede Tabelle erhält einen Primärschlüssel, der die eindeutige Identifikation der Datensätze ermöglicht.
- Beziehungen: Für n zu m Beziehungen wird eine separate Tabelle erstellt, die die Primärschlüssel der beteiligten Entitäten als Fremdschlüssel enthält. Für 1 zu n Beziehungen wird der Primärschlüssel der "1"-Seite als Fremdschlüssel in der "n"-Seite verwendet. Für 1 zu 1 Beziehungen kann der Primärschlüssel einer Entität als Fremdschlüssel in der anderen Entität verwendet werden.

d)

Falls es Lehrer gibt, die die gleiche Namenskombinationen haben und somit über ein gleiches Kürzel verfügen, ist die Wahl des Kürzels als Primärschlüssel problematisch, da es zu Duplikaten kommen könnte. In diesem Fall wäre es besser, eine eindeutige Lehrer-ID als Primärschlüssel zu verwenden, um sicherzustellen, dass jeder Lehrer eindeutig identifiziert werden kann. (Eindeutigkeit verletzt)

## Aufgabe 3

a)

```sql
SELECT COUNT(*) FROM LehrkraftGGL;
```

b)

```sql
SELECT COUNT(*) FROM LehrkraftGGL WHERE Funktion = 'Beamter';
```

c)

```sql
SELECT PersID AS LehrkraftID, Vorname FROM LehrkraftGGL WHERE Name OR Vorname LIKE 'Mueller' OR 'Müller';
```
