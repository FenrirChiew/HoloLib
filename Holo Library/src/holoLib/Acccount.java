package holoLib;

import java.util.Date;
import java.time.LocalDate;

public class Acccount {
    private String username;
    private String password;
    private String name;
    private String gender;
    private Date dateOfBirth;
    private String icNo;
    private String phoneNo;

    public Acccount() {
        this("", "", "", "", null, "", "");
    }

    public Acccount(String username, String password, String name,String gender, Date dateOfBirth, String icNo, String phoneNo ){
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.icNo = icNo;
        this.phoneNo = phoneNo; 
    }

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

    

}
