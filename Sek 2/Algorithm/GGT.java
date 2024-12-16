public class GGT {
	
	public int ggT(int a, int b) {
		if(a==b) {
			return a;
		}
		if(a<b) {
			return b-a; 
		}
		if(a>b) {
			return a-b;
		}
		else {
			return ggT(a,b-a);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}