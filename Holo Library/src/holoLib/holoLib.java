package holoLib;

import java.time.LocalDateTime;
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