package holoLib;

import java.util.GregorianCalendar;

public class LibraryCard {
	/********** Properties **********/
	private String cardNO;
	private String pinNO;
	private double cardBalance;
	private GregorianCalendar cardExpDate;
	private Material[] currentBorrowed;
	private Material[] borrowedHistory;
	private static int totalCards = 0;

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

	public Material[] getCurrentBorrowed() {
		return currentBorrowed;
	}

	public void setCurrentBorrowed(Material[] currentBorrowed) {
		this.currentBorrowed = currentBorrowed;
	}

	public Material[] getBorrowedHistory() {
		return borrowedHistory;
	}

	public void setBorrowedHistory(Material[] borrowedHistory) {
		this.borrowedHistory = borrowedHistory;
	}

	public static int getTotalCards() {
		return totalCards;
	}

	/********** Methods **********/
	public boolean validatePinNO(String pinNO) {
		return this.pinNO.matches(pinNO);
	}

	public void addCurrentBorrowed(Material book) {
		currentBorrowed[currentBorrowed.length] = book;
	}

	// toString() method
	public String toString() {
		return "Library Card Number: " + cardNO + String.format("\nLibrary Card Balance: %.2f", cardBalance)
				+ "\nExpired Date: " + cardExpDate;
	}
}
