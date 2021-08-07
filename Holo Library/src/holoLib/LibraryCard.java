package holoLib;

public class LibraryCard {
    private String memberID; 
    private String memberExpDate; 

    public LibraryCard(){
        this("", "");
    }

    public LibraryCard(String memberID, String memberExpDate){
        this.memberID = memberID;
        this.memberExpDate = memberExpDate;
    }

    public void setId(String memberID){
        this.memberID = memberID;
    }

    public void setExpDate(String memberExpDate){
        this.memberExpDate = memberExpDate;
    }

    public String getMemberID(){
        return memberID;
    }

    public String getMemberExpDate(){
        return memberExpDate;
    }

    public String toString() {
        return "Member ID: " + memberID + "\nExpired Date: " + memberExpDate + "\n";
    }
    
}
