-- c) Im Vergleich zur vorherigen Implementierung wird hier eine Guard-Klausel verwendet, um sicherzustellen, dass sowohl der Radius r als auch die Höhe h nicht negativ sind. Wenn einer der Werte negativ ist, wird ein Fehler ausgegeben. Andernfalls wird das Volumen wie zuvor berechnet. Dies verbessert die Robustheit der Funktion, indem ungültige Eingaben abgefangen werden.
zylindervolumen2 :: Float -> Float -> Float
zylindervolumen2 r h | r < 0 || h < 0 = error "Längen dürfen nicht negativ sein!"
    | otherwise = grundfaeche * h
        where grundfaeche = pi * r **2