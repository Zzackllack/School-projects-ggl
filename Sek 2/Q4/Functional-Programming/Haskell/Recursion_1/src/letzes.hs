-- Gibt das letzte Element einer Liste zurück.
-- Typannotation: für jede Liste von Werten des Typs 'a' liefert die Funktion ein 'a'.
letztes :: [a] -> a

-- Fall 1: leere Liste
-- Eine leere Liste hat kein letztes Element, daher verursachen wir einen Fehler
letztes []     = error "letztes: leere Liste"

-- Fall 2: Liste mit genau einem Element
-- Wenn die Liste genau ein Element [x] ist, ist dieses Element das letzte.
letztes [x]    = x

-- Fall 3: Liste mit mindestens zwei Elementen
-- Der Ausdruck (_:xs) zerlegt die Liste in Kopf (hier unbenutzt, deshalb '_')
-- und Schwanz 'xs'. Wir rufen 'letztes' rekursiv auf dem Schwanz auf.
-- Dadurch wird die Liste bei jedem Aufruf kürzer, bis eines der obigen
-- Basisfälle erreicht wird.
letztes (_:xs) = letztes xs