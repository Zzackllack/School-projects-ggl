public class Token {
	
	private String wert;
	private String typ;
	
	public Token(String pTyp, String pWert) {
		typ = pTyp;
		wert = pWert;				
	}
	
	public String getWert() {
		return wert;
	}
	
	
	public String getTyp() {
		return typ;
	}
	

}
