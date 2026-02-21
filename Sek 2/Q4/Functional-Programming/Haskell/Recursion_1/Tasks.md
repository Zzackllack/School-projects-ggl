*Hinweis: Wildcars*

Wenn einer der Parameter für die Berechnung der Funktion nicht benötigt wird, können wir das Symbol _an dieser Stelle als Platzhalter (wildcard) schreiben.

Beispiel:

```haskell
zweiundvierzig :: Int -> Int
zweiundvierzig a = 42
````

Da a aber keinen Einfluss auf die Ausgabe hat, können wir das durch die Verwendung einer Wildcard dem Leser signalisieren.

```haskell
zweiundvierzig_ = 42
```

### Aufgabe 1: Haskell – Rekursiv

Analysieren Sie und testen Sie folgende Funktion:

```haskell
erstes :: [a] -> a
erstes (x:_) = x
```

### Aufgabe 2: Haskell – Rekursiv

Implementieren Sie eine Funktion ohneletzes in Haskell, die von einer Liste den Anfang ohne das letzte Element zurückliefert.

### Aufgabe 3: Haskell – Rekursiv

Implementieren Sie eine Funktion letztes in Haskell, die das letzte Element der übergebenen Liste zurückliefert.
