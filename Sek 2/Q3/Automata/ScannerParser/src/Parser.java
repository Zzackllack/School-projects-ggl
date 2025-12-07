// Diese Klasse wird in der Klausur abgefragt, scanner nicht, also nicht direkt code schreiben aber trotzdem kennen.
public class Parser {
	private static final String TOKENTYP_ENDE = "ENDE";
	private static final String TOKENTYP_EGAL = "EGAL";
	boolean istFehler;
	List<Token> tokenliste;
	Token aktuellesToken;

	public Parser(List<Token> pTokenliste) {
		istFehler = false;
		tokenliste = pTokenliste;
		tokenliste.toFirst();
		aktuellesToken = tokenliste.getContent();
	}

	private Token nextToken() {
		tokenliste.next();
		return tokenliste.getContent();
	}

	// Klausurrelevant
	public boolean parse() {
		if (tokenliste.hasAccess() && pruefeS())
			return true;
		else
			return false;
	}
	
	// Klausurrelevant
	public boolean parse_1() {
		return tokenliste.hasAccess() && pruefeS();		
	}
	
	// Klausurrelevant
	public boolean pruefeS_1() {
		if(!tokenliste.hasAccess()){
			return false;
		}
		String tokenTyp = aktuellesToken.getTyp();
		if (TOKENTYP_EGAL.equals(tokenTyp) || TOKENTYP_ENDE.equals(tokenTyp)) {
			aktuellesToken = nextToken();
			return pruefeA();
		} else {
			return false;
		}
	}

	// Klausurrelevant
	public boolean pruefeS() {
		if (tokenliste.hasAccess() && (aktuellesToken.getTyp() == TOKENTYP_EGAL || aktuellesToken.getTyp() == TOKENTYP_ENDE)) {
			aktuellesToken = nextToken();
			return pruefeA();
		} else
			return false;
	}

	// Klausurrelevant
	public boolean pruefeA() {
		if (tokenliste.hasAccess() && (aktuellesToken.getTyp() == TOKENTYP_EGAL || aktuellesToken.getTyp() == TOKENTYP_ENDE)) {
			aktuellesToken = nextToken();
			return pruefeB();
		} else^
			return false;
	}

	// Klausurrelevant
	public boolean pruefeB() {		
		if (tokenliste.hasAccess() && aktuellesToken.getTyp() == TOKENTYP_ENDE) {
			return true;
		} else
			return false;
	}
}