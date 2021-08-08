package holoLib;

public class LibraryCard {
    private String memberID;  
    private String memberExpDate; 
    private double cardBalance; 
    private static String nextMemberID;  

     // Constructor without arguments 
    public LibraryCard(){
        this("", "", 0.0);
    }

    // Constructor with arguments 
    public LibraryCard(String memberID, String memberExpDate, double cardBalance){
        this.memberID = memberID;
        this.memberExpDate = memberExpDate;
        this.cardBalance = cardBalance;
        // this.memberID = String.format("M00%02d")
    }

    //Setter
    public void setMemberID(String memberID){
        this.memberID = memberID;
    }

    public void setExpDate(String memberExpDate){
        this.memberExpDate = memberExpDate;
    }

    public void setcardBalance(double cardBalance) {
        this.cardBalance = cardBalance; 
    } 

    //Getter
    public String getMemberID(){
        return memberID;
    }

    public String getMemberExpDate(){
        return memberExpDate;
    }

    public double getcardBalance() {
        return cardBalance;
    }

    // ~~~~~~~~~~~~~ method ~~~~~~~~~~~~~~~

    // toString method 
    public String toString() {
        return "Member ID: " + memberID + "\nExpired Date: " + memberExpDate + "\n";
    }

    //next memberId method
    public static String nextMemberID(){
        return nextMemberID; 
    }
    
}
