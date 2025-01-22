public class PatientenWarteschlange {
	//Ein Zähler wird benötigt
	private int anzahlPatienten;
	//Ein Array, welches Elemente vom Datentyp Patient speichert
	private Patient[] patientenStand;

	//Ein Konstruktor, in dem der Patienten-Array auf Größe 80 und der Zähler auf 0 initialisiert werden (Array ist noch leer)  
	public PatientenWarteschlange() {
		patientenStand = new Patient[80];
		anzahlPatienten = 0;
	}

	//Diese Methode trägt den Patienten t in die Warteschlange hinten ein.
	public void hintenEintragen(Patient t) {
		//Falls die Warteschlange voll ist (Array-Größe 80 wurde erreicht),
		//gibt es eine Meldung für Benutzer, dass keine Eintragung mehr möglich ist.
		if (anzahlPatienten >= 80) {
			System.out.println("Fehler: Keine Eintragung mehr möglich!");
		}
		// In allen anderen Fällen wird der Eingangsparameter t (neuer Patient) in das Array patientenStand gespeichert,
		// beim ersten Mal unter dem Index 0 (der Zähler anzahlPatienten==0) und der zähler anzahlPatienten wird erhöht.
		else {
			patientenStand[anzahlPatienten] = t;
			anzahlPatienten = anzahlPatienten + 1;
		}	
	}

	//Diese Methode liefert den ersten Eintrag aus der Warteschlange (hier ein Patient) und entfernt ihn; FIFO-Prinzip
	public Patient erstenAufrufen() {
		//Eine Hilfsvariable wird mit null initialisiert
		Patient ersterPatient = null;
		//Wieder eine Überprüfung, diesmal, ob es überhaupt Elemente in der Warteschlange gibt.
		//Falls nicht (Zähler ist 0), wird eine Meldung für den Benutzer ausgegeben
		if (anzahlPatienten == 0) {
			System.out.println("Fehler: Kein Patient wartet!");
		}
		//In die Hilfsvariable ersterPatient wird das Element (der erste Patient, Index 0) aus dem Array patientenStand gespeichert 
		else {
			ersterPatient = patientenStand [0];
			//Danach müssen alle Patienten aus der Warteschlange um einen Platz nach vorne verschoben werden. 
			//Die mit dem Index i bekommen Index i - 1
			for (int i = 1; i < anzahlPatienten; i++) {
				patientenStand[i-1] = patientenStand[i];
			}
			//Der letzte Platz (anzahlPatienten - 1 ist der letzte Platz, da der Index ab 0 läuft)
			//soll dann sicherheitshalber mit null initialisiert werden (es ist nichts mehr da) 
			patientenStand[anzahlPatienten - 1] = null;
			//Der Zähler wird um 1 verringert
			anzahlPatienten = anzahlPatienten - 1;
		}
		//Da die Methode gemäß der ersten Zeile (Signatur) ein Ergebnis vom Datentyp Patient liefern muss,
		//muss die letzte Anweisung return sein, der erste Patient wird zurückgeliefert, 
		//falls ein anderes Teil des Programms den ersten Patienten weiter verarbeiten möchte.
		return ersterPatient;
	}

	//Ausgabe aller Nachnamen, Zugriff erfolgt über Array (Schublade)
	public void nachnamenAusgeben() {
		for (int i = 0; i < anzahlPatienten; i++) {
			System.out.println(patientenStand[i].getNachname());				
		}

	}
}
