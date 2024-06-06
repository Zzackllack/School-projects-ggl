import greenfoot.*;  
import java.util.*;

public class Auto extends Actor
{
    // Eigenschaften des Autos
    private int nummer;
    private int verbrauch;
    private int tankinhalt;
    private int tankvolumen;
    private int kilometerstand;

    // Hilfsvariablen
    private boolean einmalig  = true;
    private boolean tankpause = false;
    private boolean tankleer = false;

    // Variable für die Landstrasse, auf der sich das Auto befindet 
    private Landstrasse street;
    // Liste für Tankanzeigen
    private List<Zeiger> tankanzeigen;
    // ein Zeiger für die aktuelle Tankanzeige
    private Zeiger aktZeiger;

    // Konstruktor
    public Auto()
    {
        this.tankinhalt = 20;
        this.tankvolumen = 60;
        this.verbrauch = 8;
        this.kilometerstand = 0;
    }

    public void act() 
    {
        if(einmalig)
        {
            street = (Landstrasse)getWorld();
            street.addObject(new Basis(), 50, 350);
            street.addObject(new Zeiger(),50, 355);
            street.addObject(new Button(),90, 350);
            
            Greenfoot.delay(100);
            this.tankanzeigen = street.getObjects(Zeiger.class);
            this.aktZeiger    = tankanzeigen.get(0);
            this.einmalig     = false;
        }

        fahren();
        
        if(this.tankpause)
        {
            this.autoAnhalten(300);
        }

        if (Greenfoot.isKeyDown("space")) {
            tanken();
        }
    }    

    public void fahren()
    {
        // Prüfen, ob der Tank leer ist
        if (tankinhalt <= 0) {
            return; // Auto bleibt stehen
        }

        int aktX = this.getX() + 1;
        if (aktX > 780)
        {
            aktX -= 760;
        }
        this.setLocation(aktX, this.getY());
        
        if (aktX % 8 == 0)
        {
            this.kilometerstand++;
        }

        if (kilometerstand % 100 == 0) {  // Verbrauch alle 100 km
            tankinhalt -= verbrauch;
            if (tankinhalt < 0) {
                tankinhalt = 0;
                tankleer = true;
                tankpause = true;
            }
        }

        if (aktZeiger != null) {
            aktZeiger.setLocation(aktZeiger.getX(), berechneZeigerY());
        }
    }
    
    public void tanken()
    {
        if(!this.tankpause)
        {
            if(this.aktZeiger.getY() > 310)
            {
                this.tankinhalt += 5;
                if (this.tankinhalt > this.tankvolumen) {
                    this.tankinhalt = this.tankvolumen;
                }
                aktZeiger.setLocation(aktZeiger.getX(), berechneZeigerY());
                this.tankleer = false;
                this.tankpause = true;
            }
        }
    }
    
    public int berechneZeigerY()
    {
        int yPosition = 355 + (int)(80 * (1 - (double)this.tankinhalt / this.tankvolumen));
        return yPosition;
    }
    
    public void autoAnhalten(int millisekunden)
    {
        int stopTime = millisekunden / 10;  // Annahme: 10 ms pro Act-Schritt
        for (int i = 0; i < stopTime; i++) {
            Greenfoot.delay(1);  // Halte das Auto an
        }
        tankpause = false;  // Nach der Pause weiterfahren
    }
}
