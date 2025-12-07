Schreibe als Vorbereitung für meine Informatik Klausur mir einen Notion Lernzettel basierend auf den Informationen der angehangen PDF's und Materialien, orientiere dich stark an den Materialien beim Schreiben des Lernzettels, etc. schreibe in Markdown mit vollständigen, prägnanten, simplen, korrekten Erklärungen für Fachbegriffe und die Themen, der Lernzettel soll ausführlich sein und auf alle, jegliche Aspekte/Themen eingehen, die irgendwie vorkommen.

Folglich findest du die Themen für die Klausur:

- Endliche Automaten: Folien Teil 1: Unterschied Akzeptor/Transduktor, Mealy-Automat (Definition, Graph, Tabellen)
- Folien Teil 2: DEA: Definition (Beispiel Kaffeeautomat, Definition, Graph, Tabelle)
- Folien Teil 3: NEA: Beispiele, Definition, NEA zum DEA…
- Beispielprogramm: SOSCodeprüfer
- Kellerautomaten (Dokument: p.144-148-Kellerautomaten.pdf): Definition, Graph, Tabelle
- Formale Sprachen: Unterschied: Natürliche/Formale Sprachen, Definition (Unterschied): Syntax/Semantik, Definition Grammatik/Terminale/Nicht-Terminale, Beispiel: lol-Sprache
- Reguläre/Kontextfreie Sprachen: Definitionen, Unterschied,Beispiele (von Folien)
- Unterschied: Interpretierte vs. compilierte Sprachen
- Scanner/Parser: Definitionen (Aufgaben von Scanner/Parser)
- Beispielprogramme: Arbeitsauftrag_1 und 2 ScannerParser.

Weiterer Kontext:

- Wort Untersuchen als Methode bei soscodeprüfer können
- soscodeprüfer 2 methoden parser 3 methoden
- Für NEA Beispiel mit Datum anschauen
- Tabelle für Zustände bei Kellerautomaten anschauen

Relevante Java Klassen (auswendig am besten):

- SosCodePruefer

```java
public class SOSCodepruefer { 

  private int zustand;

  private void zustandWechseln(char eingabe) {
    switch(zustand) {
    case 0: {
      switch(eingabe) {
      case '#': {zustand = 11; } break;
      case '-': {zustand = 0; } break;
      case '.': {zustand = 0; } break;
      }
    } break;
    case 1: {
      switch(eingabe) {
      case '#': {zustand = 11; } break;
      case '-': {zustand = 0; } break;
      case '.': {zustand = 2; } break;
      }
    } break;
    case 2: {
      switch(eingabe) {
      case '#': {zustand = 11; } break;
      case '-': {zustand = 0; } break;
      case '.': {zustand = 3; } break;
      }
    } break;
    case 3: {
      switch(eingabe) {
      case '#': {zustand = 11; } break;
      case '-': {zustand = 4; } break;
      case '.': {zustand = 0; } break;
      }
    } break;  
    case 4: {
      switch(eingabe) {
      case '#': {zustand = 11; } break;
      case '-': {zustand = 5; } break;
      case '.': {zustand = 0; } break;
      }
    } break;  
    case 5: {
      switch(eingabe) {
      case '#': {zustand = 11; } break;
      case '-': {zustand = 6; } break;
      case '.': {zustand = 0; } break;
      }
    } break;    
    case 6: {
      switch(eingabe) {
      case '#': {zustand = 11; } break;
      case '-': {zustand = 0; } break;
      case '.': {zustand = 7; } break;
      }
    } break;    
    case 7: {
      switch(eingabe) {
      case '#': {zustand = 11; } break;
      case '-': {zustand = 0; } break;
      case '.': {zustand = 8; } break;
      }
    } break;
    case 8: {
      switch(eingabe) {
      case '#': {zustand = 11; } break;
      case '-': {zustand = 0; } break;
      case '.': {zustand = 9; } break;
      }
    } break;    
    case 9: {
      switch(eingabe) {
      case '#': {zustand = 10; } break;
      case '-': {zustand = 0; } break;
      case '.': {zustand = 9; } break;
      }
    } break;    
    case 11: {
      switch(eingabe) {
      case '#': {zustand = 11; } break;
      case '-': {zustand = 0; } break;
      case '.': {zustand = 1; } break;
      }
    } break;
    }
  } 
  
  public boolean wortUntersuchen(String text)
  {  
    boolean SOSistEnthalten = false;
    for (int i = 0; i < text.length(); i++) {
      zustandWechseln(text.charAt(i));
    }
    if (zustand == 10) {
      SOSistEnthalten = true; 
    }
    zustand = 0; //Anfangszustand z0
    return SOSistEnthalten;   
  }

  public static void main(String[] args) {    

    SOSCodepruefer sosp = new SOSCodepruefer();
    //Tests
    boolean erg1 = sosp.wortUntersuchen("#..---...#");      
    boolean erg2 = sosp.wortUntersuchen("#.....-----.#...---...#...---..-.---.-.-#");
    System.out.println(erg1);
    System.out.println(erg2);
  }
}
```

- Parser

```java
public class Parser {
 private static final String TOKENTYP_ENDE = "ENDE";
 private static final String TOKENTYP_EGAL = "EGAL";
 private  List<Token> tokenliste;
 private  Token aktuellesToken;

 public Parser(List<Token> pTokenliste) {
  tokenliste = pTokenliste;
  tokenliste.toFirst();
  aktuellesToken = tokenliste.getContent();
 }

 private Token nextToken() {
  tokenliste.next();
  return tokenliste.getContent();
 }

 public boolean parse() {
  return tokenliste.hasAccess() && pruefeS();  
 }


 public boolean pruefeS_1() {
  if(!tokenliste.hasAccess()){
   return false;
  }
  String tokenTyp = aktuellesToken.getTyp();
  if (TOKENTYP_EGAL.equals(tokenTyp) || TOKENTYP_ENDE.equals(tokenTyp)) {
   aktuellesToken = nextToken();
   return pruefeA();
  } else {
   return false;
  }
 }

 public boolean pruefeS() {
  String tokenTyp = aktuellesToken.getTyp();
  if (tokenliste.hasAccess() && (TOKENTYP_EGAL.equals(tokenTyp) || TOKENTYP_ENDE.equals(tokenTyp))) {
   aktuellesToken = nextToken();
   return pruefeA();
  } else
   return false;
 }


 public boolean pruefeA() {
  String tokenTyp = aktuellesToken.getTyp();
  if (tokenliste.hasAccess() && (TOKENTYP_EGAL.equals(tokenTyp) || TOKENTYP_ENDE.equals(tokenTyp))) {
   aktuellesToken = nextToken();
   return pruefeB();
  } else
   return false;
 }

 public boolean pruefeB() { 
  String tokenTyp = aktuellesToken.getTyp();
  return tokenliste.hasAccess() && TOKENTYP_ENDE.equals(tokenTyp); 
 }


}

```

- Scanner

```java
public class Scanner {
 private boolean istFehler;
 private Token aktuellesToken;
 private String eingabe;
 private List<Token> tokenliste;

 public Scanner(String pEingabe, List<Token> pTokenliste) {
  eingabe = pEingabe + "#";
  tokenliste = pTokenliste;
  tokenliste.toFirst();
  istFehler = false;
 }

 public void scanne() {
  char erster, zweiter;
  int pos = 0;
  while (eingabe.charAt(pos) != '#') {
   erster = eingabe.charAt(pos);
   zweiter = eingabe.charAt(pos + 1);
   if (erster == 'l' && zweiter == 'a') {
    aktuellesToken = new Token("EGAL", "la");
   } else if (erster == 'l' && zweiter == 'e') {
    aktuellesToken = new Token("EGAL", "le");
   } else if (erster == 'l' && zweiter == 'u') {
    aktuellesToken = new Token("ENDE", "lu");
   } else {
    istFehler = true;
    break;
   }
   pos = pos + 2;
   tokenliste.append(aktuellesToken);
  }
  ausgabe(istFehler);
 }

 private void ausgabe(boolean pFehler) {
  tokenliste.toFirst();
  if (pFehler == true || tokenliste.getContent() == null) {
   System.out.println("Lexikalische Analyse abgebrochen");
  } else {
   System.out.println("Lexikalische erfolgreich");
  }
 }

 public List<Token> getTokenliste() {
  if (istFehler == false) {
   return tokenliste;
  } else
   return null;
 }
}
```

- Token

```java
public class Token {
 
 private String wert;
 private String typ;
 
 public Token(String pTyp, String pWert) {
  typ = pTyp;
  wert = pWert;    
 }
 
 public String getWert() {
  return wert;
 }
 
 
 public String getTyp() {
  return typ;
 }
 

}
```

- Analyse

```java
public class Analyse {
 private String eingabe;
 private Scanner scanner;
 private Parser parser;

 private List<Token> tokenliste;

 public Analyse(String pEingabe) {
  eingabe = pEingabe;
  tokenliste = new List<Token>();
  scanner = new Scanner(eingabe, tokenliste);
  parser = new Parser(tokenliste);
 }

 public void analysiere() {
  scanner.scanne();
  tokenliste.toFirst();
  //printTokenlist();
  if (scanner.getTokenliste() != null) {
   parser = new Parser(scanner.getTokenliste());
   if (parser.parse())
    System.out.println("Erfolgreiches Parsing");
   else
    System.out.println("Kein erfolgreiches Parsing");
  }
 }
 
 public void analysiere1() {
  scanner.scanne();
  List<Token> tokenliste = scanner.getTokenliste();
  if (tokenliste == null) {
   System.out.println("Leere Eingabe");
   return;
  }
  Parser parser = new Parser(scanner.getTokenliste());

  if (parser.parse()) {
   System.out.println("Erfolgreiches Parsing");
  } else {
   System.out.println("Kein erfolgreiches Parsing");
  }
 }
 
 private void printTokenlist() {
  while (tokenliste.hasAccess()) {
   System.out.println(tokenliste.getContent().getTyp());
   tokenliste.next();
  }
  tokenliste.toFirst();
 }

 public static void main(String[] args) {
  Analyse test = new Analyse("lalelu#");
  test.analysiere();
 }

}
```
