package model;

public class Education {
    int educationId;
    String educationName;

    public Education() {
    }

    public Education(int educationId, String educationName) {
        this.educationId = educationId;
        this.educationName = educationName;
    }

    public int getEducationId() {
        return educationId;
    }

    public void setEducationId(int educationId) {
        this.educationId = educationId;
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName;
    }
}
