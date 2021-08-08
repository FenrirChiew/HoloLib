package holoLib;

import java.util.Scanner;

public class holoLib {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hello World!");
        System.out.print("Press Enter to continue...");
        sc.nextLine();
        cls();

        sc.close();
    }

    public static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
