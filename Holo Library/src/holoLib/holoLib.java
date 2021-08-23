package holoLib;

import java.util.Scanner;

public class holoLib {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Facility[] facilityList = {
                new Area("Detective ICT Area", "FT00001", "Area",
                        "Desktop Computer, Headphone, Printer, Air-conditional", 5.0, new Member[] {}, 100),
                new Room("Shark Meeting Room", "FT00002", "Room", "Microphone, Speaker, White Board, Air-conditional",
                        10.0, new Member[] {}, 20, new Schedule("SD00001")),
                new Area("Ancient Study Area", "FT00003", "Area", "Tablet, Speaker, Projector, Air-conditional", 10.0,
                        new Member[] {}, 120),
                new Room("Ripper Meeting Room", "FT00004", "Room",
                        "Laptop Computer, Microphone, Speaker, Projector, Air-conditional", 20.0, new Member[] {}, 30,
                        new Schedule("SD00002")),
                new Room("Bird Meeting Room", "FT00005", "Room", "Microphone, Speaker, Projector, Air-conditional",
                        15.0, new Member[] {}, 30, new Schedule("SD00003")) };
        LibrarySystem holoLib = new LibrarySystem(facilityList);
        int selection = 0;
        boolean continueInput = true;

        do {
            try {
                cls();
                holoLib.displayReserveMenu();
                selection = sc.nextInt();
                continueInput = false;
            } catch (Exception e) {
                sc.nextLine();
                System.out.print("\n\tInvalid selection! Please try agian...");
                sc.nextLine();
            }
        } while (continueInput);

        cls();
        sc.nextLine();

        switch (selection) {
            case 0:
                System.out.print("\n\tReturn to last stage. Press Enter to continue...");
                sc.nextLine();
                cls();
                break;
            case 1:
                holoLib.displayFacility();
                System.out.print("\n\tReturn to last stage. Press Enter to continue...");
                sc.nextLine();
                cls();
        }

        sc.close();
    }

    public static void cls() {
        System.out.print("\033[H\033[2J");
        // \033 - escape character (ECS)
        // \033[H - move cursor to top left of the console
        // \033[2J - clear the screen from cursor to the end of the console
        System.out.flush(); // clear the buffers
    }
}
