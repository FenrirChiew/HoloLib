package holoLib;

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
        System.out.println("Main Menu");
        System.out.println("");
        System.out.println("Enter your selection > ");
    }

    // Display Membership Menu
    public void displayMembershipMenu() {
        System.out.println("Membership Menu");
        System.out.println("Enter your selection > ");
    }

    // Display Borrow Menu
    public void displayBorrowMenu() {
        System.out.println("Borrow Menu");
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
        System.out.print("\nEnter your selection > ");
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
        System.out.println("Payment Menu");
        System.out.println("Enter your selection > ");
    }

    // Display Administrative Menu
    public void displayAdministrativeMenu() {
        System.out.println("Administrative Menu");
        System.out.println("Enter your selection > ");
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

    // HoloLib logo
    public void Logo() {
        System.out.println("\n\n\n");
        System.out.println("    HHH    HHH      OOOOOO      LLL            OOOOOO  ");
        System.out.println("    HHH    HHH     OOO  OOO     LLL           OOO  OOO ");
        System.out.println("    HHHHHHHHHH    OOO    OOO    LLL          OOO    OOO");
        System.out.println("    HHH    HHH     OOO  OOO     LLL           OOO  OOO ");
        System.out.println("    HHH    HHH      OOOOOO      LLLLLLLLLL     OOOOOO  ");
        System.out.println("\n");
        System.out.println("          LLL           IIIIIIIIII    BBBBBBBB");
        System.out.println("          LLL              IIII       BBB    BBB");
        System.out.println("          LLL              IIII       BBBBBBBB");
        System.out.println("          LLL              IIII       BBB    BBB");
        System.out.println("          LLLLLLLLLL    IIIIIIIIII    BBBBBBBB");
        System.out.println("\n\n                                              Logo V1.0");
        System.out.println("              Press Enter to continue...");
    }
}
