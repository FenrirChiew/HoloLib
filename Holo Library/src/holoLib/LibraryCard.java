package holoLib;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class LibraryCard {
	/********** Properties **********/
	private String cardNO;
	private String pinNO;
	private double cardBalance;
	private GregorianCalendar cardExpDate;
	private Book[] currentBorrowed = new Book[5];
	private Book[] borrowedHistory = new Book[100];
	private static int totalCards = 0;
	private static Book[] returnedBook = new Book[100];

	/********** Constructors **********/
	public LibraryCard() {
		this("", null);
	}

	public LibraryCard(String pinNO, GregorianCalendar cardExpDate) {
		this.cardNO = String.format("C%04d", totalCards + 1);
		this.pinNO = pinNO;
		this.cardExpDate = cardExpDate;
		totalCards++;
	}

	/********** Accessors & Mutators **********/
	public String getCardNO() {
		return cardNO;
	}

	public void setCardNO(String cardNO) {
		this.cardNO = cardNO;
	}

	public void setPinNO(String pinNO) {
		this.pinNO = pinNO;
	}

	public double getCardBalance() {
		return cardBalance;
	}

	public void setCardBalance(double cardBalance) {
		this.cardBalance = cardBalance;
	}

	public GregorianCalendar getCardExpDate() {
		return cardExpDate;
	}

	public void setCardExpDate(GregorianCalendar cardExpDate) {
		this.cardExpDate = cardExpDate;
	}

	public Book[] getCurrentBorrowed() {
		return currentBorrowed;
	}

	public void setCurrentBorrowed(Book[] currentBorrowed) {
		this.currentBorrowed = currentBorrowed;
	}

	public Book[] getBorrowedHistory() {
		return borrowedHistory;
	}

	public void setBorrowedHistory(Book[] borrowedHistory) {
		this.borrowedHistory = borrowedHistory;
	}

	public static int getTotalCards() {
		return totalCards;
	}

	/********** Methods **********/
	public boolean validatePinNO(String pinNO) {
		if (!this.pinNO.matches(pinNO)) {
			System.out.println("\n\tInvalid Pin Number! Please try again...");
			return false;
		}

		return true;
	}

	public void cashIn(double cash) {
		cardBalance += cash;
	}

	public void cashOut(double cash) {
		cardBalance -= cash;
	}

	public String cardExpDateToString() {
		return String.format("%02d", cardExpDate.get(Calendar.DAY_OF_MONTH)) + "/"
				+ String.format("%02d", cardExpDate.get(Calendar.MONTH) + 1) + "/" + cardExpDate.get(Calendar.YEAR);
	}

	public void renewCardExpDate() {
		cardExpDate.set(cardExpDate.get(Calendar.DAY_OF_MONTH), cardExpDate.get(Calendar.MONTH),
				cardExpDate.get(Calendar.YEAR) + 1);
	}

	public void addCurrentBorrowed(Book book) {
		currentBorrowed[currentBorrowed.length] = book;
	}

	public void removeCurrentBorrow(int index){
		// remove book details from currentBorrowed
		for(int i = index; i < currentBorrowed.length; i++){
			currentBorrowed[i] = currentBorrowed[i+1];
		}
	}

	// toString() method
	public String toString() {
		return "Library Card Number: " + cardNO + String.format("\nLibrary Card Balance: %.2f", cardBalance)
				+ "\nCard Expired Date: " + cardExpDateToString();
	}
}
