import java.util.ArrayList;
import java.util.List;

public class NewStyleListWithGenerics {
	public static void main(String[] args) {
		final List <Laeufer> laeuferList = new ArrayList <Laeufer>();
		laeuferList.add(new Laeufer("Max", 44, true));
		laeuferList.add(new Laeufer("Moritz", 42, true));
		laeuferList.add(new Laeufer("Ingo", 64, false));
		laeuferList.add(new Dog("I am a dog, not a runner!!!"));
		
		for(int i = 0; i < laeuferList.size(); i++) {
			Laeufer laeufer = (Laeufer) laeuferList.get(i);
			System.out.println(laeufer.getName() + " ist qualifiziert: " + laeufer.isQuali());
		}
	}
}
}
