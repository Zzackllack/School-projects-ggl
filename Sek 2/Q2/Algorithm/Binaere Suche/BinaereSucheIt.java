public class BinaereSucheIt {

    public boolean binaereSucheIter(int[] arr, int i) {
        int links = 0, mitte, rechts = arr.length - 1;

        while (links <= rechts) {
            mitte = (links + rechts) / 2;

            if (arr[mitte] == i) {
                return true;
            }

            if (arr[mitte] < i) {
                links = mitte + 1;
            } else {
                rechts = mitte - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        BinaereSucheIt suche = new BinaereSucheIt();
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int i = 7;

        boolean result = suche.binaereSucheIter(arr, i);
        System.out.println("Element " + i + " gefunden: " + result);
    }
}