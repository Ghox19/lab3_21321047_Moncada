package System_21321047_MoncadaSanchez;

import Chatbot_21321047_MoncadaSanchez.Chatbot_21321047_MoncadaSanchez;
import Flow_21321047_MoncadaSanchez.Flow_21321047_MoncadaSanchez;
import Option_21321047_MoncadaSanchez.Option_21321047_MoncadaSanchez;
import ChatHistory_21321047_MoncadaSanchez.ChatHistory_21321047_MoncadaSanchez;
import EstadoUsuario_21321047_MoncadaSanchez.EstadoUsuarioMenu_21321047_MoncadaSanchez;
import User_21321047_MoncadaSanchez.User_21321047_MoncadaSanchez;

import java.util.ArrayList;

public interface inSystem_21321047_MoncadaSanchez {

    /**
     * Getter de la Lista de Usuarios
     * @return
     */
    ArrayList<User_21321047_MoncadaSanchez> getUsers();

    /**
     * Getter del usuario Loggeado en el Sistema
     * @return
     */
    String getLoggedUser();

    /**
     * Getter del Historial del Sistema
     * @return
     */
    ArrayList<ChatHistory_21321047_MoncadaSanchez> getChatHistory();

    /**
     * Getter del Objeto EstadoUsuarioMenu del Sistema
     * @return
     */
    EstadoUsuarioMenu_21321047_MoncadaSanchez getCurrentState();

    /**
     * Getter de la id inicial del Chatbot del sistema
     * @return
     */
    int getInitialChatbotCodeLink();

    /**
     * Getter de la lista de Chatbots del Sistema
     * @return
     */
    ArrayList<Chatbot_21321047_MoncadaSanchez> getChatbots();

    /**
     * Getter de un Chatbot del Sistema a base de su Id
     * @param Id
     * @return
     */
    Chatbot_21321047_MoncadaSanchez getChatbotById(int Id);

    /**
     * Getter de una Id de Flow inicial de una Lista de Chatbots
     * @param chatbots
     * @param chatbotId
     * @return
     */
    Integer getIntialFlowIdByChatbotList(ArrayList<Chatbot_21321047_MoncadaSanchez> chatbots, int chatbotId);

    /**
     * Getter de un Usuario del Sistema a base de su username
     * @param username
     * @return
     */
    User_21321047_MoncadaSanchez getUserByUsername(String username);

    /**
     * Getter de todos los Option dentro del Sistema
     * @return
     */
    ArrayList<Option_21321047_MoncadaSanchez> getOptionInSystem();

    /**
     * Getter de todos los Flows del Sistema
     * @return
     */
    ArrayList<Flow_21321047_MoncadaSanchez> getFlowInSystem();

    /**
     * Setter de la lista de usuarios del sistema
     * @param users
     */
    void setUsers(ArrayList<User_21321047_MoncadaSanchez> users);

    /**
     * Setter del objeto EstadoUsuarioMenu del Sistema
     * @param currentState
     */
    void setCurrentState(EstadoUsuarioMenu_21321047_MoncadaSanchez currentState);

    /**
     * Setter de la lista de Chatbots del Sistema
     * @param chatbots
     */
    void setChatbots(ArrayList<Chatbot_21321047_MoncadaSanchez> chatbots);

    /**
     * Setter de un Nuevo estado actual y un nuevo chatHistory
     * @param option
     * @param message
     */
    void setNewCurrentStateandChatHistory(Option_21321047_MoncadaSanchez option, String message);

    /**
     * Metodo que permite agregar un Chatbot al Sistema
     * @param chatbot
     */
    void systemAddChatbot(Chatbot_21321047_MoncadaSanchez chatbot);

    /**
     * Metodo que permite agregar un Usuario al Sistema
     * @param username
     */
    void systemAddUser(String username);

    /**
     * Metodo que permite Logear un usuario al Sistema
     * @param username
     */
    void systemLogin(String username);

    /**
     * Permite Deslogear cualquier Usuario del Sistema
     */
    void systemLogout();

    /**
     * Permite interactuar con el Sistema a base de un Mensaje
     * @param message
     */
    void systemTalk(String message);

    /**
     * Verifica y devuelve una lista de Chatbots Limpia a base de sus IDs
     * @param chatbots
     * @return
     */
    ArrayList<Chatbot_21321047_MoncadaSanchez> verifyChatbots(ArrayList<Chatbot_21321047_MoncadaSanchez> chatbots);

    /**
     * Permite generar una muestra de los mensaje enviados por el Usuario en el Sistema
     * @param username
     */
    void systemSynthesis(String username);

    /**
     * Permite simular interacciones a base de una Seed en un Sistema
     * @param maxInteractions
     * @param seed
     * @param sistema
     */
    void systemSimulate(int maxInteractions, int seed, System_21321047_MoncadaSanchez sistema);

    /**
     * Permite Imprimir un Sistema
     * @return
     */
    String toString();
}
