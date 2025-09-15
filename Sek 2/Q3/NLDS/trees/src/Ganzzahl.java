public class Ganzzahl extends Datenelement{

	private int wert;

	public Ganzzahl (int w) {
		wert = w;
	}

	public int wertGeben() {
		return wert;		
	}

	public void datenAusgeben() {
		System.out.println("["+wert+"]");

	}
}
