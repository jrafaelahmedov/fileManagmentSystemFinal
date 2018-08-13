package utility;

import beans.Config;
import beans.User;
import config.Initializer;

import java.util.List;
import java.util.Scanner;

public class Login {
    public static User login() {
        User enteredUser = askUsernameAndPassword();
        List<User> allActiveUsers = Initializer.getAllActiveUsers();
        for (User user : allActiveUsers) {
            if (user.getUsername().equals(enteredUser.getUsername()) &&
                    user.getPassword().equals(enteredUser.getPassword())) {
                Initializer.config.setLoggedInUser(user);
                return user;
            }
        }

        throw new IllegalArgumentException("Invalid username or password");
    }


    private static User askUsernameAndPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();
        User user = new User(username,password);
        return user;
    }
}
