package User_21321047_MoncadaSanchez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User_21321047_MoncadaSanchez implements inUser_21321047_MoncadaSanchez {
    /**
     * Almacena el nombre del Usuario
     */
    private String username;
    /**
     * Almacena si es o no un Usuario
     */
    private boolean admin;

    /**
     * Almacena si es o no su Primera interaccion
     */
    private boolean firstInteraction;

    /**
     * Constructor de un Usuario
     * @param username (Nombre del Usuario)
     */
    public User_21321047_MoncadaSanchez(String username) {
        this.username = username;
        this.admin = false;
        this.firstInteraction = true;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public void setFirstInteraction(boolean firstInteraction){this.firstInteraction = firstInteraction;}


    @Override
    public boolean isAdmin() {
        return admin;
    }

    @Override
    public boolean isFirstInteraction(){return firstInteraction; }

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