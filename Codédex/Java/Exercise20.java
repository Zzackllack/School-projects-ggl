public class Exercise20 {
    public static void main(String[] args) {
        for(int i = 0;i<=52; i++){
            if (i==32){
                System.out.println("An incorrect card was found in item " + i);
                break;
            } else  {
                System.out.println("Card " + i);
            }
        }
        
    }
}
