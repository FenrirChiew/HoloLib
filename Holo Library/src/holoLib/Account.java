package holoLib;

import java.util.Date;
import java.time.LocalDate;

public class Account {
    protected String username;
    protected String password;
    protected String name;
    protected String gender;
    protected Date dateOfBirth;
    protected String icNo;
    protected String phoneNo;

    // Constructor without arguments 
    public Account() {
        this("", "", "", "", null, "", "");
    }

    // Constructor with arguments 
    public Account(String username, String password, String name,String gender, Date dateOfBirth, String icNo, String phoneNo){
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.icNo = icNo;
        this.phoneNo = phoneNo; 
    }

    // Getter 
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getIcNo() {
        return icNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    //Setter 
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setIcNo(String icNo) {
        this.icNo = icNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    // ~~~~~~~~~~~~~ method ~~~~~~~~~~~~~~~

    // toString method 
    public String toString(){
        return "Username: " + username + "\nPassword: " + password + "\nName: " + name + "\nGender: " + gender + 
                "Date Of Birth: " + dateOfBirth + "\nIC No: " +icNo + "\nPhone No: " + phoneNo  + "\n";
    }

}
