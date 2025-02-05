public class RekSuche {
    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5,6,7,8,9,10};
        BinaereSuche bs = new BinaereSuche();
        int links = 0;
        int rechts = arr.length - 1;
        int key = 5;
        boolean result = bs.binaereSucheRek(arr, links, rechts, key);
        System.out.println("Key found: " + result);
    }
}
