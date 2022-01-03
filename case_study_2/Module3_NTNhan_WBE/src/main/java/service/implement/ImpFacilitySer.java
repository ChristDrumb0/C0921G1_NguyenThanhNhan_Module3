package service.implement;

import model.*;
import reponsitory.FacilityRepo;
import reponsitory.imlement.ImpFacilityRepo;
import service.FacilitySer;

import java.sql.SQLException;
import java.util.List;

public class ImpFacilitySer implements FacilitySer {

    FacilityRepo fRepo = new ImpFacilityRepo();

    @Override
    public void addHouse(House house) throws SQLException {
        fRepo.addHouse(house);
    }

    @Override
    public void addVilla(Villa villa) throws SQLException {
        fRepo.addVilla(villa);
    }

    @Override
    public void addRoom(Room room) throws SQLException {
        fRepo.addRoom(room);
    }

    @Override
    public List<ServiceType> selectServiceType() {
        return fRepo.selectServiceType();
    }

    @Override
    public List<RentType> selectRentType() {
        return fRepo.selectRentType();
    }
}
