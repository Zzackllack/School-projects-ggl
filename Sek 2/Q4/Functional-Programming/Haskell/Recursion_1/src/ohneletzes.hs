-- ohneletzes nimmt eine Liste von Elementen beliebigen Typs ([a])
-- und gibt wiederum eine Liste desselben Typs zurück ([a]).
ohneletzes :: [a] -> [a]

-- Pattern-Matching: leere Liste
-- Wenn die Eingabeliste leer ist, können wir kein "letztes" Element entfernen.
ohneletzes []     = error "ohneletzes: leere Liste"

-- Pattern-Matching: Liste mit genau einem Element
-- Wenn die Liste genau ein Element hat ([_]), dann ist die Liste ohne das
-- letzte Element die leere Liste [].
ohneletzes [_]    = []

-- Pattern-Matching: Liste mit Kopf und Rest (x:xs)
-- x ist das erste Element (Kopf), xs ist die restliche Liste (Tail).
-- Wir behalten das erste Element x und rufen ohneletzes rekursiv auf xs auf.
-- Durch die Rekursion wird das letzte Element am Ende entfernt.
-- Beispiel: ohneletzes [1,2,3] -> 1 : ohneletzes [2,3] -> 1 : 2 : ohneletzes [3]
-- -> 1 : 2 : [] -> [1,2]
ohneletzes (x:xs) = x : ohneletzes xs