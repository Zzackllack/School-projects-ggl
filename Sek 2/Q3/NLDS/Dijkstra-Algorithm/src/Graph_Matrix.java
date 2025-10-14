
/**
 * Klasse Graph_Matrix
 * Klasse für einen ungerichteten, gewichteten Graphen
 * Als Datenstruktur wird eine Adjazenzmatrix verwendet
 * 
 * Schulbuch Informatik 1 Oberstufe
 * Oldenbourg Verlag
 * 
 * @author U.Freiberger 
 * @version 1.0
 * 
 */


public class Graph_Matrix
{
	private static final int UNVERBUNDEN = -1;
	private static final int NICHTVORHANDEN = -2;

	private int anzahlKnoten;

	private Knoten[] knoten;   

	private int[][] matrix;
	
	private boolean[] besucht;
	private int distanz[];
	private int kommtVon[];


	/**
	 * Konstruktor für Objekte der Klasse GRAPH_MATRIX
	 * Die maximale Anzahl der Knoten wird dabei festgelegt
	 *      
	 * @param   maximaleKnoten   Anzahl der maximal möglichen Knoten
	 * 
	 */
	public Graph_Matrix(int maximaleKnoten)
	{
		anzahlKnoten = 0;
		knoten   = new Knoten[maximaleKnoten];
		matrix   = new int[maximaleKnoten][maximaleKnoten];
		besucht  = new boolean[maximaleKnoten];
		distanz  = new int[maximaleKnoten];
		kommtVon = new int[maximaleKnoten];
	}



	public void knotenEinfuegen(String bezeichner)    
	{
		// Prüfen, ob bereits ein Knoten mit diesem Bezeichner existiert
		if (knotenNummer(bezeichner) != NICHTVORHANDEN)
			return;

		// Prüfen, ob noch Platz für einen weiteren Knoten ist
		if (anzahlKnoten >= knoten.length)
			return;

		// Neuer Knoten anlegen
		knoten[anzahlKnoten] = new Knoten(bezeichner);

		// Für den neuen Knoten alle Verbindungen zu/von anderen Knoten als UNVERBUNDEN markieren
		for (int i = 0; i <= anzahlKnoten; i++)
		{
			matrix[anzahlKnoten][i] = UNVERBUNDEN;
			matrix[i][anzahlKnoten] = UNVERBUNDEN;
		}

		anzahlKnoten++;
	}


	/**
	 * Gibt die interne Nummer des Knoten
	 * Wenn ein Knoten mit diesem Bezeichner nicht bekannt ist wird -2 zurückgegeben
	 * 
	 * @param   bezeichner   Bezeichner des Knoten der gesucht wird
	 * @return  Indexnummer des Knotens im Knotenarray; 0<= x <= anzahl-1 bzw. -2
	 * 
	 */   
	private int knotenNummer(String bezeichner)
	{
		int i, ergeb;
		ergeb = NICHTVORHANDEN;
		for (i=0; (i < anzahlKnoten) && (ergeb == NICHTVORHANDEN); i++)
			if (knoten[i].BezeichnungGeben().equals(bezeichner))
				ergeb = i;

		return ergeb;
	}


	/**
	 * Gibt die Bezeichnung eines Knotens mit der internen Knotennummer
	 * 
	 * @param    Indexnummer des Knotens im Knotenarray; 0<= x <= anzahl-1
	 * @return   bezeichner  Bezeichner des Knoten
	 * 
	 */   
	public String knotenBezeichnerGeben(int knotenNummer)
	{
		if ((knotenNummer < anzahlKnoten) && (knotenNummer >= 0))
			return knoten[knotenNummer].BezeichnungGeben();
		else
			return "";
	}


	public void kanteEinfuegen(String von, String nach, int gewichtung)
	{
 		int vonNummer = knotenNummer(von);
		int nachNummer = knotenNummer(nach);

		// Nur einfügen, wenn beide Knoten existieren und Gewichtung gültig ist
		if ((vonNummer != NICHTVORHANDEN) && (nachNummer != NICHTVORHANDEN) && (gewichtung > 0))
		{
			matrix[vonNummer][nachNummer] = gewichtung;
			matrix[nachNummer][vonNummer] = gewichtung; // ungerichteter Graph => symmetrisch
		}
	}


	/**
	 * Gibt die Adjazenzmatrix des Graphen in der Konsole aus
	 * Nach Zeilen und Spalten formatiert
	 * Als Spaltenbreite wurde hier 4 Zeichen gewählt.
	 * 
	 */   
	public void ausgeben()
	{
		int breite = 4;
		// Kopfzeile
		System.out.print("    ");  
		for (int i=0; i<anzahlKnoten; i++)
			System.out.print(knoten[i].BezFormatGeben(breite));
		System.out.println();

		for (int i=0; i<anzahlKnoten; i++)
		{
			System.out.print(knoten[i].BezFormatGeben(breite));
			for (int j=0; j<anzahlKnoten; j++)
				if (matrix[i][j] != UNVERBUNDEN)
					System.out.print((matrix[i][j]+"   ").substring(0,breite));
				else
					System.out.print("    ");
			System.out.println();           
		}
	}    


	/**
	 * Gibt die Anzahl der Knoten des Graphen
	 * 
	 * @return  Anzahl der Knoten
	 * 
	 */   
	public int knotenAnzahlgeben()
	{
		return anzahlKnoten;
	}


	/**
	 * Gibt die Gewichtung einer Kante
	 * Die Kante ist durch einen Anfangsknoten und einen Endknoten festgelegt
	 * 
	 * @param   von         Bezeichner des Anfangsknotens
	 * @param   nach         Bezeichner des Endknotens
	 * @return  Gewichtung der Kante
	 * 
	 */   
	public int kanteGewichtGeben(String von, String nach)
	{
		int vonNummer, nachNummer;

		vonNummer = knotenNummer(von);
		nachNummer = knotenNummer(nach);
		if ((vonNummer!=NICHTVORHANDEN) && (nachNummer!=NICHTVORHANDEN))
			return matrix[vonNummer][nachNummer];
		else
			return UNVERBUNDEN;
	}


	/**
	 * Besucht einen Knoten
	 * und besucht dann alle von diesem Knoten ausgehenden Knoten
	 * sofern diese noch nicht besucht wurden.
	 * 
	 * @param   knotenNummer    Knotennummer des zu besuchenden Knotens
	 * 
	 */   
	private void besuchen(int knotenNummer)
	{
		// aktiven Knoten auf besucht setzen und in der Konsole ausgeben
		besucht[knotenNummer] = true;
		System.out.print("besucht " + knoten[knotenNummer].BezeichnungGeben()+"; ");

		// in der Matrix die Zeile des aktiven Knotens nach Kanten durchforsten
		for (int abzweigNummer=0; abzweigNummer < anzahlKnoten; abzweigNummer++)
		{
			// es gibt eine Kante und deren Zeilknoten ist noch nicht besucht
			if ((matrix[knotenNummer][abzweigNummer]>0) && !(besucht[abzweigNummer]))
			{
				besuchen(abzweigNummer);  
				System.out.print("zurück nach " + knoten[knotenNummer].BezeichnungGeben()+"; ");                
			}
		}

		// der aktive Knoten mit der knotenNummer ist fertig bearbeitet
		System.out.println("fertig mit " + knoten[knotenNummer].BezeichnungGeben()+"; ");
	}


	private int minKnoten()
	{
		int minDistanzIndex = 0;
		int minDistanz = Integer.MAX_VALUE;

		for (int i=0; i<anzahlKnoten; i++)
		{
			//NICHT BESUCHT und MAX_WERT füt Distanz > distanz[i]  
			if (!besucht[i] && (minDistanz > distanz[i]))
			{
				minDistanz = distanz[i];
				minDistanzIndex = i;              
			}
		}
		return minDistanzIndex;
	}    	

	public void kuerzesterWeg(String startKnoten, String zielKnoten)
	{
		int startNummer = knotenNummer(startKnoten); 
		int zielNummer  = knotenNummer(zielKnoten);
		int knotenNummer, neueDistanz;
		String pfad;
		
		for (int i=0; i<anzahlKnoten; i++)
		{
			besucht[i]=false;
			distanz[i]=Integer.MAX_VALUE;              
		}
		distanz[startNummer] = 0;
		kommtVon[startNummer] = startNummer;

		// wiederhole bis alle Knoten besucht sind
		for (int i=0; i<anzahlKnoten; i++)
		{
			// der unbesuchte Knoten mit der minimalen Distanz wird zum aktiven Knoten
			knotenNummer = minKnoten();
			besucht[knotenNummer] = true;
			for (int abzweigNummer=0; abzweigNummer<anzahlKnoten; abzweigNummer++)
			{
				if ((matrix[knotenNummer][abzweigNummer]>0) && (!besucht[abzweigNummer]))            	
				{
					neueDistanz = distanz[knotenNummer] + matrix[knotenNummer][abzweigNummer];

					if (neueDistanz < distanz[abzweigNummer])
					{
						distanz[abzweigNummer] = neueDistanz;
						kommtVon[abzweigNummer] = knotenNummer;
					}
				}
			}            
		}

		// Fertig! Die Entfernung ausgeben
		System.out.println("Entfernung: " + distanz[zielNummer]);
		pfad = zielKnoten;
		knotenNummer = zielNummer;
		while (knotenNummer != startNummer)
		{
			knotenNummer = kommtVon[knotenNummer];
			pfad = knoten[knotenNummer].BezeichnungGeben() + "/" + pfad;
		}
		System.out.println("Weg: " + pfad);
	}
	
	
}
