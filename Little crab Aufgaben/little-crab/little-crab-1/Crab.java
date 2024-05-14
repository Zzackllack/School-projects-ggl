import greenfoot.*;  // imports Actor, World, ...

public class Crab extends Animal
{
    public void act()
    {
        this.move();
        if (canSee(Worm.class)) {
            eat(Worm.class);
        }
        if (Greenfoot.isKeyDown("k")) {
        turn(-10); // Linksdrehung um 10 Grad
        }
        if (Greenfoot.isKeyDown("l")) {
        turn(10); // Rechtsdrehung um 10 Grad
        }
    }        
}   