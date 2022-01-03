package controller;

import model.*;
import service.FacilitySer;
import service.implement.ImpFacilitySer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "FacilityServlet", urlPatterns = {"/facility"})
public class FacilityServlet extends HttpServlet {

    FacilitySer facilitySer = new ImpFacilitySer();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try{
        switch (action) {
            case "room":
                createRoom(request, response);
                break;
            case "villa":
                createVilla(request, response);
                break;
            default:
//                "house":
                createHouse(request,response);
                break;

            }
        }catch (SQLException ex) {
            throw new ServletException(ex);

        }
    }

    private void createHouse(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{

        try{
        House house = new House();
//        (`name`,area,cost,capacity,rent_type_id,service_type_id,room_standard,`description`,storey)
        house.setServiceName(request.getParameter("name"));
        house.setArea(Double.parseDouble(request.getParameter("area")));
        house.setCost(Double.parseDouble(request.getParameter("cost")));
        house.setCapacity(Integer.parseInt(request.getParameter("capacity")));
        house.setRentalType(Integer.parseInt(request.getParameter("rentType")));
        house.setServiceType(1);
        house.setStandard(request.getParameter("standard"));
        house.setDescription(request.getParameter("description"));
        house.setStorey(Integer.parseInt(request.getParameter("storey")));


        facilitySer.addHouse(house);
        response.sendRedirect("/facility");

    } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
    private void createVilla(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{

        try{
        Villa villa = new Villa();
//        (`name`,area,cost,capacity,rent_type_id,service_type_id,room_standard,`description`,pool_area,storey)
        villa.setServiceName(request.getParameter("name"));
        villa.setArea(Double.parseDouble(request.getParameter("area")));
        villa.setCost(Double.parseDouble(request.getParameter("cost")));
        villa.setCapacity(Integer.parseInt(request.getParameter("capacity")));
        villa.setRentalType(Integer.parseInt(request.getParameter("rentType")));
        villa.setServiceType(2);
        villa.setStandard(request.getParameter("standard"));
        villa.setDescription(request.getParameter("description"));
        villa.setPoolArea(Double.parseDouble(request.getParameter("pool_area")));
        villa.setStorey(Integer.parseInt(request.getParameter("storey")));


        facilitySer.addVilla(villa);
        response.sendRedirect("/facility");

    } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
    private void createRoom(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{

        try{
        Room room = new Room();
//        (`name`,area,cost,capacity,rent_type_id,service_type_id,room_standard,`description`,storey)
        room.setServiceName(request.getParameter("name"));
        room.setArea(Double.parseDouble(request.getParameter("area")));
        room.setCost(Double.parseDouble(request.getParameter("cost")));
        room.setCapacity(Integer.parseInt(request.getParameter("capacity")));
        room.setRentalType(Integer.parseInt(request.getParameter("rentType")));
        room.setServiceType(3);
        room.setInclude(request.getParameter("description"));


        facilitySer.addRoom(room);
        response.sendRedirect("/facility");

    } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "room":
                    showCreateRoom(request, response);
                    break;
                case "villa":
                    showCreateVilla(request, response);
                    break;
                default:
//                "house":
                    showCreateHouse(request, response);
                    break;

            }
        }catch (SQLException ex) {
                throw new ServletException(ex);

        }
    }

    private void showCreateHouse(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        List<RentType> rentTypeList = facilitySer.selectRentType();
        request.setAttribute("getRentType", rentTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Facility/createHouse.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }


    }
    private void showCreateVilla(HttpServletRequest request, HttpServletResponse response)
            throws SQLException,ServletException, IOException {

        List<RentType> rentTypeList = facilitySer.selectRentType();
        request.setAttribute("getRentType", rentTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Facility/createVilla.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }


    }
    private void showCreateRoom(HttpServletRequest request, HttpServletResponse response)
            throws SQLException,ServletException, IOException {

        List<RentType> rentTypeList = facilitySer.selectRentType();
        request.setAttribute("getRentType", rentTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Facility/createRoom.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }


    }
}
