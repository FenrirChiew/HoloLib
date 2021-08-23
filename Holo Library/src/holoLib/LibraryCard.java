package holoLib;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class LibraryCard {
    /********** Properties **********/
    private String cardNO; // Library Card Number
    private String pinNo; // Pin Number
    private GregorianCalendar memberExpDate; // Membership Expire Date (initialize today date)
    private double cardBalance; // Library Card Balance    (initialize 0.0)
    private ReservedTimeslot[] reservedTimeSlots; // Reserved Time Slots
    private BookBorrowed[] booksBorrowed; // Books Borrowed
    private Timeslot[] reservedHistory; // Reserved History
    private ReadingMaterial[] borrowedHistory; // Borrowed History

    /********** Constructors **********/
    public LibraryCard() {
        this("", "", null, 0.0, null, null, null, null);
    }

    public LibraryCard(String cardNO, String pinNo, GregorianCalendar memberExpDate, double cardBalance,
            ReservedTimeslot[] reservedTimeSlots, BookBorrowed[] booksBorrowed, Timeslot[] reservedHistory,
            ReadingMaterial[] borrowedHistory) {
        this.cardNO = cardNO;
        this.pinNo = pinNo;
        this.memberExpDate = memberExpDate;
        this.cardBalance = cardBalance;
        this.reservedTimeSlots = reservedTimeSlots;
        this.booksBorrowed = booksBorrowed;
        this.reservedHistory = reservedHistory;
        this.borrowedHistory = borrowedHistory;
    }

    /********** Accessors & Mutators **********/
    public String getCardNO() {
        return cardNO;
    }

    public void setCardNO(String cardNO) {
        this.cardNO = cardNO;
    }

    public String getPinNo() {
        return pinNo;
    }

    public void setPinNo(String pinNo) {
        this.pinNo = pinNo;
    }

    public GregorianCalendar getMemberExpDate() {
        return memberExpDate;
    }

    public void setExpDate(GregorianCalendar memberExpDate) {
        this.memberExpDate = memberExpDate;
    }

    public double getcardBalance() {
        return cardBalance;
    }

    public void setcardBalance(double cardBalance) {
        this.cardBalance = cardBalance;
    }

    public ReservedTimeslot[] getReservedTimeSlots() {
        return reservedTimeSlots;
    }

    public void setReservedTimeSlots(ReservedTimeslot[] reservedTimeSlots) {
        this.reservedTimeSlots = reservedTimeSlots;
    }

    public BookBorrowed[] getBooksBorrowed() {
        return booksBorrowed;
    }

    public void setBooksBorrowed(BookBorrowed[] booksBorrowed) {
        this.booksBorrowed = booksBorrowed;
    }

    public Timeslot[] getReservedHistory() {
        return reservedHistory;
    }

    public void setReservedHistory(Timeslot[] reservedHistory) {
        this.reservedHistory = reservedHistory;
    }

    public ReadingMaterial[] getBorrowedHistory() {
        return borrowedHistory;
    }

    public void setBorrowedHistory(ReadingMaterial[] borrowedHistory) {
        this.borrowedHistory = borrowedHistory;
    }

    //when return book can review how many books did the person borrowed and want to return which book 
    public void displayBookBorrowed(Member[] member, ReadingMaterial[] readingMaterial){

        Scanner sc = new Scanner(System.in);
        ReadingMaterial tempReadingMaterial = new ReadingMaterial();
        Member tempMember = new Member();
        Librarian tempLibrarian = new Librarian();

        //how can i add totalborrowed ? 

        tempMember = tempLibrarian.SearchLibraryCardNo(member);

        
    }

    /********** Methods **********/
    // next memberId method
    /*
     * public static String nextMemberID(){ return nextMemberID; }
     */

    // toString() method
    public String toString() {
        return "\nLibrary Card Number: " + cardNO + "\nExpired Date: " + memberExpDate + "\nLibrary Card Balance: "
                + cardBalance;
    }
}
