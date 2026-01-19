-- | Gibt die Liste ohne das letzte Element zurück.
-- Fehler bei leerer Liste.
ohneletzes :: [a] -> [a]
ohneletzes []     = error "ohneletzes: leere Liste"
ohneletzes [_]    = []
ohneletzes (x:xs) = x : ohneletzes xs