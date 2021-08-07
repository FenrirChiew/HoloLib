package holoLib;

import java.util.Date;

public class Member extends Account{
    private LibraryCard libraryCard;
    private static int totalMember = 0;
    
    // Constructor without arguments 
    public Member(){
        super("", "", "", "", null, "", "");
    }

    // Constructor with arguments
    public Member(String username, String password, String name,String gender, Date dateOfBirth, String icNo, String phoneNo, LibraryCard libraryCard){
        super(username, password, name, gender, dateOfBirth, icNo, phoneNo);
        this.libraryCard = libraryCard;
        totalMember++;
     
    }

    //getter 
    public static int getTotalMember(){
        return totalMember;
    }

    // ~~~~~~~~~~~~~ method ~~~~~~~~~~~~~~~

    // toString method 
    public String toString(){
        return super.toString() + libraryCard.toString() ;
    }

    // Register Membership method 
    private void registerMembership(){
        
    }

}
