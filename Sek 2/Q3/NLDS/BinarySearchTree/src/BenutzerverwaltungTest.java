public class BenutzerverwaltungTest {

    public static void main(String[] args) {
        Benutzerverwaltung verwaltung = new Benutzerverwaltung();

        // Nutzer anlegen
        verwaltung.neuenNutzerAnlegen("alice", "pw1");
        verwaltung.neuenNutzerAnlegen("bob", "pw2");
        verwaltung.neuenNutzerAnlegen("carol", "pw3");

        // Vorhandensein prüfen
        System.out.println("bob vorhanden? " + verwaltung.profilVorhanden("bob")); // true
        System.out.println("dave vorhanden? " + verwaltung.profilVorhanden("dave")); // false

        // Duplikat einfügen (soll nichts ändern)
        verwaltung.neuenNutzerAnlegen("alice", "anderesPw");
        System.out.println("alice vorhanden (nach Duplikat)? " + verwaltung.profilVorhanden("alice")); // true

        // Nutzer löschen
        verwaltung.nutzerLoeschen("bob", "irgendeinPw");
        System.out.println("bob vorhanden (nach Löschen)? " + verwaltung.profilVorhanden("bob")); // false
    }
}

