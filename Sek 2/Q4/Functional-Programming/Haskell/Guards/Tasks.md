# Aufgabe 1: Haskell – Guards

**Seit Haskell 2010 können mehrere durch Komma getrennte Bedingung angegeben werden.**

a) Finden Sie die Fehler, korrigieren Sie den Code Sie und testen Sie diese Funktion:

```haskell
welcome ::String-> String -> String
welcome vorname nachname| vorname = "Steffen",nachname = "Jost"= "Good morning Dr Jost!"
                        | nachname = "Jost"= "Welcome!
                        | otherwise= "Go away!"
```haskell

b) Analysieren Sie und testen Sie diese Funktionen:

```haskell
habGeldNachAktion ::Int -> Int -> String
habGeldNachAktion konto zahlung| kontoneu < 0, zahlung > 0 = "Kannst Du Dir nicht leisten!"
                               | kontoneu > 0, zahlung > 0 = "Bist echt reich!"
                               | otherwise = "Alles ist ok."
                               where kontoneu = konto - zahlung
```haskell
