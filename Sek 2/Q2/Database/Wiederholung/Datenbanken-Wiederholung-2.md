# DB-Wiederholung - Arbeitsauftrag 2 : Seite 1

### Aufgabe 1:

*Folgende SQL-Anweisung soll mithilfe relationaler Algebra optimiert werden.*

```sql
SELECT Adresse FROM Kurs, Standort WHERE
Kurs.Adresse=Standort.Adresse AND KursNr=150;
``` 

*a) Transformieren Sie die obige Anweisung in einen Ausdruck relationaler Algebra.*

$$
\pi_{\text{Adresse}}\bigl(\sigma_{\text{KursNr}=150}(Kurs \bowtie_{\text{Kurs.Adresse}=\text{Standort.Adresse}} Standort)\bigr)
$$

*b) Erläutern Sie den Begriff des Kreuzprodukts und geben Sie die Anzahl von Schritten zur Berechnung des Ausdrucks an, die sich bei einer Anzahl von 60 Datensätzen in der Tabelle Kurs und 5 Datensätzen in der Tabelle Standort ergeben.*

**Antwort:**
Das Kreuzprodukt (kartesisches Produkt) zweier Relationen R und S erzeugt alle möglichen Kombinationen von Tupeln (r, s) mit r ∈ R und s ∈ S. Bei |R| = 60 und |S| = 5 ergeben sich dabei:

1. **Kreuzprodukt:**  
   - Erzeugung von 60 × 5 = 300 Tupeln.

2. **Selektion (σ):**  
   - Anwendung der Bedingung `Kurs.Adresse = Standort.Adresse` und `KursNr = 150` auf alle 300 Tupel → 300 Vergleichsoperationen.

3. **Projektion (π):**  
   - Extraktion des Attributs `Adresse` aus den selektierten Tupeln → bis zu 300 Extraktionen (im ungünstigsten Fall).

Insgesamt fallen somit etwa **300 Kreuzprodukt-Operationen, 300 Selektions-Checks und 300 Projektions-Schritte an.**

*c) Optimieren Sie den Ausdruck aus a) und geben Sie die damit notwendige Anzahl von Schritten zur Berechnung des Ausdrucks an (unter der Annahme, dass es nur einen Kurs mit der KursNr 150 gibt).*

**Optimierter Ausdruck:**

$$
\pi_{\text{Adresse}}\Bigl(\bigl(\sigma_{\text{KursNr}=150}(Kurs)\bigr)\;\bowtie_{\text{Kurs.Adresse}=\text{Standort.Adresse}}\;Standort\Bigr)
$$

**Anzahl der Arbeitsschritte (bei genau einem Kurs mit KursNr = 150):**

1. **Selektion:** Überprüfen von 60 Tupeln in `Kurs` auf `KursNr = 150` → 60 Vergleiche, Ergebnismenge enthält 1 Tupel.  
2. **Join:** Verknüpfen des einzelnen selektierten Tupels mit allen 5 Tupeln in `Standort`, Prüfung der Join-Bedingung → 5 Vergleiche, Ergebnismenge enthält 1 Tupel.  
3. **Projektion:** Extraktion des Attributs `Adresse` aus dem einzelnen Ergebnis-Tupel → 1 Extraktion.  

Insgesamt also **60 + 5 + 1 = 66** Arbeitsschritte.

*d) Erläutern Sie Ihr Vorgehen bei der Optimierung.*

Zur Optimierung wurde die Selektion `σ_{KursNr=150}` direkt auf die Relation `Kurs` angewendet, bevor der Join mit `Standort` durchgeführt wurde. 
Dadurch reduziert sich die Anzahl der Tupel für den Join von ursprünglich 60×5 = 300 auf 1×5 = 5 Tupel, was die Gesamtkosten für Kreuzprodukt- und Selektionsoperationen erheblich senkt. 
Anschließend erfolgt erst die Projektion auf `Adresse`, wodurch unnötige Datenverarbeitungen vermieden werden.
