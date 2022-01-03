package model;

public class Villa extends Facility{
    String standard;
    String description;
    double poolArea;
    int storey;

    public Villa() {
    }

    public Villa(String serviceName, double area, double cost, int capacity, int rentalType,int serviceType, String standard, String description, double poolArea, int storey) {
        super(serviceName, area, cost, capacity, rentalType,serviceType);
        this.standard = standard;
        this.description = description;
        this.poolArea = poolArea;
        this.storey = storey;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getStorey() {
        return storey;
    }

    public void setStorey(int storey) {
        this.storey = storey;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "standard='" + standard + '\'' +
                ", description='" + description + '\'' +
                ", poolArea=" + poolArea +
                ", storey=" + storey +
                ", serviceName='" + serviceName + '\'' +
                ", area=" + area +
                ", cost=" + cost +
                ", capacity=" + capacity +
                ", rentalType=" + rentalType +
                '}';
    }
}
