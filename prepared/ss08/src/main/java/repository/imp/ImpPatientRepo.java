package repository.imp;

import bean.MedicalRecord;
import bean.PatientDescription;
import repository.ConnectionSQL;
import repository.PatientRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImpPatientRepo implements PatientRepo {

    private static final String SELECT_PATIENT_DESCRIPTION = "select * FROM patient_description";
    private static final String SELECT_TO_SHOW_ALL = "select p.id,p.patient_id,pd.`name`,p.date_in,p.date_out,p.reason,p.is_delete FROM patient p right join patient_description pd on pd.id = p.patient_id;";
//    private static final String INSERT_PATIENT_SQL = " INSERT INTO medRecordtomer (`name`,dob,gender,personal_id,phone,email,address,medRecordtomer_type_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String INSERT_PATIENT_SQL = " {call insert_patient(?,?,?,?,?,?,?)}; ";
    private static final String SELECT_PATIENT_BY_ID = " select p.id,p.patient_id,pd.`name`,p.date_in,p.date_out,p.reason,p.is_delete FROM patient p right join patient_description pd on pd.id = p.patient_id where p.id = ? ; ";
    private static final String UPDATE_PATIENT_SQL = " update patient p set p.date_in=?,p.date_out=?,p.reason=? where p.id = ?; ";
    private static final String UPDATE_PATIENT_NAME_SQL = " update patient_description pd set pd.`name`=? where id = ?; ";
    private static final String DELETE_PATIENT_SQL = " update patient set is_delete = ? where id = ?; ";
    private static final String SEARCH_PATIENT_SQL = " select p.id,p.patient_id,pd.`name`,p.date_in,p.date_out,p.reason,p.is_delete FROM patient p right join patient_description pd on pd.id = p.patient_id where pd.`name` like ?; ";








    @Override
    public List<MedicalRecord> searchPatient(String name) {
        List<MedicalRecord> patients = new ArrayList<>();
        MedicalRecord medRecord =null;
        Connection connection = new ConnectionSQL().getConnection();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PATIENT_SQL);
            preparedStatement.setString(1, "%"+name+"%");
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                medRecord = new MedicalRecord();
                medRecord.setId(rs.getString("id"));
                medRecord.setPatientDescription(new PatientDescription(rs.getString("patient_id"),rs.getString("name")) );
                medRecord.setDateIn(rs.getString("date_in"));
                medRecord.setDateOut(rs.getString("date_out"));
                medRecord.setReason(rs.getString("reason"));
                patients.add(medRecord);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            ConnectionSQL.close();
        }

        return patients;
    }

    @Override
    public List<MedicalRecord> listPatient() {
        List<MedicalRecord> patients = new ArrayList<>();
        Connection connection = new ConnectionSQL().getConnection();
        try (

                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TO_SHOW_ALL)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                MedicalRecord patient = new MedicalRecord();
                patient.setId(rs.getString("id"));
                PatientDescription pD = new PatientDescription();
                patient.setPatientDescription(new PatientDescription(rs.getString("patient_id"),rs.getString("name")));
                patient.setDateIn(rs.getString("date_in"));
                patient.setDateOut(rs.getString("date_out"));
                patient.setReason(rs.getString("reason"));

                if (rs.getByte("is_delete")!=1){
                    patients.add(patient);
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            ConnectionSQL.close();
        }

        return patients;
    }

    @Override
    public void addPatient(MedicalRecord patient) throws SQLException {
        Connection connection = new ConnectionSQL().getConnection();
        try (
                CallableStatement callableStatement = connection.prepareCall(INSERT_PATIENT_SQL)) {

            callableStatement.setString(1, patient.getPatientDescription().getPatientDesId());
            callableStatement.setString(2, patient.getPatientDescription().getPatientDesName());
            callableStatement.setString(3, patient.getId());
            callableStatement.setString(4, patient.getPatientDescription().getPatientDesId());
            callableStatement.setString(5, patient.getDateIn());
            callableStatement.setString(6, patient.getDateOut());
            callableStatement.setString(7, patient.getReason());
            System.out.println(callableStatement);
            callableStatement.executeQuery();
        } catch (SQLException ignored) {
            printSQLException(ignored);

        } finally {
            ConnectionSQL.close();
        }
    }

    @Override
    public boolean deletePatient(String id) throws SQLException {
        boolean rowUpdated;
        Connection connection = new ConnectionSQL().getConnection();
        try ( PreparedStatement statement = connection.prepareStatement(DELETE_PATIENT_SQL);) {

            statement.setBoolean(1, true);
            statement.setString(2, id);

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean editPatient(MedicalRecord patient) throws SQLException {
        boolean rowUpdated = false;
        Connection connection = new ConnectionSQL().getConnection();
        try  {
             PreparedStatement statement = connection.prepareStatement(UPDATE_PATIENT_SQL);
             PreparedStatement statement2 = connection.prepareStatement(UPDATE_PATIENT_NAME_SQL);

//          p.date_in=?,p.date_out=?,p.reason=? where p.id = ?; pd.`name`=? where pd.id = ?;
            statement.setString(1, patient.getDateIn());
            statement.setString(2, patient.getDateOut());
            statement.setString(3, patient.getReason());
            statement.setString(4, patient.getId());
            statement2.setString(1, patient.getPatientDescription().getPatientDesName());
            statement2.setString(2, patient.getPatientDescription().getPatientDesId());

            rowUpdated = statement.executeUpdate() > 0;
            statement2.executeUpdate();
        }catch (SQLException e) {
            printSQLException(e);
        } finally {
            ConnectionSQL.close();
        }
        return rowUpdated;
    }

    @Override
    public List<PatientDescription> selectPatientDescription() {
        List<PatientDescription> patienttomerDescription = new ArrayList<>();
        Connection connection = new ConnectionSQL().getConnection();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PATIENT_DESCRIPTION)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                patienttomerDescription.add(new PatientDescription(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            ConnectionSQL.close();
        }
        return patienttomerDescription;
    }

    @Override
    public MedicalRecord findPatientById(String id) {
        MedicalRecord medRecord =null;
        Connection connection = new ConnectionSQL().getConnection();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PATIENT_BY_ID);
            preparedStatement.setString(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                medRecord = new MedicalRecord();
                medRecord.setId(id);
                medRecord.setPatientDescription(new PatientDescription(rs.getString("patient_id"),rs.getString("name")) );
                medRecord.setDateIn(rs.getString("date_in"));
                medRecord.setDateOut(rs.getString("date_out"));
                medRecord.setReason(rs.getString("reason"));

            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            ConnectionSQL.close();
        }

        return medRecord;
    }
    private String getPatientDescription(String typeId) {
        List<PatientDescription> patienttomerDescription = selectPatientDescription();
        for (PatientDescription patientDescription : patienttomerDescription){
            if (typeId.equals(patientDescription.getPatientDesId()) ) {
                return patientDescription.getPatientDesName();
            }
        }
        return null;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
