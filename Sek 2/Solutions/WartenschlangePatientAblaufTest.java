public class WartenschlangePatientAblaufTest {
	
    //Hier werden nur 3 Variablen vom Datentyp Patient zur Verfügung gestellt.
	//Es gibt noch keine Objekte.
	private Patient patient1;
	private Patient patient2;
	private Patient patient3;	
   
	public static void main(String[] args) {
		//In der main-Methode wird zuerst ein Objekt der Klasse selbst erzeugt
		//damit wir die Methoden aus dieser Klasse aufrufen können.
		WartenschlangePatientAblaufTest test = new WartenschlangePatientAblaufTest();
		//Zuerst werden Patient-Objekte erzeugt.
		test.patientenErzeugen();
		//Warteschlangenlogik wird getestet.
		test.testAblaufen();		
	}	
	
	//In dieser Methode werden die Objekte erzeugt und wird das Attribut nachname für alle 3 Objekte gesetzt.
	//Ohne Setzen von Attributen sind die Objekte leer.
	public void patientenErzeugen() {
		//Ein leeres Objekt patient1 wird erzeugt:
		patient1 = new Patient();
		//patient1 bekommt das Attribut nachname gesetzt:
		patient1.setNachname("Müller");
		patient2 = new Patient();
		patient2.setNachname("Lang");
		patient3 = new Patient();
		patient3.setNachname("Kretschmar");		
	}
	
	public void testAblaufen() {
		//Damit die Logik (Methoden aus der Klasse PatientenWarteschlange) aufgerufen werden können, 
		//muss zuerst ein Objekt dieser Klasse erzeugt werden:
		PatientenWarteschlange warteschlange = new PatientenWarteschlange();
		//Jetzt kann man über dieses Objekt warteschlange die Methoden zum hinten eintragen ,
		//ersten aufrufen und nachnamenAusgeben aufrufen.
		//Methode hintenEintragen benötigt einen Input-Parameter des Datentyps Patient (hier patient1 oder patient2).
		//Vor dem Aufruf müssen die Objekte patient1 und patient2 erzeugt werden (siehe Methode patientenErzeugen).
		warteschlange.hintenEintragen(patient1);
		warteschlange.hintenEintragen(patient2);
		warteschlange.erstenAufrufen();
		warteschlange.nachnamenAusgeben();		
	}
	
}
