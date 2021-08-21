package holoLib;

public class LibrarySystem {
    /********** Properties **********/
    private People[] librarianList; // Librarian List
    private People[] memberList; // Member List
    private Facility[] facilityList; // Facility List
    private ReadingMaterial[] readingMaterialList; // Reading Material List

    /********** Constructors **********/
    public LibrarySystem() {

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
        System.out.println("Reserve Menu");
        System.out.println("Enter your selection > ");
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
}
