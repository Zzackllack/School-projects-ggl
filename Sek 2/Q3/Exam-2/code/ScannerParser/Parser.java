public class Parser {
	private static final String TOKENTYP_ENDE = "ENDE";
	private static final String TOKENTYP_EGAL = "EGAL";
	private List<Token> tokenliste;
	private Token aktuellesToken;

	public Parser(List<Token> pTokenliste) {
		tokenliste = pTokenliste;
		tokenliste.toFirst();
		aktuellesToken = tokenliste.getContent();
	}

	private Token nextToken() {
		tokenliste.next();
		return tokenliste.getContent();
	}

	public boolean parse() {
		return tokenliste.hasAccess() && pruefeS();		
	}

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

	public boolean pruefeS() {
		String tokenTyp = aktuellesToken.getTyp();
		if (tokenliste.hasAccess() && (TOKENTYP_EGAL.equals(tokenTyp) || TOKENTYP_ENDE.equals(tokenTyp))) {
			aktuellesToken = nextToken();
			return pruefeA();
		} else
			return false;
	}


	public boolean pruefeA() {
		String tokenTyp = aktuellesToken.getTyp();
		if (tokenliste.hasAccess() && (TOKENTYP_EGAL.equals(tokenTyp) || TOKENTYP_ENDE.equals(tokenTyp))) {
			aktuellesToken = nextToken();
			return pruefeB();
		} else
			return false;
	}

	public boolean pruefeB() {	
		String tokenTyp = aktuellesToken.getTyp();
		return tokenliste.hasAccess() && TOKENTYP_ENDE.equals(tokenTyp); 
	}


}

