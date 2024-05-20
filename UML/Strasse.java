/**
 *
 * Description
 *
 * @version 1.0 from 21.05.2024
 * @author 
 */

public class Strasse {
  
  public static void main(String[] args)
  {
         Lehrkraft cool = new Lehrkraft("cool", 33);
         cool.autoKaufen(new Auto("mercedes", 50, 280, 20, 70));
         cool.print();
  }
} // end of Strasse
