public class Kartenspiel {
    private Stack<Karte> stapel;

    public Kartenspiel(){
        stapel = new Stack<>();
    }

    public void karteAufStapelLegen(Karte karte){
        if(karte != null){
            stapel.push(karte);
        } else {
            System.out.println("Die Karte darf nicht null sein.");
        }
    }

    public void karteVomStapelNehmen(){
        if(!stapel.isEmpty()){
            stapel.pop();
        }
    }

    public void obersteKarteAusgeben(){
        if(!stapel.isEmpty()){
            Karte obersteKarte = stapel.top();
            System.out.println("Oberste Karte, mit Wert: " + obersteKarte.getWert() + " und Farbe: " + obersteKarte.getFarbe());
        } else { 
            System.out.println("Der Stapel ist leer.");

        }
    }
}
