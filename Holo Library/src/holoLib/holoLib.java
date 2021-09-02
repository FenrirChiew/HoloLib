package holoLib;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class holoLib {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Librarian[] librarianList = {
				new Librarian("Watoto", "111111-11-1111", "Male", new GregorianCalendar(2001, 1, 1), "111-1111111",
						new LibraryCard("010101", new GregorianCalendar(2022, 02, 1)), "admin1", "Library Admin"),
				new Librarian("Kiwawa", "222222-22-2222", "Female", new GregorianCalendar(2002, 2, 2), "222-2222222",
						new LibraryCard("020202", new GregorianCalendar(2021, 12, 1)), "admin2", "General Staff"),
				new Librarian("Yuul B Alwright", "333333-33-3333", "Female", new GregorianCalendar(2003, 3, 3),
						"333-3333333", new LibraryCard("030303", new GregorianCalendar(2022, 5, 1)), "admin3",
						"General Staff"),
				new Librarian("Memei", "444444-44-4444", "Female", new GregorianCalendar(2004, 4, 4), "444-4444444",
						new LibraryCard("040404", new GregorianCalendar(2021, 10, 1)), "admin4", "Librarian Admin") };
		Member[] memberList = {
				new Member("LaoSu", "555555-55-5555", "Female", new GregorianCalendar(2001, 1, 31), "555-5555555",
						new LibraryCard("050505", new GregorianCalendar(2022, 9, 1))),
				new Member("FEET", "666666-66-6666", "Female", new GregorianCalendar(2002, 2, 28), "666-6666666",
						new LibraryCard("060606", new GregorianCalendar(2021, 9, 1))),
				new Member("DAD", "777777-77-7777", "Male", new GregorianCalendar(2003, 3, 31), "777-7777777",
						new LibraryCard("070707", new GregorianCalendar(2022, 3, 1))),
				new Member("Branch Horn", "888888-88-8888", "Female", new GregorianCalendar(2004, 4, 30), "888-8888888",
						new LibraryCard("080808", new GregorianCalendar(2022, 1, 1))) };
		LibrarySystem holoLib = new LibrarySystem(librarianList, memberList);

		String librarianID;
		do {
			System.out.print("Librarian ID: ");
			librarianID = sc.nextLine();
		} while (!holoLib.validateStringFormat("Librarian ID", librarianID, "(LB[0-9]{3}"));

		String password;
		do {
			System.out.print("Passoword: ");
			password = sc.nextLine();
		} while (!holoLib.validateStringFormat("Password (Must be a combination of letters and digits)", password,
				"(?=.*[0-9])(?=.*[a-z])(?=.*[a-zA-Z])[0-9A-Za-z]+"));

		if (holoLib.searchLibrarianByID(librarianID) == null) {
			System.out.println("\n\tLibrarian ID does not exist! Login Failed...\n");
		} else {
			if (!((Librarian) holoLib.searchLibrarianByID(librarianID)).validateLogin(password)) {
				System.out.println("\n\tWrong Password! Login Failed...\n");
			} else {
				holoLib.login(librarianID);
				System.out.println("\n\tLogin Successful! Welcome Back, " + holoLib.getCurrentLoggedUser().name + "\n");
			}
		}

		int selection = 0;
		do {
			cls();
			holoLib.displayMembershipMenu();
			selection = holoLib.captureMenuSelection(4);
			cls();

			switch (selection) {
				case 0:
					break;
				case 1:
					do {
						String name;
						do {
							System.out.print("Name: ");
							name = sc.nextLine();
						} while (!holoLib.validateStringFormat("Name", name, "([A-Z][A-Za-z]* *)+"));

						String icNO;
						do {
							System.out.print("IC Number: ");
							icNO = sc.nextLine();
						} while (!holoLib.validateStringFormat("IC Number", icNO, "[0-9]{6}-[0-9]{2}-[0-9]{4}"));

						String gender;
						do {
							System.out.print("Gender: ");
							gender = sc.nextLine();
						} while (!holoLib.validateStringFormat("Gender", gender, "[Male|Female]"));

						String dob;
						do {
							System.out.print("Date of Birth (DD/MM/YYYY): ");
							dob = sc.nextLine();
						} while (!holoLib.validateDate(dob));

						String phoneNO;
						do {
							System.out.print("Phone Number (XXX-XXXXXXX): ");
							phoneNO = sc.nextLine();
						} while (!holoLib.validateStringFormat("Phone Number", phoneNO, "[0-9]{3}-[0-9]{7,8}"));

						String pinNO;
						do {
							System.out.print("Pin Number for Library Card: ");
							pinNO = sc.nextLine();
						} while (!holoLib.validateStringFormat("Pin Number", pinNO, "[0-9]{6}"));

						if (holoLib.captureYesNoChoice("Confirm Registration") == "Y") {
							holoLib.registerMembership(name, icNO, gender, dob, phoneNO, pinNO);
							System.out.println("Registration Successfully!");
						} else {
							System.out.println("Registration Canceled!");
						}
					} while (holoLib.captureYesNoChoice("Another Registration") == "Y");
					break;
				case 2:
					do {
						String cardNO;
						do {
							System.out.print("Library Card Number: ");
							cardNO = sc.nextLine();
						} while (!holoLib.validateStringFormat("Library Card Number", cardNO, "LC[0-9]{3}"));

						String pinNO;
						do {
							System.out.print("Pin Number: ");
							pinNO = sc.nextLine();
						} while (!holoLib.validateStringFormat("Pin Number", pinNO, "[0-9]{6}"));

						if (holoLib.validateLibraryCard(cardNO, pinNO)) {
							System.out.println("Card Expired Date: "
									+ holoLib.searchLibraryCardByCardNO(cardNO).cardExpDateToString());

							if (holoLib.captureYesNoChoice("Confirm Renewal") == "Y") {
								holoLib.searchLibraryCardByCardNO(cardNO).renewCardExpDate();
								System.out.println("Renewal Successfully!");
							} else {
								System.out.println("Renewal Canceled!");
							}
						}
					} while (holoLib.captureYesNoChoice("Another Reload") == "Y");
					break;
				case 3:
					do {
						String cardNO;
						do {
							System.out.print("Library Card Number: ");
							cardNO = sc.nextLine();
						} while (!holoLib.validateStringFormat("Library Card Number", cardNO, "LC[0-9]{3}"));

						String pinNO;
						do {
							System.out.print("Pin Number: ");
							pinNO = sc.nextLine();
						} while (!holoLib.validateStringFormat("Pin Number", pinNO, "[0-9]{6}"));

						if (holoLib.validateLibraryCard(cardNO, pinNO)) {
							double cash = holoLib.captureMoney("Reload Amount");
							if (holoLib.captureYesNoChoice("Confirm Reload") == "Y") {
								holoLib.reloadCardBalance(cardNO, cash);
								System.out.println("Reload Successfully!");
							} else {
								System.out.println("Reload Canceled!");
							}
						}
					} while (holoLib.captureYesNoChoice("Another Reload") == "Y");
					break;
				case 4:
					do {
						String borrowerID;
						do {
							System.out.print("Member/Librarian ID: ");
							borrowerID = sc.nextLine();
						} while (!holoLib.validateStringFormat("Member/Librarian ID", borrowerID, "[LB|MB][0-9]{3}"));

						if (holoLib.searchBorrowerByID(borrowerID) != null) {
							holoLib.searchBorrowerByID(borrowerID).displayBorrowerDetails();
						} else {
							System.out.println("Borrower Not Found!");
						}
					} while (holoLib.captureYesNoChoice("Search Another Borrower") == "Y");
					break;
			}
		} while (selection != 0);

		System.out.println("\n\tBack to Home. Press Enter to continue...");
		sc.nextLine();
		cls();

		// BorrowMenu, BookSearchingMenu
		do {
			cls();
			holoLib.displayBorrowMenu();
			selection = holoLib.captureMenuSelection(4);
			cls();

			switch (selection) {
				case 0:
					break;
				case 1:
					holoLib.displayBook();
					break;
				case 2:
					cls();
					holoLib.displayBookSearchingMenu();
					int searchSelection = holoLib.captureMenuSelection(4);
					cls();
					do {
						switch (searchSelection) {
							case 0:
								break;
							case 1:
								String title;
								System.out.print("Enter Book Title: ");
								title = sc.nextLine();

								holoLib.searchBookByTitle(title);
								break;
							case 2:
								String id;
								do {
									System.out.println("Enter Book ID: ");
									id = sc.nextLine();
								} while (!holoLib.validateStringFormat("Book ID", id, "BK[0-9]{3}"));

								holoLib.searchBookByID(id);
								break;
							case 3:
								String author;
								System.out.println("Enter Book Author: ");
								author = sc.nextLine();

								holoLib.searchBookByAuthor(author);
								break;
							case 4:
								String publisher;
								System.out.println("Enter Book Publisher: ");
								publisher = sc.nextLine();

								holoLib.searchBookByPublisher(publisher);
								break;
						}
					} while (searchSelection != 0);
					break;
				case 3:
					do {
						String borrowerID;
						do {
							System.out.print("Member/Librarian ID: ");
							borrowerID = sc.nextLine();
						} while (!holoLib.validateStringFormat("Member/Librarian ID", borrowerID, "[LB|MB][0-9]{3}"));

						if (holoLib.searchBorrowerByID(borrowerID) != null) {
							// Display Borrower Details founded
							holoLib.searchBorrowerByID(borrowerID).displayBorrowerDetails();

							String bookID;
							do {
								System.out.println("Enter Book ID: ");
								bookID = sc.nextLine();
							} while (!holoLib.validateStringFormat("Book ID", bookID, "BK[0-9]{3}"));

							// searchBookByID()
							if (holoLib.searchBookByID(bookID) != null) {
								// Display Book Details found
								holoLib.searchBookByID(bookID).displayBookDetails();

								// check borrow status
								if (((Book) holoLib.searchBookByID(bookID)).isBorrowed() == false) {
									// Confirmation
									if (holoLib.captureYesNoChoice("Confirm borrow book " + bookID + "?") == "Y") {
										// borrow
										String pinNo;
										System.out.println("Enter PIN No: ");
										pinNo = sc.nextLine();

										holoLib.searchBorrowerByID(borrowerID).borrowBook(pinNo,
												holoLib.searchBookByID(bookID));

										// pay
										// * LB - Rate xxx, * MB - Rate xxx , take to * the borrow fee
										holoLib.searchBorrowerByID(borrowerID).libraryCard
												.cashOut(((Book) holoLib.searchBookByID(bookID)).getBorrowFees());
									}
								} else {
									System.out.println("\nThis book cannot be borrowed.");
								}
							}
						}
					} while (holoLib.captureYesNoChoice("Continue borrow ?") == "Y");
					break;
				case 4:
					// return = Kong Zhi Lin
					break;
			}
		} while (selection != 0);

		// BooksInvManagementMenu
		do {
			cls();
			holoLib.displayBooksInvManagementMenu();
			selection = holoLib.captureMenuSelection(3);
			cls();

			switch (selection) {
				case 0:
					break;
				case 1:
					do {
						// prompt user enter book details
						System.out.print("Enter Book Title: ");
						String title = sc.nextLine();

						System.out.print("Enter Book Author: ");
						String author = sc.nextLine();

						System.out.print("Enter Book Publisher: ");
						String publisher = sc.nextLine();

						String publisherDate;
						do {
							System.out.print("Enter Book Publisher Date (DD/MM/YYYY): ");
							publisherDate = sc.nextLine();
						} while (!holoLib.validateDate(publisherDate));

						System.out.print("Enter Book Price: ");
						double price = sc.nextDouble();

						// Ask user to confirm add this book
						if ((holoLib.captureYesNoChoice("Confirm add this book ?")) == "Y") {
							holoLib.addBook(title, author, publisher, publisherDate, price);
							System.out.println(holoLib.getBookList()[holoLib.getBookList().length]);
							System.out.println("This add book action has been success.");
						} else {
							System.out.println("This add book action has been repeal.");
						}
					} while (holoLib.captureYesNoChoice("Add another book?") == "Y");
					break;
				case 2:
					// modify
					break;
				case 3:
					// delete
					break;
			}
		} while (selection != 0);

		// Administrative
		String confirmPassword = "0";
		do {
			cls();
			System.out.println("Security Lock");
			System.out.println("=============");

			if (!holoLib.getCurrentLoggedUser().isAdmin()) {
				System.out.println("\n\tYou are not a Library Admin! Access Denied...\n");
			} else {
				System.out.println("Librarian ID: " + holoLib.getCurrentLoggedUser().getLibrarianID());

				do {
					System.out.print("Password (Exit = 0): ");
					confirmPassword = sc.nextLine();
				} while (!holoLib.validateStringFormat("Password (Must be a combination of letters and digits)",
						confirmPassword, "(?=.*[0-9])(?=.*[a-z])(?=.*[a-zA-Z])[0-9A-Za-z]+|0"));

				if (!confirmPassword.matches("0")) {
					if (!holoLib.getCurrentLoggedUser().validateLogin(confirmPassword)) {
						System.out.println("\n\tWrong Password! Access Denied...\n");
					} else {
						do {
							holoLib.displayAdministrativeMenu();
							selection = holoLib.captureMenuSelection(3);
							cls();

							switch (selection) {
								case 0:
									break;
								case 1:
									holoLib.displayMemberManagementMenu();
									break;
								case 2:
									holoLib.displayLibrarianManagementMenu();
									break;
								case 3:
									holoLib.displayBooksInvManagementMenu();
									break;
							}
						} while (selection != 0);
					}
				}
			}
		} while (holoLib.getCurrentLoggedUser().isAdmin() && !confirmPassword.matches("0"));

		sc.close();
	}

	// Clear Screen
	public static void cls() {
		System.out.print("\033[H\033[2J");
		// \033 - Escape character (ECS)
		// \033[H - Move cursor to top left of the console
		// \033[2J - Clear the screen from cursor to the end of the console
		System.out.flush(); // Clear the buffers
	}
}

// Scanner sc = new Scanner(System.in);
// Facility[] facilityList = {
// new Area("Detective ICT Area", "FT001", "Area", "Desktop Computer, Headphone,
// Printer, Air-conditional",
// 5.0, new Member[] {}, 100),
// new Room("Shark Meeting Room", "FT002", "Room", "Microphone, Speaker, White
// Board, Air-conditional",
// 10.0, new Member[] {}, 20),
// new Area("Ancient Study Area", "FT003", "Area", "Tablet, Speaker, Projector,
// Air-conditional", 10.0,
// new Member[] {}, 120),
// new Room("Ripper Meeting Room", "FT004", "Room",
// "Laptop Computer, Microphone, Speaker, Projector, Air-conditional", 20.0, new
// Member[] {}, 30),
// new Room("Bird Meeting Room", "FT005", "Room", "Microphone, Speaker,
// Projector, Air-conditional", 15.0,
// new Member[] {}, 30) };
// LibrarySystem holoLib = new LibrarySystem(facilityList);
// int selection = 0;

// holoLib.Logo();

// cls();
// holoLib.displayReserveMenu();
// selection = holoLib.captureMenuSelection(3);
// cls();

// switch (selection) {
// case 0:
// System.out.print("\n\tReturn to last stage. Press Enter to continue...");
// sc.nextLine();
// cls();
// break;
// case 1:
// holoLib.displayFacility();
// System.out.print("\n\tReturn to last stage. Press Enter to continue...");
// sc.nextLine();
// cls();
// break;
// case 2:
// int searchSelection = 0;

// do {
// holoLib.searchFacilityMenu();
// searchSelection = holoLib.captureMenuSelection(3);

// sc.nextLine();
// cls();

// switch (searchSelection) {
// // case 0 is Exit --> nothing to do
// case 1:
// System.out.print("Enter Facility Name > ");
// String facilityName = sc.nextLine();
// holoLib.searchFacilityByName(facilityName);
// break;
// case 2:
// System.out.println("Enter Facility ID > ");
// String facilityID = sc.nextLine();
// holoLib.searchFacilityByID(facilityID);
// break;
// case 3:
// System.out.println("Enter Facility Type (Area/Room) > ");
// String facilityType = sc.nextLine();
// holoLib.searchFacilityByType(facilityType);
// break;
// }

// } while (holoLib.captureContinueChoice().toUpperCase() == "Y");

// System.out.print("\n\tReturn to last stage. Press Enter to continue...");
// sc.nextLine();
// cls();
// break;
// case 3:
// Member member = null;

// do {
// System.out.println("Enter Member ID > ");
// String memberID = sc.nextLine();
// System.out.println("Enter Library Card Number > ");
// String cardNO = sc.nextLine();

// member = holoLib.searchMemberByID(memberID);

// if (member != null) {
// if (member.getLibraryCard() == holoLib.searchLibraryCardByNO(cardNO)) {
// Facility facility = null;

// System.out.println("Enter Facility ID > ");
// String facilityID = sc.nextLine();

// facility = holoLib.searchFacilityByID(facilityID);

// if (facility.facilityType.matches("Room")) {
// ((Room) facility).getSchedule().displaySchedule();
// System.out.println("\nEnter Slot ID to reserve > ");
// } else {
// ((Area) facility).displaySeats();
// System.out.println("\nEnter Seat ID to reserve > ");
// }

// String placementID = sc.nextLine();
// }
// }
// } while (holoLib.captureContinueChoice().toUpperCase() == "Y");
// }

// sc.close();

// LocalDateTime currentDateTime = LocalDateTime.now();
// GregorianCalendar gc = new GregorianCalendar();
// gc.set(currentDateTime.getYear(), currentDateTime.getMonthValue(),
// currentDateTime.getDayOfMonth());
// // gc.set(GregorianCalendar.YEAR, currentDateTime.getYear());
// System.out.println(currentDateTime);
// System.out.println(gc.get);
// System.out.println(cal.get(Calendar.DAY_OF_MONTH) + "/" +
// cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR));

// Schedule schedule = new Schedule("SD001");
// schedule.displaySchedule();
// Area area = new Area("Detective ICT Area", "FT001", "Area",
// "Desktop Computer, Headphone, Printer, Air-conditional", 5.0, new Member[]
// {}, 100);
// area.displaySeats();