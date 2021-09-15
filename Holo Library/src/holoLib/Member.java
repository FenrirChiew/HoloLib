package holoLib;

//import java.util.Scanner;
import java.util.GregorianCalendar;
import java.time.LocalDate;

public class Member extends Borrower {
	/********** Properties **********/
	private String memberID;
	private static int totalMembers = 0;
	private static final int MAX_BORROW = 5;

	/********** Constructors **********/
	public Member() {
		this("", "", "", null, "", null);
	}

	public Member(String name, String icNO, String gender, GregorianCalendar dateOfBirth, String phoneNO,
			LibraryCard libraryCard) {
		super(name, icNO, gender, dateOfBirth, phoneNO, libraryCard);
		this.memberID = String.format("MB%03d", totalMembers + 1);
		totalMembers++;
	}

	/********** Accessors & Mutators **********/
	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public static int getTotalMembers() {
		return totalMembers;
	}

	/********** Methods **********/
	@Override
	public void displayBorrowerDetails() {
		System.out.println("========================");
		System.out.println("Library Borrower Details");
		System.out.println("========================");
		System.out.println("Name           : " + name);
		System.out.println("Member ID      : " + memberID);
		System.out.println("Card Number    : " + libraryCard.getCardNO());
		System.out.printf("Card Balance   : %.2f\n", libraryCard.getCardBalance());
		System.out.print("Current Borrow : ");

		if (libraryCard.getCurrentBorrowedCount() == 0) {
			System.out.println("N/A");
		} else {
			for (int i = 0; i < libraryCard.getCurrentBorrowedCount(); i++) {
				System.out.printf("\n                 %d. %s (%s)", i + 1,
						libraryCard.getCurrentBorrowed()[i].getBookTitle(),
						libraryCard.getCurrentBorrowed()[i].getBookID());
			}

			System.out.printf("\n                 (Total Borrow = %d units)\n",
					libraryCard.getCurrentBorrowedCount());
		}
		System.out.println("========================");
	}

	@Override
	public void borrowBook(String pinNO, Book book) {
		if (!(libraryCard.validatePinNO(pinNO))) {
			System.out.println("\n\tInvalid Pin Number!\n");
		}
		else {
			// check have more than limit of borrow
			if (libraryCard.getCurrentBorrowedCount() >= MAX_BORROW) {
				System.out.printf("\n\tYou have reached the Borrow Limit (%d)!\n\n", MAX_BORROW);
			}
			else {
				// check is it enough card balance to pay
				if(libraryCard.getCardBalance() > book.getBorrowFees()){
					// pay
					libraryCard.cashOut(book.getBorrowFees());

					// add to Current Book
					book.setBorrowed(true);
					book.setBorrowDate(LocalDate.now());
					libraryCard.addCurrentBorrowed(book);

					System.out.println("Borrow Success!");
				}
				else{
					System.out.println("Insufficient balance! Borrow failed!");
				}
			}
		}
	}

	// toString() method
	@Override
	public String toString() {
		return super.toString() + "\nMember ID: " + memberID + libraryCard.toString();
	}

}
