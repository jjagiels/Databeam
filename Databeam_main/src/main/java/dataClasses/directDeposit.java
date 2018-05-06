package dataClasses;

public class directDeposit extends basicInfo {

    private String address;
    private String city;
    private String state;
    private String zipCode;
    private boolean checkOrSaving; //false = Checking account, true = Savings/MIA/Money Market account
    private String checkAcct;
    private String saveAcct;
    private String routNum;

    public directDeposit() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public boolean isCheckOrSaving() {
        return checkOrSaving;
    }

    public void setCheckOrSaving(boolean checkOrSaving) {
        this.checkOrSaving = checkOrSaving;
    }

    public String getCheckAcct() {
        return checkAcct;
    }

    public void setCheckAcct(String checkAcct) {
        this.checkAcct = checkAcct;
    }

    public String getSaveAcct() {
        return saveAcct;
    }

    public void setSaveAcct(String saveAcct) {
        this.saveAcct = saveAcct;
    }

    public String getRoutNum() {
        return routNum;
    }

    public void setRoutNum(String routNum) {
        this.routNum = routNum;
    }
}
