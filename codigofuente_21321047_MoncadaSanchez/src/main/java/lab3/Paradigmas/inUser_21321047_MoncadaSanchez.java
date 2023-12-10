package lab3.Paradigmas;

import java.util.ArrayList;

public interface inUser_21321047_MoncadaSanchez {

    String getUsername();

    boolean getTipoUsario();

    boolean isAdmin();

    void setAdmin(boolean admin);

    ArrayList<User_21321047_MoncadaSanchez> userVerify(ArrayList<User_21321047_MoncadaSanchez> userList);

    String toString();
}
