package holoLib;

public class TestLogo {

/*

// Library that need to import

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

// Codes are below

	private static int recordCount = 0;
	private String[] loginID = new String[100];
	private LocalDateTime[] loginTime = new LocalDateTime[100];
	private LocalDateTime[] logoutTime = new LocalDateTime[100];
	private boolean isLogin = false;
	private boolean isLogout = false;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

	// need to be call everytime the user login/logout + need to set isLogin / isLogout to true before it is called
	public void RecordTime() {
		if (isLogin) {
			loginID[recordCount] = currentLoggedUser.getLibrarianID();
			loginTime[recordCount] = LocalDateTime.now();
			isLogin = false;
		}

		if (isLogout) {
			logoutTime[recordCount] = LocalDateTime.now();
			isLogout = false;
			recordCount++;
		}
	}

	// Used to display login record
    public void displayLoginRecord() {
        System.out.println("+==========+==========================+===========================+");
		System.out.println("| Login ID |        Login Time        |        Logout Time        |");
		System.out.println("+==========+==========================+===========================+");
		for (int i = 0; i < recordCount; i++)
			System.out.printf("| %-8s | " + dtf.format(loginTime[recordCount]) + " | " + dtf.format(logoutTime[recordCount]) + " |");
		System.out.println("+==========+==========================+===========================+");
    }

*/


	public static void main(String[] args) {
        System.out.println("⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄");
		System.out.println("⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣀⠠⠤⠤⠤⠤⠤⠤⠤⠤⠤⠐⠒⠒⢄⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄");
		System.out.println("⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣀⡠⠤⠄⠒⠒⠂⠤⣀⠄⠄⡠⠒⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠒⢄⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄");
		System.out.println("⠄⠄⠄⠄⠄⠄⠄⠄⢀⠠⠒⠉⠄⠄⠄⠄⠄⠄⠄⠄⠄⠑⠲⣅⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠒⢄⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄");
		System.out.println("⠄⠄⠄⠄⠄⣀⠤⠊⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠳⣄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠒⢄⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄");
		System.out.println("⠄⠄⠄⡴⢫⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠓⢄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠒⢄⡀⠄⠄⠄⠄⠄⠄⠄⠄");
		System.out.println("⠄⠄⣰⠇⠄⠱⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠑⢄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠒⢄⡀⠄⠄⠄⠄⠄");
		System.out.println("⠄⠄⠙⣷⡀⠄⠘⣄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠙⢦⡀⠄⠄⠄⠄⠄⠄⠄⠄⢀⣀⣤⣤⠤⠤⠴⠶⠒⠒⠒⠒⠒⠒⠒⢺⠂⠄⠄⠄⠄");
		System.out.println("⠄⠄⠄⠘⢿⣄⠄⠈⢆⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠙⢦⡀⠄⠄⢀⡤⠖⠋⠉⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠘⣷⣦⣀⠄⠄");
		System.out.println("⠄⠄⠄⠄⠈⢻⣆⠄⠄⠣⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣀⣀⡠⠤⠤⠤⠽⣦⣰⠋⠄⠄⠄⠄⠄⣀⣀⣀⣀⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣽⣿⣿⠃⠄");
		System.out.println("⠄⠄⠄⠄⠄⠄⠹⣧⡀⠄⠱⡄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣠⠤⠒⠋⠉⠄⠄⠄⠄⠄⠄⢠⣾⣥⣤⣄⠄⣠⣶⣿⣿⣿⣿⡿⠿⠿⠿⠛⠛⠛⠛⠉⠉⠉⠉⠁⠄⠄⠄");
		System.out.println("⠄⠄⠄⠄⠄⠄⠄⠙⣷⡄⠄⠘⢄⠄⠄⠄⠄⠄⠄⣀⠤⠒⠉⠄⠄⠄⠄⠄⠄⠄⣀⣀⣀⣀⣿⣿⣿⣿⡿⠟⠉⠉⠉⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄");
		System.out.println("⠄⠄⠄⠄⠄⠄⠄⠄⠘⢿⣄⠄⠈⢢⠄⣀⡠⠔⠋⠁⠄⠄⠄⠄⣀⣤⣴⣾⣿⠿⠟⠛⠉⠙⠛⠋⠉⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄");
		System.out.println("⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⢻⣦⠄⠄⡏⠄⠄⠄⠄⢀⣠⣴⣾⡿⠿⠛⠉⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄");
		System.out.println("⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠻⣷⣀⡇⠄⣀⣤⣶⠿⠛⠉⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄");
		System.out.println("⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠙⣿⡷⠟⠋⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄");
		System.out.println("⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄");
		System.out.println("\n");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⣿⣿⣿⠀");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⣿⠀⠀⠀⣿");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⣿⣿⣿⣿");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⣿⠀⠀⠀⣿");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⣿⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⣿⣿⣿⣿⠀⠀⣿⣿⣿⣿⠀");
		System.out.println("\n");
		System.out.println("                 Press Enter to start...");
    }
}

/*
⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠤⠖⠚⢉⣩⣭⡭⠛⠓⠲⠦⣄⡀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⢀⡴⠋⠁⠀⠀⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠳⢦⡀⠀⠀⠀⠀
⠀⠀⠀⠀⢀⡴⠃⢀⡴⢳⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣆⠀⠀⠀
⠀⠀⠀⠀⡾⠁⣠⠋⠀⠈⢧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢧⠀⠀
⠀⠀⠀⣸⠁⢰⠃⠀⠀⠀⠈⢣⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣇⠀
⠀⠀⠀⡇⠀⡾⡀⠀⠀⠀⠀⣀⣹⣆⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⠀
⠀⠀⢸⠃⢀⣇⡈⠀⠀⠀⠀⠀⠀⢀⡑⢄⡀⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡇
⠀⠀⢸⠀⢻⡟⡻⢶⡆⠀⠀⠀⠀⡼⠟⡳⢿⣦⡑⢄⠀⠀⠀⠀⠀⠀⠀⠀⢸⡇
⠀⠀⣸⠀⢸⠃⡇⢀⠇⠀⠀⠀⠀⠀⡼⠀⠀⠈⣿⡗⠂⠀⠀⠀⠀⠀⠀⠀⢸⠁
⠀⠀⡏⠀⣼⠀⢳⠊⠀⠀⠀⠀⠀⠀⠱⣀⣀⠔⣸⠁⠀⠀⠀⠀⠀⠀⠀⢠⡟⠀
⠀⠀⡇⢀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⢸⠃⠀
⠀⢸⠃⠘⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠁⠀⠀⢀⠀⠀⠀⠀⠀⣾⠀⠀
⠀⣸⠀⠀⠹⡄⠀⠀⠈⠁⠀⠀⠀⠀⠀⠀⠀⡞⠀⠀⠀⠸⠀⠀⠀⠀⠀⡇⠀⠀
⠀⡏⠀⠀⠀⠙⣆⠀⠀⠀⠀⠀⠀⠀⢀⣠⢶⡇⠀⠀⢰⡀⠀⠀⠀⠀⠀⡇⠀⠀
⢰⠇⡄⠀⠀⠀⡿⢣⣀⣀⣀⡤⠴⡞⠉⠀⢸⠀⠀⠀⣿⡇⠀⠀⠀⠀⠀⣧⠀⠀
⣸⠀⡇⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⢹⠀⠀⢸⠀⠀⢀⣿⠇⠀⠀⠀⠁⠀⢸⠀⠀
⣿⠀⡇⠀⠀⠀⠀⠀⢀⡤⠤⠶⠶⠾⠤⠄⢸⠀⡀⠸⣿⣀⠀⠀⠀⠀⠀⠈⣇⠀
⡇⠀⡇⠀⠀⡀⠀⡴⠋⠀⠀⠀⠀⠀⠀⠀⠸⡌⣵⡀⢳⡇⠀⠀⠀⠀⠀⠀⢹⡀
⡇⠀⠇⠀⠀⡇⡸⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠮⢧⣀⣻⢂⠀⠀⠀⠀⠀⠀⢧
⣇⠀⢠⠀⠀⢳⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⡎⣆⠀⠀⠀⠀⠀⠘
⢻⠀⠈⠰⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⠘⢮⣧⡀⠀⠀⠀⠀
⠸⡆⠀⠀⠇⣾⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠆⠀⠀⠀⠀⠀⠀⠀⠙⠳⣄⡀⢢⡀
*/