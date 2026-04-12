public class Umgekehrt {
    private Stack<Integer> stack;

    public void Umgekeht() {
        stack = new Stack<>();
    }

    public void eingabe(int pEingabe ){
        stack.push(pEingabe);
    }

    public void ausgabe_zahlenfolge() {
        while (!stack.isEmpty()) {
            System.out.println("Ausgabe Stack ist: " + stack.top());
            stack.pop();
        }
    }
    
    public static void main(String[] args) {
        Umgekehrt u = new Umgekehrt();
        u.eingabe(2);
        u.eingabe(3);
        u.eingabe(4);
        u.ausgabe_zahlenfolge();
    }
}
