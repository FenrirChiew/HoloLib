package holoLib;

public abstract class People {
    /********** Properties **********/
    private String name; // Name
    private String gender; // Gender
    private String dateOfBirth; // Date of Birth
    private String icNO; // IC Number
    private String phoneNO; // Phone Number

    /********** Constructors **********/
    public People() {
        this("", "", "", "", "");
    }

    public People(String name, String gender, String dateOfBirth, String icNO, String phoneNO) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.icNO = icNO;
        this.phoneNO = phoneNO;
    }

    /********** Accessors & Mutators **********/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIcNO() {
        return icNO;
    }

    public void setIcNO(String icNO) {
        this.icNO = icNO;
    }

    public String getPhoneNO() {
        return phoneNO;
    }

    public void setPhoneNo(String phoneNO) {
        this.phoneNO = phoneNO;
    }

    /********** Methods **********/
    // toString() method
    @Override
    public String toString() {
        return "\nName: " + name + "\nGender: " + gender + "Date of Birth: " + dateOfBirth + "\nIC NO: " + icNO
                + "\nPhone Number: " + phoneNO;
    }

}
