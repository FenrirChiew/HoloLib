// package holoLib;

// public class Temp {
    
// 		// Home --> Administrative
// 		String confirmPassword = "0";
// 		do {
// 			cls();
// 			System.out.println("Security Lock");
// 			System.out.println("=============");

// 			if (!holoLib.getCurrentLoggedUser().isAdmin()) {
// 				System.out.println("\n\tYou are not a Library Admin! Access Denied...\n");
// 			} else {
// 				System.out.println("Librarian ID: " + holoLib.getCurrentLoggedUser().getLibrarianID());

// 				do {
// 					System.out.print("Password (Exit = 0): ");
// 					confirmPassword = sc.nextLine();
// 				} while (!holoLib.validateStringFormat("Password (Must be a combination of letters and digits)",
// 						confirmPassword, "(?=.*[0-9])(?=.*[a-z])(?=.*[a-zA-Z])[0-9A-Za-z]+|0"));

// 				if (!confirmPassword.matches("0")) {
// 					if (!holoLib.getCurrentLoggedUser().validateLogin(confirmPassword)) {
// 						System.out.println("\n\tWrong Password! Access Denied...\n");
// 					} else {
// 						do {
// 							holoLib.displayAdministrativeMenu();
// 							selection = holoLib.captureMenuSelection(sc, 3);
// 							cls();

// 							switch (selection) {
// 								case 0:
// 									break;
// 								case 1:
// 									holoLib.displayMemberManagementMenu();
// 									break;
// 								case 2:
// 									holoLib.displayLibrarianManagementMenu();
// 									break;
// 								case 3:
// 									// 3. Books Inventory Management
// 									do {
// 										holoLib.displayBooksInvManagementMenu();
// 										selection = holoLib.captureMenuSelection(sc, 3);
// 										cls();

// 										String bookID;

// 										switch (selection) {
// 											case 0:
// 												break;
// 											case 1:
// 												// add book
// 												do {
// 													// prompt user enter book details
// 													System.out.print("Book Title: ");
// 													String title = sc.nextLine();

// 													System.out.print("Book Author: ");
// 													String author = sc.nextLine();

// 													System.out.print("Book Publisher: ");
// 													String publisher = sc.nextLine();

// 													String publicationDate;
// 													do {
// 														System.out.print("Book Publication Date (DD/MM/YYYY): ");
// 														publicationDate = sc.nextLine();
// 													} while (!holoLib.validateDate(publicationDate));

// 													System.out.print("Book Price: ");
// 													double price = sc.nextDouble();

// 													// Ask user to confirm add this book
// 													if (holoLib.captureYesNoChoice(sc, "Add Book").matches("Y")) {
// 														holoLib.addBook(title, author, publisher, publicationDate,
// 																price);
// 														System.out.println("Book Added!");
// 													} else {
// 														System.out.println("Repeal Adding Book!");
// 													}
// 												} while (holoLib.captureYesNoChoice(sc, "Add Another Book")
// 														.matches("Y"));
// 												break;
// 											// 2. Modify Book
// 											case 2:
// 												do {
// 													holoLib.displayBookModifyMenu();
// 													int modifySelection = holoLib.captureMenuSelection(sc, 5);
// 													cls();

// 													// Get Book ID
// 													do {
// 														System.out.print("Book ID: ");
// 														bookID = sc.nextLine();
// 													} while (!holoLib.validateStringFormat("Book ID", bookID,
// 															"BK[0-9]{3}"));

// 													if (holoLib.searchBookByID(bookID) != null) {
// 														do {
// 															cls();
// 															// Display Book Details found
// 															holoLib.searchBookByID(bookID).displayBookDetails();
// 															String modificationChoice = "";
// 															switch (modifySelection) {
// 																// 0. Back to Books Inventory Management
// 																case 0:
// 																	break;
// 																// 1. Book Title
// 																case 1:
// 																	String title;
// 																	System.out.print("Book Title: ");
// 																	title = sc.nextLine();
// 																	modificationChoice = holoLib.captureYesNoChoice(sc,
// 																			"Modify Book Title");
// 																	if (modificationChoice.matches("Y")) {
// 																		holoLib.searchBookByID(bookID)
// 																				.setBookTitle(title);
// 																	}
// 																	break;
// 																// 2. Book Author
// 																case 2:
// 																	String author;
// 																	System.out.print("Book Author: ");
// 																	author = sc.nextLine();
// 																	modificationChoice = holoLib.captureYesNoChoice(sc,
// 																			"Modify Book Author");
// 																	if (modificationChoice.matches("Y")) {
// 																		holoLib.searchBookByID(bookID)
// 																				.setBookAuthor(author);
// 																	}
// 																	break;
// 																// 3. Book Publisher
// 																case 3:
// 																	String publisher;
// 																	System.out.print("Book Publisher: ");
// 																	publisher = sc.nextLine();
// 																	modificationChoice = holoLib.captureYesNoChoice(sc,
// 																			"Modify Book Publisher");
// 																	if (modificationChoice.matches("Y")) {
// 																		holoLib.searchBookByID(bookID)
// 																				.setBookPublisher(publisher);
// 																	}
// 																	break;
// 																// 4. Book Publication Date
// 																case 4:
// 																	String tempPublicationDate;
// 																	do {
// 																		System.out.print(
// 																				"Book Publication Date (DD/MM/YYYY): ");
// 																		tempPublicationDate = sc.nextLine();
// 																	} while (!holoLib
// 																			.validateDate(tempPublicationDate));

// 																	int[] dmy = holoLib
// 																			.toIntDate(tempPublicationDate.split("/"));
// 																	GregorianCalendar publicationDate = new GregorianCalendar(
// 																			dmy[2], dmy[1], dmy[0]);

// 																	modificationChoice = holoLib.captureYesNoChoice(sc,
// 																			"Modify Book Publication Date");
// 																	if (modificationChoice.matches("Y")) {
// 																		holoLib.searchBookByID(bookID)
// 																				.setBookPublicationDate(
// 																						publicationDate);
// 																	}
// 																	break;
// 																// 4. Book Price
// 																case 5:
// 																	double price;
// 																	System.out.print("Book Price: ");
// 																	price = sc.nextDouble();
// 																	modificationChoice = holoLib.captureYesNoChoice(sc,
// 																			"Modify Book Price");
// 																	if (modificationChoice.matches("Y")) {
// 																		holoLib.searchBookByID(bookID)
// 																				.setBookPrice(price);
// 																	}
// 																	break;
// 															}

// 															if (modificationChoice.matches("Y")) {
// 																System.out.println("Book Modified!");

// 																System.out.println("Modified Book " + bookID + ": ");
// 																// Display modified Book Details
// 																holoLib.searchBookByID(bookID).displayBookDetails();
// 															} else {
// 																System.out.println("Repeal Book Modification!");
// 															}
// 														} while (holoLib
// 																.captureYesNoChoice(sc, "Continue Modify " + bookID)
// 																.matches("Y"));
// 													} else {
// 														System.out.println("Book ID Not Found!");
// 													}
// 												} while (holoLib.captureYesNoChoice(sc, "Modify Another Book")
// 														.matches("Y"));
// 												break;
// 											// 3. Delete Book
// 											case 3:
// 												do {
// 													// Get Book ID
// 													do {
// 														System.out.print("Book ID: ");
// 														bookID = sc.nextLine();
// 													} while (!holoLib.validateStringFormat("Book ID", bookID,
// 															"BK[0-9]{3}"));

// 													if (holoLib.searchBookByID(bookID) != null) {
// 														// Display Book Details found
// 														holoLib.searchBookByID(bookID).displayBookDetails();

// 														// delete
// 														if (holoLib.captureYesNoChoice(sc, "Delete Book")
// 																.matches("Y")) {
// 															holoLib.deleteBook(bookID);
// 															System.out.println("Book Deleted!");
// 														} else {
// 															System.out.println("Repeal Book Deletion!");
// 														}
// 													}
// 												} while (holoLib.captureYesNoChoice(sc, "Delete Another Book")
// 														.matches("Y"));
// 												break;
// 										}
// 									} while (selection != 0);
// 									break;
// 							}
// 						} while (selection != 0);
// 					}
// 				}
// 			}
// 		} while (holoLib.getCurrentLoggedUser().isAdmin() && !confirmPassword.matches("0"));
    
// }
