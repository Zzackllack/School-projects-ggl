import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Landstraae here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Landstrasse extends World
{

    /**
     * Constructor for objects of class Landstraae.
     * 
     */
   private int spuranzahl = 2;

    /**
     * Constructor for objects of class Autobahn.
     */
    public Landstrasse()
    {    
        // Create a new world with 800x200 cells with a cell size of 1x1 pixels.
        super(800, 400, 1); 
        this.populateWorld();
    }

    /**
     * Create the objects for the start of the game.
     */
    private void populateWorld()
    {
        this.addObject(new Auto() ,      170, 130);
        this.addObject(new Dashboard() ,  80, 320);
        this.addObject(new Dashboard() , 240, 320);
        this.addObject(new Dashboard() , 400, 320);
        this.addObject(new Dashboard() , 560, 320);
        this.addObject(new Dashboard() , 720, 320);
    }

    public int getSpuranzahl()
    {
        return this.spuranzahl;
    }
}
