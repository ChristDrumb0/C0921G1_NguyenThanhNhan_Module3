package model;

public class Employee extends Person{
    String education;
    String position;
    String division;
    String username;
    double salary;

    public Employee() {

    }

    public Employee(int id, String name, String dob, String gender, String cmnd, double salary, String phone, String email, String address, String position, String education, String division, String username) {
        super(id, name, dob, gender, cmnd, phone, email, address);
        this.education = education;
        this.position = position;
        this.division = division;
        this.username = username;
        this.salary = salary;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "education='" + education + '\'' +
                ", position='" + position + '\'' +
                ", division='" + division + '\'' +
                ", username='" + username + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", cmnd='" + cmnd + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
