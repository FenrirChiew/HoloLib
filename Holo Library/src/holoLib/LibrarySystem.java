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
        System.out.println("++=================================++");
        System.out.println("||            Main Menu            ||");
        System.out.println("++===++============================++");
        System.out.println("|| 1 || Membership Management      ||");
        System.out.println("|| 2 || Book Borrowing & Returning ||");
        System.out.println("|| 3 || Reservation Management     ||");
        System.out.println("|| 4 || Administrative Management  ||");
        System.out.println("++===++============================++");
        System.out.println("\n\tEnter your selection > ");
    }

    // Display Membership Menu
    public void displayMembershipMenu() {
        System.out.println("++===============================++");
        System.out.println("||        Membership Menu        ||");
        System.out.println("++===============================++");
        System.out.println("|| 1 || Membership Registration  ||");
        System.out.println("|| 2 || Renewal n Reload ?       ||");  // TBD
        System.out.println("|| 3 || Display detail ?         ||");  // TBD
        System.out.println("++===++==========================++");
        System.out.println("Enter your selection > ");
    }

    // Display Borrow Menu
    public void displayBorrowMenu() {
        System.out.println("++=========================++");
        System.out.println("||       Borrow Menu       ||");
        System.out.println("++=========================++");
        System.out.println("|| 1 || Borrow book        ||");
        System.out.println("|| 2 || Return book        ||");
        System.out.println("|| 3 || Back               ||");
        System.out.println("++===++====================++");
        System.out.println("Enter your selection > ");
    }

    // Display Reserve Menu
    public void displayReserveMenu() {
        System.out.println("++=========================++");
        System.out.println("||      Reserve Menu       ||");
        System.out.println("++===++====================++");
        System.out.println("|| 1 ||  Display Facility  ||");
        System.out.println("|| 2 ||  Search Facility   ||");
        System.out.println("|| 3 ||  Reserve Facility  ||");
        System.out.println("++===++====================++");
        System.out.print("\n\tEnter your selection > ");
    }

    public void displayFacility() {
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

    // Display Payment Menu
    public void displayPaymentMenu() {
        System.out.println("++=========================++");
        System.out.println("||      Payment Menu       ||");
        System.out.println("++===++====================++");
        System.out.println("|| 1 ||                    ||");
        System.out.println("|| 2 ||                    ||");
        System.out.println("|| 3 ||                    ||");
        System.out.println("++===++====================++");
        System.out.println("Enter your selection > ");
    }

    // User needs to be verified as administrator before entering this menu
    // Display Administrative Menu
    public void displayAdministrativeMenu() {
        System.out.println("Administrative Menu");
        System.out.println("++=========================++");
        System.out.println("||   Administrative Menu   ||");
        System.out.println("++===++====================++");
        System.out.println("|| 1 || Add new librarian  ||");
        System.out.println("|| 2 || Edit librarian ID  ||");
        System.out.println("|| 3 || Back               ||");
        System.out.println("++===++====================++");
        System.out.println("Enter your selection > ");
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
            }
            else {
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

        // Return False when both conditions above is not achieved
        return false;
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
