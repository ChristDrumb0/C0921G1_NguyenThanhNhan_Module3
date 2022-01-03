package model;

public abstract class Facility {

    String serviceName;
    double area;
    double cost;
    int capacity;
    int rentalType;
    int serviceType;

    public Facility() {
    }

    public Facility(String serviceName, double area, double cost, int capacity, int rentalType,int serviceType) {
        this.serviceName = serviceName;
        this.area = area;
        this.cost = cost;
        this.capacity = capacity;
        this.rentalType = rentalType;
        this.serviceType = serviceType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
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
