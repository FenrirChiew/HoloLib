package holoLib;

public class LibraryCard {
    private String memberID; 
    private String memberExpDate; 
    private double cardBalnace; 

     // Constructor without arguments 
    public LibraryCard(){
        this("", "", 0.0);
    }

    // Constructor with arguments 
    public LibraryCard(String memberID, String memberExpDate, double caedBalance){
        this.memberID = memberID;
        this.memberExpDate = memberExpDate;
        this.cardBalnace = caedBalance;
    }

    //Setter
    public void setId(String memberID){
        this.memberID = memberID;
    }

    public void setExpDate(String memberExpDate){
        this.memberExpDate = memberExpDate;
    }

    public void setCardBalnace(double cardBalnace) {
        this.cardBalnace = cardBalnace;
    }

    //Getter
    public String getMemberID(){
        return memberID;
    }

    public String getMemberExpDate(){
        return memberExpDate;
    }

    public double getCardBalnace() {
        return cardBalnace;
    }

    // ~~~~~~~~~~~~~ method ~~~~~~~~~~~~~~~

    // toString method 
    public String toString() {
        return "Member ID: " + memberID + "\nExpired Date: " + memberExpDate + "\n";
    }
    
}
