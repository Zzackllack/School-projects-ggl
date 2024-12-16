public class Fibonacci_Iterativ {

    //Der Unterschied zur rekursiven Methode besteht darin, dass die iterative Methode eine Schleife verwendet, um die Fibonacci-Zahlen zu berechnen, während die rekursive Methode sich selbst aufruft, um die Berechnungen durchzuführen. Die iterative Methode ist in der Regel effizienter, da sie weniger Speicherplatz benötigt und keine zusätzlichen Funktionsaufrufe erzeugt.

    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        Fibonacci_Iterativ f = new Fibonacci_Iterativ();
        System.out.println(f.fibonacci(10));
    }
}
