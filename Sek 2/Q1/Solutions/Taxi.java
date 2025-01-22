public class Taxi {

	private String fahrerNachnahme;
	private String kennzeichen;
	
	public Taxi() {}
	
    //Alternative zu set-Methoden, Konstruktor mit Input-Parametern
	public Taxi(String pFahrerNachnahme, String pKennzeichen) {
		fahrerNachnahme = pFahrerNachnahme;
		kennzeichen = pKennzeichen;
	}
	
	public void setFahrerNachnahme(String fahrerNachnahme) {
		this.fahrerNachnahme = fahrerNachnahme;
	}

	public void setKennzeichen(String kennzeichen) {
		this.kennzeichen = kennzeichen;
	}

	public String getFahrerNachnahme() {
		return fahrerNachnahme;
	}

	public String getKennzeichen() {
		return kennzeichen;
	}

}
