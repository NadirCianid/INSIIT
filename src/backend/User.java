package backend;

import java.util.ArrayList;
import java.util.List;

public class User {

    public static List<User> admins = new ArrayList<>();
    private String name;
    private String phoneNumber;
    private boolean isAdmin;

    public User(String name, String phoneNumber, boolean isAdmin) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isAdmin = isAdmin;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public static boolean isUserAdmin(String name, String phoneNumber) {
        for (User user : admins) {
            if (user.getName().equals(name) && user.getPhoneNumber().equals(phoneNumber) && user.isAdmin()) {
                return true;
            }
        }
        return false;

    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
