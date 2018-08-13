import beans.User;
import config.Initializer;
import utility.*;

public class Main {
    private static boolean adminlogin = true;
    private static boolean userlogin = true;
    private static boolean nonlogin = true;

    public static void main(String[] args) throws Exception {
        Initializer.initialize();
        while (nonlogin) {
            int nonloggedinmenu = Menu.menuForNonLoggedIn();
            if (nonloggedinmenu == 1) {
                UserSystem.register();
            } else if (nonloggedinmenu == 2) {
                User user = Login.login();
                if (user.isAdmin()) {
                    while (adminlogin) {
                        int adminmenu = Menu.menuForLoggedInAdmin();
                        if (adminmenu == 1) {
                            UserSystem.printAllActiveUsers();
                        } else if (adminmenu == 2) {
                            UserSystem.printAllActiveUsers();
                        } else if (adminmenu == 3) {
                            UserSystem.printAllInActiveUsers();
                        } else if (adminmenu == 4) {
                            UserSystem.approveUser();
                        } else if (adminmenu == 5) {
                            FileManagerSystem.setNonAccessibleFileOrFoldersForUser();
                        } else if (adminmenu == 6)
                            adminlogin = false;
                    }
                } else if (!user.isAdmin()) {
                    if (user.getStatus() == 0) {
                        System.out.println("You are cannt applayed!!");
                    } else if (user.getStatus() == 1) {
                        while (userlogin) {
                            int usermenu = Menu.menuForLoggedInUsers();
                            if (usermenu == 1) {
                                UserSystem.showMySelf();
                            } else if (usermenu == 2) {
                                FileManagerSystem.printAllSubFilesAndFolders();
                            } else if (usermenu == 3)
                                userlogin = false;
                        }
                    }
                }
            } else if (nonloggedinmenu == 3) {
                nonlogin = false;
            }
        }
    }
}
