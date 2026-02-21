-- Aufgabe 1 
-- a) Die Funktion zylindervolumen berechnet das Volumen eines Zylinders basierend auf dem Radius r und der Höhe h. Die Formel für das Volumen eines Zylinders ist V = Grundfläche * Höhe, wobei die Grundfläche eines Kreises mit dem Radius r durch die Formel π * r^2 gegeben ist. Sie liefert das Volumen als Float zurück.
-- b) Das Schlüsselwort where in Haskell bedeutet allgemein "wo" und wird verwendet, um lokale Definitionen oder Hilfsfunktionen innerhalb einer Funktion zu erstellen. In diesem Fall wird es verwendet, um die Grundfläche des Zylinders zu berechnen und diese Berechnung von der Hauptfunktion zylindervolumen zu trennen. Dadurch wird der Code klarer und besser strukturiert.
zylindervolumen :: Float -> Float -> Float
zylindervolumen r h = grundfaeche * h
    where grundfaeche = pi * r * r