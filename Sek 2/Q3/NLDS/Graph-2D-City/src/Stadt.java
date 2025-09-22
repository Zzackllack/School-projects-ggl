public class Stadt {
    private boolean markiert;
    private String provinz;
    private String name;


    public boolean isMarkiert() {
        return markiert;
    }
    public void setMarkiert(boolean markiert) {
        this.markiert = markiert;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getProvinz() {
        return provinz;
    }
    public void setProvinz(String provinz) {
        this.provinz = provinz;
    }
}