package lab3.Paradigmas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User_21321047_MoncadaSanchez implements inUser_21321047_MoncadaSanchez{
    private String username;
    private boolean admin;

    public User_21321047_MoncadaSanchez(String username) {
        this.username = username;
        this.admin = false;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean getTipoUsario() {
        return admin;
    }

    @Override
    public boolean isAdmin() {
        return admin;
    }

    @Override
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public ArrayList<User_21321047_MoncadaSanchez> userVerify(ArrayList<User_21321047_MoncadaSanchez> userList) {
        String username = this.getUsername();

        List<String> existingUsernames = userList.stream()
                .map(User_21321047_MoncadaSanchez::getUsername)
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