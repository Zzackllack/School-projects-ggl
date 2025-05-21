import greenfoot.*;  // imports World, Actor, ...

/**
 * @author  (volker lange) 
 * @version (dezember 2009)
 */

public class Mattenbahn  extends World
{
   /**
    * Constructor for objects of class "Mattenbahn".
    * 
    */
    public Mattenbahn()
    {    
        // Create a new world with 1x1 cells with a cell size of 1000x400 pixels.
        super(1000, 400, 1); 
        this.populateWorld();
    }

   /**
    * Create the objects for the start.
    */
    public void populateWorld()
    {
        this.addObject(new Bodenturner(), 150, 250);
    }
}