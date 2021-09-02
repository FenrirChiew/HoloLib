package holoLib;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Book {
    /********** Properties **********/
    private String bookTitle;
    private String bookID;
    private String bookAuthor;
    private String bookPublisher;
    private GregorianCalendar bookPublicationDate;
    private double bookPrice;
    private boolean isBorrowed;
    private double borrowFees;
    private LocalDate borrowDate;
    private static int totalBooks = 0;
    private static final int MAX_GRACE_PERIOD_IN_DAY = 30;

    /********** Constructors **********/
    public Book() {
        this("", "", "", null, 0.0);
        isBorrowed = false;
        calBorrowFees();
        totalBooks++;
    }

    public Book(String bookTitle, String bookAuthor, String bookPublisher,
            GregorianCalendar bookPublicationDate, double bookPrice) {
        this.bookTitle = bookTitle;
        bookID = String.format("BK%03d", totalBooks + 1);
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.bookPublicationDate = bookPublicationDate;
        this.bookPrice = bookPrice;
        isBorrowed = false;
        calBorrowFees();
        totalBooks++;
    }

    /********** Accessors & Mutators **********/

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookID() {
        return bookID;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public GregorianCalendar getBookPublicationDate() {
        return bookPublicationDate;
    }

    public void setBookPublicationDate(GregorianCalendar bookPublicationDate) {
        this.bookPublicationDate = bookPublicationDate;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public double getBorrowFees() {
        return borrowFees;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public static int getTotalBooks() {
        return totalBooks;
    }

    public static int getMAX_GRACE_PERIOD_IN_DAY() {
        return MAX_GRACE_PERIOD_IN_DAY;
    }

    /********** Methods **********/
    public void displayBookDetails(){
        System.out.println("Book Details");
        System.out.println("==========================");
        System.out.println("Title                     : " + bookTitle);
        System.out.println("Material ID               : " + bookID);
        System.out.println("Material Author           : " + bookAuthor);
        System.out.println("Material Publisher        : " + bookPublisher);
        System.out.println("Material Publication Date : " + publisherDateToString());
        System.out.println("Material Price            : " + bookPrice);
        System.out.println("Material Borrow Status    : " + isBorrowed);
        System.out.println("\nBorrow Fee                : " + borrowFees);
    }

    public String publisherDateToString() {
        return String.format("%02d", bookPublicationDate.get(Calendar.DATE)) + "/"
                + String.format("%02d", bookPublicationDate.get(Calendar.MONTH) + 1) + "/" + bookPublicationDate.get(Calendar.YEAR);
    }

    // accept the type of borrower (librarian/member)
    // the rate will change...OR fix payment amount?
    public void calBorrowFees(){
        borrowFees = bookPrice * 0.1;
    }

    @Override
    public String toString() {
        return "Material Title: " + bookTitle + "\nMaterial ID: " + bookID + "\nMaterial Author: "
                + bookAuthor + "\nMaterial Publisher: " + bookPublisher + "\nMaterial Publication Date: "
                + bookPublicationDate + "\nMaterial Price: " + bookPrice;
    }
}