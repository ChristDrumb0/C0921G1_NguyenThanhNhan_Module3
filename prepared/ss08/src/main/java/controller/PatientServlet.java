package controller;

import bean.MedicalRecord;
import bean.PatientDescription;
import repository.PatientRepo;
import repository.imp.ImpPatientRepo;
import service.PatientSer;
import service.imp.ImpPatientSer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "PatientServlet", urlPatterns = {"/patient"})
public class PatientServlet extends HttpServlet {
    PatientSer patientSer = new ImpPatientSer();
    PatientRepo patientRepo = new ImpPatientRepo();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createPatient(request, response);
                break;
            case "edit":
                updatePatient(request, response);
                break;
            default:

                break;
        }
    } //do post

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showPatientCreate(request, response);
                    break;
                case "edit":
                    showPatientEdit(request, response);
                    break;
                case "delete":
                    deletePatient(request, response);
                    break;
                case "search":
                    searchPatient(request, response);
                    break;
                default:
                    listPatient(request, response);
                    break;

            }
        } catch (SQLException ex) {
            throw new ServletException(ex);

        }
    } //do get
    private void listPatient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        List<MedicalRecord> listPatient = patientSer.listPatient();
        request.setAttribute("listPatient", listPatient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/patient/ListPatient.jsp");
        dispatcher.forward(request, response);
    } //list
    private void showPatientCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<PatientDescription> patientTypes = patientRepo.selectPatientDescription();
        request.setAttribute("getPatientDescription", patientTypes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/patient/CreatePatient.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    } //show create
    private void createPatient(HttpServletRequest request, HttpServletResponse response) {
        MedicalRecord patient = new MedicalRecord();
//      mrid,pid,name,datein,dateout,reason
        patient.setId(request.getParameter("mrid"));
        patient.setPatientDescription(new PatientDescription(request.getParameter("pid"),request.getParameter("name")));
        patient.setDateIn( request.getParameter("datein"));
        patient.setDateOut(request.getParameter("dateout"));
        patient.setReason( request.getParameter("reason"));

        try {
            Map<String,String> messageMap = patientSer.addPatient(patient);
            if (!messageMap.isEmpty()) {
//                request.setAttribute("msgName", messageMap.get("namemsg"));
                request.setAttribute("msgMRId", messageMap.get("mrMsg"));
                request.setAttribute("msgPId", messageMap.get("pMsg"));
                request.setAttribute("msgDate", messageMap.get("nameMsg"));
                request.setAttribute("msgDateIn", messageMap.get("dateIMsg"));
                request.setAttribute("msgDateOut", messageMap.get("dateOMsg"));
                request.setAttribute("msgDateOut2", messageMap.get("dateOMsg2"));

                request.setAttribute("patient", patient);
                showPatientCreate(request, response);
            } else {
                response.sendRedirect("/patient");
            }
        } catch (SQLException | IOException | ServletException throwables) {
            throwables.printStackTrace();
        }

    } //create

    private void showPatientEdit(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        MedicalRecord existingPatient = patientSer.findPatientById(id);
//        List<PatientDescription> patientType = patientRepo.selectPatientDescription();
//        request.setAttribute("getPatientType", patientType);
        request.setAttribute("patient",existingPatient);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/patient/EditPatient.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    } //show update

    private void updatePatient(HttpServletRequest request, HttpServletResponse response) {
        MedicalRecord patient = new MedicalRecord();
//      mrid,pid,name,datein,dateout,reason
        patient.setId(request.getParameter("mrid"));
        patient.setPatientDescription(new PatientDescription(request.getParameter("pid"),request.getParameter("name")));
        patient.setDateIn( request.getParameter("datein"));
        patient.setDateOut(request.getParameter("dateout"));
        patient.setReason( request.getParameter("reason"));

        try {
            Map<String,String> messageMap = patientSer.editPatient(patient);
            if (!messageMap.isEmpty()) {
//                request.setAttribute("msgName", messageMap.get("namemsg"));
                request.setAttribute("msgMRId", messageMap.get("mrMsg"));
                request.setAttribute("msgPId", messageMap.get("pMsg"));
                request.setAttribute("msgDate", messageMap.get("nameMsg"));
                request.setAttribute("msgDateIn", messageMap.get("dateIMsg"));
                request.setAttribute("msgDateOut", messageMap.get("dateOMsg"));
                request.setAttribute("msgDateOut2", messageMap.get("dateOMsg2"));

                request.setAttribute("patient", patient);
                showPatientCreate(request, response);
            } else {
                response.sendRedirect("/patient");
            }
        } catch (SQLException | IOException | ServletException throwables) {
            throwables.printStackTrace();
        }

    } //update

    private void deletePatient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String id = request.getParameter("id");

        patientSer.deletePatient(id);
        listPatient(request, response);

    } //delete

    private void searchPatient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String something = request.getParameter("search");
        List<MedicalRecord> listSearch = patientSer.searchPatient(something);
        request.setAttribute("listPatient", listSearch);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/patient/ListPatient.jsp");
        dispatcher.forward(request, response);
    } //search
}
