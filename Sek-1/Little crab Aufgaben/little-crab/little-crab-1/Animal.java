import greenfoot.*;  // imports Actor, World, ...


public class Animal extends Actor
{
    private static final double WALKING_SPEED = 5.0;
    
    public void act()
    {
    }


    /**
     * Bewegt sich geradeaus (in der derzeitigen Richtung).
     */
    public void move()
    {
        double angle = Math.toRadians( this.getRotation() );
        int x = (int) Math.round(getX() + Math.cos(angle) * this.WALKING_SPEED);
        int y = (int) Math.round(getY() + Math.sin(angle) * this.WALKING_SPEED);

        this.setLocation(x, y);
    }


    /**
     * Ändert die Richtung um den angegebenen Winkel im Uhrzeigersinn.
     */
    public void turn(int angle)
    {
        this.setRotation( this.getRotation() + angle );
    }

    
    /**
     * Ändert die Richtung zufällig.
     */
    public void randomTurn()
    {
        if( Greenfoot.getRandomNumber(10)<2 )
        {
           this.turn( Greenfoot.getRandomNumber(50)-25 );
        }
    }

    
    /**
     * Testet, ob das Tier sich am Rand der Welt befindet (Rückgabe "true", wenn das der Fall ist).
     */
    public boolean atWorldEdge()
    {
        if( this.getX() < 20 || this.getX() > getWorld().getWidth() - 20 )
        {
            return true;
        }
        if( this.getY() < 20 || this.getY() > getWorld().getHeight()- 20 )
        {
            return true;
        }
        else
            return false;
    }
    
    
    /**
     * Gibt "true" zurück, wenn ein Tier der angegebenen Klasse zu sehen ist, und "false", wenn nicht. 
     */
    public boolean canSee(Class klasse)
    {
        Actor actor = this.getOneObjectAtOffset(0, 0, klasse);
        return actor != null;        
    }

    
    /**
     * Frisst ein Tier der angegebenen Klasse.
     */
    public void eat(Class klasse)
    {
        Actor actor = this.getOneObjectAtOffset(0, 0, klasse);
        if( actor != null ) 
        {
            this.getWorld().removeObject(actor);
            Greenfoot.playSound("slurp.wav");
        }
    }

    
    /**
     * Stoppt die Simulation (das Spiel).
     */
    public void stopGame()
    {
        Greenfoot.playSound("au.wav");
        Greenfoot.delay(300);
        Greenfoot.stop();
    }
}
