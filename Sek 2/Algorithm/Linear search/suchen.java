public class suchen {
    private List<Integer> liste;

    public suchen() {
        liste = new List<>();
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

    public void add(int i){
        liste.append(i);
    }

    public static void main(String[] args) {
        suchen s = new suchen();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        s.add(5);
        s.add(6);
        s.add(7);
        s.add(8);
        s.add(9);
        s.add(10);
        System.out.println(s.lineareSuche(5));
        System.out.println(s.lineareSuche(11));
    }

}
