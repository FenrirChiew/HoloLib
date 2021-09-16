package holoLib;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class LibrarySystem implements SearchBorrower, SearchLibraryCard, SearchBook {
	/********** Properties **********/
	private Borrower[] borrowerList;
	private Book[] bookList;
	private Librarian currentLoggedUser;
	private Librarian[] loggedList = new Librarian[100];
	private LocalDateTime[] loginTime = new LocalDateTime[100];
	private LocalDateTime[] logoutTime = new LocalDateTime[100];
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	private static int recordCount = 0;

	/********** Constructors **********/
	public LibrarySystem() {
		this(null, null);
	}

	public LibrarySystem(Borrower[] borrowerList, Book[] bookList) {
		this.borrowerList = borrowerList;
		this.bookList = bookList;
		currentLoggedUser = null;
	}

	/********** Accessors & Mutators **********/
	public Librarian getCurrentLoggedUser() {
		return currentLoggedUser;
	}

	/********** Methods **********/
	/****************************** Login Module ******************************/
	public static void logo() {
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
		System.out.println("⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄\n");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⣿⣿⣿⠀");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⣿⠀⠀⠀⣿");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⣿⣿⣿⣿");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⣿⠀⠀⠀⣿");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⣿⣿⣿⠀\n");
	}

	// Welcome screen
	public void welcomeScreen() {
		logo();
		System.out.println("                        1. Login");
		System.out.println("                        0. Terminate");
	}

	// Login method
	public void login(String librarianID) {
		currentLoggedUser = (Librarian) searchLibrarianByID(librarianID);
	}

	// need to be call everytime the user login/logout + need to set isLogin /
	// isLogout to true before it is called
	public void recordTime(boolean isLogin) {
		if (isLogin) {
			loggedList[recordCount] = currentLoggedUser;
			loginTime[recordCount] = LocalDateTime.now();
		} else {
			logoutTime[recordCount] = LocalDateTime.now();
			recordCount++;
		}
	}

	public void endingScreen() {
		logo();
		System.out.println("             Thank you for using our system!");
	}

	/****************************** Menu ******************************/
	// Display Main Menu
	public void displayHomeMenu() {
		System.out.println("++==============================++");
		System.out.println("||             Home             ||");
		System.out.println("++===++=========================++");
		System.out.println("|| 1 ||  Membership Management  ||");
		System.out.println("|| 2 ||  Book Borrowing         ||");
		System.out.println("|| 3 ||  Reports                ||");
		System.out.println("|| 4 ||  Login Records          ||");
		System.out.println("|| 0 ||  Logout                 ||");
		System.out.println("++===++=========================++");
	}

	/******************************
	 * Membership Module
	 ******************************/
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

	public void registerMembership(String name, String icNO, String gender, String dob, String phoneNO, String pinNO,
			double cardBalance) {
		int[] dmy = toIntDate(dob.split("/"));
		GregorianCalendar cardEXPDate = new GregorianCalendar(LocalDate.now().getYear() + 1,
				LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());

		borrowerList[Borrower.getTotalBorrowers()] = new Member(name, icNO, gender,
				new GregorianCalendar(dmy[2], dmy[1], dmy[0]), phoneNO,
				new LibraryCard(pinNO, cardEXPDate, cardBalance));
	}

	/****************************** Utility Methods ******************************/
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
				} else {
					System.out.println("\n\tInvalid selection! Please try again...");
				}
			} catch (Exception e) { // Activate when captured non-integer menu selection
				sc.nextLine();
				System.out.println("\n\tInvalid selection! Please try again...");
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
			} else {
				continueInput = false;
			}
		} while (continueInput);

		return choice.toUpperCase(); // Return uppercase choice
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
				} else {
					System.out.println("\n\tInvalid " + message + "! Please try again...\n");
				}
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("\n\tInvalid " + message + "! Please try again...\n");
			}
		} while (continueInput);

		sc.nextLine();

		return cash;
	}

	@Override
	public Borrower searchMemberByID(String memberID) {
		for (int i = 0; i < Borrower.getTotalBorrowers(); i++) {
			if (borrowerList[i] instanceof Member) {
				if (((Member) borrowerList[i]).getMemberID().matches(memberID)) {
					return borrowerList[i];
				}
			}
		}

		System.out.println("\n\tMember Not Found!");
		return null;
	}

	@Override
	public Borrower searchLibrarianByID(String librarianID) {
		for (int i = 0; i < Borrower.getTotalBorrowers(); i++) {
			if (borrowerList[i] instanceof Librarian) {
				if (((Librarian) borrowerList[i]).getLibrarianID().matches(librarianID)) {
					return borrowerList[i];
				}
			}
		}

		System.out.println("\n\tLibrarian Not Found!");
		return null;
	}

	@Override
	public Borrower searchBorrowerByID(String borrowerID) {
		if (borrowerID.matches("MB[0-9]{3}")) {
			return searchMemberByID(borrowerID);
		} else if (borrowerID.matches("LB[0-9]{3}")) {
			return searchLibrarianByID(borrowerID);
		}

		System.out.println("\n\tBorrower Not Found!");
		return null;
	}

	@Override
	public Borrower searchBorrowerByCardNO(String cardNO) {
		for (int i = 0; i < Borrower.getTotalBorrowers(); i++) {
			if (borrowerList[i].libraryCard.getCardNO().matches(cardNO)) {
				return borrowerList[i];
			}
		}

		System.out.println("\n\tBorrower Not Found!");
		return null;
	}

	@Override
	public LibraryCard searchLibraryCardByCardNO(String cardNO) {
		for (int i = 0; i < Borrower.getTotalBorrowers(); i++) {
			if (borrowerList[i].libraryCard.getCardNO().matches(cardNO)) {
				return borrowerList[i].libraryCard;
			}
		}
		System.out.println("\n\tLibrary Card Not Found!");
		return null;
	}

	public boolean validateLibraryCard(String cardNO, String pinNO) {
		if (searchLibraryCardByCardNO(cardNO) != null) {
			return searchLibraryCardByCardNO(cardNO).validatePinNO(pinNO);
		}
		System.out.println("\n\tWrong Pin Number!");
		return false;
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
	public static int toDays(LocalDate localDate) {
		return (localDate.getYear() * 365 + localDate.getMonthValue() * 30 + localDate.getDayOfMonth());
	}

	/******************************
	 * Book Borrowing Module
	 ******************************/
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
		System.out.println(
				"++====++==========================================++=========++=========================++================================++=======================++============++========++============++");
		System.out.println(
				"|| NO ||                Book Title                || Book ID ||       Book Author       ||         Book Publisher         || Book Publication Date || Book Price || Status || Borrow Fee ||");
		System.out.println(
				"++====++==========================================++=========++=========================++================================++=======================++============++========||============++");

		for (int i = 0; i < Book.getTotalBooks(); i++) {
			if (i > 0) {
				System.out.println(
						"++----++------------------------------------------++---------++-------------------------++--------------------------------++-----------------------++------------++--------++------------++");
			}
			System.out.printf("|| %02d || %-40s || %-7s || %-23s || %-30s || %-21s || %-10.2f || %-6s || %-10.2f ||\n",
					i + 1, bookList[i].getBookTitle(), bookList[i].getBookID(), bookList[i].getBookAuthor(),
					bookList[i].getBookPublisher(), bookList[i].publisherDateToString(), bookList[i].getBookPrice(),
					bookList[i].isBorrowed(), bookList[i].getBorrowFees());
		}
		System.out.println(
				"++====++==========================================++=========++=========================++================================++=======================++============++========||============++");
		System.out.println("\nTotal Book(s) Found: " + Book.getTotalBooks() + "\n");
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

	@Override
	public void searchBookByTitle(String bookTitle) {
		int totalResult = 0;

		System.out.println("Results match with \"" + bookTitle + "\":");

		for (int i = 0; i < Book.getTotalBooks(); i++) {
			if (bookList[i].getBookTitle().toUpperCase().indexOf(bookTitle.toUpperCase()) != -1) {
				totalResult++;
				System.out.printf("\nResult %d\n", totalResult);
				bookList[i].displayBookDetails();
			}
		}
		System.out.println("\nTotal Book(s) Found: " + totalResult);
	}

	@Override
	public Book searchBookByID(String bookID) {
		for (int i = 0; i < Book.getTotalBooks(); i++) {
			if (bookList[i].getBookID().indexOf(bookID) != -1) {
				return bookList[i];
			}
		}

		System.out.println("\n\tBook Not Found!");
		return null;
	}

	@Override
	public void searchBookByAuthor(String bookAuthor) {
		int totalResult = 0;

		System.out.println("Results match with \"" + bookAuthor + "\":");

		for (int i = 0; i < Book.getTotalBooks(); i++) {
			if (bookList[i].getBookAuthor().toUpperCase().indexOf(bookAuthor.toUpperCase()) != -1) {
				totalResult++;
				System.out.printf("\nResult %d\n", totalResult);
				bookList[i].displayBookDetails();
			}
		}
		System.out.println("\nTotal Book(s) Found: " + totalResult);
	}

	@Override
	public void searchBookByPublisher(String bookPublisher) {
		int totalResult = 0;

		System.out.println("Results match with \"" + bookPublisher + "\":");

		for (int i = 0; i < Book.getTotalBooks(); i++) {
			if (bookList[i].getBookPublisher().toUpperCase().indexOf(bookPublisher.toUpperCase()) != -1) {
				totalResult++;
				System.out.printf("\nResult %d\n", totalResult);
				bookList[i].displayBookDetails();
			}
		}
		System.out.println("\nTotal Book(s) Found: " + totalResult);
	}

	/****************************** Reports Module ******************************/
	// Display Report Menu
	public void displayReportMenu() {
		System.out.println("++==================================++");
		System.out.println("||              Report              ||");
		System.out.println("++===++=============================++");
		System.out.println("|| 1 ||  Daily Book Borrow Report   ||");
		System.out.println("|| 2 ||  Daily Book Return Report   ||");
		System.out.println("|| 3 ||  Expired Borrower Report    ||");
		System.out.println("|| 0 ||  Back to Home               ||");
		System.out.println("++===++=============================++");
	}

	public void displayDailyBookBorrowReport() {
		int count = 0;
		System.out.println("                        Daily Book Borrowed Report for " + LocalDate.now().getDayOfMonth()
				+ "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear());
		System.out.println(
				"+==========================================+=====================+======================+==================+");
		System.out.println(
				"|                Book Title                |       Book ID       |     Borrower Name    |    Borrower ID   |  ");
		System.out.println(
				"+==========================================+=====================+======================+==================+");
		for (int i = 0; i < Borrower.getTotalBorrowers(); i++) {
			if (borrowerList[i].libraryCard.getCurrentBorrowedCount() > 0) {
				for (int j = 0; j < borrowerList[i].libraryCard.getCurrentBorrowedCount(); j++) {
					if (toDays(borrowerList[i].libraryCard.getCurrentBorrowed()[j].getBorrowDate()) == toDays(
							LocalDate.now())) {
						if (count > 0) {
							System.out.println(
									"+------------------------------------------+---------------------+-----------------------+-----------------+");
						}
						System.out.printf("| %-40s | %-19s | %-20s |",
								borrowerList[i].libraryCard.getCurrentBorrowed()[j].getBookTitle(),
								borrowerList[i].libraryCard.getCurrentBorrowed()[j].getBookID(), borrowerList[i].name);
						if (borrowerList[i] instanceof Member) {
							System.out.printf(" %-16s |\n", ((Member) borrowerList[i]).getMemberID());
						} else {
							System.out.printf(" %-16s |\n", ((Librarian) borrowerList[i]).getLibrarianID());
						}
						count++;
					}
				}
			}
		}
		System.out.println(
				"+==========================================+=====================+======================+==================+");
		System.out.println("Total count book borrowed: " + count);
	}

	public void displayDailyBookReturnedReport() {
		int count = 0;
		System.out.println("                        Daily Book Returned Report for " + LocalDate.now().getDayOfMonth()
				+ "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear());
		System.out.println(
				"+==========================================+=====================+======================+==================+");
		System.out.println(
				"|                 Book Title               |       Book ID       |     Borrower Name    |    Borrower ID   |  ");
		System.out.println(
				"+==========================================+=====================+======================+==================+");

		for (int i = 0; i < Borrower.getTotalBorrowers(); i++) {

			if (borrowerList[i].libraryCard.getBorrowedHistoryCount() > 0) {
				for (int j = 0; j < borrowerList[i].libraryCard.getBorrowedHistoryCount(); j++) {
					if (toDays(borrowerList[i].libraryCard.getBorrowedHistory()[j].getReturnDate()) == toDays(
							LocalDate.now())) {
						if (count > 0) {
							System.out.println(
									"+-----------------------------------------+---------------------+---------------------+------------------+");
						}
						System.out.printf("| %-40s | %-19s | %-20s |",
								borrowerList[i].libraryCard.getBorrowedHistory()[j].getBookTitle(),
								borrowerList[i].libraryCard.getBorrowedHistory()[j].getBookID(), borrowerList[i].name);
						if (borrowerList[i] instanceof Member) {
							System.out.printf(" %-16s |\n", ((Member) borrowerList[i]).getMemberID());
						} else {
							System.out.printf(" %-16s |\n", ((Librarian) borrowerList[i]).getLibrarianID());
						}
						count++;
					}
				}
			}
		}
		System.out.println(
				"+==========================================+=====================+======================+==================+");
		System.out.println("Total count book returned: " + count);
	}

	public void displayExpiredBorrowerReport() {
		int count = 0;
		System.out.println(
				"                               Library Card Expired Report                                   ");
		System.out.println(
				"+===============+=====================+==============+==================+===================+");
		System.out.println(
				"|  Borrower ID  |    Borrower Name    |   Phone No   |   Expired Date   |  Expired Duration | ");
		System.out.println(
				"---------------------------------------------------------------------------------------------");

		for (int i = 0; i < Borrower.getTotalBorrowers(); i++) {
			LocalDate expDate = LocalDate.of(borrowerList[i].libraryCard.getCardExpDate().get(Calendar.YEAR),
					borrowerList[i].libraryCard.getCardExpDate().get(Calendar.MONTH),
					borrowerList[i].libraryCard.getCardExpDate().get(Calendar.DAY_OF_MONTH));
			int daysBetween = toDays(LocalDate.now()) - toDays(expDate);
			if (daysBetween > 0) {
				if (borrowerList[i] instanceof Member) {
					System.out.printf("| %-14s", ((Member) borrowerList[i]).getMemberID());
				} else {
					System.out.printf("| %-14s", ((Librarian) borrowerList[i]).getLibrarianID());
				}

				System.out.format("| %-20s| %-13s|    %-14s|    %4d day(s)    |\n", borrowerList[i].name,
						borrowerList[i].phoneNO, borrowerList[i].libraryCard.cardExpDateToString(), daysBetween);
				count++;
			}
		}
		System.out.println(
				"+===============+=====================+==============+==================+===================+");
		System.out.printf("Total borrower had expired :                                             %d(person(s))\n",
				count);
	}

	/******************************
	 * Administrative Module
	 ******************************/
	// Display login Records for Library Admin
	public void displayLoginRecords() {
		if (recordCount == 0) {
			System.out.println("No Login Records!");
		} else {
			System.out.println("+==========+=====================+======================+");
			System.out.println("| Login ID |     Login Time      |     Logout Time      |");
			System.out.println("+==========+=====================+======================+");
			for (int i = 0; i < recordCount; i++) {
				System.out.printf("| %-8s | %19s | %19s  |\n", loggedList[i].getLibrarianID(), loginTime[i].format(dtf),
						logoutTime[i].format(dtf));
			}
			System.out.println("+==========+=====================+======================+");
		}
	}
}
