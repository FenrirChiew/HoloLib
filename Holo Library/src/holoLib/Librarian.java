package holoLib;

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
		this.librarianID = String.format("LB%03d", totalLibrarians + 1);
		this.password = password;
		this.position = position;
		totalLibrarians++;
	}

	/********** Accessors & Mutators **********/
	public String getLibrarianID() {
		return librarianID;
	}

	public void setLibrarianID(String librarianID) {
		this.librarianID = librarianID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public static int getTotalLibrarian() {
		return totalLibrarians;
	}

	public static int getTotalLibrarians() {
		return totalLibrarians;
	}

	public static double getBorrowingRate() {
		return BORROWING_RATE;
	}

	/********** Methods **********/
	@Override
	public void displayCardHolderDetails() {
		System.out.println("Library Card Holder Details");
		System.out.println("===========================");
		System.out.println("Name           : " + name);
		System.out.println("Librarian ID   : " + librarianID);
		System.out.println("Card Number    : " + libraryCard.getCardNO());
		System.out.printf("Card Balance   : %.2f\n" + libraryCard.getCardBalance());
		System.out.printf("Borrowing Rate : %.2f\n" + BORROWING_RATE);
		System.out.print("Current Borrow : ");

		if (libraryCard.getCurrentBorrowed().length == 0) {
			System.out.println("N/A");
		} else {
			for (int i = 0; i < libraryCard.getCurrentBorrowed().length; i++) {
				System.out.printf("\n                 %d. %s (%s)", i + 1,
						libraryCard.getCurrentBorrowed()[i].getMaterialTitle(),
						libraryCard.getCurrentBorrowed()[i].getMaterialID());
			}

			System.out.printf("\n                 (Total Borrow = %d units)\n",
					libraryCard.getCurrentBorrowed().length);
		}
	}

	@Override
	public void borrowBook(String pinNO, Material book) {
		if (!(this.libraryCard.validatePinNO(pinNO))) {
			System.out.println("\n\tInvalid Pin Number!\n");
		} else {
			if (libraryCard.getCurrentBorrowed().length >= MAX_BORROW) {
				System.out.printf("\n\tYou have reached the Borrow Limit (%d)!\n\n", MAX_BORROW);
			} else {
				this.libraryCard.addCurrentBorrowed(book);
			}
		}
	}

	// toString() method
	@Override
	public String toString() {
		return super.toString() + "\nLibrarian ID: " + librarianID + "\nPosition: " + position + "\nBorrowing Rate: "
				+ BORROWING_RATE;
	}
}
