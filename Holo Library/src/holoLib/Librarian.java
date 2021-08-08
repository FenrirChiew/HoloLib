package holoLib;

import java.util.Scanner;
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
            String gender= sc.nextLine();
           
            System.out.print("Date Of Birth: ");
            String dateOfBirth = sc.nextLine();
            Date dob = ConvertToDate(dateOfBirth); 

            System.out.print("Phone No: ");
            String phoneNo= sc.nextLine();

            System.out.print("Do you confirm want to register to be a member (Y= Yes N= No): ");
            char doubleConfirm = sc.nextLine().charAt(0);
            
            // here need to store above variable to the member there, still figured out 
            if(doubleConfirm == 'Y'){
                System.out.println("You had success to add a member!!");
                member.setName(name);
                member.setIcNo(icNo);
                member.setGender(gender);
                member.setDateOfBirth(dob);
                member.setPhoneNo(phoneNo);

            }
            else{
                System.out.println("You had not add a member!!");
            }
        }
        else{
            System.out.println("You are not ready to register a membership.");
        }
        // default how to return? 
        return member;
    }

    // Convert String to Date
    public Date ConvertToDate(String dateOfBirth)throws Exception{
        Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth);

        return dob;
    }

    // Method to reload the money of the membership 
/*    public LibraryCard ReloadMembership(){

        Scanner sc = new Scanner(System.in);

        LibraryCard libraryCard = new LibraryCard();
        Member[] member = new Member[4];

        System.out.print("Do you want to reload the money to the library card (Y= Yes N= No): ");
        char confirm = sc.nextLine().charAt(0);

        System.out.print("Please key in your member ID: ");
        String memberID = sc.nextLine();

        for(int i = 0; i < member.length; i++){

            if(member[i].libraryCard.getMemberID() == memberID){
                System.out.println("Member Id: " + libraryCard[i].getMemberID());
                System.out.println("Member name: " + libraryCard[i]);
                System.out.println("Member Id: " + libraryCard[i].getMemberID());
                System.out.println("Member Id: " + libraryCard[i].getMemberID());
            }
        }

      
    }*/

    //Method to renew the membership 


}
