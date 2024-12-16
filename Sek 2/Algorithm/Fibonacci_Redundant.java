public class Fibonacci_Redundant {
    
    public int fibonacci(int n) {
        if(n==0) {
            return 0;
        }
        if(n==1) {
            return 1;
        }
        else {
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }

    public static void main(String[] args) {
        Fibonacci_Redundant f = new Fibonacci_Redundant(); 
        System.out.println(f.fibonacci(10));

    }
}