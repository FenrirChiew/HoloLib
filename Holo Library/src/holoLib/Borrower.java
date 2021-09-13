package holoLib;

import java.time.Duration;
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
	}

	/********** Methods **********/
	public abstract void displayBorrowerDetails();

	public abstract void borrowBook(String pinNO, Book book);

	public void returnBook(String pinNo, Book book) {
		if (!(libraryCard.validatePinNO(pinNo))) {
			System.out.println("\n\tInvalid Pin Number!\n");
		} else {
			for (int i = 0; i < libraryCard.getCurrentBorrowedCount(); i++) {
				// find the book borrow record in current borrowed
				if (libraryCard.getCurrentBorrowed()[i].getBookID().matches(book.getBookID())) {
					long daysBetween = Duration.between(book.getBorrowDate(), LocalDate.now()).toDays();

					if (daysBetween > Book.getMaxGracePeriodInDay()) {
						System.out.println("Day Exceeded: " + (daysBetween - Book.getMaxGracePeriodInDay()));
						System.out.printf("Penalty: RM .2f\n", Book.calPenalty((int) daysBetween));
						libraryCard.cashOut(Book.calPenalty((int) daysBetween));
					}
					// remove the book record from current borrowed
					libraryCard.removeBorrow(i);
					book.setBorrowed(false);
					book.setReturnDate(LocalDate.now());
					// remove the book record from current borrowed
					libraryCard.removeBorrow(i);

					System.out.println("Book Returned!");
					System.out.printf("Card Balance: RM .2f\n", libraryCard.getCardBalance());
				}
			}
		}
	}

	// toString() method
	@Override
	public String toString() {
		return "Name: " + name + "\nIC Number: " + icNO + "\nGender: " + gender + "Date of Birth: " + dateOfBirth
				+ "\nPhone Number: " + phoneNO;
	}

}
