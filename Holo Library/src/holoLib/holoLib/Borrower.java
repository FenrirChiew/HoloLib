package holoLib;

import java.time.LocalDate;
import java.util.GregorianCalendar;

public abstract class Borrower {
	/********** Properties **********/
	protected String name;
	protected String icNO;
	protected String gender;
	protected GregorianCalendar dateOfBirth;
	protected String phoneNO;
	protected LibraryCard libraryCard;
	private static int totalBorrowers = 0;

	/********** Constructors **********/
	protected Borrower() {
		this("", "", "", null, "", null);
	}

	protected Borrower(String name, String icNO, String gender, GregorianCalendar dateOfBirth, String phoneNO,
			LibraryCard libraryCard) {
		this.name = name;
		this.icNO = icNO;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.phoneNO = phoneNO;
		this.libraryCard = libraryCard;
		totalBorrowers++;
	}

	/********** Accessors & Mutators **********/
	public static int getTotalBorrowers() {
		return totalBorrowers;
	}

	/********** Methods **********/
	public void returnBook(String pinNo, Book book) {
		int daysBetween = 0;

		if (!(libraryCard.validatePinNO(pinNo))) {
			System.out.println("\n\tInvalid Pin Number!\n");
		} else {
			for (int i = 0; i < libraryCard.getCurrentBorrowedCount(); i++) {
				// find the book borrow record in current borrowed
				if (libraryCard.getCurrentBorrowed()[i].getBookID().matches(book.getBookID())) {
					daysBetween = LibrarySystem.toDays(LocalDate.now())
							- LibrarySystem.toDays(libraryCard.getCurrentBorrowed()[i].getBorrowDate());

					// if borrow more than Max Grace Period
					if (daysBetween > Book.getMaxGracePeriodInDay()) {
						System.out.println("Day Exceeded: " + (daysBetween - Book.getMaxGracePeriodInDay()));
						System.out.printf("Penalty: RM %.2f\n", book.calPenalty(daysBetween));

						// check is it enough card balance to pay
						if (libraryCard.getCardBalance() > book.calPenalty(daysBetween)) {
							libraryCard.payPayment(book.calPenalty(daysBetween));
						} else {
							System.out.println("\n\tInsufficient card balance! Repeal book return action!!");
						}
					}

					// remove the book record from current borrowed
					libraryCard.removeBorrow(i);
					book.setBorrowed(false);
					book.setReturnDate(LocalDate.now());

					System.out.println("Successfully returned book!");
					System.out.printf("Card Balance: RM %.2f\n", libraryCard.getCardBalance());
				}
			}
		}
	}

	public abstract void displayBorrowerDetails();

	public abstract void borrowBook(String pinNO, Book book);
}
