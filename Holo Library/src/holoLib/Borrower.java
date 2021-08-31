package holoLib;

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

	public abstract void borrowBook(String pinNO, Material book);

	// toString() method
	@Override
	public String toString() {
		return "Name: " + name + "\nIC Number: " + icNO + "\nGender: " + gender + "Date of Birth: " + dateOfBirth
				+ "\nPhone Number: " + phoneNO;
	}

}
