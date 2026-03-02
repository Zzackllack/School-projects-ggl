# Tiefensuche implementieren

Aufgabe 1:
a) Gegeben sind die Klassen Knoten und Graph_Matrix. In der Klasse
Graph_Matrix ist folgende Methode zu implementieren:
public void tiefenSuche(String startBezeichner){…}
Voraussetzung: Analysieren Sie zuerst die Methode besuchen aus der Klasse
Graph_Matrix und führen Sie einen Testdurchlauf auf Papier durch.
Die Methode tiefenSuche soll:
• die Knotennummer des Startknotens (des Knotens mit dem
startBezeichner) ermitteln.
• Falls der bezeichnete Startknoten NICHTVORHANDEN ist, soll tiefenSuche
abbrechen.
• Im Normalfall hingegen sollen zuerst alle knotenentsprechenden Elemente des
Arrays besucht auf false gesetzt werden (da am Anfang noch kein Knoten im
Verlauf der Tiefensuche besucht wurde). Sodann soll die rekursive Methode
besuchen mit der Knotennummer des Startknotens aufgerufen werden.
b) Implementieren Sie eine Klasse Test_Graph_Matrix, die die Methode
tiefenSuche aus der Klasse Graph_Matrix testet.
