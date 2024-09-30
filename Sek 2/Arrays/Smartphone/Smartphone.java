
public class Smartphone {
	
	private String hersteller;
	private String modell;
	private int speicher;
	
	public Smartphone (String hersteller, String modell, int speicher){
		this.hersteller = hersteller;
		this.modell =  modell;
		this.speicher = speicher;
	}
	
	public String getHersteller() {
		return hersteller;
		
	}
	
	public String getModell(){
		return modell;
	}
	
	public int getSpeicher() {
		return speicher;
	}

	
	public static void main(String[] args) {
	}

}
