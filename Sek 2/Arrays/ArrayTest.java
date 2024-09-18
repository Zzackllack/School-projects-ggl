public class ArrayTest {
    public static void main(String[] args) {
        String[] namen  = {"Nikolas", "Daniel", "Henrik"};
        System.out.println(namen);

        for (int i = 0; i < namen.length; i++) {
            System.out.println(namen[i]);
        }

        for (String name : namen) {
            System.out.println(name);
        }
    }
}
