# Gene und Codon — Aufgaben

Gene werden in Computerprogrammen üblicherweise als Abfolgen der Zeichen A, C, G
und T dargestellt. Jeder Buchstabe steht für ein Nukleotid und die Kombination aus drei
Nukleotiden wird Codon genannt. Ein klassische Aufgabe in der Bioinformatik besteht
darin, ein bestimmtes Codon innerhalb eines Gens zu finden.

## Aufgabe 1: Neue Klasse Gene

a) Erzeugen Sie eine neue Klasse `Gene`, und in dieser Klasse einen Enum mit dem Namen `Nucleotide`, die die vier möglichen Werte (`A`, `C`, `G`, `T`) deklariert.  
Hinweis: Finden Sie im Internet, was das Java-Sprachelement enum ist und schreiben Sie 1-2 Sätze dazu.

b) Informieren Sie sich über die Java-Schnittstelle `Comparable` und testen Sie sie an einem Beispiel.  

## Aufgabe 2: Innere statische Klasse Codon

a) Informieren Sie sich über innere statische Klassen und testen Sie ein Beispiel.

b) Gegeben ist die statische innere Klasse Codon. Schreiben Sie ein paar Sätze, über die neuen Java-Sprachelemente, die Sie noch nicht kennen.

```java
public static class Codon implements Comparable<Codon> {
    public final Nucleotide first, second, third;
    private final Comparator <Codon> comparator =
    Comparator.comparing((Codon c) -> c.first).thenComparing((Codon c)->
    c.second).thenComparing((Codon c)-> c.third);
...}
```

c) Vervollständigen Sie den Konstruktor der Klasse `Codon` und analysieren Sie die Methode `compareTo`.

```java
public Codon (String codonStr) {
    first = Nucleotide.valueOf(codonStr.substring(//TODO));
    second = //TODO;
    third = //TODO;
}
public int compareTo(Codon other) {
    return comparator.compare(this, other); }
```

d) Gegeben ist eine ArrayList von Codons: `private ArrayList<Codon> codons = new ArrayList<>();` und der Konstruktor der Klasse Gene.

Analysieren Sie den Konstruktor Gene und beschreiben Sie, was diese Codezeilen bewirken.

```java
public Gene(String geneStr) {
    for (int i = 0; i < geneStr.length()-3; i+=3) {
        codons.add(new Codon(geneStr.substring(i, i+3)));
    }
}
```

e) Implementieren Sie die Methode der linearen Suche, die überprüft, ob ein Codon in der ArrayList codons vorhanden ist.
`public boolean linearContains (Codon key){//TODO}`

f) Testen Sie die Methode linearContains in einer main-Methode, in dem Sie
zuerst einen String von Buchstaben, der mögliche Nukleotide enthält, an den
Konstruktor der Klasse Gene übergeben. Dann prüfen Sie mit der Methode einige
selbst gewählte Codons, ob sie in dem Gene enthalten sind.
