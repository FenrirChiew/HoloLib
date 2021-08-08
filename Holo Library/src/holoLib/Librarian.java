package holoLib;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Librarian {


    // Register Membership method 
    public Member registerMembership(){

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
                
            }
        }


    }

    // Convert String to Date
    public Date ConvertToDate(String dateOfBirth)throws Exception{
        Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth);

        return dob;
    }
}
