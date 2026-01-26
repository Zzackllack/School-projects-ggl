qSort :: Ord a => [a] -> [a]  -- Typ: qSort nimmt eine Liste von vergleichbaren Werten und gibt eine Liste zurück
qSort [] = []                 -- Basisfall: eine leere Liste bleibt leer
qSort (x:xs) =                -- Rekursiver Fall: x ist das erste Element (Pivot), xs ist der Rest
    qSort [y | y <- xs, y <= x] ++ [x] ++  -- Sortiere alle Elemente, die kleiner oder gleich x sind, dann füge x ein
    qSort [y | y <- xs, y > x]             -- Sortiere alle Elemente, die größer als x sind