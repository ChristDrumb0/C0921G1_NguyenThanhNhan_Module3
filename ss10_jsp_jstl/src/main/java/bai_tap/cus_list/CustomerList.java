package bai_tap.cus_list;

public class CustomerList {
//    private Integer id;
    private String name;
    private String dOB;
    private String address;
    private String img;

    public CustomerList( String name, String dOB, String address, String img) {
//        this.id = id;
        this.name = name;
        this.dOB = dOB;
        this.address = address;
        this.img = img;
    }

//    public Integer getId() {
//        return id;
//    }

//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getdOB() {
        return dOB;
    }

    public void setdOB(String dOB) {
        this.dOB = dOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
