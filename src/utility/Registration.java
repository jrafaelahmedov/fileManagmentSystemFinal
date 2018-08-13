package utility;

import beans.Config;
import beans.User;
import config.Initializer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Registration {
    private static boolean a = true;

    public static User registration() {
        List<User> list = Initializer.config.getAllUsers();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter your surname: ");
        String surname = scanner.nextLine();
        System.out.println("Please enter your username: ");
        String username = scanner.nextLine();
        for (int i = 0; i < list.toArray().length; i++) {
            if (list.get(i).getUsername().equals(username)) {
                System.out.println("This username is already in existence! Please insert other!");
               return null;
            }
        }
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();
        User user = new User(name, surname, username, password);
        return user;
    }
}
