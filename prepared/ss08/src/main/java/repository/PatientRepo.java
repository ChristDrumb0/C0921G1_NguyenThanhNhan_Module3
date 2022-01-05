package repository;

import bean.MedicalRecord;
import bean.PatientDescription;

import java.sql.SQLException;
import java.util.List;

public interface PatientRepo {

    public List<MedicalRecord> searchPatient(String something);

    public List<MedicalRecord> listPatient();

    public void addPatient(MedicalRecord customer) throws SQLException;
    public boolean deletePatient(String id) throws SQLException;
    public boolean editPatient(MedicalRecord customer) throws SQLException;
    public List<PatientDescription> selectPatientDescription();
    public MedicalRecord findPatientById(String id);

}
