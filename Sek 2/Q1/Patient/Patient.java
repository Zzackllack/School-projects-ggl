public class Patient {

    private int patientID;
    private String patientVorname;
    private String patientNachname;

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        if (patientID <= 0) {
            System.out.println("Fehler: Die PatientID darf nicht negativ oder 0 sein.");
        } else {
            this.patientID = patientID;
        }
    }

    public String getPatientVorname() {
        return patientVorname;
    }

    public void setPatientVorname(String patientVorname) {
        this.patientVorname = patientVorname;
    }

    public String getPatientNachname() {
        return patientNachname;
    }

    public void setPatientNachname(String patientNachname) {
        this.patientNachname = patientNachname;
    }
}