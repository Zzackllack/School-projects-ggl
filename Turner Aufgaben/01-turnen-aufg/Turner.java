import greenfoot.*;  // imports World, Actor, ...
import java.util.List;
import java.util.LinkedList;

/**
 * Die Klasse Turner enthält verschiedene Turnübungen, die der Turner ausführen kann.
 * 
 * @author  (volker lange) 
 * @version (dezember 2009)
 */

public class Turner extends Actor
{
    List rolleVorwaertsImg    = new LinkedList();
    List rolleRueckwaertsImg  = new LinkedList();
    List radImg               = new LinkedList();
    List ueberschlagImg       = new LinkedList();
    List uebungsTeil          = new LinkedList();
    int step=0;
    int uebungsTeilNr=1;

    public Turner()
    {
        this.rolleVorwaertsImg.add(new GreenfootImage("stand.png"));
        this.rolleVorwaertsImg.add(new GreenfootImage("rolle1.png"));
        this.rolleVorwaertsImg.add(new GreenfootImage("rolle2.png"));
        this.rolleVorwaertsImg.add(new GreenfootImage("rolle3.png"));
        this.rolleVorwaertsImg.add(new GreenfootImage("rolle4.png"));
        this.rolleVorwaertsImg.add(new GreenfootImage("rolle5.png"));
        this.rolleVorwaertsImg.add(new GreenfootImage("strecksprung2.png"));
        this.rolleVorwaertsImg.add(new GreenfootImage("stand.png"));
        this.rolleRueckwaertsImg.add(new GreenfootImage("stand.png"));
        this.rolleRueckwaertsImg.add(new GreenfootImage("rolleRw2.png"));
        this.rolleRueckwaertsImg.add(new GreenfootImage("rolleRw3.png"));
        this.rolleRueckwaertsImg.add(new GreenfootImage("rolleRw4.png"));
        this.rolleRueckwaertsImg.add(new GreenfootImage("rolleRw5.png"));
        this.rolleRueckwaertsImg.add(new GreenfootImage("rolleRw6.png"));
        this.rolleRueckwaertsImg.add(new GreenfootImage("rolleRw7.png"));
        this.rolleRueckwaertsImg.add(new GreenfootImage("stand.png"));
        this.radImg.add(new GreenfootImage("stand.png"));
        this.radImg.add(new GreenfootImage("rad1.png"));
        this.radImg.add(new GreenfootImage("rad2.png"));
        this.radImg.add(new GreenfootImage("rad3.png"));
        this.radImg.add(new GreenfootImage("rad4.png"));
        this.radImg.add(new GreenfootImage("rad5.png"));
        this.radImg.add(new GreenfootImage("rad6.png"));
        this.radImg.add(new GreenfootImage("stand.png"));
        this.ueberschlagImg.add(new GreenfootImage("stand.png"));
        this.ueberschlagImg.add(new GreenfootImage("ueberschlag1.png"));
        this.ueberschlagImg.add(new GreenfootImage("ueberschlag2.png"));
        this.ueberschlagImg.add(new GreenfootImage("ueberschlag3.png"));
        this.ueberschlagImg.add(new GreenfootImage("ueberschlag4.png"));
        this.ueberschlagImg.add(new GreenfootImage("ueberschlag5.png"));
        this.ueberschlagImg.add(new GreenfootImage("ueberschlag6.png"));
        this.ueberschlagImg.add(new GreenfootImage("stand.png"));
    }

   /**
    * Turnen der Vorwärtsrolle. 
    * Es muss übergeben werden, die wievielte Teilübung dieses Element in der Bodenkür ist
    */    
    public void rolleVorwaerts(int ueTeil)
    {
       if( this.uebungsTeilNr == ueTeil)
       {
         if( this.step < this.rolleVorwaertsImg.size() )
         {
           this.setImage( (GreenfootImage)this.rolleVorwaertsImg.get(this.step) );
           if( this.step<3 && this.step>0 )
             this.setLocation(this.getX()+10,this.getY());
           else if( this.step<6 && this.step>0 )
                  this.setLocation(this.getX()+30,this.getY());
           this.step++;
         }
         if( this.step == this.rolleVorwaertsImg.size() )
         {
           this.step=0;
           this.uebungsTeilNr++;
         } 
       }
    }

   /**
    * Turnen der Rückwärtsrolle. 
    * Es muss übergeben werden, die wievielte Teilübung dieses Element in der Bodenkür ist
    */    
    public void rolleRueckwaerts(int ueTeil)
    {
       if( this.uebungsTeilNr == ueTeil)
       {
         if( this.step < this.rolleRueckwaertsImg.size() )
         {
           this.setImage((GreenfootImage)this.rolleRueckwaertsImg.get(step));
           if( this.step==1 || this.step==2 || this.step==3 || this.step==4 || this.step==6) 
             this.setLocation(this.getX()-20,this.getY());
           else if( this.step==5 ) 
                  this.setLocation(this.getX()-40,this.getY());
           this.step++;
         }
         if( this.step == this.rolleVorwaertsImg.size() )
         {
           this.step=0;
           this.uebungsTeilNr++;
         }
       }
    }

   /**
    * Turnen des Rades. 
    * Es muss übergeben werden, die wievielte Teilübung dieses Element in der Bodenkür ist
    */    
    public void rad(int ueTeil)
    {
       if( this.uebungsTeilNr == ueTeil)
       {
         if( this.step < this.radImg.size() )
         {
           this.setImage((GreenfootImage)this.radImg.get(step));
           if( this.step>0 ) 
             this.setLocation(this.getX()+30,this.getY());
           this.step++;
         }
         if( this.step == this.radImg.size() )
         {
           this.step=0;
           this.uebungsTeilNr++;
         }
       }
    }

   /**
    * Turnen des Handstandüberschlags. 
    * Es muss übergeben werden, die wievielte Teilübung dieses Element in der Bodenkür ist
    */    
    public void ueberschlag(int ueTeil)
    {
       if( this.uebungsTeilNr == ueTeil)
       {
         if( this.step < this.ueberschlagImg.size() )
         {
           this.setImage((GreenfootImage)ueberschlagImg.get(step));
           if( this.step==7 || this.step==1 ) 
             this.setLocation(this.getX()+20,this.getY());
           else if( this.step>0 )
                  this.setLocation(this.getX()+40,this.getY());
           this.step++;
         }
         if( this.step == this.ueberschlagImg.size() )
         {
           this.step=0;
           this.uebungsTeilNr++;
         }
       }
    }

   /**
    * Beenden einer Turnübung. 
    * Es muss übergeben werden, die wievielte Teilübung dieses Element in der Bodenkür ist
    */    
    public void ende(int ueAnzahl)
    {
        if( this.uebungsTeilNr > ueAnzahl) 
        { Greenfoot.stop(); }
    }
}