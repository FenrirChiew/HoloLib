package holoLib;

import java.time.LocalDate;
import java.util.GregorianCalendar;

public class Librarian extends Borrower {
	/********** Properties **********/
	private String librarianID;
	private String password;
	private String position;
	private static int totalLibrarians = 0;
	private static final double BORROWING_RATE = 0.8;
	private static final int MAX_BORROW = 10;

	/********** Constructors **********/
	public Librarian() {
		this("", "", "", null, "", null, "", "");
	}

	public Librarian(String name, String icNO, String gender, GregorianCalendar dateOfBirth, String phoneNO,
			LibraryCard libraryCard, String password, String position) {
		super(name, icNO, gender, dateOfBirth, phoneNO, libraryCard);
		totalLibrarians++;
		this.librarianID = String.format("LB%03d", totalLibrarians);
		this.password = password;
		this.position = position;
	}

	/********** Accessors & Mutators **********/
	public String getLibrarianID() {
		return librarianID;
	}

	public static int getTotalLibrarians() {
		return totalLibrarians;
	}

	public static double getBorrowingRate() {
		return BORROWING_RATE;
	}

	/********** Methods **********/
	@Override
	public void displayBorrowerDetails() {
		System.out.println("========================");
		System.out.println("Library Borrower Details");
		System.out.println("========================");
		System.out.println("Name           : " + name);
		System.out.println("Librarian ID   : " + librarianID);
		System.out.println("Card Number    : " + libraryCard.getCardNO());
		System.out.printf("Card Balance   : %.2f\n", libraryCard.getCardBalance());
		System.out.printf("Borrowing Rate : %.2f\n", BORROWING_RATE);
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
				if(libraryCard.getCardBalance() > book.getBorrowFees()) {
					// pay (Librarian has discount)
					libraryCard.payPayment(book.getBorrowFees() * BORROWING_RATE);

					// add to Current Book
					book.setBorrowed(true);
					book.setBorrowDate(LocalDate.now());
					libraryCard.addCurrentBorrowed(book);
					System.out.println("Successfully borrowed book!");

					// display receipt
					System.out.println("+----------------------------------------------+");
					System.out.println("|                Borrow Receipt                |");
					System.out.println("+----------------------------------------------+");
					book.displayBookDetails();
					System.out.println("+----------------------------------------------+");
					System.out.println("As you are librarian, 20% discount on borrowing fees!");
					System.out.printf("Card Balance: RM %.2f\n", libraryCard.getCardBalance());
				}
				else{
					System.out.println("\n\tInsufficient card balance! Repeal book borrow action!");
				}
			}
		}
	}

	public boolean validateLogin(String password) {
		if (!this.password.matches(password)) {
			return false;
		}

		return true;
	}

	public boolean isAdmin() {
		if (position.matches("Library Admin")) {
			return true;
		}

		return false;
	}
}
