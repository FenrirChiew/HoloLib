package holoLib;

//import java.util.Scanner;
import java.util.GregorianCalendar;

public class Member extends People {
    /********** Properties **********/
    private String memberID; // Member ID 
    private LibraryCard libraryCard; // Member Library Card
    private static int totalMember = 0; // Total Number of Member

    /********** Constructors **********/
    public Member() {
        this("", "", null, "", "", "", null);
    }

    public Member(String name, String gender, GregorianCalendar dateOfBirth, String icNo, String phoneNo, String memberID,
            LibraryCard libraryCard) {
        super(name, gender, dateOfBirth, icNo, phoneNo);
        this.memberID = memberID;
        this.libraryCard = libraryCard;
        totalMember++;
    }

    /********** Accessors & Mutators **********/
    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public LibraryCard getLibraryCard() {
        return libraryCard;
    }

    public void setLibraryCard(LibraryCard libraryCard) {
        this.libraryCard = libraryCard;
    }

    public static int getTotalMember() {
        return totalMember;
    }

    /********** Methods **********/
    // Calculate the age (required or not)

    // toString() method
    @Override
    public String toString() {
        return super.toString() + "\nMember ID: " + memberID + libraryCard.toString();
    }

}
