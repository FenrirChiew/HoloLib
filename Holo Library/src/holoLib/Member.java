package holoLib;

//import java.util.Scanner;
import java.util.GregorianCalendar;

public class Member extends People {
    /********** Properties **********/
    private String memberID; // Member ID
    private LibraryCard libraryCard; // Member Library Card
    private static int totalMember = 0; // Total Number of Member
    private static int nextMemberID = 0001;

    /********** Constructors **********/
    public Member() {
        this("", "", null, "", "", null);
    }

    public Member(String name, String gender, GregorianCalendar dateOfBirth, String icNo, String phoneNo, LibraryCard libraryCard) {
        super(name, gender, dateOfBirth, icNo, phoneNo);
        this.memberID = String.format("M%04d", nextMemberID);
        this.libraryCard = libraryCard;
        totalMember++;
        nextMemberID++;
    }

    /********** Accessors & Mutators **********/
    public String getMemberID() {
        return memberID;
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

    public static int getNextMemberID() {
        return nextMemberID;
    }

    /********** Methods **********/
    // toString() method
    @Override
    public String toString() {
        return super.toString() + "\nMember ID: " + memberID + libraryCard.toString();
    }

}
