package lab3.Paradigmas;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Sistema implements inSistema {
    private String name;
    private ArrayList<User> users;
    private String loggedUser;
    private ArrayList<ChatHistory> chatHistory;
    private EstadoUsuarioMenu currentState;
    private int initialChatbotCodeLink;
    private ArrayList<Chatbot> chatbots;

    public Sistema(String name, int initialChatbotCodeLink, ArrayList<Chatbot> chatbots) {
        this.name = name;
        this.users = new ArrayList<>();
        this.loggedUser = null;
        this.chatHistory = new ArrayList<>();
        this.currentState = new EstadoUsuarioMenu(initialChatbotCodeLink, getIntialFlowIdByChatbotList(verifyChatbots(chatbots), initialChatbotCodeLink));
        this.initialChatbotCodeLink = initialChatbotCodeLink;
        this.chatbots = verifyChatbots(chatbots);
    }

    public Integer getIntialFlowIdByChatbotList(ArrayList<Chatbot> chatbots, int chatbotId) {
        for (Chatbot chatbot : chatbots) {
            if (chatbot.getChatbotId() == chatbotId) {
                return chatbot.getStartFlowId();
            }
        }
        return null;
    }

    public ArrayList<Chatbot> verifyChatbots(ArrayList<Chatbot> chatbots) {
        ArrayList<Chatbot> chatbotsClean = new ArrayList<>();
        for (Chatbot chatbot : chatbots) {
            int IdActual = chatbot.getChatbotId();
            boolean IdExiste = false;
            for (Chatbot chb : chatbotsClean) {
                if (chb.getChatbotId() == IdActual) {
                    IdExiste = true;
                    break;
                }
            }
            if (!IdExiste) {
                chatbotsClean.add(chatbot);
            }
        }
        return chatbotsClean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public String getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(String loggedUser) {
        this.loggedUser = loggedUser;
    }

    public ArrayList<ChatHistory> getChatHistory() {
        return chatHistory;
    }

    public void setChatHistory(ArrayList<ChatHistory> chatHistory) {
        this.chatHistory = chatHistory;
    }

    public EstadoUsuarioMenu getCurrentState() {
        return currentState;
    }

    public void setCurrentState(EstadoUsuarioMenu currentState) {
        this.currentState = currentState;
    }

    public int getInitialChatbotCodeLink() {
        return initialChatbotCodeLink;
    }

    public void setInitialChatbotCodeLink(int initialChatbotCodeLink) {
        this.initialChatbotCodeLink = initialChatbotCodeLink;
    }

    public ArrayList<Chatbot> getChatbots() {
        return chatbots;
    }

    public void setChatbots(ArrayList<Chatbot> chatbots) {
        this.chatbots = chatbots; }

    @Override
    public void systemAddChatbot(Chatbot chatbot) {
        var code = chatbot.getChatbotId();
        var ChatbotCodes = this.getChatbots().stream()
                .map(Chatbot::getChatbotId)
                .collect(Collectors.toList());
        if (!ChatbotCodes.contains(code)) {
            var Chatbots = this.getChatbots();
            Chatbots.add(chatbot);
            this.setChatbots(Chatbots);
        }
    }

    @Override
    public void systemAddUser(String username) {
        var users = this.getUsers();
        User user = new User(username);
        var newUsers = user.userVerify(users);
        setUsers(newUsers);
    }

    @Override
    public void systemLogin(String username){
        List<String> existingUsernames = this.getUsers().stream()
                .map(User::getUsername)
                .collect(Collectors.toList());

        if (existingUsernames.contains(username) && this.loggedUser == null) {
            this.loggedUser = username;
        }
    }

    @Override
    public void systemLogout(){
        if (this.loggedUser != null){
            this.loggedUser = null;
            this.getCurrentState().setActualChatbotCodeLink(this.getInitialChatbotCodeLink());
            this.getCurrentState().setActualFlowCodeLink(this.getIntialFlowIdByChatbotList(this.getChatbots(), this.getInitialChatbotCodeLink()));
        }
    }

    @Override
    public void systemTalk(String message){
        if (this.loggedUser != null){
            boolean ChangeStatus = false;
            var chatbot = this.getChatbotById(this.getCurrentState().getActualChatbotCodeLink());
            if (chatbot != null){
                var flow = chatbot.getFlowById(this.getCurrentState().getActualFlowCodeLink());
                if (flow != null){
                    if (Commons.esNumero(message)) {
                        var option = flow.getOptionById(Integer.parseInt(message));
                        if (option != null){
                            this.setNewCurrentStateandChatHistory(option, message);
                            ChangeStatus = true;
                        }
                    }else{
                        var option = flow.getOptionByKeyword(message);
                        if (option != null){
                            this.setNewCurrentStateandChatHistory(option, message);
                            ChangeStatus = true;
                        }
                    }
                }
            }
            if (!ChangeStatus){
                var messageChatHistory = new ChatHistory(this.loggedUser, message, this.getCurrentState().getActualChatbotCodeLink(), this.getCurrentState().getActualFlowCodeLink());
                this.getChatHistory().add(messageChatHistory);
            }
        }
    }
}