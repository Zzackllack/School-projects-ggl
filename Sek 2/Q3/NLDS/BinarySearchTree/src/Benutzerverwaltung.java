public class Benutzerverwaltung{

    private BinarySearchTree<Benutzerprofil> benutzerBaum = new
    BinarySearchTree<Benutzerprofil>();
    public void neuenNutzerAnlegen(String pBenutzername, String pPw){
        Benutzerprofil b = new Benutzerprofil(pBenutzername, pPw);
        benutzerBaum.insert(b);
    }

    public void nutzerLoeschen(String pBenutzername, String pPw){//TODO}
    }

    public boolean profilVorhanden(String pBenutzername){
        Benutzerprofil b = new Benutzerprofil(pBenutzername, "");
        return benutzerBaum.contains(b);
    }
    
}