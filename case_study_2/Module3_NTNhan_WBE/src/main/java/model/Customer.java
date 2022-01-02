package model;

public class Customer extends Person{
    String type;
    String address;


    public Customer() {
    }

    public Customer(int id, String name, String dob, String gender, String cmnd, String phone, String email, String address, String type, String address1) {
        super(id, name, dob, gender, cmnd, phone, email, address);
        this.type = type;
        this.address = address1;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "type=" + type +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", gender=" + gender +
                ", cmnd='" + cmnd + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
