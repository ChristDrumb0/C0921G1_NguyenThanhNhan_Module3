package model;

public class AttachService {
    int attachServiceIc;
    String attachServiceName;
    double attachServiceCost;
    int attachServiceUnit;
    String attachServiceStatus;

    public AttachService() {
    }

    public AttachService(int attachServiceIc, String attachServiceName, double attachServiceCost, int attachServiceUnit, String attachServiceStatus) {
        this.attachServiceIc = attachServiceIc;
        this.attachServiceName = attachServiceName;
        this.attachServiceCost = attachServiceCost;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceStatus = attachServiceStatus;
    }

    public int getAttachServiceIc() {
        return attachServiceIc;
    }

    public void setAttachServiceIc(int attachServiceIc) {
        this.attachServiceIc = attachServiceIc;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public double getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(double attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public int getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(int attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }
}
