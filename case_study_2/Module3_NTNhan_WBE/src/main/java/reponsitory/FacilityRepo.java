package reponsitory;

import model.*;

import java.sql.SQLException;
import java.util.List;

public interface FacilityRepo {
//    public void addFacility(Facility facility) throws SQLException;
    public void addHouse(House house) throws SQLException;
    public void addVilla(Villa villa) throws SQLException;
    public void addRoom(Room room) throws SQLException;
    public List<ServiceType> selectServiceType();
    public List<RentType> selectRentType();
}
