package lab3.Paradigmas;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class System_21321047_MoncadaSanchez implements inSystem_21321047_MoncadaSanchez {
    private String name;
    private ArrayList<User_21321047_MoncadaSanchez> users;
    private String loggedUser;
    private ArrayList<ChatHistory_21321047_MoncadaSanchez> chatHistory;
    private EstadoUsuarioMenu_21321047_MoncadaSanchez currentState;
    private int initialChatbotCodeLink;
    private ArrayList<Chatbot_21321047_MoncadaSanchez> chatbots;

    public System_21321047_MoncadaSanchez(String name, int initialChatbotCodeLink, ArrayList<Chatbot_21321047_MoncadaSanchez> chatbots) {
        this.name = name;
        this.users = new ArrayList<>();
        this.loggedUser = null;
        this.chatHistory = new ArrayList<>();
        this.currentState = new EstadoUsuarioMenu_21321047_MoncadaSanchez(initialChatbotCodeLink, getIntialFlowIdByChatbotList(verifyChatbots(chatbots), initialChatbotCodeLink));
        this.initialChatbotCodeLink = initialChatbotCodeLink;
        this.chatbots = verifyChatbots(chatbots);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public ArrayList<User_21321047_MoncadaSanchez> getUsers() {
        return users;
    }

    @Override
    public void setUsers(ArrayList<User_21321047_MoncadaSanchez> users) {
        this.users = users;
    }

    @Override
    public String getLoggedUser() {
        return loggedUser;
    }

    @Override
    public void setLoggedUser(String loggedUser) {
        this.loggedUser = loggedUser;
    }

    @Override
    public ArrayList<ChatHistory_21321047_MoncadaSanchez> getChatHistory() {
        return chatHistory;
    }

    @Override
    public void setChatHistory(ArrayList<ChatHistory_21321047_MoncadaSanchez> chatHistory) {
        this.chatHistory = chatHistory;
    }

    @Override
    public EstadoUsuarioMenu_21321047_MoncadaSanchez getCurrentState() {
        return currentState;
    }

    @Override
    public void setCurrentState(EstadoUsuarioMenu_21321047_MoncadaSanchez currentState) {
        this.currentState = currentState;
    }

    @Override
    public int getInitialChatbotCodeLink() {
        return initialChatbotCodeLink;
    }

    @Override
    public void setInitialChatbotCodeLink(int initialChatbotCodeLink) {
        this.initialChatbotCodeLink = initialChatbotCodeLink;
    }

    @Override
    public ArrayList<Chatbot_21321047_MoncadaSanchez> getChatbots() {
        return chatbots;
    }

    @Override
    public void setChatbots(ArrayList<Chatbot_21321047_MoncadaSanchez> chatbots) {
        this.chatbots = chatbots;
    }

    @Override
    public void systemAddChatbot(Chatbot_21321047_MoncadaSanchez chatbot) {
        var code = chatbot.getChatbotId();
        var ChatbotCodes = this.getChatbots().stream()
                .map(Chatbot_21321047_MoncadaSanchez::getChatbotId)
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
        User_21321047_MoncadaSanchez user = new User_21321047_MoncadaSanchez(username);
        var newUsers = user.userVerify(users);
        setUsers(newUsers);
    }

    @Override
    public void systemLogin(String username) {
        List<String> existingUsernames = this.getUsers().stream()
                .map(User_21321047_MoncadaSanchez::getUsername)
                .collect(Collectors.toList());

        if (existingUsernames.contains(username) && this.loggedUser == null) {
            this.loggedUser = username;
        }
    }

    @Override
    public void systemLogout() {
        if (this.loggedUser != null) {
            this.loggedUser = null;
            this.getCurrentState().setActualChatbotCodeLink(this.getInitialChatbotCodeLink());
            this.getCurrentState().setActualFlowCodeLink(this.getIntialFlowIdByChatbotList(this.getChatbots(), this.getInitialChatbotCodeLink()));
        }
    }

    @Override
    public void systemTalk(String message) {
        if (this.loggedUser != null) {
            boolean ChangeStatus = false;
            var chatbot = this.getChatbotById(this.getCurrentState().getActualChatbotCodeLink());
            if (chatbot != null) {
                var flow = chatbot.getFlowById(this.getCurrentState().getActualFlowCodeLink());
                if (flow != null) {
                    Commons_21321047_MoncadaSanchez funcion = new Commons_21321047_MoncadaSanchez();
                    if (funcion.esNumero(message)) {
                        var option = flow.getOptionById(Integer.parseInt(message));
                        if (option != null) {
                            this.setNewCurrentStateandChatHistory(option, message);
                            ChangeStatus = true;
                        }
                    } else {
                        var option = flow.getOptionByKeyword(message);
                        if (option != null) {
                            this.setNewCurrentStateandChatHistory(option, message);
                            ChangeStatus = true;
                        }
                    }
                }
            }
            if (!ChangeStatus) {
                var messageChatHistory = new ChatHistory_21321047_MoncadaSanchez(this.loggedUser, message, this.getCurrentState().getActualChatbotCodeLink(), this.getCurrentState().getActualFlowCodeLink());
                this.getChatHistory().add(messageChatHistory);
            }
        }
    }

    @Override
    public Integer getIntialFlowIdByChatbotList(ArrayList<Chatbot_21321047_MoncadaSanchez> chatbots, int chatbotId) {
        for (Chatbot_21321047_MoncadaSanchez chatbot : chatbots) {
            if (chatbot.getChatbotId() == chatbotId) {
                return chatbot.getStartFlowId();
            }
        }
        return null;
    }

    @Override
    public ArrayList<Chatbot_21321047_MoncadaSanchez> verifyChatbots(ArrayList<Chatbot_21321047_MoncadaSanchez> chatbots) {
        ArrayList<Chatbot_21321047_MoncadaSanchez> chatbotsClean = new ArrayList<>();
        for (Chatbot_21321047_MoncadaSanchez chatbot : chatbots) {
            int IdActual = chatbot.getChatbotId();
            boolean IdExiste = false;
            for (Chatbot_21321047_MoncadaSanchez chb : chatbotsClean) {
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

    @Override
    public Chatbot_21321047_MoncadaSanchez getChatbotById(int Id){
        for (Chatbot_21321047_MoncadaSanchez chb : this.getChatbots()) {
            if (chb.getChatbotId() == Id) {
                return chb;
            }
        }
        return null;
    }

    @Override
    public void setNewCurrentStateandChatHistory(Option_21321047_MoncadaSanchez option, String message){
        this.getCurrentState().setActualChatbotCodeLink(option.getChatbotCodeLink());
        this.getCurrentState().setActualFlowCodeLink(option.getInitialFlowCodeLink());
        var messageChatHistory = new ChatHistory_21321047_MoncadaSanchez(this.loggedUser, message, option.getChatbotCodeLink(), option.getInitialFlowCodeLink());
        this.getChatHistory().add(messageChatHistory);
    }

    @Override
    public User_21321047_MoncadaSanchez getUserByUsername(String username){
        for (User_21321047_MoncadaSanchez usr : this.getUsers()){
            if (Objects.equals(username, usr.getUsername())){
                return usr;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Option_21321047_MoncadaSanchez> getOptionInSystem(){
        var options = new ArrayList<Option_21321047_MoncadaSanchez>();
        for (Chatbot_21321047_MoncadaSanchez chb : this.getChatbots()){
            for (Flow_21321047_MoncadaSanchez flw : chb.getFlows()){
                options.addAll(flw.getOptions());
            }
        }
        return options;
    }

    @Override
    public ArrayList<Flow_21321047_MoncadaSanchez> getFlowInSystem(){
        var flows = new ArrayList<Flow_21321047_MoncadaSanchez>();
        for (Chatbot_21321047_MoncadaSanchez chb : this.getChatbots()){
            flows.addAll(chb.getFlows());
        }
        return flows;
    }

    @Override
    public String toString() {
        return "Sistema{" +
                "name='" + name + '\'' +
                ", users=" + users +
                ", loggedUser='" + loggedUser + '\'' +
                ", chatHistory=" + chatHistory +
                ", currentState=" + currentState +
                ", initialChatbotCodeLink=" + initialChatbotCodeLink +
                ", chatbots=" + chatbots +
                '}';
    }
}