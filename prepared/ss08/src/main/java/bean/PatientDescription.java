package bean;

public class PatientDescription {
    String patientDesId;
    String patientDesName;

    public PatientDescription() {
    }

    public PatientDescription(String patientDesId) {
        this.patientDesId = patientDesId;
    }

    public PatientDescription(String patientId, String patientName) {
        this.patientDesId = patientId;
        this.patientDesName = patientName;
    }

    public String getPatientDesId() {
        return patientDesId;
    }

    public void setPatientDesId(String patientDesId) {
        this.patientDesId = patientDesId;
    }

    public String getPatientDesName() {
        return patientDesName;
    }

    public void setPatientDesName(String patientDesName) {
        this.patientDesName = patientDesName;
    }
}
