public class Kartenspiel {
	private Stack<Karte> kartenstapel;
	private int zaelher;
	
	public Kartenspiel() {
		kartenstapel = new Stack<Karte>();
		int zaehler = 0;
	}

	public void karteAufStapelLegen(Karte pKarte){
		kartenstapel.push(pKarte);
	}
	
 	public void karteVomStapelNehmen(Karte karte) {
 		kartenstapel.pop();
 		zaelher--;
 	}
 	
 	public void obersteKarteAusgeben() {
 		kartenstapel.top();
 	}
}
