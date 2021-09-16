package holoLib;

import java.util.Scanner;

import java.util.GregorianCalendar;

public class holoLib {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Borrower[] borrowerList = new Borrower[100];

		borrowerList[0] = new Librarian("Watoto", "111111-11-1111", "Male", new GregorianCalendar(2001, 1, 1),
				"111-1111111", new LibraryCard("010101", new GregorianCalendar(2020, 02, 1), 66.60), "admin1",
				"Library Admin");
		borrowerList[1] = new Librarian("Kiwawa", "222222-22-2222", "Female", new GregorianCalendar(2002, 2, 2),
				"222-2222222", new LibraryCard("020202", new GregorianCalendar(2021, 11, 1), 5.00), "admin2",
				"General Staff");
		borrowerList[2] = new Librarian("Yuul B Alwright", "333333-33-3333", "Female",
				new GregorianCalendar(2003, 3, 3), "333-3333333",
				new LibraryCard("030303", new GregorianCalendar(2022, 5, 1), 10.00), "admin3", "General Staff");
		borrowerList[3] = new Librarian("Memei", "444444-44-4444", "Female", new GregorianCalendar(2004, 4, 4),
				"444-4444444", new LibraryCard("040404", new GregorianCalendar(2019, 10, 1), 5.00), "admin4",
				"Librarian Admin");
		borrowerList[4] = new Member("LaoSu", "555555-55-5555", "Female", new GregorianCalendar(2001, 1, 31),
				"555-5555555", new LibraryCard("050505", new GregorianCalendar(2018, 10, 1), 10.00));
		borrowerList[5] = new Member("FEET", "666666-66-6666", "Female", new GregorianCalendar(2002, 2, 28),
				"666-6666666", new LibraryCard("060606", new GregorianCalendar(2009, 2, 1), 11.11));
		borrowerList[6] = new Member("Kawaiiope Morison", "777777-77-7777", "Male", new GregorianCalendar(2003, 3, 31),
				"777-7777777", new LibraryCard("070707", new GregorianCalendar(2022, 3, 1), 15.00));
		borrowerList[7] = new Member("Branch Horn", "888888-88-8888", "Female", new GregorianCalendar(2004, 4, 30),
				"888-8888888", new LibraryCard("080808", new GregorianCalendar(2022, 1, 1), 20.00));

		Book[] bookList = new Book[100];

		bookList[0] = new Book("Effective Java", "Joshua Bloch", "Addison-Wesley Professional",
				new GregorianCalendar(2017, 11, 27), 185.88);
		bookList[1] = new Book("HTML and CSS: Design and Build Websites", "Jon Duckett", "John Wiley&Sonc Inc",
				new GregorianCalendar(2011, 10, 18), 124.02);
		bookList[2] = new Book("I Had That Same Dream Again", "Yoru Sumino", "Seven Seas Entertainment,LLC",
				new GregorianCalendar(2020, 7, 7), 58.02);
		bookList[3] = new Book("Your Name", "Makoto Shinkai", "Little,Brown&Company",
				new GregorianCalendar(2017, 5, 23), 71.65);
		bookList[4] = new Book("Japanese Cooking Made Simple", "Salinas Press", "Salinas Press",
				new GregorianCalendar(2014, 4, 29), 59.02);

		LibrarySystem holoLib = new LibrarySystem(borrowerList, bookList);
		boolean isLogin = false;
		int selection1;
		int selection2;

		do {
			cls();
			// Welcome Screen
			holoLib.welcomeScreen();
			selection1 = holoLib.captureMenuSelection(sc, 1);
			cls();

			switch (selection1) {
				// 0. Terminate
				case 0:
					break;
				// 1. Login
				case 1:
					System.out.println("Login");
					System.out.println("=====");

					String librarianID;
					do {
						// for(int i = 0; i < Borrower.getTotalBorrowers(); i++){
						// System.out.println("Borrower ID: "+
						// ((Librarian)borrowerList[i]).getLibrarianID());
						// }
						System.out.print("Librarian ID: ");
						librarianID = sc.nextLine();
					} while (!holoLib.validateStringFormat("Librarian ID", librarianID, "LB[0-9]{3}"));

					String password;
					do {
						System.out.print("Password: ");
						password = sc.nextLine();
					} while (!holoLib.validateStringFormat("Password (Must be a combination of letters and digits)",
							password, "(?=.*[0-9])(?=.*[a-z])(?=.*[a-zA-Z])[0-9A-Za-z]+"));

					if (holoLib.searchLibrarianByID(librarianID) == null) {
						System.out.println("\n\tLibrarian ID does not exist! Login Failed...\n");
					} else {
						if (!((Librarian) holoLib.searchLibrarianByID(librarianID)).validateLogin(password)) {
							System.out.println("\n\tWrong Password! Login Failed...\n");
						} else {
							holoLib.login(librarianID);
							System.out.println("\n\tLogin Successful! Welcome Back, "
									+ holoLib.getCurrentLoggedUser().name + "\n");
							isLogin = true;
							holoLib.recordTime(isLogin);
						}
					}
					System.out.print("\n\tPress Enter To Continue...");
					sc.nextLine();
					cls();
					break;
			}

			if (isLogin) {
				cls();
				do {
					holoLib.displayHomeMenu();
					selection1 = holoLib.captureMenuSelection(sc, 4);
					cls();

					switch (selection1) {
						// 0. Logout
						case 0:
							isLogin = false;
							holoLib.recordTime(isLogin);
							break;
						// 1. Membership Management
						case 1:
							do {
								cls();
								holoLib.displayMembershipMenu();
								selection2 = holoLib.captureMenuSelection(sc, 4);
								cls();

								switch (selection2) {
									// 0. Back to Home
									case 0:
										break;
									// 1. Membership Registration
									case 1:
										do {
											cls();
											String name;
											do {
												System.out.println("\n========================");
												System.out.println("   Register Membership  ");
												System.out.println("========================");

												System.out.print("Name: ");
												name = sc.nextLine();
											} while (!holoLib.validateStringFormat("Name", name,
													"([A-Z][A-Za-z]* *)+"));

											String icNO;
											do {
												System.out.print("IC Number (XXXXXX-XX-XXXX): ");
												icNO = sc.nextLine();
											} while (!holoLib.validateStringFormat("IC Number", icNO,
													"[0-9]{6}-[0-9]{2}-[0-9]{4}"));

											String gender;
											do {
												System.out.print("Gender (Male/Female): ");
												gender = sc.nextLine();
											} while (!holoLib.validateStringFormat("Gender", gender, "Male|Female"));

											String dob;
											do {
												System.out.print("Date of Birth (DD/MM/YYYY): ");
												dob = sc.nextLine();
											} while (!holoLib.validateDate(dob));

											String phoneNO;
											do {
												System.out.print("Phone Number (XXX-XXXXXXX): ");
												phoneNO = sc.nextLine();
											} while (!holoLib.validateStringFormat("Phone Number", phoneNO,
													"[0-9]{3}-[0-9]{7,8}"));

											String pinNO;
											do {
												System.out.print("Pin Number for Library Card: ");
												pinNO = sc.nextLine();
											} while (!holoLib.validateStringFormat("Pin Number", pinNO, "[0-9]{6}"));
											double cash = holoLib.captureMoney(sc, "Reload Amount");
											if (holoLib.captureYesNoChoice(sc, "Confirm Registration").matches("Y")) {
												holoLib.registerMembership(name, icNO, gender, dob, phoneNO, pinNO,
														cash);
												System.out.println("Registration Successfully!");
											} else {
												System.out.println("Registration Canceled!");
											}
										} while (holoLib.captureYesNoChoice(sc, "Another Registration").matches("Y"));
										break;
									// 2. Card Renewal
									case 2:
										do {
											System.out.println("\n========================");
											System.out.println("       Card Renewal     ");
											System.out.println("========================");

											String cardNO;
											do {
												System.out.print("Library Card Number: ");
												cardNO = sc.nextLine();
											} while (!holoLib.validateStringFormat("Library Card Number", cardNO,
													"LC[0-9]{3}"));

											String pinNO;
											do {
												System.out.print("Pin Number: ");
												pinNO = sc.nextLine();
											} while (!holoLib.validateStringFormat("Pin Number", pinNO, "[0-9]{6}"));

											if (holoLib.validateLibraryCard(cardNO, pinNO)) {
												holoLib.searchBorrowerByCardNO(cardNO).libraryCard.displayCardDetails();
												if (holoLib.captureYesNoChoice(sc, "Confirm Renewal").matches("Y")) {
													// pay
													double cash = 20.00;
													if (holoLib.searchBorrowerByCardNO(cardNO).libraryCard
															.getCardBalance() >= cash) {
														holoLib.searchLibraryCardByCardNO(cardNO).payPayment(cash);
														holoLib.searchLibraryCardByCardNO(cardNO).renewCardExpDate();
														System.out.println("Renewal Successfully!");
														holoLib.searchLibraryCardByCardNO(cardNO).displayInvoice(
																holoLib.searchBorrowerByCardNO(cardNO), cash);
													} else {
														System.out.println(
																"Insufficient Balance. Please Reload The Card.");
													}
												} else {
													System.out.println("Renewal Canceled!");
												}
											}
											else{
												System.out.println("\tYou had key in invalid password");
											}
										} while (holoLib.captureYesNoChoice(sc, "Another Reload").matches("Y"));
										break;
									// 3. Reload Card Balance
									case 3:
										do {
											System.out.println("\n========================");
											System.out.println("   Reload Card Balance  ");
											System.out.println("========================");

											String cardNO;
											do {
												System.out.print("Library Card Number: ");
												cardNO = sc.nextLine();
											} while (!holoLib.validateStringFormat("Library Card Number", cardNO,
													"LC[0-9]{3}"));

											String pinNO;
											do {
												System.out.print("Pin Number: ");
												pinNO = sc.nextLine();
											} while (!holoLib.validateStringFormat("Pin Number", pinNO, "[0-9]{6}"));

											if (holoLib.validateLibraryCard(cardNO, pinNO)) {
												holoLib.searchBorrowerByCardNO(cardNO).displayBorrowerDetails();
												double cash = holoLib.captureMoney(sc, "Reload Amount");
												if (holoLib.captureYesNoChoice(sc, "Confirm Reload").matches("Y")) {
													holoLib.searchLibraryCardByCardNO(cardNO).cashIn(cash);
													System.out.println("Reload Successfully!");
													holoLib.searchLibraryCardByCardNO(cardNO).displayInvoice(
															holoLib.searchBorrowerByCardNO(cardNO), cash);
												} else {
													System.out.println("Reload Canceled!");
												}
											}
										} while (holoLib.captureYesNoChoice(sc, "Another Reload").matches("Y"));
										break;
									// 4. Search Borrower
									case 4:
										do {
											System.out.println("\n========================");
											System.out.println("     Search Borrower    ");
											System.out.println("========================");

											String borrowerID;
											do {
												System.out.print("Member/Librarian ID: ");
												borrowerID = sc.nextLine();
											} while (!holoLib.validateStringFormat("Member/Librarian ID", borrowerID,
													"LB[0-9]{3}|MB[0-9]{3}"));

											if (holoLib.searchBorrowerByID(borrowerID) != null) {
												holoLib.searchBorrowerByID(borrowerID).displayBorrowerDetails();
											}
											/*
											 * else { System.out.println("Borrower Not Found!"); }
											 */
										} while (holoLib.captureYesNoChoice(sc, "Search Another Borrower")
												.matches("Y"));
										break;
								}
							} while (selection2 != 0);
							break;
						// 2. Book Borrowing
						case 2:
							// Home --> 2. Book Borrowing
							do {
								cls();
								holoLib.displayBorrowMenu();
								selection2 = holoLib.captureMenuSelection(sc, 4);
								cls();

								switch (selection2) {
									// 0. Back to Home
									case 0:
										break;
									// 1. Display book
									case 1:
										// display all book
										holoLib.displayBook();
										break;
									// 2. Search Book
									case 2:
										int searchSelection;
										do {
											cls();
											holoLib.displayBookSearchingMenu();
											searchSelection = holoLib.captureMenuSelection(sc, 4);
											cls();

											switch (searchSelection) {
												// 2.0 back to Book Borrowing Menu
												case 0:
													break;
												// 2.1 Search Book by Book Title
												case 1:
													String title;
													System.out.print("Book Title: ");
													title = sc.nextLine();

													holoLib.searchBookByTitle(title);
													break;
												// 2.2 Search Book by Book ID
												case 2:
													String id;
													do {
														System.out.print("Book ID: ");
														id = sc.nextLine();
													} while (!holoLib.validateStringFormat("Book ID", id,
															"BK[0-9]{3}"));

													if (holoLib.searchBookByID(id) == null) {
														System.out.println(
																"\n\tBook ID match with \"" + id + "\" not found!");
													} else {
														System.out.println("\n\tResult match with \"" + id + "\":");
														holoLib.searchBookByID(id).displayBookDetails();
													}
													break;
												// 2.3 Search Book by Book Author
												case 3:
													String author;
													System.out.print("Book Author: ");
													author = sc.nextLine();

													holoLib.searchBookByAuthor(author);
													break;
												// 2.4 Search Book by Book Publisher
												case 4:
													String publisher;
													System.out.print("Book Publisher: ");
													publisher = sc.nextLine();

													holoLib.searchBookByPublisher(publisher);
													break;
											}
										} while (searchSelection != 0 && holoLib
												.captureYesNoChoice(sc,
														"Continue search book [N - Back to Book Borrowing Menu]?")
												.matches("Y"));
										break;
									// 3. Borrow Book
									case 3:
										do {
											cls();
											// Get Borrower ID
											String borrowerID;
											do {
												System.out.print("Member/Librarian ID: ");
												borrowerID = sc.nextLine();
											} while (!holoLib.validateStringFormat("Member/Librarian ID", borrowerID,
													"LB[0-9]{3}|MB[0-9]{3}"));

											if (holoLib.searchBorrowerByID(borrowerID) != null) {
												// Display Borrower Details founded
												holoLib.searchBorrowerByID(borrowerID).displayBorrowerDetails();

												// Get Book ID
												String bookID;
												do {
													System.out.print("\nBook ID: ");
													bookID = sc.nextLine();
												} while (!holoLib.validateStringFormat("Book ID", bookID,
														"BK[0-9]{3}"));

												// searchBookByID()
												if (holoLib.searchBookByID(bookID) != null) {
													// Display Book Details found
													holoLib.searchBookByID(bookID).displayBookDetails();

													// check borrow status
													if ((holoLib.searchBookByID(bookID)).isBorrowed() == false) {
														// Confirmation
														if (holoLib
																.captureYesNoChoice(sc, "Borrow Book " + bookID + "?")
																.matches("Y")) {
															// PIN to borrow book
															String pinNo;
															System.out.print("Pin Number: ");
															pinNo = sc.nextLine();

															// check PIN, check balance, pay borrow fee and borrow
															if (borrowerID.indexOf("LB") != -1) {
																((Librarian) holoLib.searchBorrowerByID(borrowerID))
																		.borrowBook(pinNo,
																				holoLib.searchBookByID(bookID));
															} else if (borrowerID.indexOf("MB") != -1) {
																((Member) holoLib.searchBorrowerByID(borrowerID))
																		.borrowBook(pinNo,
																				holoLib.searchBookByID(bookID));
															}
														}
													} else {
														System.out.println("\n\tBook \"" + bookID
																+ "\" is borrowed, can't continue borrow book action!");

													}
												} else {
													System.out.println("\n\tBook Not Found!");
												}
											}
											System.out.print("\n\tPress Enter to continue...");
											sc.nextLine();
											System.out.print("\n");
										} while (holoLib.captureYesNoChoice(sc, "Another Borrow?").matches("Y"));
										break;
									// 4. Return Book
									case 4:
										do {
											cls();
											// Get Borrower ID
											String borrowerID;
											do {
												System.out.print("Member/Librarian ID: ");
												borrowerID = sc.nextLine();
											} while (!holoLib.validateStringFormat("Member/Librarian ID", borrowerID,
													"LB[0-9]{3}|MB[0-9]{3}"));

											if (holoLib.searchBorrowerByID(borrowerID) != null) {
												// Display Borrower Details found (have show current borrow)
												holoLib.searchBorrowerByID(borrowerID).displayBorrowerDetails();

												// Check currentBorrow
												if (holoLib.searchBorrowerByID(borrowerID).libraryCard
														.getCurrentBorrowedCount() == 0) {
													System.out.println("\n\tCurrent Borrow of " + borrowerID
															+ " is N/A can't continue return book action!");
												} else {
													// Get Book ID
													String bookID;
													boolean isCurrentBorrow = false;

													do {
														System.out.print("Book ID: ");
														bookID = sc.nextLine();
													} while (!holoLib.validateStringFormat("Book ID", bookID,
															"BK[0-9]{3}"));

													// searchBookByID()
													if (holoLib.searchBookByID(bookID) != null) {
														// check book is borrowed by this Member/Librarian
														for (int i = 0; i < holoLib
																.searchBorrowerByID(borrowerID).libraryCard
																		.getCurrentBorrowedCount(); i++) {
															if (bookID.compareTo(
																	holoLib.searchBorrowerByID(borrowerID).libraryCard
																			.getCurrentBorrowed()[i]
																					.getBookID()) == 0) {
																isCurrentBorrow = true;
															}
														}

														// book cannot found in current borrow
														if (isCurrentBorrow == false) {
															System.out.println("\n\tBook " + bookID
																	+ " is not borrowed, can't continue return book action!");
														}
														// book found in current borrowed, can return
														else {
															// Display Book Details found
															holoLib.searchBookByID(bookID).displayBookDetails();

															if (holoLib.captureYesNoChoice(sc, "Return Book " + bookID)
																	.matches("Y")) {
																String pinNo;
																System.out.print("Pin Number: ");
																pinNo = sc.nextLine();

																// check PIN, check balance, pay penalty fee(if any) and
																// return
																holoLib.searchBorrowerByID(borrowerID).returnBook(pinNo,
																		holoLib.searchBookByID(bookID));
															} else {
																System.out.println("\n\tRepeal book return action!");
															}
														}
													}
												}
											}
										} while (holoLib.captureYesNoChoice(sc, "Another Return?").matches("Y"));
								}
								System.out.print("\n\tPress Enter To Continue...");
								sc.nextLine();
								cls();
							} while (selection2 != 0);
							break;
						// 3. Report
						case 3:
							do {
								cls();
								holoLib.displayReportMenu();
								selection2 = holoLib.captureMenuSelection(sc, 3);
								cls();

								switch (selection2) {
									// 0. Back to Home
									case 0:
										break;
									// 1. Daily Book Borrow Report
									case 1:
										holoLib.displayDailyBookBorrowReport();
										break;
									// 2. Daily Book Return Report
									case 2:
										holoLib.displayDailyBookReturnedReport();
										break;
									// 3. Expired Borrowwer Report
									case 3:
										holoLib.displayExpiredBorrowerReport();
										break;
								}
								System.out.println("\n\tPress Enter To Continue...");
								sc.nextLine();
								cls();
							} while (selection2 != 0);
							break;
						// 4. Login Records
						case 4:
							String confirmPassword = "0";
							do {
								cls();
								System.out.println("Security Lock");
								System.out.println("=============");

								if (!holoLib.getCurrentLoggedUser().isAdmin()) {
									System.out.println("\n\tYou are not a Library Admin! Access Denied...");
								} else {
									System.out.println(
											"Librarian ID: " + holoLib.getCurrentLoggedUser().getLibrarianID());

									do {
										System.out.print("Password (Exit = 0): ");
										confirmPassword = sc.nextLine();
									} while (!holoLib.validateStringFormat(
											"Password (Must be a combination of letters and digits)", confirmPassword,
											"(?=.*[0-9])(?=.*[a-z])(?=.*[a-zA-Z])[0-9A-Za-z]+|0"));

									if (!confirmPassword.matches("0")) {
										if (!holoLib.getCurrentLoggedUser().validateLogin(confirmPassword)) {
											System.out.println("\n\tWrong Password! Access Denied...");
										} else {
											holoLib.displayLoginRecords();
											sc.nextLine();
										}
									}
									cls();
								}
							} while (holoLib.getCurrentLoggedUser().isAdmin() && !confirmPassword.matches("0"));
							break;
					}
				} while (selection1 != 0);
				System.out.println("\n\tBack To Home. Press Enter To Continue...");
				sc.nextLine();
				cls();
			}
		} while (!holoLib.captureYesNoChoice(sc, "Terminate Program").matches("Y"));

		// Ending Screen
		cls();
		holoLib.endingScreen();
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
