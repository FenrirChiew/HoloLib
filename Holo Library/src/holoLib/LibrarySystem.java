package holoLib;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class LibrarySystem {
	/********** Properties **********/
	private Borrower[] librarianList;
	private Borrower[] memberList;
	private Book[] bookList;
	private Librarian currentLoggedUser;

	/********** Constructors **********/
	public LibrarySystem() {
		this(null, null, null);
	}

	// testing purpose
	public LibrarySystem(Borrower[] librarianList, Borrower[] memberList) {
		this.librarianList = librarianList;
		this.memberList = memberList;
		bookList = null;
		currentLoggedUser = null;
	}

	public LibrarySystem(Borrower[] librarianList, Borrower[] memberList, Book[] bookList) {
		this.librarianList = librarianList;
		this.memberList = memberList;
		this.bookList = bookList;
		currentLoggedUser = null;
	}

	/********** Accessors & Mutators **********/
	public Borrower[] getLibrarianList() {
		return librarianList;
	}

	public void setLibrarianList(Borrower[] librarianList) {
		this.librarianList = librarianList;
	}

	public Borrower[] getMemberList() {
		return memberList;
	}

	public void setMemberList(Borrower[] memberList) {
		this.memberList = memberList;
	}

	public Book[] getBookList() {
		return bookList;
	}

	public void setBookList(Book[] bookList) {
		this.bookList = bookList;
	}

	public Librarian getCurrentLoggedUser() {
		return currentLoggedUser;
	}

	public void setCurrentLoggedUser(Librarian currentLoggedUser) {
		this.currentLoggedUser = currentLoggedUser;
	}

	/********** Methods **********/
	// Display Main Menu
	public void displayMainMenu() {
		System.out.println("++==============================++");
		System.out.println("||             Home             ||");
		System.out.println("++===++=========================++");
		System.out.println("|| 1 ||  Membership Management  ||");
		System.out.println("|| 2 ||  Book Borrowing         ||");
		System.out.println("|| 3 ||  Reports                ||");
		System.out.println("|| 4 ||  Administrative         ||");
		System.out.println("|| 0 ||  Logout                 ||");
		System.out.println("++===++=========================++");
	}

	// Display Membership Menu
	public void displayMembershipMenu() {
		System.out.println("++================================++");
		System.out.println("||     Membership Management      ||");
		System.out.println("++================================++");
		System.out.println("|| 1 ||  Membership Registration  ||");
		System.out.println("|| 2 ||  Card Renewal             ||");
		System.out.println("|| 3 ||  Reload Card Balance      ||");
		System.out.println("|| 4 ||  Search Borrower          ||");
		System.out.println("|| 0 ||  Back to Home             ||");
		System.out.println("++===++===========================++");
	}

	public void registerMembership(String name, String icNO, String gender, String dob, String phoneNO, String pinNO) {
		int[] dmy = toIntDate(dob.split("/"));
		GregorianCalendar cardEXPDate = new GregorianCalendar(LocalDate.now().getYear() + 1,
				LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());

		memberList[Member.getTotalMembers()] = new Member(name, icNO, gender,
				new GregorianCalendar(dmy[2], dmy[1], dmy[0]), phoneNO, new LibraryCard(pinNO, cardEXPDate));
	}

	public LibraryCard searchLibraryCardByCardNO(String cardNO) {
		for (int i = 0; i < Member.getTotalMembers(); i++) {
			if (memberList[i].libraryCard.getCardNO().matches(cardNO)) {
				return memberList[i].libraryCard;
			}
		}

		for (int i = 0; i < Librarian.getTotalLibrarians(); i++) {
			if (librarianList[i].libraryCard.getCardNO().matches(cardNO)) {
				return librarianList[i].libraryCard;
			}
		}

		System.out.println("\n\tInvalid Library Card Number! Please try again...");
		return null;
	}

	public boolean validateLibraryCard(String cardNO, String pinNO) {
		if (searchLibraryCardByCardNO(cardNO) != null) {
			return searchLibraryCardByCardNO(cardNO).validatePinNO(pinNO);
		}

		return false;
	}

	public void renewCardExpDate(String cardNO) {
		searchLibraryCardByCardNO(cardNO).renewCardExpDate();
	}

	public double captureMoney(Scanner sc, String message) {
		boolean continueInput = true;
		double cash = 0.0;

		do {
			try {
				System.out.print(message + ": ");
				cash = sc.nextDouble();

				if (cash > 0.0) {
					continueInput = false;
				}
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("\n\tInvalid " + message + "! Please try again...\n");
				sc.nextLine();
			}
		} while (continueInput);

		sc.nextLine();

		sc.close();

		return cash;
	}

	public void reloadCardBalance(String cardNO, double cash) {
		searchLibraryCardByCardNO(cardNO).cashIn(cash);
	}

	public Borrower searchBorrowerByID(String borrowerID) {
		if (borrowerID.matches("MB[0-9]{3}")) {
			return searchMemberByID(borrowerID);
		} else {
			return searchLibrarianByID(borrowerID);
		}
	}

	// Display Borrow Menu
	public void displayBorrowMenu() {
		System.out.println("++=========================++");
		System.out.println("||     Book Borrowing      ||");
		System.out.println("++=========================++");
		System.out.println("|| 1 ||  Display Book      ||");
		System.out.println("|| 2 ||  Search Book       ||");
		System.out.println("|| 3 ||  Borrow Book       ||");
		System.out.println("|| 4 ||  Return Book       ||");
		System.out.println("|| 0 ||  Back to Home      ||");
		System.out.println("++===++====================++");
	}

	public void displayBook() {
		System.out.println("\n++======================++");
		System.out.println("||     Display Book     ||");
		System.out.println(
				"++====++==========================================++=========++=========================++================================++=======================++============++========++============++");
		System.out.println(
				"|| NO ||                Book Title                || Book ID ||       Book Author       ||         Book Publisher         || Book Publication Date || Book Price || Status || Borrow Fee ||");
		System.out.println(
				"++====++==========================================++=========++=========================++================================++=======================++============++========||============++");

		for (int i = 0; i < bookList.length; i++) {
			if(i > 0){
				System.out.println("++----++------------------------------------------++---------++-------------------------++--------------------------------++-----------------------++------------++--------++------------++");
			}
			System.out.printf("|| %02d || %-40s || %-7s || %-23s || %-30s || %-21s || %-10.2f || %-6s || %-10.2f ||\n",
					i + 1, bookList[i].getBookTitle(), bookList[i].getBookID(), bookList[i].getBookAuthor(),
					bookList[i].getBookPublisher(), bookList[i].publisherDateToString(), bookList[i].getBookPrice(),
					bookList[i].isBorrowed(), bookList[i].getBorrowFees());
		}
		System.out.println(
				"++====++==========================================++=========++=========================++================================++=======================++============++========||============++");
		System.out.println("\nTotal Book(s) Found: " + bookList.length + "\n");
	}

    public void displayBorrowReport(String bookID) {
        System.out.println("+------------------------------------------+");
        System.out.println("|              Borrow Receipt              |");
        System.out.println("+------------------------------------------+");
        searchBookByID(bookID).displayBookDetails();
        System.out.println("+------------------------------------------+");

    }

	// Display Book Searching Menu
	public void displayBookSearchingMenu() {
		System.out.println("++===============================++");
		System.out.println("||          Search Book          ||");
		System.out.println("++===============================++");
		System.out.println("|| Search By:                    ||");
		System.out.println("++===++==========================++");
		System.out.println("|| 1 ||  Book Title              ||");
		System.out.println("|| 2 ||  Book ID                 ||");
		System.out.println("|| 3 ||  Author                  ||");
		System.out.println("|| 4 ||  Publisher               ||");
		System.out.println("|| 0 ||  Back to Book Borrowing  ||");
		System.out.println("++===++==========================++");
	}

	public void searchBookByTitle(String bookTitle) {
		int totalResult = 0;

		System.out.println("Results match with \"" + bookTitle + "\":");

		for (int i = 0; i < bookList.length; i++) {
			if (bookList[i].getBookTitle().toUpperCase().indexOf(bookTitle.toUpperCase()) != -1) {
				totalResult++;
				System.out.printf("\nResult %d\n", totalResult);
				bookList[i].displayBookDetails();
			}
		}
		System.out.println("\nTotal Book(s) Found: " + totalResult);
	}

	public Book searchBookByID(String bookID) {
		for (int i = 0; i < bookList.length; i++) {
			if (bookList[i].getBookID().indexOf(bookID) != -1) {
				System.out.println("\nResult match with \"" + bookID + "\":");
				return bookList[i];
			}
		}
		return null;
	}

	public void searchBookByAuthor(String bookAuthor) {
		int totalResult = 0;

		System.out.println("Results match with \"" + bookAuthor + "\":");

		for (int i = 0; i < bookList.length; i++) {
			if (bookList[i].getBookAuthor().toUpperCase().indexOf(bookAuthor.toUpperCase()) != -1) {
				totalResult++;
				System.out.printf("\nResult %d\n", totalResult);
				bookList[i].displayBookDetails();
			}
		}
		System.out.println("\nTotal Book(s) Found: " + totalResult);
	}

	public void searchBookByPublisher(String bookPublisher) {
		int totalResult = 0;

		System.out.println("Results match with \"" + bookPublisher + "\":");

		for (int i = 0; i < bookList.length; i++) {
			if (bookList[i].getBookPublisher().toUpperCase().indexOf(bookPublisher.toUpperCase()) != -1) {
				totalResult++;
				System.out.printf("\nResult %d\n", totalResult);
				bookList[i].displayBookDetails();
			}
		}
		System.out.println("\nTotal Book(s) Found: " + totalResult);
	}

	// Display Report Menu
	public void displayReportMenu() {
		System.out.println("++=================================++");
		System.out.println("||             Reports             ||");
		System.out.println("++===++============================++");
		System.out.println("|| 1 ||  Daily Book Borrow Report  ||");
		System.out.println("|| 2 ||  Daily Book Return Report  ||");
		System.out.println("|| 0 ||  Back to Home              ||");
		System.out.println("++===++============================++");
	}

	public void DailyBookBorrowReport(Member[] member, Librarian[] librarian) {

		int count = 0;

		System.out.println("                        Daily Book Borrowed Report for " + LocalDate.now().getDayOfMonth()
				+ "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear());
		System.out.println("+========================================+===================+====================+================+");
		System.out.println("|               Book Title               |      Book ID      |    Borrower Name   |   Borrower ID  |  ");
		for (int i = 0; i < member.length; i++) {
			if (member[i].libraryCard.getCurrentBorrowed().length > 0) {
				for (int j = 0; j < member[i].libraryCard.getCurrentBorrowed().length; j++) {
					Book book = member[i].libraryCard.getCurrentBorrowed()[j];
					if (book.getBorrowDate() == LocalDate.now()) {
						System.out.printf("|%-40s|%-19s|%-20s|%-16s|", book.getBookTitle(), book.getBookID(),
								member[i].name, member[i].getMemberID());
						count++;
					}
				}
			}
		}

		for (int i = 0; i < librarian.length; i++) {
			if (librarian[i].libraryCard.getCurrentBorrowed().length > 0) {
				for (int j = 0; j < librarian[i].libraryCard.getCurrentBorrowed().length; j++) {
					Book book = librarian[i].libraryCard.getCurrentBorrowed()[j];
					if (book.getBorrowDate() == LocalDate.now()) {
						System.out.printf("| %-40s | %-19s | %-20s | %-16s |", book.getBookTitle(), book.getBookID(),
								librarian[i].name, librarian[i].getLibrarianID());
						count++;
					}
				}
			}

		}
		System.out.println("+========================================+===================+====================+================+");
		System.out.println("Total count book borrowed: " + count);

	}

	public void DailyBookReturnedReport(Member[] member, Librarian[] librarian) {
		int count = 0;

		System.out.println("                        Daily Book Returned Report for " + LocalDate.now().getDayOfMonth()
				+ "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear());
		System.out.println("+========================================+===================+====================+================+");
		System.out.println("|               Book Title               |      Book ID      |    Borrower Name   |   Borrower ID  |  ");
		for (int i = 0; i < member.length; i++) {
			if (member[i].libraryCard.getBorrowedHistory().length > 0) {
				for (int j = 0; j < member[i].libraryCard.getBorrowedHistory().length; j++) {
					Book book = member[i].libraryCard.getBorrowedHistory()[j];
					if (book.getReturnDate() == LocalDate.now()) {
						System.out.printf("| %-40s | %-19s | %-20s | %-16s |", book.getBookTitle(), book.getBookID(),
								member[i].name, member[i].getMemberID());
						count++;
					}
				}
			}
		}

		for (int i = 0; i < librarian.length; i++) {
			if (librarian[i].libraryCard.getBorrowedHistory().length > 0) {
				for (int j = 0; j < librarian[i].libraryCard.getBorrowedHistory().length; j++) {
					Book book = librarian[i].libraryCard.getBorrowedHistory()[j];
					if (book.getReturnDate() == LocalDate.now()) {
						System.out.printf("| %-40s | %-19s | %-20s | %-16s |", book.getBookTitle(), book.getBookID(),
								librarian[i].name, librarian[i].getLibrarianID());
						count++;
					}
				}
			}

		}
		System.out.println("+========================================+===================+====================+================+");
		System.out.println("Total count book returned: " + count);
	}

	public void expiredMembershipReport(Member[] member, Librarian[] librarian) {
		int count = 0;
		int daysBetween = 0;

		System.out.println(
				"                               Library Card Expired Report                                   ");
		System.out.println(
				"+===============+=====================+==============+==================+===================+");
		System.out.println(
				"|  Borrower ID  |     Member Name     |   Phone No   |   Expired Date   |  Expired Duration | ");
		System.out.println(
				"---------------------------------------------------------------------------------------------");

		for (int i = 0; i < Member.getTotalMembers(); i++) {
			LocalDate expDate = LocalDate.of(member[i].libraryCard.getCardExpDate().get(Calendar.YEAR),
					member[i].libraryCard.getCardExpDate().get(Calendar.MONTH),
					member[i].libraryCard.getCardExpDate().get(Calendar.DAY_OF_MONTH));

			if (toDays(LocalDate.now()) > toDays(expDate)) {
				daysBetween = toDays(LocalDate.now()) - toDays(expDate);

				System.out.format("| %-14s| %-20s| %-13s|    %-14s|    %4d day(s)    |\n", member[i].getMemberID(),
						member[i].name, member[i].phoneNO, member[i].libraryCard.cardExpDateToString(), daysBetween);
				count++;
			}
		}
		for (int i = 0; i < Librarian.getTotalLibrarians(); i++) {

			LocalDate expDate = LocalDate.of(librarian[i].libraryCard.getCardExpDate().get(Calendar.YEAR),
					librarian[i].libraryCard.getCardExpDate().get(Calendar.MONTH),
					librarian[i].libraryCard.getCardExpDate().get(Calendar.DAY_OF_MONTH));

			daysBetween = toDays(LocalDate.now()) - toDays(expDate);
			if (daysBetween > 0) {
				System.out.format("| %-14s| %-20s| %-13s|    %-14s|    %4d day(s)    |\n",
						librarian[i].getLibrarianID(), librarian[i].name, librarian[i].phoneNO,
						librarian[i].libraryCard.cardExpDateToString(), daysBetween);
				count++;
			}

		}
		System.out.println(
				"+===============+=====================+==============+==================+===================+");
		System.out.printf("Total member had expired membership :                                  %d(person(s))\n",
				count);

	}

	// User needs to be verified as administrator before entering this menu
	// Display Administrative Menu
	public void displayAdministrativeMenu() {
		System.out.println("++===================================++");
		System.out.println("||          Administrative           ||");
		System.out.println("++===++==============================++");
		System.out.println("|| 1 ||  Member Management           ||");
		System.out.println("|| 2 ||  Librarian Management        ||");
		System.out.println("|| 3 ||  Books Inventory Management  ||");
		System.out.println("|| 0 ||  Back to Home                ||");
		System.out.println("++===++==============================++");
	}

	public Borrower searchMemberByID(String memberID) {
		for (int i = 0; i < memberList.length; i++) {
			if (((Member) memberList[i]).getMemberID().matches(memberID)) {
				return memberList[i];
			}
		}

		return null;
	}

	public Borrower searchLibrarianByID(String librarianID) {
		for (int i = 0; i < librarianList.length; i++) {
			if (((Librarian) librarianList[i]).getLibrarianID().matches(librarianID)) {
				return librarianList[i];
			}
		}

		return null;
	}

	// Display Member Management Menu
	public void displayMemberManagementMenu() {
		System.out.println("++===============================++");
		System.out.println("||       Member Management       ||");
		System.out.println("++===++==========================++");
		System.out.println("|| 1 ||  Add Member              ||");
		System.out.println("|| 2 ||  Modify Member           ||");
		System.out.println("|| 3 ||  Delete Member           ||");
		System.out.println("|| 0 ||  Back to Administrative  ||");
		System.out.println("++===++==========================++");
	}

	// Display Librarian Management Menu
	public void displayLibrarianManagementMenu() {
		System.out.println("++===============================++");
		System.out.println("||     Librarian Management      ||");
		System.out.println("++===++==========================++");
		System.out.println("|| 1 ||  Add New Librarian       ||");
		System.out.println("|| 2 ||  Modify Librarian        ||");
		System.out.println("|| 3 ||  Delete Librarian        ||");
		System.out.println("|| 0 ||  Back to Administrative  ||");
		System.out.println("++===++==========================++");
	}

	// Display Books Inventory Management Menu
	public void displayBooksInvManagementMenu() {
		System.out.println("++===============================++");
		System.out.println("||  Books Inventory Management   ||");
		System.out.println("++===++==========================++");
		System.out.println("|| 1 ||  Add Book                ||");
		System.out.println("|| 2 ||  Modify Book             ||");
		System.out.println("|| 3 ||  Delete Book             ||");
		System.out.println("|| 0 ||  Back to Administrative  ||");
		System.out.println("++===++==========================++");
	}

	public void addBook(String title, String author, String publisher, String publicationDate, double price) {
		int[] dmy = toIntDate(publicationDate.split("/"));

		bookList[bookList.length] = new Book(title, author, publisher, new GregorianCalendar(dmy[2], dmy[1], dmy[0]),
				price);
	}

	public void deleteBook(String bookID) {
		for (int i = 0; i < bookList.length; i++) {
			if (bookList[i].getBookID().indexOf(bookID) != -1) {
				for (int j = i; j < bookList.length; j++) {
					bookList[j] = bookList[j + 1];
				}
			}
		}
	}

	// Display Book Searching Menu
	public void displayBookModifyMenu() {
		System.out.println("++===========================================++");
		System.out.println("||                 Modify Book               ||");
		System.out.println("++===========================================++");
		System.out.println("|| Modify :                                  ||");
		System.out.println("++===++======================================++");
		System.out.println("|| 1 ||  Book Title                          ||");
		System.out.println("|| 2 ||  Book Author                         ||");
		System.out.println("|| 3 ||  Book Publisher                      ||");
		System.out.println("|| 4 ||  Book Publication Date               ||");
		System.out.println("|| 5 ||  Book Price                          ||");
		System.out.println("|| 0 ||  Back to Books Inventory Management  ||");
		System.out.println("++===++======================================++");
	}


	// Capture a menu selection after invoke any menu method
	public int captureMenuSelection(Scanner sc, int maxMenuSelection) {
		boolean continueInput = true;
		int selection = 0;

		// Keep looping until:
		// 1. Captured a proper menu selection (integer)
		// 2. Menu selection is within the range
		do {
			try {
				System.out.print("\nEnter your selection > ");
				selection = sc.nextInt();

				if (selection >= 0 && selection <= maxMenuSelection) {
					continueInput = false;
				}
			} catch (Exception e) { // Activate when captured non-integer menu selection
				sc.nextLine();
				System.out.println("\n\tInvalid selection! Please try again...");
				sc.nextLine();
			}
		} while (continueInput);

		sc.nextLine(); // Clear input buffer

		return selection; // Return menu selection
	}

	// Capture a Y or N choice
	public String captureYesNoChoice(Scanner sc, String message) {
		boolean continueInput = true;
		String choice = "";

		// Keep looping until:
		// 1. Captured a proper choice ("Y" / "N")
		// 2. The choice is exact 1 character
		do {
			System.out.print("\n" + message + " (Y/N) > ");
			choice = sc.nextLine();

			if (!(choice.length() == 1 && choice.toUpperCase().matches("Y|N"))) {
				System.out.println("\n\tInvalid choice! Please try again...");
				sc.nextLine();
			} else {
				continueInput = false;
			}
		} while (continueInput);

		// sc.nextLine(); // Clear input buffer

		return choice; // Return choice
	}

	public boolean validateStringFormat(String type, String str, String regex) {
		if (!str.matches(regex)) {
			System.out.println("\n\tInvalid " + type + "! Please try again...\n");
			return false;
		} else {
			return true;
		}
	}

	public int[] toIntDate(String[] day_month_year) {
		int[] d = new int[day_month_year.length];

		for (int i = 0; i < day_month_year.length; i++) {
			char[] c = day_month_year[i].toCharArray();

			for (int j = c.length - 1; j >= 0; j--) {
				d[i] += ((int) c[j] - 48) * (int) Math.pow(10, c.length - j - 1);
			}
		}

		return d;
	}

	public boolean validateDate(String date) {
		if (!validateStringFormat("Date Format", date, "[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
			return false;
		} else {
			String[] day_month_year = date.split("/");

			if (toIntDate(day_month_year)[2] < 1800 || toIntDate(day_month_year)[2] > LocalDate.now().getYear()) {
				System.out.println("\n\tInvalid Year! Please try again...");
				return false;
			}

			switch (toIntDate(day_month_year)[1]) {
				case 1, 3, 5, 7, 8, 10, 12:
					if (toIntDate(day_month_year)[0] <= 0 || toIntDate(day_month_year)[0] > 31) {
						System.out.println("\n\tInvalid Day! Please try again...");
						return false;
					}

					break;
				case 4, 6, 9, 11:
					if (toIntDate(day_month_year)[0] <= 0 || toIntDate(day_month_year)[0] > 30) {
						System.out.println("\n\tInvalid Day! Please try again...");
						return false;
					}

					break;
				case 2:
					if (toIntDate(day_month_year)[2] % 4 == 0) {
						if (toIntDate(day_month_year)[0] <= 0 || toIntDate(day_month_year)[0] > 29) {
							System.out.println("\n\tInvalid Day! Please try again...");
							return false;
						}
					} else {
						if (toIntDate(day_month_year)[0] <= 0 || toIntDate(day_month_year)[0] > 28) {
							System.out.println("\n\tInvalid Day! Please try again...");
							return false;
						}
					}

					break;
				default:
					System.out.println("\n\tInvalid Month! Please try again...");
					return false;
			}

			return true;
		}
	}

	// Convert Date to Days
	public int toDays(LocalDate localDate) {
		return (localDate.getYear() * 365 + localDate.getMonthValue() * 30 + localDate.getDayOfMonth());
	}


	// Login method
	public void login(String librarianID) {
		currentLoggedUser = (Librarian) searchLibrarianByID(librarianID);
	}

	/*
	// HoloLib logo
	public void Logo() {
		System.out.println("⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄");
		System.out.println("⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣀⠠⠤⠤⠤⠤⠤⠤⠤⠤⠤⠐⠒⠒⢄⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄");
		System.out.println("⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣀⡠⠤⠄⠒⠒⠂⠤⣀⠄⠄⡠⠒⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠒⢄⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄");
		System.out.println("⠄⠄⠄⠄⠄⠄⠄⠄⢀⠠⠒⠉⠄⠄⠄⠄⠄⠄⠄⠄⠄⠑⠲⣅⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠒⢄⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄");
		System.out.println("⠄⠄⠄⠄⠄⣀⠤⠊⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠳⣄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠒⢄⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄");
		System.out.println("⠄⠄⠄⡴⢫⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠓⢄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠒⢄⡀⠄⠄⠄⠄⠄⠄⠄⠄");
		System.out.println("⠄⠄⣰⠇⠄⠱⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠑⢄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠒⢄⡀⠄⠄⠄⠄⠄");
		System.out.println("⠄⠄⠙⣷⡀⠄⠘⣄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠙⢦⡀⠄⠄⠄⠄⠄⠄⠄⠄⢀⣀⣤⣤⠤⠤⠴⠶⠒⠒⠒⠒⠒⠒⠒⢺⠂⠄⠄⠄⠄");
		System.out.println("⠄⠄⠄⠘⢿⣄⠄⠈⢆⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠙⢦⡀⠄⠄⢀⡤⠖⠋⠉⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠘⣷⣦⣀⠄⠄");
		System.out.println("⠄⠄⠄⠄⠈⢻⣆⠄⠄⠣⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣀⣀⡠⠤⠤⠤⠽⣦⣰⠋⠄⠄⠄⠄⠄⣀⣀⣀⣀⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣽⣿⣿⠃⠄");
		System.out.println("⠄⠄⠄⠄⠄⠄⠹⣧⡀⠄⠱⡄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣠⠤⠒⠋⠉⠄⠄⠄⠄⠄⠄⢠⣾⣥⣤⣄⠄⣠⣶⣿⣿⣿⣿⡿⠿⠿⠿⠛⠛⠛⠛⠉⠉⠉⠉⠁⠄⠄⠄");
		System.out.println("⠄⠄⠄⠄⠄⠄⠄⠙⣷⡄⠄⠘⢄⠄⠄⠄⠄⠄⠄⣀⠤⠒⠉⠄⠄⠄⠄⠄⠄⠄⣀⣀⣀⣀⣿⣿⣿⣿⡿⠟⠉⠉⠉⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄");
		System.out.println("⠄⠄⠄⠄⠄⠄⠄⠄⠘⢿⣄⠄⠈⢢⠄⣀⡠⠔⠋⠁⠄⠄⠄⠄⣀⣤⣴⣾⣿⠿⠟⠛⠉⠙⠛⠋⠉⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄");
		System.out.println("⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⢻⣦⠄⠄⡏⠄⠄⠄⠄⢀⣠⣴⣾⡿⠿⠛⠉⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄");
		System.out.println("⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠻⣷⣀⡇⠄⣀⣤⣶⠿⠛⠉⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄");
		System.out.println("⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠙⣿⡷⠟⠋⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄");
		System.out.println("⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄");
		System.out.println("\n");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⣿⣿⣿⠀");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⣿⠀⠀⠀⣿");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⣿⣿⣿⣿");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⣿⠀⠀⠀⣿");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⣿⣿⣿⠀");
		System.out.println("\n");
		System.out.println("                 Press Enter to start...");
	}
	*/
}
