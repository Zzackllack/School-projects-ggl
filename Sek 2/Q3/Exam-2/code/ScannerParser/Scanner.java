public class Scanner {
	private boolean istFehler;
	private Token aktuellesToken;
	private String eingabe;
	private List<Token> tokenliste;

	public Scanner(String pEingabe, List<Token> pTokenliste) {
		eingabe = pEingabe + "#";
		tokenliste = pTokenliste;
		tokenliste.toFirst();
		istFehler = false;
	}

	public void scanne() {
		char erster, zweiter;
		int pos = 0;
		while (eingabe.charAt(pos) != '#') {
			erster = eingabe.charAt(pos);
			zweiter = eingabe.charAt(pos + 1);
			if (erster == 'l' && zweiter == 'a') {
				aktuellesToken = new Token("EGAL", "la");
			} else if (erster == 'l' && zweiter == 'e') {
				aktuellesToken = new Token("EGAL", "le");
			} else if (erster == 'l' && zweiter == 'u') {
				aktuellesToken = new Token("ENDE", "lu");
			} else {
				istFehler = true;
				break;
			}
			pos = pos + 2;
			tokenliste.append(aktuellesToken);
		}
		ausgabe(istFehler);
	}

	private void ausgabe(boolean pFehler) {
		tokenliste.toFirst();
		if (pFehler == true || tokenliste.getContent() == null) {
			System.out.println("Lexikalische Analyse abgebrochen");
		} else {
			System.out.println("Lexikalische erfolgreich");
		}
	}

	public List<Token> getTokenliste() {
		if (istFehler == false) {
			return tokenliste;
		} else
			return null;
	}
}
