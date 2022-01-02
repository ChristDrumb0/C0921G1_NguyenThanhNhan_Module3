package model;

public abstract class Facility {

    String serviceName;
    double area;
    double cost;
    int capacity;
    int rentalType;

    public Facility() {
    }

    public Facility(String serviceName, double area, double cost, int capacity, int rentalType) {
        this.serviceName = serviceName;
        this.area = area;
        this.cost = cost;
        this.capacity = capacity;
        this.rentalType = rentalType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRentalType() {
        return rentalType;
    }

    public void setRentalType(int rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "serviceName='" + serviceName + '\'' +
                ", area=" + area +
                ", cost=" + cost +
                ", capacity=" + capacity +
                ", rentalType=" + rentalType +
                '}';
    }
}
