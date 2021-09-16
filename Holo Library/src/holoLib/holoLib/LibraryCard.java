package holoLib;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class LibraryCard implements Payment {
	/********** Properties **********/
	private String cardNO;
	private String pinNO;
	private double cardBalance;
	private GregorianCalendar cardExpDate;
	private Book[] currentBorrowed = new Book[5];
	private int currentBorrowedCount = 0;
	private Book[] borrowedHistory = new Book[100];
	private int borrowedHistoryCount = 0;
	private static int totalCards = 0;

	/********** Constructors **********/
	public LibraryCard() {
		this("", null, 0.0);
	}

	public LibraryCard(String pinNO, GregorianCalendar cardExpDate, double cardBalance) {
		totalCards++;
		this.cardNO = String.format("LC%03d", totalCards);
		this.pinNO = pinNO;
		this.cardExpDate = cardExpDate;
		this.cardBalance = cardBalance;
	}

	/********** Accessors & Mutators **********/
	public String getCardNO() {
		return cardNO;
	}

	public double getCardBalance() {
		return cardBalance;
	}

	public GregorianCalendar getCardExpDate() {
		return cardExpDate;
	}

	public Book[] getCurrentBorrowed() {
		return currentBorrowed;
	}

	public int getCurrentBorrowedCount() {
		return currentBorrowedCount;
	}

	public Book[] getBorrowedHistory() {
		return borrowedHistory;
	}

	public int getBorrowedHistoryCount() {
		return borrowedHistoryCount;
	}

	/********** Methods **********/
	public boolean validatePinNO(String pinNO) {
		if (!this.pinNO.matches(pinNO)) {
			// System.out.println("\n\tInvalid Pin Number! Please try again...");
			return false;
		}

		return true;
	}

	public void cashIn(double cash) {
		cardBalance += cash;
	}

	public String cardExpDateToString() {
		return String.format("%02d", cardExpDate.get(Calendar.DAY_OF_MONTH)) + "/"
				+ String.format("%02d", cardExpDate.get(Calendar.MONTH)) + "/" + cardExpDate.get(Calendar.YEAR);
	}

	public void renewCardExpDate() {
		cardExpDate.set(cardExpDate.get(Calendar.YEAR) + 1, cardExpDate.get(Calendar.MONTH),
				cardExpDate.get(Calendar.DAY_OF_MONTH));
	}

	public void addCurrentBorrowed(Book book) {
		currentBorrowed[currentBorrowedCount] = book;
		currentBorrowedCount++;
	}

	public void removeBorrow(int index) {
		// move borrow record from currenBorrowed to borrowedHistory
		borrowedHistory[borrowedHistoryCount] = currentBorrowed[index];
		borrowedHistoryCount++;

		// remove book details from currentBorrowed
		for (int i = index; i < currentBorrowedCount; i++) {
			currentBorrowed[i] = currentBorrowed[i + 1];
		}
		currentBorrowedCount--;
	}

	public void displayCardDetails() {
		System.out.println("\n============================================");
		System.out.println("            Library Card Details");
		System.out.println("============================================");
		System.out.println("Library Card Number       : " + cardNO);
		System.out.printf("Library Card Balance      : RM %.2f \n", cardBalance);
		System.out.println("Library Card Expired Date : " + cardExpDateToString());
		System.out.println("============================================");
	}

	@Override
	public void payPayment(double payment) {
		cardBalance -= payment;
	}

	@Override
	public void displayInvoice(Borrower borrower, double payment) {
		LocalDateTime dt = LocalDateTime.now();
		System.out.println("\n==============================++===========");
		System.out.println("  Thank You,                  ||   HOLO    ");
		System.out.println("  Here's Your Receipt         ||  LIBRARY  ");
		System.out.println("==============================++===========");
		System.out.println("  Invoice ID           : " + dt.getYear() + dt.getMonthValue() + dt.getYear() + dt.getHour()
				+ dt.getMinute() + dt.getSecond());
		System.out.println("  Borrower Name        : " + borrower.name);
		System.out.printf("  Borrower ID          : ");
		if (borrower instanceof Member) {
			System.out.println(((Member) borrower).getMemberID());
		} else if (borrower instanceof Librarian) {
			System.out.println(((Librarian) borrower).getLibrarianID());
		}
		System.out.println("  Library Card Number  : " + cardNO);
		System.out.printf("  Payment Amount       : RM %.2f\n", payment);
		System.out.printf("  Card Balance         : RM %.2f\n", cardBalance);
		System.out.println("  Card Expired Date    : " + cardExpDateToString());
		System.out.println("===========================================");
	}
}
