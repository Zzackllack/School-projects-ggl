# Endliche Automaten und formale Sprachen – Scanner/Parser

Implementieren Sie einen Scanner und einen Parser für die lal‑Sprache. Der Scanner soll eine Tokenliste generieren, die vom Parser genutzt werden kann.

## Aufgabe 1: Token / Scanner — Implementierung

### a) Klasse Token

Implementieren Sie zuerst eine Klasse `Token` mit:

- Attribut `typ : String`
- Attribut `wert : String`
- passendem Konstruktor
- Getter‑Methoden für beide Attribute

### b) Methode `scanne` (gegeben)

Die Methode `scanne` für die Klasse `Scanner` lautet:

```java
public void scanne(){
    char erster, zweiter;
    int pos = 0;
    while (eingabe.charAt(pos) != '#') {
        erster = eingabe.charAt(pos);
        zweiter = eingabe.charAt(pos+1);
        if (erster == 'l' && zweiter == 'a'){
            aktuellesToken = new Token("EGAL", "la");
        }
        else if (erster == 'l' && zweiter == 'e') {
            aktuellesToken = new Token("EGAL", "le");
        }
        else if (erster == 'l' && zweiter == 'u') {
            aktuellesToken = new Token("ENDE", "lu");
        }
        else {
            istFehler = true;
            break;
        }
        pos = pos + 2;
        tokenliste.append(aktuellesToken);
    }
    ausgabe(istFehler);
}

private void ausgabe(boolean pFehler){
    tokenliste.toFirst();
    if (pFehler == true || tokenliste.getContent() == null) {
        System.out.println("Lexikalische Analyse abgebrochen");
    } else {
        System.out.println("Lexikalische erfolgreich");
    }
} // Ende ausgabe
```

Erläutern Sie, was die Methode `scanne` (zusammen mit der privaten Methode `ausgabe`) leistet.

### c) Methode `getTokenliste`

Erläutern Sie, was die Methode `getTokenliste()` leistet. Gegebener Code:

```java
public List<Token> getTokenliste() {
    if (istFehler == false) {
        return tokenliste;
    } else return null;
}
```

### d) Konstruktor für `Scanner`

Ergänzen Sie die Klasse `Scanner` um den folgenden Konstruktor:

```java
public Scanner(String pEingabe, List<Token> pTokenliste) {
    // TODO
    // Lokale Variable vom Datentyp String eingabe wird gebildet aus dem
    // Eingabeargument pEingabe und dem Zeichen '#'
    // Lokale Variable tokenliste vom Datentyp List<Token> wird auf den
    // Eingabeparameter pTokenliste gesetzt.
    // Die Liste von Tokens tokenliste wird auf das erste Element positioniert.
    // Lokale Variable istFehler vom Datentyp boolean wird auf false
    // initialisiert.
    …
}
```

Aufgabenstellung: Implementieren Sie den Konstruktor entsprechend den Kommentaren.

- Setzen Sie `eingabe = pEingabe + "#"`.
- Setzen Sie `tokenliste = pTokenliste` und positionieren Sie die Liste auf das erste Element (falls Methode vorhanden).
- Initialisieren Sie `istFehler = false`.
- Falls nötig, initialisieren Sie verbleibende Felder (`aktuellesToken`, etc.).
- Dokumentieren Sie kurz das Verhalten bei null‑Argumenten (optional).
