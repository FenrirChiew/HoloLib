/*
package holoLib;

import java.time.LocalDate;
import java.util.GregorianCalendar;


public class Borrowable extends Material{
    */
/********** Properties **********//*

    protected double borrowFees;
    protected String borrowStatus;
    protected LocalDate borrowDate;

    */
/********** Constructors **********//*

    public Borrowable(String materialTitle, String materialID, String materialAuthor, String materialPublisher,
                      GregorianCalendar materialPublicationDate, double materialPrice, double borrowFees, String borrowStatus) {
        super(materialTitle, materialID, materialAuthor, materialPublisher, materialPublicationDate, materialPrice);
        this.borrowFees = borrowFees;
        this.borrowStatus = borrowStatus;
    }

    */
/********** Accessors & Mutators **********//*

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    */
/********** Methods **********//*


    // accept the type of borrower (librarian/member)
    // the rate will change...OR fix payment amount?
    public double calBorrowPay(){
        borrowFees = materialPrice * 1.0;
        return borrowFees;
    }

    @Override
    public String toString() {
        return super.toString() + "\nBorrow Fees: RM" + borrowFees + "\nBorrow Status: " + borrowStatus;
    }

}
*/
