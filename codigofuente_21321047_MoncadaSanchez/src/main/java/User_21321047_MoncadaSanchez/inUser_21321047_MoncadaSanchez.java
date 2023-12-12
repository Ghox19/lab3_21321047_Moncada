package User_21321047_MoncadaSanchez;

import User_21321047_MoncadaSanchez.User_21321047_MoncadaSanchez;

import java.util.ArrayList;

public interface inUser_21321047_MoncadaSanchez {

    /**
     * Getter del Nombre de un Usuario
     * @return
     */
    String getUsername();

    /**
     * Setter de FirstInteraction de un User
     * @param firstInteraction
     */
    void setFirstInteraction(boolean firstInteraction);

    /**
     * Setter de un Administrador
     * @param admin
     */
    void setAdmin(boolean admin);
    /**
     * Consulta de si este Usuario es Administrador
     * @return
     */
    boolean isAdmin();

    /**
     * Consulta si es la primera interaccion del Usuario
     * @return
     */
    boolean isFirstInteraction();

    /**
     * Metodo que verifica de una Lista de Usuario si este lo contiene
     * @param userList
     * @return
     */
    ArrayList<User_21321047_MoncadaSanchez> userVerify(ArrayList<User_21321047_MoncadaSanchez> userList);

    /**
     * Permite imprimir a un Usuario
     * @return
     */
    String toString();
}
