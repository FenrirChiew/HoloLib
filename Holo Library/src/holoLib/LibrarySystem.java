package holoLib;

import java.util.Scanner;

public class LibrarySystem {
    /********** Properties **********/
    private People[] librarianList; // Librarian List
    private People[] memberList; // Member List
    private Facility[] facilityList; // Facility List
    private Material[] materialList; // Material List

    /********** Constructors **********/
    public LibrarySystem() {
        this(null, null, null, null);
    }

    // testing purpose
    public LibrarySystem(Facility[] facilityList) {
        this.facilityList = facilityList;
    }

    public LibrarySystem(People[] librarianList, People[] memberList, Facility[] facilityList,
            Material[] materialList) {
        this.librarianList = librarianList;
        this.memberList = memberList;
        this.facilityList = facilityList;
        this.materialList = materialList;
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

    public Material[] materialList() {
        return materialList;
    }

    public void setReadingMaterialList(Material[] materialList) {
        this.materialList = materialList;
    }

    /********** Methods **********/
    // Display Main Menu
    public void displayMainMenu() {
        System.out.println("++==============================++");
        System.out.println("||          Main Menu           ||");
        System.out.println("++===++=========================++");
        System.out.println("|| 1 ||  Membership Management  ||");
        System.out.println("|| 2 ||  Book Borrowing         ||");
        System.out.println("|| 3 ||  Reports                ||");
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
        System.out.println("|| 2 || Membership Renewal       ||"); //Renew means the expire date is reach then renew
        System.out.println("|| 3 || Reload Card Balance      ||"); //Reload means the card do not have enough balance then reload
        System.out.println("|| 3 || Display detail ?         ||"); // this display all member detail? 
        System.out.println("++===++==========================++");
    }

    // Display Borrow Menu
    public void displayBorrowMenu() {
        System.out.println("++=========================++");
        System.out.println("||     Book Borrowing      ||");
        System.out.println("++=========================++");
        System.out.println("|| 1 || Display book        ||");
        System.out.println("|| 2 || Search book        ||");
        System.out.println("|| 3 || Borrow book        ||");
        System.out.println("|| 4 || Return book        ||");
        System.out.println("|| 0 || Back               ||");
        System.out.println("++===++====================++");
    }

    // * Date how to print @A@
    public void displayBook() {
        System.out.println("++======================++");
        System.out.println("||     Display Book      ||");
        System.out.println("++====++========================++=========++=========================++==================++=======================++============++");
        System.out.println("|| NO ||       Book Title       || Book ID ||       Book Author       ||  Book Publisher  || Book Publication Date || Book Price ||");
        System.out.println("++====++========================++=========++=========================++==================++=======================++============++");

        for (int i = 0; i < materialList.length; i++) {
            System.out.printf("|| %02d || %-22s || %-7s || %-23s || %-16s || date || %-10.2f ||\n", i + 1, materialList[i].materialTitle,
                    materialList[i].materialID, materialList[i].materialAuthor, materialList[i].materialPublisher,
                    materialList[i].materialPublicationDate, materialList[i].materialPrice);
            System.out.println("++====++========================++=========++=========================++==================++=======================++============++");
        }
        System.out.println("\nTotal Book(s) Found: " + materialList.length);
    }

    public void borrowBook(){
        // Member ID:
        // searchMemberByID()
        // Book ID:
        // searchBookByID()
        // Confirmation
        // Y - borrowBook(), cal()/pay()
        // any wrong - captureContinueChoice() - used to ask user continue ? (Y/N)
        // Y - loop again, N - back to menu
    }

    public void returnBook(){

    }

    // Display Book Searching Menu
    public void displayBookSearchingMenu() {
        System.out.println("++============================++");
        System.out.println("||       Book Searching       ||");
        System.out.println("++============================++");
        System.out.println("|| Search By:                 ||");
        System.out.println("|| 1    Book Title            ||");
        System.out.println("|| 2    Book ID               ||");
        System.out.println("|| 3    Author                ||");
        System.out.println("|| 4    Publisher             ||");
        System.out.println("|| 0    Back                  ||");
        System.out.println("++===++=======================++");
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
        System.out.println("++===============================++");
        System.out.println("||            Report             ||");
        System.out.println("++===++==========================++");
        System.out.println("|| 1 || Daily Book Borrow Report ||");
        System.out.println("|| 2 || Daily Book Return Report ||");
        System.out.println("|| 0 || Back                     ||");
        System.out.println("++===++==========================++");
    }

    // User needs to be verified as administrator before entering this menu
    // Display Administrative Menu
    public void displayAdministrativeMenu() {
        System.out.println("++==============================++");
        System.out.println("||        Administrative        ||");
        System.out.println("++===++=========================++");
        System.out.println("|| 1 || Member Management       ||");
        System.out.println("|| 2 || Librarian Management    ||");
        System.out.println("|| 3 || Books Inv. Management   ||");
        System.out.println("|| 0 || Back                    ||");
        System.out.println("++===++=========================++");
    }

    // Display Member Management Menu
    public void displayMemberManagementMenu() {
        System.out.println("++==============================++");
        System.out.println("||      Member Management       ||");
        System.out.println("++===++=========================++");
        System.out.println("|| 1 || Add Member              ||");
        System.out.println("|| 2 || Modify Member           ||");
        System.out.println("|| 3 || Delete Member           ||");
        System.out.println("|| 0 || Back                    ||");
        System.out.println("++===++=========================++");
    }

    // Display Librarian Management Menu
    public void displayLibrarianManagementMenu() {
        System.out.println("++==============================++");
        System.out.println("||     Librarian Management     ||");
        System.out.println("++===++=========================++");
        System.out.println("|| 1 || Add Librarian           ||");
        System.out.println("|| 2 || Modify Librarian        ||");
        System.out.println("|| 3 || Delete Librarian        ||");
        System.out.println("|| 0 || Back                    ||");
        System.out.println("++===++=========================++");
    }

    // Display Books Inventory Management Menu
    public void displayBooksInvManagementMenu() {
        System.out.println("++==============================++");
        System.out.println("||  Books Inventory Management  ||");
        System.out.println("++===++=========================++");
        System.out.println("|| 1 || Add Book Data           ||");
        System.out.println("|| 2 || Modify Book Data        ||");
        System.out.println("|| 3 || Delete Book Data        ||");
        System.out.println("|| 0 || Back                    ||");
        System.out.println("++===++=========================++");
    }

    public void addBook(){

    }

    public void modifyBook(){

    }

    public void deleteBook(){

    }

    // Removed, put here for decorative and reference purpose
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
