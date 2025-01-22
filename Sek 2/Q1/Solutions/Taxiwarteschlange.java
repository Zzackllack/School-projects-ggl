public class Taxiwarteschlange {

	private int anzahlTaxis;
	private Taxi [] taxistand;    //taxistand wird als Array Deklariert   

	public Taxiwarteschlange() {
		taxistand = new Taxi [4];  //taxistand wird als Array initialisiert
		anzahlTaxis = 0;
	}

	public void hintenAnstellen (Taxi t) {
		if (anzahlTaxis >= 4) {
			System.out.println("Fehler: kein Platz mehr frei!");
		}else {
			taxistand [anzahlTaxis] = t;  			//dem Platz mit dem Wert 		(anzahltaxis) wird der Input parameter des Objektes Taxi t zugewiesen
			anzahlTaxis = anzahlTaxis + 1; 
		}
	}

	public Taxi vorneAbfahren() {
		if (anzahlTaxis == 0) {
			System.out.println("Fehler: kein Taxi in der Schlange!");
			return null;
		}
		Taxi erstesTaxi = taxistand [0];    							// Das Erste Taxi in der Schlange wird in einem Objekt gespeichert

		for (int i = 1; i < anzahlTaxis; i++) {
			taxistand[i - 1] = taxistand[i];
		} 																//Alle Taxis rücken einen Platz auf und überschreiben das vorherige
		taxistand [anzahlTaxis - 1] = null; 							//überprüfung, dass der letzte platz leer ist
		anzahlTaxis = anzahlTaxis-1; 		
		return erstesTaxi;
	}

	public void fahrernamenAusgeben() {
		for (int i = 0; i< anzahlTaxis; i++) {
			System.out.println(taxistand[i].getFahrerNachnahme());			
		}
	}
}
