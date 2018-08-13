package beans;

import java.io.Serializable;
import java.util.List;

public class Config extends User implements Serializable {
    public static final String fileName = "fmsconfig.ser";
    private transient User loggedInUser;
    private List<User> allUsers;

    public List<User> getAllUsers() {
        return allUsers;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void setAllUsers(List<User> allUsers) {
        this.allUsers = allUsers;
    }

}
