package holoLib;

import java.util.Scanner;

public class Member extends Account{
    private LibraryCard libraryCard;
    private static int totalMember = 0;
    
    // Constructor without arguments 
    public Member(){
        super("", "", "", "", null, "", "");
    }

    // Constructor with arguments
    public Member(String username, String password, String name,String gender, String dateOfBirth, String icNo, String phoneNo, LibraryCard libraryCard){
        super(username, password, name, gender, dateOfBirth, icNo, phoneNo);
        this.libraryCard = libraryCard;
        totalMember++;
     
    }

    //getter 
    public static int getTotalMember(){
        return totalMember;
    }

    public LibraryCard getLibraryCard() {
        return libraryCard;
    }

    // ~~~~~~~~~~~~~ method ~~~~~~~~~~~~~~~

    // toString method 
    public String toString(){
        return super.toString() + libraryCard.toString() ;
    }

    

    // Calculate the age (required or not)
    

}
