package holoLib;

import java.sql.Date;

public class Member {
    private String memeberName;
    private Date DOB; 
    private String  IC;
    private LibraryCard libraryCard;
    private static int totalMember = 0;
    

    public Member(){
        this.memeberName = "";
    }

    public Member(String memeberName, LibraryCard libraryCard){
        this.memeberName = memeberName;
        this.libraryCard = libraryCard;
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
