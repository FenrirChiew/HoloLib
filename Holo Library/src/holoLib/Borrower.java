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

	public void returnBook(String pinNo, Book book){
		if (!(this.libraryCard.validatePinNO(pinNo))) {
			System.out.println("\n\tInvalid Pin Number!\n");
		}
		else {
			for (int i = 0; i < libraryCard.getCurrentBorrowed().length; i++) {
				// find the book borrow record in current borrowed
				if (libraryCard.getCurrentBorrowed()[i].getBookID().matches(book.getBookID())) {
					// move the book returned to borrow history
					libraryCard.getBorrowedHistory()[libraryCard.getBorrowedHistory().length] = libraryCard.getCurrentBorrowed()[i];

					((Book) book).setReturnDate(LocalDate.now());
					((Book) book).setBorrowed(false);

					// remove the book record from current borrowed
					libraryCard.removeCurrentBorrow(i);

					System.out.println("This return book action has been success.");
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
