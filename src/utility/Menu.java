package utility;

import java.util.Scanner;

public class Menu {
    public static int menuForNonLoggedIn() {

        System.out.println("Please choose menu:\n" +
                "1.Register\n" +
                "2.Login\n" +
                "3.Exit");
        Scanner scan = new Scanner(System.in);
        int selectedMenu = scan.nextInt();
        return selectedMenu;
    }

    public static int menuForLoggedInUsers() {
        System.out.println("Please choose menu:\n" +
                "1.Show myself\n" +
                "2.Enter file or folder\n" +
                "3.Exit");
        Scanner scan = new Scanner(System.in);
        int selectedMenu = scan.nextInt();
        return selectedMenu;
    }

    public static int menuForLoggedInAdmin() {
        System.out.println("Please choose menu:\n" +
                "1.Show users\n" +
                "2.Show active users\n" +
                "3.Show inactive users\n" +
                "4.Approve user\n" +
                "5.Set non accessible files or folders for user\n" +
                "6.Exit");
        Scanner scan = new Scanner(System.in);
        int selectedMenu = scan.nextInt();
        return selectedMenu;
    }
}
