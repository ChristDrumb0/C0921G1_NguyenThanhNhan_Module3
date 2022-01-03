package model;

public class Room extends Facility{
    String include;

    public Room() {
    }

    public Room(String serviceName, double area, double cost, int capacity, int rentalType,int serviceType, String include) {
        super(serviceName, area, cost, capacity, rentalType,serviceType);
        this.include = include;
    }

    public String getInclude() {
        return include;
    }

    public void setInclude(String include) {
        this.include = include;
    }

    @Override
    public String toString() {
        return "Room{" +
                "include='" + include + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", area=" + area +
                ", cost=" + cost +
                ", capacity=" + capacity +
                ", rentalType=" + rentalType +
                '}';
    }
}
