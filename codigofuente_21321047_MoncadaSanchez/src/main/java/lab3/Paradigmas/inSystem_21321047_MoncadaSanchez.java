package lab3.Paradigmas;

import java.util.ArrayList;

public interface inSystem_21321047_MoncadaSanchez {

    String getName();

    void setName(String name);

    ArrayList<User_21321047_MoncadaSanchez> getUsers();

    void setUsers(ArrayList<User_21321047_MoncadaSanchez> users);

    String getLoggedUser();

    void setLoggedUser(String loggedUser);

    ArrayList<ChatHistory_21321047_MoncadaSanchez> getChatHistory();

    void setChatHistory(ArrayList<ChatHistory_21321047_MoncadaSanchez> chatHistory);

    EstadoUsuarioMenu_21321047_MoncadaSanchez getCurrentState();

    void setCurrentState(EstadoUsuarioMenu_21321047_MoncadaSanchez currentState);

    int getInitialChatbotCodeLink();

    void setInitialChatbotCodeLink(int initialChatbotCodeLink);

    ArrayList<Chatbot_21321047_MoncadaSanchez> getChatbots();

    Integer getIntialFlowIdByChatbotList(ArrayList<Chatbot_21321047_MoncadaSanchez> chatbots, int chatbotId);

    void setChatbots(ArrayList<Chatbot_21321047_MoncadaSanchez> chatbots);

    void systemAddChatbot(Chatbot_21321047_MoncadaSanchez chatbot);

    void systemAddUser(String username);

    void systemLogin(String username);

    void systemLogout();

    void systemTalk(String message);

    ArrayList<Chatbot_21321047_MoncadaSanchez> verifyChatbots(ArrayList<Chatbot_21321047_MoncadaSanchez> chatbots);

    Chatbot_21321047_MoncadaSanchez getChatbotById(int Id);

    void setNewCurrentStateandChatHistory(Option_21321047_MoncadaSanchez option, String message);

    User_21321047_MoncadaSanchez getUserByUsername(String username);

    ArrayList<Option_21321047_MoncadaSanchez> getOptionInSystem();

    ArrayList<Flow_21321047_MoncadaSanchez> getFlowInSystem();

    String toString();
}
