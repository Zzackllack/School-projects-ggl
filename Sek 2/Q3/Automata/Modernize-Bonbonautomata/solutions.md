# Lösungen: Bonbonautomat modernisieren & Alphabet-Aufgaben

## 1) Moderner Bonbonautomat als Mealy-Automat

**Beschreibung.** Preis: 20 Cent. Münzen: 10 ¢, 20 ¢. Auswahl: Hebel **R** (süß) bzw. **L** (sauer).
Wir modellieren die Guthabenstände als Zustände:

- q₀: 0 ¢
- q₁₀: 10 ¢
- q₂₀: 20 ¢ (kaufbereit)

**Eingabealphabet (Σ):** {`10`, `20`, `L`, `R`}  
**Ausgabealphabet (Ω):** {`Ø` (kein Auswurf), `SÜSS`, `SAUER`}  
**Startzustand:** q₀

**Übergangstabelle (Mealy: Ausgabe auf der Transition)**

| Zustand | Eingabe `10`        | Eingabe `20`        | Eingabe `L`                 | Eingabe `R`                 |
|:-------:|:--------------------|:--------------------|:----------------------------|:----------------------------|
| **q₀**  | q₁₀ / Ø             | q₂₀ / Ø             | q₀ / Ø                      | q₀ / Ø                      |
| **q₁₀** | q₂₀ / Ø             | q₂₀ / Ø             | q₁₀ / Ø                     | q₁₀ / Ø                     |
| **q₂₀** | q₂₀ / Ø *(Mehrgeld ignoriert)* | q₂₀ / Ø *(Mehrgeld ignoriert)* | q₀ / **SAUER**              | q₀ / **SÜSS**               |

**Bemerkungen.**

- Der Automat gibt erst beim Hebelzug aus (Mealy-Ausgabe), nicht schon beim Münzeinwurf.
- Überzahlungen (Münzeinwurf in q₂₀) werden ignoriert; alternativ wäre auch „Rückgeld“ modellierbar, wurde hier aber weggelassen, da nicht gefordert.

**b) Überführungsgraph (Beschreibung).**

- Knoten: q₀, q₁₀, q₂₀.
- Kanten sind mit „Eingabe/Ausgabe“ beschriftet:
  - q₀ —`10/Ø`→ q₁₀; q₀ —`20/Ø`→ q₂₀; q₀ —`L/Ø`→ q₀; q₀ —`R/Ø`→ q₀
  - q₁₀ —`10/Ø`→ q₂₀; q₁₀ —`20/Ø`→ q₂₀; q₁₀ —`L/Ø`→ q₁₀; q₁₀ —`R/Ø`→ q₁₀
  - q₂₀ —`L/SAUER`→ q₀; q₂₀ —`R/SÜSS`→ q₀; q₂₀ —`10/Ø`→ q₂₀; q₂₀ —`20/Ø`→ q₂₀

---

## 2) Gültige Alphabete? Begründung

**Definition:** Ein Alphabet ist eine **endliche, nichtleere** Menge von Symbolen. Die Symbole sind **atomar** (ihre Schreibweise ist unerheblich).

- **a) \(\mathbb{N}_{ung} = \{1,3,5,7,\dots\}\)** → **Ungültig.** Unendlich; Alphabete müssen endlich sein.
- **b) \({\emptyset}\)** → **Gültig.** Das ist ein **einzelnes** Symbol, dessen Name „∅“ ist. Symbole dürfen beliebig benannt sein; es ist **nicht** die leere Menge als Alphabet, sondern eine Menge **mit einem Symbol**.
- **c) \(\{1,3,A,B,\pm\}\)** → **Gültig.** Endliche Menge von fünf Symbolen; Mischungen aus Ziffern/Buchstaben/Zeichen sind erlaubt.
- **d) \(\{\pi, e, -1\}\)** → **Gültig.** Auch „−1“ kann als **atomarer** Symbolname aufgefasst werden; die Schreibweise spielt keine Rolle, nur die Endlichkeit.

---

## 3) Passende Alphabete zu den Symbolfolgen

(Jeweils ein mögliches, möglichst **kleines** Alphabet, das die gegebenen Zeichen enthält.)

- **a)** „a,b,c“ → \(\Sigma = \{a, b, c\}\) *(die Kommata dienen hier nur der Aufzählung)*
- **b)** „AabBabB“ → \(\Sigma = \{A, a, b, B\}\) *(Groß-/Kleinschreibung unterscheidet Symbole)*
- **c)** „aaaaa“ → \(\Sigma = \{a\}\)
- **d)** „(a+b)*2“ → \(\Sigma = \{(, ), a, +, b, *, 2\}\) *(als reine Zeichenfolge interpretiert)*
- **e)** „010001101“ → \(\Sigma = \{0, 1\}\)
- **f)** „I, II, III, IV, V, VI, VII, VIII, IX, X“ → \(\Sigma = \{I, V, X\}\) *(römische Zahlzeichen; Trennzeichen sind nicht Teil der Folge)*
- **g)** „1024“ → \(\Sigma = \{0, 1, 2, 4\}\)