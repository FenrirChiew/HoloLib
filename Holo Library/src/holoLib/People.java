package holoLib;

public abstract class People {
    /********** Properties **********/
    protected String name; // Name
    protected String gender; // Gender
    protected String dateOfBirth; // Date of Birth
    protected String icNO; // IC Number
    protected String phoneNO; // Phone Number

    /********** Constructors **********/
    protected People() {
        this("", "", "", "", "");
    }

    protected People(String name, String gender, String dateOfBirth, String icNO, String phoneNO) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.icNO = icNO;
        this.phoneNO = phoneNO;
    }

    /********** Accessors & Mutators **********/
    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getGender() {
        return gender;
    }

    protected void setGender(String gender) {
        this.gender = gender;
    }

    protected String getDateOfBirth() {
        return dateOfBirth;
    }

    protected void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    protected String getIcNO() {
        return icNO;
    }

    protected void setIcNO(String icNO) {
        this.icNO = icNO;
    }

    protected String getPhoneNO() {
        return phoneNO;
    }

    protected void setPhoneNo(String phoneNO) {
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
