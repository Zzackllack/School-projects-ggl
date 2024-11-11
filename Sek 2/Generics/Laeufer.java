public class Laeufer {
    private String name;
    private int alter;
    private boolean laeufer;

    public Laeufer(String name, int alter, boolean laeufer) {
        this.name = name;
        this.alter = alter;
        this.laeufer = laeufer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isQuali() {
        return laeufer;
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
}
