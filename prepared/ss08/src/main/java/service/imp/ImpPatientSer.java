package service.imp;

import bean.MedicalRecord;
import repository.PatientRepo;
import repository.imp.ImpPatientRepo;
import service.PatientSer;
import validate.Validate;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImpPatientSer implements PatientSer {

    PatientRepo repo = new ImpPatientRepo();

    @Override
    public List<MedicalRecord> searchPatient(String name) {
        return repo.searchPatient(name);
    }

    @Override
    public List<MedicalRecord> listPatient() {
        return repo.listPatient();
    }

    @Override
    public Map<String, String> addPatient(MedicalRecord patient) throws SQLException {
        Map<String,String> mesMap = new HashMap<>();

        if(Validate.regexMedicalRecordId(patient.getId())){
            mesMap.put("mrMsg","Medical record should be BA-XXX (3 digit)");
        }
        if(Validate.regexPatientId(patient.getPatientDescription().getPatientDesId())){
            mesMap.put("pMsg","Patient ID should be BN-XXX (3 digit)");
        }
        if(Validate.regexName(patient.getPatientDescription().getPatientDesName())){
            mesMap.put("nameMsg","Name is not valid");
        }
        if(Validate.dateValid(patient.getDateIn())){
            mesMap.put("dateIMsg","invalid date structure - yyyy-mm-dd");
        }
        if(Validate.dateValid(patient.getDateOut())){
            mesMap.put("dateOMsg","invalid date structure - yyyy-mm-dd");
        }
        if(Validate.compareDate(patient.getDateIn(),patient.getDateOut())){
            mesMap.put("dateOMsg2","invalid date - hospitalize date should be earlier");
        }
        if(mesMap.isEmpty()){
            // Medical Record + Patient
            repo.addPatient(patient);
        }

        return mesMap;
    }

    @Override
    public boolean deletePatient(String id) throws SQLException {
        return repo.deletePatient(id);
    }

    @Override
    public Map<String, String> editPatient(MedicalRecord patient) throws SQLException {
        Map<String,String> mesMap = new HashMap<>();

        if(Validate.regexMedicalRecordId(patient.getId())){
            mesMap.put("mrMsg","Medical record should be BA-XXX (3 digit)");
        }
        if(Validate.regexPatientId(patient.getPatientDescription().getPatientDesId())){
            mesMap.put("pMsg","Patient ID should be BN-XXX (3 digit)");
        }
        if(Validate.regexName(patient.getPatientDescription().getPatientDesName())){
            mesMap.put("nameMsg","Name is not valid");
        }
        if(Validate.dateValid(patient.getDateIn())){
            mesMap.put("dateIMsg","invalid date structure - yyyy-mm-dd");
        }
        if(Validate.dateValid(patient.getDateOut())){
            mesMap.put("dateOMsg","invalid date structure - yyyy-mm-dd");
        }
        if(Validate.compareDate(patient.getDateIn(),patient.getDateOut())){
            mesMap.put("dateOMsg2","invalid date - hospitalize date should be earlier");
        }
        if(mesMap.isEmpty()){
            // Medical Record + Patient
            repo.editPatient(patient);
        }

        return mesMap;
    }

    @Override
    public MedicalRecord findPatientById(String id) {
        return repo.findPatientById(id);
    }
}
