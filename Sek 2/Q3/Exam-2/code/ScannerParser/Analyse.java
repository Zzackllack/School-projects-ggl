public class Analyse {
	private String eingabe;
	private Scanner scanner;
	private Parser parser;

	private List<Token> tokenliste;

	public Analyse(String pEingabe) {
		eingabe = pEingabe;
		tokenliste = new List<Token>();
		scanner = new Scanner(eingabe, tokenliste);
		parser = new Parser(tokenliste);
	}

	public void analysiere() {
		scanner.scanne();
		tokenliste.toFirst();
		//printTokenlist();
		if (scanner.getTokenliste() != null) {
			parser = new Parser(scanner.getTokenliste());
			if (parser.parse())
				System.out.println("Erfolgreiches Parsing");
			else
				System.out.println("Kein erfolgreiches Parsing");
		}
	}
	
	public void analysiere1() {
		scanner.scanne();
		List<Token> tokenliste = scanner.getTokenliste();
		if (tokenliste == null) {
			System.out.println("Leere Eingabe");
			return;
		}
		Parser parser = new Parser(scanner.getTokenliste());

		if (parser.parse()) {
			System.out.println("Erfolgreiches Parsing");
		} else {
			System.out.println("Kein erfolgreiches Parsing");
		}
	}
	
	private void printTokenlist() {
		while (tokenliste.hasAccess()) {
			System.out.println(tokenliste.getContent().getTyp());
			tokenliste.next();
		}
		tokenliste.toFirst();
	}

	public static void main(String[] args) {
		Analyse test = new Analyse("lalelu#");
		test.analysiere();
	}

}