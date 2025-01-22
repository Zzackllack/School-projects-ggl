public class Testablauf {

    public static void patientenAttributeSetzen() {
        Patient patient1 = new Patient();
        patient1.setPatientID(1);
        patient1.setPatientVorname("Max");
        patient1.setPatientNachname("Mustermann");

        Patient patient2 = new Patient();
        patient2.setPatientID(2);
        patient2.setPatientVorname("Erika");
        patient2.setPatientNachname("Musterfrau");

        Patient patient3 = new Patient();
        patient3.setPatientID(3);
        patient3.setPatientVorname("Peter");
        patient3.setPatientNachname("Lustig");

        Patient patient4 = new Patient();
        patient4.setPatientID(4);
        patient4.setPatientVorname("Sabine");
        patient4.setPatientNachname("Traurig");
    }

    public static void ablaufen() {
        PatientenWarteschlange warteschlange = new PatientenWarteschlange();

        Patient patient1 = new Patient();
        patient1.setPatientID(1);
        patient1.setPatientVorname("Max");
        patient1.setPatientNachname("Mustermann");

        Patient patient2 = new Patient();
        patient2.setPatientID(2);
        patient2.setPatientVorname("Erika");
        patient2.setPatientNachname("Musterfrau");


        warteschlange.hintenAnstellen(patient1);
        warteschlange.hintenAnstellen(patient2);

        warteschlange.patientAbfertigen();
        warteschlange.patientenAusgeben();
    }

    public static void main(String[] args) {
        patientenAttributeSetzen();
        ablaufen();
    }
}
