package holoLib;

import java.util.Scanner;

public class holoLib {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibrarySystem holoLib = new LibrarySystem();

        holoLib.Logo();
        
        sc.close();
    }

    public static void cls() {
        System.out.print("\033[H\033[2J");
        // \033 - escape character (ECS)
        // \033[H - move cursor to top left of the console
        // \033[2J - clear the screen from cursor to the end of the console
        System.out.flush(); // clear the buffers
    }
}
