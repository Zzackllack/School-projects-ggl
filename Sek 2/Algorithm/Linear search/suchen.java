public class suchen {
    private List<Integer> liste;

    public suchen(List<Integer> liste){
        this.liste = liste;
    }

    public boolean lineareSuche(int i)
    {
        boolean gefunden = false;
        liste.toFirst();
        while(liste.hasAccess() && gefunden == false){
            if (liste.getContent() == i){
                gefunden = true;
            }
            liste.next();
        }
    return gefunden;
    }
    
}
