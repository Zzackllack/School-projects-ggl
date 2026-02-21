-- Aufgabe 2
-- Die Funktion mystic2 nimmt zwei Integer-Werte x und y als Eingabe und gibt den kleineren der beiden Werte zurück. Wenn x kleiner oder gleich y ist, wird x zurückgegeben; andernfalls wird y zurückgegeben. Dies wird durch die Verwendung von Guard-Klauseln erreicht, die Bedingungen überprüfen und entsprechend den Rückgabewert bestimmen.
mystic2 :: Int -> Int -> Int
mystic2 x y | x <= y = x
    | otherwise = y