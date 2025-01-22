public class PatientenWarteschlange {

    private Patient[] warteschlange;
    private int anzahlPatienten;

    public PatientenWarteschlange() {
        warteschlange = new Patient[30];
        anzahlPatienten = 0;
    }

    public void hintenAnstellen(Patient patient) {
        if (anzahlPatienten < warteschlange.length) {
            warteschlange[anzahlPatienten] = patient;
            anzahlPatienten++;
        } else {
            System.out.println("Warteschlange ist voll.");
        }
    }

    public void patientAbfertigen() {
        if (anzahlPatienten > 0) {
            for (int i = 0; i < anzahlPatienten - 1; i++) {
                warteschlange[i] = warteschlange[i + 1];
            }
            warteschlange[anzahlPatienten - 1] = null;
            anzahlPatienten--;
        } else {
            System.out.println("Warteschlange ist leer.");
        }
    }

    public void patientenAusgeben() {
        for (int i = 0; i < anzahlPatienten; i++) {
            System.out.println("Patient " + (i + 1) + ":");
            System.out.println("ID: " + warteschlange[i].getPatientID());
            System.out.println("Vorname: " + warteschlange[i].getPatientVorname());
            System.out.println("Nachname: " + warteschlange[i].getPatientNachname());
        }
    }
}