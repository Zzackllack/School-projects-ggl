-- Aufgabe 1
-- Die Funktion mystic nimmt zwei Integer-Werte a und b als Eingabe und berechnet: (a / 2) + (3*a - b). Aufbau: Die erste Zeile (mystic :: Int -> Int -> Int) ist die Typsignatur - sie definiert, dass die Funktion zwei Integer-Parameter nimmt und einen Integer zurückgibt. Die zweite Zeile ist die Funktionsdefinition mit den Parametern a und b und der Berechnungsformel.
mystic :: Int -> Int -> Int
mystic a b = div a 2 +(3*a - b)
