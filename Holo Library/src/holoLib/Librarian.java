package holoLib;

import java.util.Scanner;
import java.util.jar.Attributes.Name;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Librarian extends Account{
    private String position;
    private static int totalLibrarian; 

    //Constructor without arguments
    public Librarian(){
        super("", "", "", "", null, "", "");
        this.position = "";
    }

    //Constructor with arguments 
    public Librarian(String username, String password, String name,String gender, Date dateOfBirth, String icNo, String phoneNo, String position){
        super(username, password, name, gender, dateOfBirth, icNo, phoneNo);
        this.position = position;
        totalLibrarian++;
    }

    // Register Membership method  (havent finish)
    public Member registerMembership() throws Exception{

        Scanner sc = new Scanner(System.in);
        Member member = new Member();

        System.out.print("Do you want to register a membership (Y= yes N= No)? ");
        char confirm = sc.nextLine().charAt(0);

        if(confirm == 'Y'){

            System.out.print("Name: ");
            String name = sc.nextLine();
           
            System.out.print("IC No: ");
            String icNo = sc.nextLine();
            
            System.out.print("Gender: ");
            String gender = sc.nextLine();
           
            System.out.print("Date Of Birth: ");
            String dateOfBirth = sc.nextLine();
            Date dob = ConvertToDate(dateOfBirth); 

            System.out.print("Phone No: ");
            String phoneNo = sc.nextLine();

            System.out.print("Username: ");
            String username = sc.nextLine();

            System.out.print("Password: ");
            String password = sc.nextLine();

            System.out.print("Do you confirm want to register to be a member (Y= Yes N= No): ");
            char doubleConfirm = sc.nextLine().charAt(0);
            
            // store the data inside to the member 
            if(doubleConfirm == 'Y'){
                System.out.println("You had success to add a member!!");
                member.setName(name);
                member.setIcNo(icNo);
                member.setGender(gender);
                member.setDateOfBirth(dob);
                member.setPhoneNo(phoneNo);
                member.setUsername(username);
                member.setPassword(password);
            }
            else{
                System.out.println("You had not add a member!!");
            }
        }
        else{
            System.out.println("You are not ready to register a membership.");
        }
        //default will return null data in the member, while confirm then after set can return the value  
        return member;
    }

    // Convert String to Date
    public Date ConvertToDate(String dateOfBirth)throws Exception{
        Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth);

        return dob;
    }

    // Method to reload the money of the membership 
    public void ReloadMembership(LibraryCard libraryCard){
        // search id is another method (return index id)--> search memberIDby Id
        // member.getlibraryCard 
        // input how much money --> main 
        // reload --> libraryCard.setbalance (set balance)

        Scanner sc = new Scanner(System.in);

        libraryCard = new LibraryCard();
        Member[] member = new Member[4];

        System.out.print("Do you want to reload the money to the library card (Y= Yes N= No): ");
        char confirm = sc.nextLine().charAt(0);

        if(confirm == 'Y'){
            SearchMemberID();

        System.out.print("How much do you want to reload: RM ");
        double reloadMoney = sc.nextDouble();
        
        System.out.printf("Do you confirm want to reload RM %.2f into %s 's account (Y= yes N= No)? ",reloadMoney, );  // cant pass the name to here
        char doubleConfirm = sc.nextLine().charAt(0);

        if(doubleConfirm == 'Y'){

        double balance = libraryCard.getcardBalance();

        double newBalance = newBalance + balance;
        
        libraryCard.setcardBalance(newBalance);

        }
        else{
            System.out.println("You have not reload the money successful!!");
        }
    }
    else{
        System.out.println("You have not ready to reload the money.");
    }
    }

    public String SearchMemberID(){

        Scanner sc = new Scanner(System.in);
        Member[] member = new Member[3];
        String name;

        System.out.print("Please key in your member ID: ");
        String memberID = sc.nextLine();

        for(int i = 0; i < member.length; i++){

            if(member[i].getLibraryCard().getMemberID() == memberID){
                System.out.println("Member Id: " + member[i].getLibraryCard().getMemberID());
                System.out.println("Member name: " + member[i].getName());
                name = member[i].getName();
            }
            else{
                System.out.println("You had key in wrong member ID!");
            }
            }
            return name; //dk why cant return this 
    }

    //Method to renew the membership 
    public LibraryCard RenewMembership(){

        Scanner sc = new Scanner(System.in);
        LibraryCard libraryCard = new LibraryCard();

        System.out.print("Do you want to renew the membership (Y= Yes N= No): ");
        char confirm = sc.nextLine().charAt(0);

        if(confirm == 'Y'){
            SearchMemberID();
            RenewMembership();
            char choices = sc.nextLine().charAt(0);
            switch(choices){
                case 1: 
              //  libraryCard.setExpDate(); // how to add 1 year into the date? 
            }
        }
        else{
            System.out.println("You are not ready to renew membership!");
        }

        return libraryCard;
    }

    public void RenewMembershipMenu(){
        System.out.println(" __________________________________________");
        System.out.println("|         Menu For Renew Membership        |");
        System.out.println("|------------------------------------------|");
        System.out.println("| 1. Renew For 1 year (RM 20.00)           |");
        System.out.println("| 2. Renew For 2 year (RM 30.00)           |");
        System.out.println("| 3. Renew For 3 year and above (RM 35.00) |");
        System.out.println(" __________________________________________");

        System.out.println("\nChoices: ");
    }

}
