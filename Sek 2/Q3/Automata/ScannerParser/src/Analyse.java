public class Analyse {
	private String eingabe;
	private Scanner scanner;
	private Parser parser;

	List<Token> tokenliste;

	public Analyse(String pEingabe) {
		eingabe = pEingabe;
		tokenliste = new List<Token>();
		scanner = new Scanner(eingabe, tokenliste);
		parser = new Parser(tokenliste);
	}

	public void analysiere() {
		scanner.scanne();
		if (scanner.getTokenliste() != null) {
			parser = new Parser(scanner.getTokenliste());
			if (parser.parse())
				System.out.println("Erfolgreiches Parsing");
			else
				System.out.println("kein erfolgreiches Parsing");
		}
	}
	
	public static void main ( String [] args) {
		
		Analyse test = new Analyse("lalele");
		test.analysiere();
		
		
	}
	
}