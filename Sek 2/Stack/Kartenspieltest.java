public class Kartenspieltest {
	public static void main(String[]args) {
		Kartenspiel spielderkarten = new Kartenspiel();
		
		Karte karte1 = new Karte();
		Karte karte2 = new Karte();
		karte1.setKartenaufgedeckt(true);
		karte1.setMuster("karo");
		karte2.setKartenaufgedeckt(true);
		karte2.setMuster("Piek");
		
		spielderkarten.karteAufStapelLegen(karte2);
		spielderkarten.karteVomStapelNehmen(karte1);
	}
}
