/**
 *
 * Description
 *
 * @version 1.0 from 21.05.2024
 * @author 
 */

public class Auto extends Fahrzeug {
  
  private String marke;
  
  public Auto(String marke, int speed, int maxSpeed, int tank, int maxTank) {
    super(speed, tank, maxSpeed, maxTank);
    this.marke = marke;
  }

  public String getMarke() {
    return marke;
  }

  public void setMarke(String marke) {
    this.marke = marke;
  }
}
