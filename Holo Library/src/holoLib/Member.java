package holoLib;

public class Member {
    private String memeberName; 
    private LibraryCard libraryCard;
    private static int totalMember = 0;
    private boolean isMember; // check is it member, need?
    // ^no need, assume all of our customers are members by HK

    public Member(){
        this.memeberName = "";
    }

    public Member(String memeberName, LibraryCard libraryCard){
        this.memeberName = memeberName;
        totalMember++;
     
    }

    public void setMemeberName(String memeberName){
        this.memeberName = memeberName;
    }

    public String getMemeberName(){
        return memeberName;
    }

    public static int getTotalMember(){
        return totalMember;
    }

    private void registerMembership(){

    }

}
