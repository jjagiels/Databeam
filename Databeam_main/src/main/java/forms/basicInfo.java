package forms;

public class basicInfo {
    private String firstName;
    private String middleName;
    private String lastName;
    private String DOB;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public basicInfo() {
        this.firstName = "N/A";
        this.middleName = "N/A";
        this.lastName = "N/A";
        DOB = "N/A";
    }
}
