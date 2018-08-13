package config;

import beans.Config;
import beans.User;
import utility.FileManagerSystem;
import utility.ReadFileIO;
import utility.WriteToFileIO;

import java.util.ArrayList;
import java.util.List;

public class Initializer {

    public static Config config;

    public static void initialize() throws Exception {
        config = FileManagerSystem.readConfig();//null

        if (config == null) {
            User user = new User("admin", "admin");
            user.setPosition(1);//admin
            user.setStatus(1);//active
            user.setId("admin");
            config = new Config();
            List<User> list = new ArrayList<>();
            list.add(user);
            config.setAllUsers(list);
            FileManagerSystem.refreshConfig();//
            initialize();
        } else {
            List<User> list = new ArrayList<>(config.getAllUsers());
            config.setAllUsers(list);
        }
    }
    public static List<User> getAllUsers() {
        //must select all users from file
        return Initializer.config.getAllUsers();
    }

    public static List<User> getAllActiveUsers() {
        List<User> list = new ArrayList<>(config.getAllUsers());
        return list;
    }

}
