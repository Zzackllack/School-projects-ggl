public class EigenesBeispiel {

    public static int lineareSuche(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i; // Gibt den Index des gefundenen Elements zurück
            }
        }
        return -1; // Gibt -1 zurück, wenn das Element nicht gefunden wird
    }

    public static void main(String[] args) {
        int[] zahlen = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int key = 50;

        int ergebnis = lineareSuche(zahlen, key);

        if (ergebnis != -1) {
            System.out.println("Element " + key + " gefunden an Index: " + ergebnis);
        } else {
            System.out.println("Element " + key + " nicht im Array gefunden.");
        }
    }
}
