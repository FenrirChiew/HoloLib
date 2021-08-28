package holoLib;

 import java.util.Scanner;
// import java.text.SimpleDateFormat;
// import java.util.Calendar;
import java.util.GregorianCalendar;

public class Librarian extends People {
    /********** Properties **********/
    private String librarianID; // Librarian ID
    private String password; // Librarian Password
    private String position; // Librarian Position
    private static int totalLibrarian = 0; // Total Number of Librarian

    /********** Constructors **********/
    public Librarian() {
        this("", "", null, "", "", "", "", "");
        totalLibrarian++;
    }

    public Librarian(String name, String gender, GregorianCalendar dateOfBirth, String icNo, String phoneNo, String librarianID,
            String password, String position) {
        super(name, gender, dateOfBirth, icNo, phoneNo);
        this.librarianID = librarianID;
        this.password = password;
        this.position = position;
        totalLibrarian++;
    }

    /********** Accessors & Mutators **********/
    public String getLibrarianID() {
        return librarianID;
    }

    public void setLibrarianID(String librarianID) {
        this.librarianID = librarianID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public static int getTotalLibrarian() {
        return totalLibrarian;
    }

     /********** Methods **********/
     // Register Membership method
     public Member registerMembership(){

        Scanner sc = new Scanner(System.in);
   
        System.out.print("Do you want to register a membership (Y= yes N= No)? ");
        char confirm = sc.nextLine().charAt(0);
   
        if (confirm == 'Y') {
   
        System.out.print("Name: ");
        String name = sc.nextLine();
   
        System.out.print("IC No: ");
        String icNo = sc.nextLine();
   
        System.out.print("Gender: ");
        String gender = sc.nextLine();
   
        System.out.print("Enter your date of birth (dd/mm/yyyy): ");
        String dob = sc.nextLine();
        GregorianCalendar dateOfBirth = ConvertDate(dob);
   
        //System.out.println(cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR));
   
        System.out.print("Phone No: ");
        String phoneNo = sc.nextLine();
   
        System.out.println("Pin number of the Library Card: ");
        String pinNo = sc.nextLine();
   
        System.out.print("Do you confirm want to register to be a member (Y = yes N = no)? ");
        char doubleConfirm = sc.nextLine().charAt(0);
   
        // store the data inside to the member
        if (doubleConfirm == 'Y') {
   
            LibraryCard libraryCard = new LibraryCard(pinNo,null);
   
            Member member = new Member(name, gender, dateOfBirth, icNo, phoneNo, libraryCard);
            System.out.println("You had success to add a member!!");

            System.out.println("Do you want to cash in for the card balance (Y = yes N = no)? ");
            char ChoiceCashIn = sc.nextLine().charAt(0);
            if(ChoiceCashIn == 'Y'){
                System.out.println("How much do you want to cash in: RM ");
                double cashIn = sc.nextDouble();
            }
            PrintRegisterDetail(member);
   
        } else {
        System.out.println("You had not add a member!!");
        }
        } else {
        System.out.println("You are not ready to register a membership.");
        }
   
        // return the value
        return member; //how to return the member? 
        }
   
        // Convert String to Date
        public static GregorianCalendar ConvertDate(String dob) {
   
            GregorianCalendar dateOfBirth = new GregorianCalendar();
            String[] arrSplit = dob.split("/", 3);
   
            int day = Integer.parseInt(arrSplit[0]);
            int month = Integer.parseInt(arrSplit[1]);
            int year = Integer.parseInt(arrSplit[2]);
   
            dateOfBirth.set(GregorianCalendar.YEAR, year);
            dateOfBirth.set(GregorianCalendar.MONTH, month);
            dateOfBirth.set(GregorianCalendar.DAY_OF_MONTH, day);
   
            return dateOfBirth;
        }
   
       public void PrintRegisterDetail(Member member){
           System.out.println("          Member Detail");
           System.out.println("===================================");
          
           member.toString();
       }

    // // Method to reload the money of the membership
    public void ReloadMembership(Member[] member) {
    // search id is another method (return index id)--> search memberIDby Id
    // member.getlibraryCard
    // input how much money --> main
    // reload --> libraryCard.setbalance (set balance)

    Scanner sc = new Scanner(System.in);
    double newBalance = 0.0;

    System.out.print("Do you want to reload the money to the library card (Y= Yes N= No): ");
    char confirm = sc.nextLine().charAt(0);

    if (confirm == 'Y') {
    String name = SearchMemberID();

    System.out.print("How much do you want to reload: RM ");
    double reloadMoney = sc.nextDouble();

    System.out.printf("Do you confirm want to reload RM %.2f into %s 's account (Y= yes N= No)? ", reloadMoney,
    name);
    char doubleConfirm = sc.nextLine().charAt(0);

    if (doubleConfirm == 'Y') {

    double balance = libraryCard.getcardBalance();

    newBalance = newBalance + balance;

    libraryCard.setcardBalance(newBalance);

    } else {
    System.out.println("You have not reload the money successful!!");
    }
    } else {
    System.out.println("You have not ready to reload the money.");
    }
    }

    public String SearchMemberID() {

    Scanner sc = new Scanner(System.in);
    Member[] member = new Member[3];
    String name = "";

    System.out.print("Please key in your member ID: ");
    String memberID = sc.nextLine();

    for (int i = 0; i < member.length; i++) {

    if (member[i].getLibraryCard().getMemberID() == memberID) {
    System.out.println("Member Id : " +
    member[i].getLibraryCard().getMemberID());
    System.out.println("Member name: " + member[i].getName());
    System.out.println("Member IC : " + member[i].getIcNo());
    name = member[i].getName();
    } else {
    System.out.println("You had key in wrong member ID!");
    }

    }
    return name;
    }

    // // Method to renew the membership
    // public LibraryCard RenewMembership() throws Exception {

    // Scanner sc = new Scanner(System.in);
    // LibraryCard libraryCard = new LibraryCard();
    // String newExpireDate;

    // System.out.print("Do you want to renew the membership (Y= Yes N= No): ");
    // char confirm = sc.nextLine().charAt(0);

    // if (confirm == 'Y') {
    // String name = SearchMemberID();
    // System.out.println("Expire Date: " + libraryCard.getMemberExpDate());
    // RenewMembershipMenu();
    // char choices = sc.nextLine().charAt(0);
    // newExpireDate = NewExpireDate(choices, libraryCard);
    // libraryCard.setExpDate(newExpireDate);
    // }

    // else {
    // System.out.println("You are not ready to renew membership!");
    // }

    // return libraryCard;
    // }

    // public void RenewMembershipMenu() {
    // System.out.println(" __________________________________________");
    // System.out.println("| Menu For Renew Membership                |");
    // System.out.println("|------------------------------------------|");
    // System.out.println("| 1. Renew For 1 year (RM 20.00)           |");
    // System.out.println("| 2. Renew For 2 year (RM 30.00)           |");
    // System.out.println("| 3. Renew For 3 year and above (RM 35.00) |");
    // System.out.println(" __________________________________________");

    // System.out.print("\nChoices: ");
    // }

    // public String NewExpireDate(int choices, LibraryCard libraryCard) throws
    // Exception {

    // String date = libraryCard.getMemberExpDate(); // Start date
    // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    // Calendar c = Calendar.getInstance();
    // c.setTime(sdf.parse(date));

    // if (choices == 1) {
    // c.add(Calendar.YEAR, 1); // number of years to add
    // } else if (choices == 2) {
    // c.add(Calendar.YEAR, 2); // number of years to add
    // } else if (choices == 3) {
    // c.add(Calendar.YEAR, 3); // number of years to add
    // } else {
    // System.out.println("You had key in invalid number!");
    // }

    // date = sdf.format(c.getTime());
    // return date;
    // }

    public void BorrowReadingMaterial(Member[] member, ReadingMaterial[] readingMaterial){

        
        Scanner sc = new Scanner(System.in);
        ReadingMaterial tempReadingMaterial = new ReadingMaterial();
        Member tempMember = new Member();
        
        System.out.println("Do you want to undergo borrow reading material process (Y = yes N = No)? ");
        char confirm = sc.nextLine().charAt(0);

        if(confirm == 'Y'){
            // get member details
            tempMember = SearchLibraryCardNo(member);
            while(tempMember == null){
                System.out.println("You had key in invalid Library Card Number! Please key in again!!");
                tempMember = SearchLibraryCardNo(member);
            }
            
            tempReadingMaterial = SearchReadingMaterialCode(readingMaterial);
            while(tempReadingMaterial == null){
                System.out.println("You had key in invalid Reading Material Number! Please key in again!!");
                tempReadingMaterial = SearchReadingMaterialCode(readingMaterial);
            }

            System.out.println("Do you want to confirm to continue the borrow process (Y = Yes N = No)? ");
            char doubleConfirm = sc.nextLine().charAt(0);

            if(doubleConfirm == 'Y'){
            System.out.println("Please key in the pin number of the library card: ");
            String pinNo = sc.nextLine();
                if(tempMember.getLibraryCard().getPinNo() == pinNo){
                    CalculateBorrowedPayment(tempReadingMaterial, tempMember);
                    PrintBorrowedReadingMaterialDetails(tempMember, tempReadingMaterial);
                    String readingMaterialStatus = "Borrowed";
                    tempReadingMaterial.setReadingMaterialStatus(readingMaterialStatus);
                }
                else{
                    System.out.println("You had key in wrong pin number");
                }
            }
        }
     }

    //  public void ReturnReadingMaterial(Member[] member, ReadingMaterial[] readingMaterial){

    //     Scanner sc = new Scanner(System.in);
    //     ReadingMaterial tempReadingMaterial = new ReadingMaterial();
    //     Member tempMember = new Member();
        
    //     System.out.println("Do you want to undergo return reading material process (Y = yes N = No)? ");
    //     char confirm = sc.nextLine().charAt(0);

    //     if(confirm == 'Y'){
    //         // get member details
    //         tempMember = SearchLibraryCardNo(member);
    //         do{
    //             System.out.println("You had key in invalid Library Card Number! Please key in again!!");
    //             tempMember = SearchLibraryCardNo(member);
    //         }while(tempMember == null);
            
    //         System.out.println("");

    //         System.out.println("Do you want to confirm to continue the return process (Y = Yes N = No)? ");
    //         char doubleConfirm = sc.nextLine().charAt(0);

    //         if(doubleConfirm == 'Y'){
    //         System.out.println("Please key in the pin number of the library card: ");
    //         String pinNo = sc.nextLine();
    //             if(tempMember.getLibraryCard().getPinNo() == pinNo){
    //                 CalculateBorrowedPayment(tempReadingMaterial, tempMember);
    //                 PrintBorrowedReadingMaterialDetails(tempMember, tempReadingMaterial);
    //                 String readingMaterialStatus = "Borrowed";
    //                 tempReadingMaterial.setReadingMaterialStatus(readingMaterialStatus);
    //             }
    //             else{
    //                 System.out.println("You had key in wrong pin number");
    //             }
    //         }
    //     }
    //  }

    // parameter Member[]
    public static Member SearchLibraryCardNo(Member[] member){
        Scanner sc = new Scanner(System.in);

        System.out.println("Library Card No: ");
        String cardNo = sc.nextLine();
        
        for(int i = 0; i < member.length; i++){
            if(member[i].getLibraryCard().getCardNO() == cardNo){
                return member[i];
            }
        }
        return null;
        
    }

    // parameter Reading Material[]
    public static ReadingMaterial SearchReadingMaterialCode(ReadingMaterial[] readingMaterial){
        Scanner sc = new Scanner(System.in);

        System.out.println("Reading Material Code: ");
        String readingMaterialCode = sc.nextLine();

        for(int i = 0; i < readingMaterial.length; i++){
            if(readingMaterial[i].getReadingMaterialCode() == readingMaterialCode){
                return readingMaterial[i];
            }
        }
        return null;   // if not equall return null readingMaterial
    }

    public static void CalculateBorrowedPayment(ReadingMaterial readingMaterial, Member member){

        Scanner sc = new Scanner(System.in);

       double cardBalance =  member.getLibraryCard().getcardBalance() - readingMaterial.getReadingMaterialPrice();

        member.getLibraryCard().setcardBalance(cardBalance);
    }

    public static void PrintBorrowedReadingMaterialDetails(Member member, ReadingMaterial readingMaterial){

        System.out.println("Member ID          : " + member.getMemberID());
        System.out.println("Member Name        : " + member.getName());
        System.out.println("Library Card Number: " + member.getLibraryCard().getCardNO());
        System.out.println("---------------------------------------------------");
        System.out.println("\nReading Material Code    : " + readingMaterial.getReadingMaterialCode());
        System.out.println("Reading Material Titile  : " + readingMaterial.getReadingMaterialTitle());
        System.out.println("Reading Material Language: " + readingMaterial.getReadingMaterialLanguage());
        System.out.println("Reading Material Author  : " + readingMaterial.getReadingMaterialAuthor());
    }

    // toString() method
    @Override
    public String toString() {
        return super.toString() + "\nLibrarian ID: " + librarianID + "\nPosition: " + position;
    }
}
