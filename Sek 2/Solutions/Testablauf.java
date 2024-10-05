public class Testablauf {

	private Taxiwarteschlange tw = new Taxiwarteschlange();
	private Taxi taxiA = new Taxi();
	private Taxi taxiB = new Taxi();
	private Taxi taxiC = new Taxi();
	private Taxi taxiD = new Taxi();

	public static void main(String[] args) {
		Testablauf test = new Testablauf();
		test.taxiAttributeSetzen();
		test.ablaufen();
	}

	public void taxiAttributeSetzen() {
		taxiA.setFahrerNachnahme("Fröhlich");
		taxiA.setKennzeichen("BL87");
		taxiB.setFahrerNachnahme("Sand");
		taxiB.setKennzeichen("ZD54");
		taxiC.setFahrerNachnahme("Mey");
		taxiC.setKennzeichen("SI65");
		taxiD.setFahrerNachnahme("Stroheim");
		taxiD.setKennzeichen("SP12");
	}

	public void ablaufen() {
		tw.hintenAnstellen(taxiA);
		tw.hintenAnstellen(taxiB);
		tw.hintenAnstellen(taxiC);
		tw.hintenAnstellen(taxiD);
		tw.vorneAbfahren();
		tw.fahrernamenAusgeben();
	}
}
