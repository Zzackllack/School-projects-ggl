/**
 *
 * Description
 *
 * @version 1.0 from 21.05.2024
 * @author 
 */

public class Fahrzeug {
  
  // start attributes
  private int speed;
  private int tank;
  private int maxSpeed;
  private int maxTank;
  // end attributes
  
  public Fahrzeug(int speed, int tank, int maxSpeed, int maxTank) {
    this.speed = speed;
    this.tank = tank;
    this.maxSpeed = maxSpeed;
    this.maxTank = maxTank;
  }

  // start methods
  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speedNew) {
    speed = speedNew;
  }

  public int getTank() {
    return tank;
  }

  public void setTank(int tankNew) {
    tank = tankNew;
  }

  public int getMaxSpeed() {
    return maxSpeed;
  }

  public void setMaxSpeed(int maxSpeedNew) {
    maxSpeed = maxSpeedNew;
  }

  public int getMaxTank() {
    return maxTank;
  }

  public void setMaxTank(int maxTankNew) {
    maxTank = maxTankNew;
  }

  // end methods
} // end of Fahrzeug
