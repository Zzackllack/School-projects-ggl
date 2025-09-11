public class Benutzerprofil implements ComparableContent<Benutzerprofil> {
    private String benutzername, pw;

    public Benutzerprofil(String pBenutzername, String pPw) {
        benutzername = pBenutzername;
        pw = pPw;
    }

    public String getBenutzername() {
        return benutzername;
    }

    @Override
    public boolean isGreater(Benutzerprofil pProfil) {
        return benutzername.compareTo(pProfil.benutzername) > 0;
    }

    @Override
    public boolean isLess(Benutzerprofil pProfil) {
        return benutzername.compareTo(pProfil.benutzername) < 0;
    }

    @Override
    public boolean isEqual(Benutzerprofil pProfil) {
        return benutzername.equals(pProfil.benutzername);
    }
}
