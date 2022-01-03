package model;

public class House extends Facility{
    String standard;
    String description;
    int storey;

    public House() {

    }

    public House(String serviceName, double area, double cost, int capacity, int rentalType,int serviceType, String standard, String description, int storey) {
        super(serviceName, area, cost, capacity, rentalType,serviceType);
        this.standard = standard;
        this.description = description;
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

    public int getStorey() {
        return storey;
    }

    public void setStorey(int storey) {
        this.storey = storey;
    }
}
