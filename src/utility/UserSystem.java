package utility;

import beans.Config;
import beans.User;
import config.Initializer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UserSystem {
    public static boolean register() {
        User user = Registration.registration();
        return add(user);
    }

    public static boolean add(User user) {
        Config config;
        List<User> list = Initializer.config.getAllUsers();
        list.add(user);
        return FileManagerSystem.refreshConfig();
    }

    public static boolean approveUser() {
        List<User> users = getAllInActiveUsers();
        if (users.size() == 0) {
            System.out.println("there is not any inactive users");
            return false;
        }
        printAllInActiveUsers();//
        String id = askForUserId();
        User user = getUserById(id);
        user.setStatus(1);
        return save(user);
    }

    public static List<User> getAllInActiveUsers() {
        List<User> allUsers = Initializer.getAllUsers();
        if (allUsers == null || allUsers.size() == 0) {
            return Collections.emptyList();
        }

        List<User> inactiveUsers = new ArrayList<>();

        for (User u : allUsers) {
            if (u.getStatus() == 0) {
                inactiveUsers.add(u);
            }
        }
        return inactiveUsers;
    }

    public static boolean save(User user) {
        return FileManagerSystem.refreshConfig();
    }

    public static List<User> getAllActiveUsers() {
        List<User> allUsers = Initializer.getAllUsers();
        if (allUsers == null || allUsers.size() == 0) {
            return Collections.emptyList();
        }

        List<User> activeUsers = new ArrayList<>();

        for (User u : allUsers) {
            if (u.getStatus() == 1) {
                activeUsers.add(u);
            }
        }
        return activeUsers;
    }


    public static void printAllActiveUsers() {
        List<User> users = getAllActiveUsers();
        System.out.println(users);
    }


    public static void printAllInActiveUsers() {
        System.out.println("All inactive users");
        List<User> users = getAllInActiveUsers();
        System.out.println(users);
    }

    public static String askForUserId() {
        List<User> allUsers = Initializer.getAllUsers();
        System.out.println(allUsers.toString());
        System.out.println("Which user you want to approve?");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static User getUserById(String id) {
        List<User> allUsers = Initializer.getAllUsers();
        if (allUsers == null || allUsers.size() == 0) {
            return null;
        }
        for (User user : allUsers) {
            if (user.getId() != null && user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public static void showMySelf() {
        User user = FileManagerSystem.getLoggedInUser();
        System.out.println(user.toString());
    }
}
