public class Token {
	
	private String wert;
	private String typ;

	public Token(String pTyp, String pWert) {
		typ = pTyp;
		wert = pWert;
	}

	public String getTyp() {
		return typ;
	}

	
	public String getWert() {
		return wert;
	}

	
}