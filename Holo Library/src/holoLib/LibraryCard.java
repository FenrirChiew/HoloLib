package holoLib;

public class LibraryCard {
    private String memberID; 
    private String memberExpDate; 

     // Constructor without arguments 
    public LibraryCard(){
        this("", "");
    }

    // Constructor with arguments 
    public LibraryCard(String memberID, String memberExpDate){
        this.memberID = memberID;
        this.memberExpDate = memberExpDate;
    }

    //Setter
    public void setId(String memberID){
        this.memberID = memberID;
    }

    public void setExpDate(String memberExpDate){
        this.memberExpDate = memberExpDate;
    }

    //Getter
    public String getMemberID(){
        return memberID;
    }

    public String getMemberExpDate(){
        return memberExpDate;
    }

    // ~~~~~~~~~~~~~ method ~~~~~~~~~~~~~~~

    // toString method 
    public String toString() {
        return "Member ID: " + memberID + "\nExpired Date: " + memberExpDate + "\n";
    }
    
}
