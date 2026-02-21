# Aufgabe 1: Haskell – Typklassen

*a)* Typklassen in Haskell sind eine Art von Schnittstellen, die definieren, welche Funktionen für bestimmte Datentypen implementiert werden müssen. Sie ermöglichen es, generischen Code zu schreiben, der mit verschiedenen Datentypen arbeiten kann, solange diese Typen die erforderlichen Funktionen der Typklasse implementieren.

Die Typklasse Show wird verwendet, um Datentypen in eine menschenlesbare Zeichenkette umzuwandeln. Jeder Datentyp, der eine Instanz der Show-Typklasse ist, muss die Funktion show implementieren, die den Datentyp als String darstellt.

Die Typklasse Eq wird verwendet, um Gleichheitsvergleiche zwischen Werten eines Datentyps zu ermöglichen. Datentypen, die eine Instanz der Eq-Typklasse sind, müssen die Funktionen (==) und (/=) implementieren, um zu überprüfen, ob zwei Werte gleich oder ungleich sind.

Die Typklasse Ord wird verwendet, um eine Ordnung zwischen Werten eines Datentyps zu definieren. Datentypen, die eine Instanz der Ord-Typklasse sind, müssen die Funktionen (<), (<=), (>), (>=), compare und min/max implementieren, um Vergleiche und Sortierungen zu ermöglichen.

*b)* Hier sind Beispiele für jede der genannten Typklassen:

### Show:

```haskell
data Person = Person String Int

instance Show Person where
  show (Person name age) =
    "Name: " ++ name ++ ", Alter: " ++ show age
```

### Eq

```haskell
data Farbe = Rot | Gruen | Blau

instance Eq Farbe where
  Rot   == Rot   = True
  Gruen == Gruen = True
  Blau  == Blau  = True
  _     == _     = False
```

### Ord

```haskell
data Wochentag = Montag | Dienstag | Mittwoch | Donnerstag | Freitag

instance Eq Wochentag where
  a == b = compare a b == EQ

instance Ord Wochentag where
  compare Montag Montag = EQ
  compare Montag _      = LT
  compare _ Montag      = GT
  compare Dienstag Dienstag = EQ
  compare Dienstag _        = LT
  compare _ Dienstag        = GT
  compare Mittwoch Mittwoch = EQ
  compare Mittwoch _        = LT
  compare _ Mittwoch        = GT
  compare Donnerstag Donnerstag = EQ
  compare Donnerstag _          = LT
  compare _ Donnerstag          = GT
  compare Freitag Freitag = EQ```
```
