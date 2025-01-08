
public class suchenoptimiert {
    private java.util.ArrayList<Integer> liste;

    public suchenoptimiert() {
        liste = new java.util.ArrayList<>();
    }

    public boolean lineareSuche(int i)
    {
        return liste.contains(i);
    }

    public void add(int i){
        liste.add(i);
    }

    public static void main(String[] args) {
        suchenoptimiert s = new suchenoptimiert();
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
