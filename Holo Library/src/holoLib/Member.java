package holoLib;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Member extends Account{
    private LibraryCard libraryCard;
    private static int totalMember = 0;
    
    // Constructor without arguments 
    public Member(){
        super("", "", "", "", null, "", "");
    }

    // Constructor with arguments
    public Member(String username, String password, String name,String gender, Date dateOfBirth, String icNo, String phoneNo, LibraryCard libraryCard){
        super(username, password, name, gender, dateOfBirth, icNo, phoneNo);
        this.libraryCard = libraryCard;
        totalMember++;
     
    }

    //getter 
    public static int getTotalMember(){
        return totalMember;
    }

    // ~~~~~~~~~~~~~ method ~~~~~~~~~~~~~~~

    // toString method 
    public String toString(){
        return super.toString() + libraryCard.toString() ;
    }

    // Register Membership method 
    public void registerMembership(){

        Scanner sc = new Scanner(System.in);

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
            Date dob = ConvertToDate(dateOfBirth);  // still figured out how to convert

            System.out.print("Phone No: ");
            String phoneNo= sc.nextLine();

            System.out.print("Do you confirm want to register to be a member (Y= Yes N= No): ");
            char doubleConfirm = sc.nextLine().charAt(0);
            if(doubleConfirm == 'Y'){
                System.out.println("You had success to add a member!!");
                totalMember++;
            }
        }


    }

    // Convert String to Date
    public Date ConvertToDate(String dateOfBirth)throws Exception{
        Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth);

        return dob;
    }

    // Calculate the age (required or not)
    

}
