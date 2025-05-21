class Lehrkraft extends Person
{ 
  private Auto auto;
  
  public Lehrkraft(String name, int alter)
  {
    super(alter, name);
    this.auto = null;
  }
  
  public void autoKaufen(Auto auto)
  {
    this.auto = auto;
  }
  
  public Auto autoVerkaufen()
  {
    Auto temp = this.auto;
    this.auto = null;
    return temp;
  }
  
  public void print()
  {
    if (this.auto != null) {
      System.out.println("Die Lehrkraft mit dem Namen " + getName() + " ist " + getAlter() + " Jahre alt, sie fährt ein Auto von der Marke " + this.auto.getMarke() + " sie fährt das Auto mit einer Geschwindigkeit von " + this.auto.getSpeed() + " km/h, ihr Auto hat ein Tankinhalt von " + this.auto.getTank() + " Litern, und einem maximalen Tankvolumen von " + this.auto.getMaxTank() + " Litern und eine Höchstgeschwindigkeit von " + this.auto.getMaxSpeed() + " km/h.");
    } else {
      System.out.println("Die Lehrkraft " + getName() + " ist " + getAlter() + " Jahre alt und fährt kein Auto.");
    }
  }
}
