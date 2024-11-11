public class Laeufer {
    private String name;
	private int alter;
	private boolean laeufer;

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public void setName(String name) {
		 this.name = name;
	}

	public boolean isQuali() {
		if(laeufer == true) {
			return true;
		}
		else {
			return false;
		}
	}

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}

	public boolean isLaeufer() {
		return laeufer;
	}

	public void setLaeufer(boolean laeufer) {
		this.laeufer = laeufer;
	}

	public Laeufer(String name, int alter, boolean laeufer) {
		// TODO Auto-generated constructor stub
	}
}
