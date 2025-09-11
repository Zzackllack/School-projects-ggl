public class Benutzerverwaltung{
    private BinarySearchTree<Benutzerprofil> benutzerBaum = new
    BinarySearchTree<Benutzerprofil>();
    public void neuenNutzerAnlegen(String pBenutzername, String pPw){
        Benutzerprofil b = new Benutzerprofil(pBenutzername, pPw);
        benutzerBaum.insert(b);
    }
}