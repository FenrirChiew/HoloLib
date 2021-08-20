package holoLib;

import java.util.GregorianCalendar;

public abstract class People {
    /********** Properties **********/
    protected String name; // Name
    protected String gender; // Gender
    protected GregorianCalendar dateOfBirth; // Date of Birth
    protected String icNO; // IC Number
    protected String phoneNO; // Phone Number

    /********** Constructors **********/
    protected People() {
        this("", "", null, "", "");
    }

    protected People(String name, String gender, GregorianCalendar dateOfBirth, String icNO, String phoneNO) {
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

    protected GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    protected void setDateOfBirth(GregorianCalendar dateOfBirth) {
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
