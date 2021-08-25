package holoLib;

import java.util.Scanner;

public class LibrarySystem {
    /********** Properties **********/
    private People[] librarianList; // Librarian List
    private People[] memberList; // Member List
    private Facility[] facilityList; // Facility List
    private ReadingMaterial[] readingMaterialList; // Reading Material List

    /********** Constructors **********/
    public LibrarySystem() {
        this(null, null, null, null);
    }

    // testing purpose
    public LibrarySystem(Facility[] facilityList) {
        this.facilityList = facilityList;
    }

    public LibrarySystem(People[] librarianList, People[] memberList, Facility[] facilityList,
            ReadingMaterial[] readingMaterialList) {
        this.librarianList = librarianList;
        this.memberList = memberList;
        this.facilityList = facilityList;
        this.readingMaterialList = readingMaterialList;
    }

    /********** Accessors & Mutators **********/
    public People[] getLibrarianList() {
        return librarianList;
    }

    public void setLibrarianList(People[] librarianList) {
        this.librarianList = librarianList;
    }

    public People[] getMemberList() {
        return memberList;
    }

    public void setMemberList(People[] memberList) {
        this.memberList = memberList;
    }

    public Facility[] getFacilityList() {
        return facilityList;
    }

    public void setFacilityList(Facility[] facilityList) {
        this.facilityList = facilityList;
    }

    public ReadingMaterial[] getReadingMaterialList() {
        return readingMaterialList;
    }

    public void setReadingMaterialList(ReadingMaterial[] readingMaterialList) {
        this.readingMaterialList = readingMaterialList;
    }

    /********** Methods **********/
    // Display Main Menu
    public void displayMainMenu() {
        System.out.println("++==============================++");
        System.out.println("||          Main Menu           ||");
        System.out.println("++===++=========================++");
        System.out.println("|| 1 ||  Membership Management  ||");
        System.out.println("|| 2 ||  Book Borrowing         ||");
        System.out.println("|| 3 ||  Facility Reservation   ||");
        System.out.println("|| 4 ||  Administrative         ||");
        System.out.println("|| 0 ||  Exit                   ||");
        System.out.println("++===++=========================++");
    }

    // Display Membership Menu
    public void displayMembershipMenu() {
        System.out.println("++===============================++");
        System.out.println("||        Membership Menu        ||");
        System.out.println("++===============================++");
        System.out.println("|| 1 || Membership Registration  ||");
        System.out.println("|| 2 || Renewal n Reload ?       ||");
        System.out.println("|| 3 || Display detail ?         ||");
        System.out.println("++===++==========================++");
    }

    // Display Borrow Menu
    public void displayBorrowMenu() {
        System.out.println("++=========================++");
        System.out.println("||     Book Borrowing      ||");
        System.out.println("++=========================++");
        System.out.println("|| 1 || Borrow book        ||");
        System.out.println("|| 2 || Return book        ||");
        System.out.println("|| 3 || Back               ||");
        System.out.println("++===++====================++");
    }

    // Display Reserve Menu
    public void displayReserveMenu() {
        System.out.println("++=========================++");
        System.out.println("||  Facility Reservation   ||");
        System.out.println("++===++====================++");
        System.out.println("|| 1 ||  Display Facility  ||");
        System.out.println("|| 2 ||  Search Facility   ||");
        System.out.println("|| 3 ||  Reserve Facility  ||");
        System.out.println("|| 4 ||  Return Facility   ||");
        System.out.println("|| 0 ||  Exit              ||");
        System.out.println("++===++====================++");
    }

    public void displayFacility() {
        System.out.println("++===========================++");
        System.out.println("||     Display Facility      ||");
        System.out.println("++====++=====================++=============++===============++");
        System.out.println("|| NO ||    Facility Name    || Facility ID || Facility Type ||");
        System.out.println("++====++=====================++=============++===============++");

        for (int i = 0; i < facilityList.length; i++) {
            System.out.printf("|| %02d || %-19s || %-11s || %-13s ||\n", i + 1, facilityList[i].facilityName,
                    facilityList[i].facilityID, facilityList[i].facilityType);
            System.out.println("++====++=====================++=============++===============++");
        }

        System.out.println("\nTotal Facilities Found: " + facilityList.length);
    }

    public void searchFacilityMenu() {
        System.out.println("++================================++");
        System.out.println("||        Search Facility         ||");
        System.out.println("++===++===========================++");
        System.out.println("|| 1 ||  Search by Facility Name  ||");
        System.out.println("|| 2 ||  Search by Facility ID    ||");
        System.out.println("|| 3 ||  Search by Facility Type  ||");
        System.out.println("|| 0 ||  Exit                     ||");
        System.out.println("++===++===========================++");
    }

    public void searchFacilityByName(String facilityName) {
        int totalResult = 0;

        System.out.println("Results match with \"" + facilityName + "\":");

        for (int i = 0; i < facilityList.length; i++) {
            if (facilityList[i].facilityName.toUpperCase().indexOf(facilityName.toUpperCase()) != -1) {
                totalResult++;
                System.out.printf("\nResult %d\n", totalResult);
                System.out.println("========");
                facilityList[i].displayFacilityDetails();
            }
        }

        System.out.println("\nTotal Facilities Found: " + totalResult);
    }

    public Facility searchFacilityByID(String facilityID) {
        if (!(facilityID.toUpperCase().matches("FT[0-9]{3}"))) {
            System.out.print("\n\tInvalid Facility ID! Please try agian...");
        } else {
            System.out.println("Results match with \"" + facilityID + "\":");

            for (int i = 0; i < facilityList.length; i++) {
                if (facilityList[i].facilityID.matches(facilityID.toUpperCase())) {
                    facilityList[i].displayFacilityDetails();
                    return facilityList[i];
                }
            }
        }

        return null;
    }

    public void searchFacilityByType(String facilityType) {
        if (!(facilityType.toUpperCase().matches("AREA|ROOM"))) {
            System.out.print("\n\tInvalid Facility Type! Please try agian...");
        } else {
            int totalResult = 0;

            System.out.println("Results match with \"" + facilityType + "\":");

            for (int i = 0; i < facilityList.length; i++) {
                if (facilityList[i].facilityType.toUpperCase().matches(facilityType.toUpperCase())) {
                    totalResult++;
                    System.out.printf("\nResult %d\n", totalResult);
                    System.out.println("========");
                    facilityList[i].displayFacilityDetails();
                }
            }

            System.out.println("\nTotal Facilities Found: " + totalResult);
        }
    }

    public Member searchMemberByID(String memberID) {
        if (!(memberID.toUpperCase().matches("MB[0-9]{3}"))) {
            System.out.print("\n\tInvalid Member ID! Please try agian...");
        } else {
            for (int i = 0; i < memberList.length; i++) {
                if (((Member) memberList[i]).getMemberID().matches(memberID.toUpperCase())) {
                    return (Member) memberList[i];
                }
            }
        }

        return null;
    }

    public LibraryCard searchLibraryCardByNO(String cardNO) {
        if (!(cardNO.toUpperCase().matches("LC[0-9]{3}"))) {
            System.out.print("\n\tInvalid Library Card Number! Please try agian...");
        } else {
            for (int i = 0; i < memberList.length; i++) {
                if (((Member) memberList[i]).getLibraryCard().getCardNO().matches(cardNO.toUpperCase())) {
                    return ((Member) memberList[i]).getLibraryCard();
                }
            }
        }

        return null;
    }

    // Display Payment Menu
    public void displayPaymentMenu() {
        System.out.println("++=========================++");
        System.out.println("||      Payment Menu       ||");
        System.out.println("++===++====================++");
        System.out.println("|| 1 ||                    ||");
        System.out.println("|| 2 ||                    ||");
        System.out.println("|| 3 ||                    ||");
        System.out.println("++===++====================++");
    }

    // User needs to be verified as administrator before entering this menu
    // Display Administrative Menu
    public void displayAdministrativeMenu() {
        System.out.println("++=========================++");
        System.out.println("||     Administrative      ||");
        System.out.println("++===++====================++");
        System.out.println("|| 1 || Add new librarian  ||");
        System.out.println("|| 2 || Edit librarian ID  ||");
        System.out.println("|| 3 || Back               ||");
        System.out.println("++===++====================++");
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
                System.out.print("\n\tInvalid selection! Please try agian...");
                sc.nextLine();
            }
        } while (continueInput);

        sc.nextLine(); // Clear input buffer

        sc.close();

        return selection; // Return menu selection
    }

    // Capture an continue choice before end of any menu
    public String captureContinueChoice() {
        Scanner sc = new Scanner(System.in);
        boolean continueInput = true;
        String choice = "";

        // Keep looping until:
        // 1. Captured a proper continue choice ("Y" / "N")
        // 2. Continue choice is exact 1 character
        do {
            System.out.print("\nContinue (Y/N) > ");
            choice = sc.nextLine();

            if (!(choice.length() == 1 && choice.toUpperCase().matches("Y|N"))) {
                System.out.print("\n\tInvalid choice! Please try agian...");
                sc.nextLine();
            } else {
                continueInput = false;
            }
        } while (continueInput);

        sc.nextLine(); // Clear input buffer

        sc.close();

        return choice; // Return continue choice
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
                System.out.println("\nWrong ID or password. Please try again.");
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

    // Logout method
    public boolean Logout() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Are you sure you want to logout? (Y/N)");
        char confirmation = sc.nextLine().charAt(0);
        sc.close();
        if (confirmation == 'Y')
            return true;
        return false;
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
