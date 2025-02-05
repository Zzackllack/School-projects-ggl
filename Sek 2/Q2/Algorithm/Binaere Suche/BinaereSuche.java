public class BinaereSuche {
	//Methode die einen Wahrheitswert zur?kgibt und die Parameter integer Array einen integer links, sowie einen integer rechts und einen integer key bekommt 
	public boolean binaereSucheRek(int[] arr, int links, int rechts, int key){
		// Abfrage ob der Ganzahlwert links gr鲞er als der wert "rechts" ist; sollte dies der Fall sein, wird der Wahrheitswert falsch zur?kgeliefert 
		if (links > rechts) return false;
		// Eine neue Variable "mitte" wird dem Wert der Variabel rechts + links durch 2 zugeordnet
		int mitte = (rechts + links)/2;
		// ?erpr?ung des Keys/Schl?sels mit dem Wert an der Position "mitte" des Arrays, falls der Vergleich gl?kt wird der Wahrheitswert "true" zur?kgeliefert
		if (key == arr[mitte]) return true;
		// Ansonsten wird ?erpr?t, ob der Schl?sel kleiner als der Wert an der Position "mitte" des Arrays ist 
		else if (key < arr[mitte]){
			// Wenn dies der Fall ist, dann wird der Rekursive Teil dieser Methode aufgerufen, indem sie sich selber aufruft aber andere Parameter ?ergibt, bspw. die Variabel mitte - 1 als ?ergabeparameter rechts ?ergeben. 
			return binaereSucheRek(arr, links, mitte-1, key);
		}else{
			// Hier wird ebenso die Methode selbst erneut aufgerufen, indem sie diesmal die Variabel mitte mit 1 addiert als Variabel links ?ergibt
			return binaereSucheRek(arr, mitte+1, rechts, key);
		}
	}
	
}
