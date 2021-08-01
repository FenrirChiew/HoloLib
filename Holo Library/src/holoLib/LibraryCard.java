package holoLib;

public class LibraryCard {
    private String memberId; 
    private String memberExpDate; 

    public LibraryCard(){
        this("", "");
    }

    public LibraryCard(String memberId, String memberExpDate){
        this.memberId = memberId;
        this.memberExpDate = memberExpDate;
    }

    public void setId(String memberId){
        this.memberId = memberId;
    }

    public void setExpDate(String memberExpDate){
        this.memberExpDate = memberExpDate;
    }

    public String getMemberId(){
        return memberId;
    }

    public String getMemberExpDate(){
        return memberExpDate;
    }

    public String toString() {
        return "Member ID: " + memberId + "\n Expired Date: " + memberExpDate + "\n";
    }
    
}
