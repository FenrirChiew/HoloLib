package holoLib;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class LibrarySystem {
	/********** Properties **********/
	private Borrower[] librarianList;
	private Borrower[] memberList;
	private Material[] materialList;

	/********** Constructors **********/
	public LibrarySystem() {
		this(null, null, null);
	}

	// testing purpose
	public LibrarySystem(Borrower[] librarianList, Borrower[] memberList) {
		this.librarianList = librarianList;
		this.memberList = memberList;
		materialList = null;
	}

	public LibrarySystem(Borrower[] librarianList, Borrower[] memberList, Material[] materialList) {
		this.librarianList = librarianList;
		this.memberList = memberList;
		this.materialList = materialList;
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

	public Material[] getMaterialList() {
		return materialList;
	}

	public void setMaterialList(Material[] materialList) {
		this.materialList = materialList;
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
		System.out.println("||     Membership Managnement     ||");
		System.out.println("++================================++");
		System.out.println("|| 1 ||  Membership Registration  ||");
		System.out.println("|| 2 ||  Card Renewal             ||");
		System.out.println("|| 3 ||  Reload Card Balance      ||");
		System.out.println("|| 4 ||  Search Borrower          ||");
		System.out.println("|| 0 ||  Back to Home             ||");
		System.out.println("++===++===========================++");
	}
	// Renew means the expire date is reach then renew
	// Reload means the card do not have enough balance then reload
	// this display all member detail?

	public void registerMembership(String name, String icNO, String gender, String dob, String phoneNO, String pinNO) {
		int[] dmy = toIntDate(dob.split("/"));
		GregorianCalendar cardEXPDate = new GregorianCalendar(LocalDate.now().getYear() + 1,
				LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());

		memberList[memberList.length] = new Member(name, icNO, gender, new GregorianCalendar(dmy[2], dmy[1], dmy[0]),
				phoneNO, new LibraryCard(pinNO, cardEXPDate));
	}

	public LibraryCard searchLibraryCardByCardNO(String cardNO) {
		for (int i = 0; i < memberList.length; i++) {
			if (memberList[i].libraryCard.getCardNO().matches(cardNO)) {
				return memberList[i].libraryCard;
			}
		}

		for (int i = 0; i < librarianList.length; i++) {
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

	public double captureMoney(String message) {
		Scanner sc = new Scanner(System.in);
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
				System.out.println("\n\tInvalid " + message + "! Please try agian...\n");
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
			for (int i = 0; i < memberList.length; i++) {
				if (((Member) memberList[i]).getMemberID().matches(borrowerID)) {
					return memberList[i];
				}
			}
		} else if (borrowerID.matches("LB[0-9]{3}")) {
			for (int i = 0; i < librarianList.length; i++) {
				if (((Librarian) librarianList[i]).getLibrarianID().matches(borrowerID)) {
					return librarianList[i];
				}
			}
		}

		return null;
	}

	// Display Borrow Menu
	public void displayBorrowMenu() {
		System.out.println("++=========================++");
		System.out.println("||     Book Borrowing      ||");
		System.out.println("++=========================++");
		System.out.println("|| 1 ||  Display book      ||");
		System.out.println("|| 2 ||  Search book       ||");
		System.out.println("|| 3 ||  Borrow book       ||");
		System.out.println("|| 4 ||  Return book       ||");
		System.out.println("|| 0 ||  Back to Home      ||");
		System.out.println("++===++====================++");
	}

	// * Date how to print @A@
	public void displayBook() {
		System.out.println("++======================++");
		System.out.println("||     Display Book      ||");
		System.out.println(
				"++====++========================++=========++=========================++==================++=======================++============++");
		System.out.println(
				"|| NO ||       Book Title       || Book ID ||       Book Author       ||  Book Publisher  || Book Publication Date || Book Price ||");
		System.out.println(
				"++====++========================++=========++=========================++==================++=======================++============++");

		for (int i = 0; i < materialList.length; i++) {
			System.out.printf("|| %02d || %-22s || %-7s || %-23s || %-16s || date || %-10.2f ||\n", i + 1,
					materialList[i].materialTitle, materialList[i].materialID, materialList[i].materialAuthor,
					materialList[i].materialPublisher, materialList[i].materialPublicationDate,
					materialList[i].materialPrice);
			System.out.println(
					"++====++========================++=========++=========================++==================++=======================++============++");
		}
		System.out.println("\nTotal Book(s) Found: " + materialList.length);
	}

	public void borrowBook() {
		// Member ID:
		// searchMemberByID()
		// Book ID:
		// searchBookByID()
		// Confirmation
		// Y - borrowBook(), cal()/pay()
		// any wrong - captureContinueChoice() - used to ask user continue ? (Y/N)
		// Y - loop again, N - back to menu
	}

	public void returnBook() {

	}

	public void DailyBookBorrowReport(Member[] member, Librarian[] librarian) {

		System.out.println("                        Daily Book Borrowed Report for " + LocalDate.now().getDayOfMonth()
				+ "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear());
		System.out.println("+===================================================================================+");
		System.out.println("|        Book Name        |      Book ID      |    Borrower Name   |   Borrower ID  |  ");
		for (int i = 0; i < member.length; i++) {
			if (member[i].libraryCard.getCurrentBorrowed().length > 0) {
				for (int j = 0; j < member[i].libraryCard.getCurrentBorrowed().length; j++) {
					Material book = member[i].libraryCard.getCurrentBorrowed()[j];
					if (((Borrowable) book).getBorrowDate() == LocalDate.now()) {
						System.out.printf("%-25s|%-19s|%-20s|%-16s|", book.getMaterialTitle(), book.materialID,
								member[i].name, member[i].getMemberID());
					}
				}
			}
		}

		for (int i = 0; i < librarian.length; i++) {
			if (librarian[i].libraryCard.getCurrentBorrowed().length > 0) {
				for (int j = 0; j < librarian[i].libraryCard.getCurrentBorrowed().length; j++) {
					Material book = librarian[i].libraryCard.getCurrentBorrowed()[j];
					if (((Borrowable) book).getBorrowDate() == LocalDate.now()) {
						System.out.printf("%-25s|%-19s|%-20s|%-16s|", book.getMaterialTitle(), book.materialID,
								librarian[i].name, librarian[i].getLibrarianID());
					}
				}
			}

		}

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

		for (int i = 0; i < materialList.length; i++) {
			if (materialList[i].materialTitle.toUpperCase().indexOf(bookTitle.toUpperCase()) != -1) {
				totalResult++;
				System.out.printf("\nResult %d\n", totalResult);
				System.out.println("========");
				materialList[i].toString();
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

	public void addBook() {

	}

	public void modifyBook() {

	}

	public void deleteBook() {

	}

	// Capture an menu selection after invoke any menu method
	public int captureMenuSelection(int maxMenuSelection) {
		Scanner sc = new Scanner(System.in);
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
				System.out.println("\n\tInvalid selection! Please try agian...");
				sc.nextLine();
			}
		} while (continueInput);

		sc.nextLine(); // Clear input buffer

		sc.close();

		return selection; // Return menu selection
	}

	// Capture a Y or N choice
	public String captureYesNoChoice(String message) {
		Scanner sc = new Scanner(System.in);
		boolean continueInput = true;
		String choice = "";

		// Keep looping until:
		// 1. Captured a proper choice ("Y" / "N")
		// 2. The choice is exact 1 character
		do {
			System.out.print("\n" + message + " (Y/N) > ");
			choice = sc.nextLine();

			if (!(choice.length() == 1 && choice.toUpperCase().matches("Y|N"))) {
				System.out.println("\n\tInvalid choice! Please try agian...");
				sc.nextLine();
			} else {
				continueInput = false;
			}
		} while (continueInput);

		sc.nextLine(); // Clear input buffer

		sc.close();

		return choice; // Return choice
	}

	public boolean validateStringFormat(String type, String str, String regex) {
		if (!str.matches(regex)) {
			System.out.println("\n\tInvalid " + type + "! Please try agian...\n");
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

			if (toIntDate(day_month_year)[2] < 1900 || toIntDate(day_month_year)[2] > LocalDate.now().getYear()) {
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

	// Login method
	public void Login() {
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("ID: ");
			String id = sc.nextLine();
			System.out.println("Password: ");
			String password = sc.nextLine();

			if (validateLogin(id, password)) {
				sc.close();
				break;
			} else {
				System.out.println("\n\tWrong ID or password. Please try again.");
			}
		} while (true);
	}

	// Validate Login using Input Librarian ID and Input Password
	public boolean validateLogin(String librarianID, String password) {
		// Loop through Librarian List to search matched Librarian ID and Password
		for (int i = 0; i < librarianList.length; i++) {
			// Return True when:
			// 1. The Input Librarian ID is matched with the Librarian ID at the index i
			// 2. The Input Password is matched with the Librarian Password at the index i
			if (((Librarian) librarianList[i]).getLibrarianID().matches(librarianID)
					&& ((Librarian) librarianList[i]).getPassword().matches(password)) {
				return true;
			}
		}

		return false; // Return False when both conditions above is not achieved
	}

	// HoloLib logo
	public void Logo() {
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠤⠖⠚⢉⣩⣭⡭⠛⠓⠲⠦⣄⡀⠀⠀⠀⠀⠀⠀⠀");
		System.out.println("⠀⠀⠀⠀⠀⠀⢀⡴⠋⠁⠀⠀⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠳⢦⡀⠀⠀⠀⠀");
		System.out.println("⠀⠀⠀⠀⢀⡴⠃⢀⡴⢳⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣆⠀⠀⠀");
		System.out.println("⠀⠀⠀⠀⡾⠁⣠⠋⠀⠈⢧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢧⠀⠀");
		System.out.println("⠀⠀⠀⣸⠁⢰⠃⠀⠀⠀⠈⢣⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣇⠀");
		System.out.println("⠀⠀⠀⡇⠀⡾⡀⠀⠀⠀⠀⣀⣹⣆⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⠀");
		System.out.println("⠀⠀⢸⠃⢀⣇⡈⠀⠀⠀⠀⠀⠀⢀⡑⢄⡀⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡇");
		System.out.println("⠀⠀⢸⠀⢻⡟⡻⢶⡆⠀⠀⠀⠀⡼⠟⡳⢿⣦⡑⢄⠀⠀⠀⠀⠀⠀⠀⠀⢸⡇");
		System.out.println("⠀⠀⣸⠀⢸⠃⡇⢀⠇⠀⠀⠀⠀⠀⡼⠀⠀⠈⣿⡗⠂⠀⠀⠀⠀⠀⠀⠀⢸⠁");
		System.out.println("⠀⠀⡏⠀⣼⠀⢳⠊⠀⠀⠀⠀⠀⠀⠱⣀⣀⠔⣸⠁⠀⠀⠀⠀⠀⠀⠀⢠⡟⠀");
		System.out.println("⠀⠀⡇⢀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⢸⠃⠀");
		System.out.println("⠀⢸⠃⠘⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠁⠀⠀⢀⠀⠀⠀⠀⠀⣾⠀⠀");
		System.out.println("⠀⣸⠀⠀⠹⡄⠀⠀⠈⠁⠀⠀⠀⠀⠀⠀⠀⡞⠀⠀⠀⠸⠀⠀⠀⠀⠀⡇⠀⠀");
		System.out.println("⠀⡏⠀⠀⠀⠙⣆⠀⠀⠀⠀⠀⠀⠀⢀⣠⢶⡇⠀⠀⢰⡀⠀⠀⠀⠀⠀⡇⠀⠀");
		System.out.println("⢰⠇⡄⠀⠀⠀⡿⢣⣀⣀⣀⡤⠴⡞⠉⠀⢸⠀⠀⠀⣿⡇⠀⠀⠀⠀⠀⣧⠀⠀");
		System.out.println("⣸⠀⡇⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⢹⠀⠀⢸⠀⠀⢀⣿⠇⠀⠀⠀⠁⠀⢸⠀⠀");
		System.out.println("⣿⠀⡇⠀⠀⠀⠀⠀⢀⡤⠤⠶⠶⠾⠤⠄⢸⠀⡀⠸⣿⣀⠀⠀⠀⠀⠀⠈⣇⠀");
		System.out.println("⡇⠀⡇⠀⠀⡀⠀⡴⠋⠀⠀⠀⠀⠀⠀⠀⠸⡌⣵⡀⢳⡇⠀⠀⠀⠀⠀⠀⢹⡀");
		System.out.println("⡇⠀⠇⠀⠀⡇⡸⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠮⢧⣀⣻⢂⠀⠀⠀⠀⠀⠀⢧");
		System.out.println("⣇⠀⢠⠀⠀⢳⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⡎⣆⠀⠀⠀⠀⠀⠘");
		System.out.println("⢻⠀⠈⠰⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⠘⢮⣧⡀⠀⠀⠀⠀");
		System.out.println("⠸⡆⠀⠀⠇⣾⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠆⠀⠀⠀⠀⠀⠀⠀⠙⠳⣄⡀⢢⡀");
		System.out.println("\n");
		System.out.println("⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⣿⣿⣿⠀");
		System.out.println("⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⣿⠀⠀⠀⣿");
		System.out.println("⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⣿⣿⣿⣿");
		System.out.println("⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⣿⠀⠀⠀⣿");
		System.out.println("⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⣿⣿⣿⠀");
		System.out.println("\n");
		System.out.println("              Press Enter to continue...");
	}
}
