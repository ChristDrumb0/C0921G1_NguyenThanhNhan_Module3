package bean;

public class MedicalRecord {
    String id;
    PatientDescription patientDescription;
    String dateIn;
    String dateOut;
    String reason;

    public MedicalRecord() {
    }

    public MedicalRecord(String id, PatientDescription patientDescription, String dateIn, String dateOut, String reason) {
        this.id = id;
        this.patientDescription = patientDescription;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.reason = reason;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PatientDescription getPatientDescription() {
        return patientDescription;
    }

    public void setPatientDescription(PatientDescription patientDescription) {
        this.patientDescription = patientDescription;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
