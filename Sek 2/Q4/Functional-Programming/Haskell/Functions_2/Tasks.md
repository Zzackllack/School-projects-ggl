# Aufgabe 1: Haskell – Funktion zylindervolumen

a) Testen Sie und schreiben Sie einen Satz dazu, wie die Funktion zylindervolumen
aufgebaut ist und was sie liefert.

```haskell
zylindervolumen :: Float -> Float -> Float
zylindervolumen r h = grundfaeche *h
                      where grundfaeche = pi* r *r
```

b) Beschreiben Sie, wozu das Schlüsselwort where in Haskell dient.

c) Testen Sie auch die folgende Funktion und beschreiben Sie den Unterschied zur
Funktion aus a).

```haskell
zylindervolumen2 :: Float -> Float -> Float
zylindervolumen2 r h | r < 0 || h < 0 = error "Längen dürfen nicht negativ sein!"
                | otherwise = grundfaeche* h
                              where grundfaeche = pi * r **2
```

# Aufgabe 2: Haskell – Funktion mystic2

Beschreiben Sie kurz (1-2 Sätze) den Aufbau und das Ergebnis dieser Funktion.

```haskell
mystic2 :: Int -> Int -> Int
mystic2 x y | x <= y    = x
            | otherwise = y
```
