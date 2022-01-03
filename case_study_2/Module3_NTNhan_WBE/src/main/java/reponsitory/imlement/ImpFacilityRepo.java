package reponsitory.imlement;


import model.*;
import reponsitory.FacilityRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImpFacilityRepo implements FacilityRepo {

    private static final String SELECT_SERVICETYPE = "select * FROM service_type";
    private static final String SELECT_RENTTYPE = "select * FROM rent_type";
    private static final String INSERT_HOUSE = "insert into service (`name`,area,cost,capacity,rent_type_id,service_type_id,room_standard,`description`,storey)  value(?,?,?,?,?,?,?,?,?); ";
    private static final String INSERT_VILLA = "insert into service (`name`,area,cost,capacity,rent_type_id,service_type_id,room_standard,`description`,pool_area,storey) value(?,?,?,?,?,?,?,?,?,?);";
    private static final String INSERT_ROOM = "insert into service (`name`,area,cost,capacity,rent_type_id,service_type_id,`description`) value(?,?,?,?,?,?,?); ";




    @Override
    public void addHouse(House house) throws SQLException {
        Connection connection = new ConnectionSQL().getConnection();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_HOUSE)) {

            preparedStatement.setString(1, house.getServiceName());
            preparedStatement.setDouble(2, house.getArea());
            preparedStatement.setDouble(3, house.getCost());
            preparedStatement.setInt(4, house.getCapacity());
            preparedStatement.setInt(5, house.getRentalType());
            preparedStatement.setInt(6, house.getServiceType());
            preparedStatement.setString(7, house.getStandard());
            preparedStatement.setString(8, house.getDescription());
            preparedStatement.setInt(9, house.getStorey());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ignored) {
            printSQLException(ignored);

        } finally {
            ConnectionSQL.close();
        }
    }

    @Override
    public void addVilla(Villa villa) throws SQLException {
        Connection connection = new ConnectionSQL().getConnection();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VILLA)) {

            preparedStatement.setString(1, villa.getServiceName());
            preparedStatement.setDouble(2, villa.getArea());
            preparedStatement.setDouble(3, villa.getCost());
            preparedStatement.setInt(4, villa.getCapacity());
            preparedStatement.setInt(5, villa.getRentalType());
            preparedStatement.setInt(6, villa.getServiceType());
            preparedStatement.setString(7, villa.getStandard());
            preparedStatement.setString(8, villa.getDescription());
            preparedStatement.setDouble(9, villa.getPoolArea());
            preparedStatement.setInt(10, villa.getStorey());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ignored) {
            printSQLException(ignored);

        } finally {
            ConnectionSQL.close();
        }
    }

    @Override
    public void addRoom(Room room) throws SQLException {
        Connection connection = new ConnectionSQL().getConnection();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROOM)) {

            preparedStatement.setString(1, room.getServiceName());
            preparedStatement.setDouble(2, room.getArea());
            preparedStatement.setDouble(3, room.getCost());
            preparedStatement.setInt(4, room.getCapacity());
            preparedStatement.setInt(5, room.getRentalType());
            preparedStatement.setInt(6, room.getServiceType());
            preparedStatement.setString(7, room.getInclude());


            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ignored) {
            printSQLException(ignored);

        } finally {
            ConnectionSQL.close();
        }
    }

    @Override
    public List<ServiceType> selectServiceType() {
        List<ServiceType> serviceTypeList = new ArrayList<>();
        Connection connection = new ConnectionSQL().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICETYPE);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                serviceTypeList.add(new ServiceType(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            ConnectionSQL.close();
        }
        return serviceTypeList;
    }

    @Override
    public List<RentType> selectRentType() {
        List<RentType> rentTypeList = new ArrayList<>();
        Connection connection = new ConnectionSQL().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RENTTYPE);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Double cost = rs.getDouble("cost");
                rentTypeList.add(new RentType(id,name,cost));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            ConnectionSQL.close();
        }
        return rentTypeList;
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
