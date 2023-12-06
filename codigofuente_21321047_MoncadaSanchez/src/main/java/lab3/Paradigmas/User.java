package lab3.Paradigmas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User implements inUser{
    private String username;
    private boolean admin;

    public User(String username) {
        this.username = username;
        this.admin = false;
    }

    public String getUsername() {
        return username;
    }

    public boolean getTipoUsario() {
        return admin;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public ArrayList<User> userVerify(ArrayList<User> userList) {
        String username = this.getUsername();

        List<String> existingUsernames = userList.stream()
                .map(User::getUsername)
                .collect(Collectors.toList());

        if (!existingUsernames.contains(username)) {
            userList.add(this);
        }
        return userList;
    }

    @Override
    public String toString() {
        return "User{" +
                "'" + username + '\'' +
                ", " + admin +
                '}';
    }
}