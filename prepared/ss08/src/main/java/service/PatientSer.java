package service;

import bean.MedicalRecord;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface PatientSer {
    public List<MedicalRecord> searchPatient(String name);

    public List<MedicalRecord> listPatient();

    public Map<String,String> addPatient(MedicalRecord patient) throws SQLException;
    public boolean deletePatient(String id) throws SQLException;
    public Map<String,String> editPatient(MedicalRecord patient) throws SQLException;

    public MedicalRecord findPatientById(String id);
}
