public class Fahrzeug {
	private String modell;
	private String farbe;
	private String kennzeichen;
	private boolean verkehrstauglich;
	
	public boolean isVerkehrstauglich() {
		return verkehrstauglich;
	}
	public void setVerkehrstauglich(boolean verkehrstauglich) {
		this.verkehrstauglich = verkehrstauglich;
	}
	public String getKennzeichen() {
		return kennzeichen;
	}
	public void setKennzeichen(String kennzeichen) {
		this.kennzeichen = kennzeichen;
	}
	public String getFarbe() {
		return farbe;
	}
	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}
	public String getModell() {
		return modell;
	}
	public void setModell(String modell) {
		this.modell = modell;
	}
}
