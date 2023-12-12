package System_21321047_MoncadaSanchez;
import ChatHistory_21321047_MoncadaSanchez.ChatHistory_21321047_MoncadaSanchez;
import Chatbot_21321047_MoncadaSanchez.Chatbot_21321047_MoncadaSanchez;
import Commons_21321047_MoncadaSanchez.Commons_21321047_MoncadaSanchez;
import EstadoUsuario_21321047_MoncadaSanchez.EstadoUsuarioMenu_21321047_MoncadaSanchez;
import Flow_21321047_MoncadaSanchez.Flow_21321047_MoncadaSanchez;
import Option_21321047_MoncadaSanchez.Option_21321047_MoncadaSanchez;
import User_21321047_MoncadaSanchez.User_21321047_MoncadaSanchez;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

public class System_21321047_MoncadaSanchez implements inSystem_21321047_MoncadaSanchez {
    /**
     * Almacena el nombre del Sistema
     */
    private String name;
    /**
     * Almacena la lista de Usuarios dentro del Sistema
     */
    private ArrayList<User_21321047_MoncadaSanchez> users;
    /**
     * Almacena el username del usuario Loggeado
     */
    private String loggedUser;
    /**
     * Almacena el Historial de interaccion del Sistema
     */
    private ArrayList<ChatHistory_21321047_MoncadaSanchez> chatHistory;

    /**
     * Almacena el estado del usuario que esta en el Sistema
     */
    private EstadoUsuarioMenu_21321047_MoncadaSanchez currentState;
    /**
     * Almacena la id del chatbot inicial dentro del Sistema
     */
    private int initialChatbotCodeLink;
    /**
     * Almacena los chatbots dentro del sistema
     */
    private ArrayList<Chatbot_21321047_MoncadaSanchez> chatbots;

    /**
     * Constructor System
     * @param name (Nombre del Sistema)
     * @param initialChatbotCodeLink (Id del Chatbot inicial del Sistema)
     * @param chatbots (Chatbots almacenados en el Sistema)
     */
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
    public ArrayList<User_21321047_MoncadaSanchez> getUsers() {
        return users;
    }

    @Override
    public String getLoggedUser() {
        return loggedUser;
    }

    @Override
    public ArrayList<ChatHistory_21321047_MoncadaSanchez> getChatHistory() {
        return chatHistory;
    }

    @Override
    public EstadoUsuarioMenu_21321047_MoncadaSanchez getCurrentState() {
        return currentState;
    }

    @Override
    public int getInitialChatbotCodeLink() {
        return initialChatbotCodeLink;
    }

    @Override
    public ArrayList<Chatbot_21321047_MoncadaSanchez> getChatbots() {
        return chatbots;
    }

    @Override
    public Integer getIntialFlowIdByChatbotList(ArrayList<Chatbot_21321047_MoncadaSanchez> chatbots, int chatbotId) {
        for (Chatbot_21321047_MoncadaSanchez chatbot : chatbots) {
            if (chatbot.getId() == chatbotId) {
                return chatbot.getStartFlowId();
            }
        }
        return 0;
    }

    @Override
    public Chatbot_21321047_MoncadaSanchez getChatbotById(int Id) {
        for (Chatbot_21321047_MoncadaSanchez chb : this.getChatbots()) {
            if (chb.getId() == Id) {
                return chb;
            }
        }
        return null;
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
    public void setUsers(ArrayList<User_21321047_MoncadaSanchez> users) {
        this.users = users;
    }

    @Override
    public void setCurrentState(EstadoUsuarioMenu_21321047_MoncadaSanchez currentState) {
        this.currentState = currentState;
    }

    @Override
    public void setChatbots(ArrayList<Chatbot_21321047_MoncadaSanchez> chatbots) {
        this.chatbots = chatbots;
    }

    @Override
    public void setNewCurrentStateandChatHistory(Option_21321047_MoncadaSanchez option, String message){
        this.getCurrentState().setActualChatbotCodeLink(option.getChatbotCodeLink());
        this.getCurrentState().setActualFlowCodeLink(option.getInitialFlowCodeLink());
        var messageChatHistory = new ChatHistory_21321047_MoncadaSanchez(this.loggedUser, message, option.getChatbotCodeLink(), option.getInitialFlowCodeLink());
        this.getChatHistory().add(messageChatHistory);
    }

    @Override
    public void systemAddChatbot(Chatbot_21321047_MoncadaSanchez chatbot) {
        var code = chatbot.getId();
        var ChatbotCodes = this.getChatbots().stream()
                .map(Chatbot_21321047_MoncadaSanchez::getId)
                .collect(Collectors.toList());
        if (!ChatbotCodes.contains(code)) {
            if (chatbot.getId() == this.getInitialChatbotCodeLink()){
                this.getCurrentState().setActualFlowCodeLink(chatbot.getStartFlowId());
            }
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
            boolean changeStatus = false;
            var chatbot = this.getChatbotById(this.getCurrentState().getActualChatbotCodeLink());
            if (chatbot != null) {
                var flow = chatbot.getFlowById(this.getCurrentState().getActualFlowCodeLink());
                if (flow != null) {
                    Commons_21321047_MoncadaSanchez funcion = new Commons_21321047_MoncadaSanchez();
                    if (funcion.esNumero(message)) {
                        var option = flow.getOptionById(Integer.parseInt(message));
                        if (option != null) {
                            this.setNewCurrentStateandChatHistory(option, message);
                            changeStatus = true;
                        }
                    } else {
                        var option = flow.getOptionByKeyword(message);
                        if (option != null) {
                            this.setNewCurrentStateandChatHistory(option, message);
                            changeStatus = true;
                        }
                    }
                }
            }
            if (!changeStatus) {
                var messageChatHistory = new ChatHistory_21321047_MoncadaSanchez(this.loggedUser, message, this.getCurrentState().getActualChatbotCodeLink(), this.getCurrentState().getActualFlowCodeLink());
                this.getChatHistory().add(messageChatHistory);
            }
        }
    }

    @Override
    public void systemSynthesis(String username){
        for (ChatHistory_21321047_MoncadaSanchez chtH : this.getChatHistory()){
            if (Objects.equals(chtH.getUser(), username)){
                var chatbot = this.getChatbotById(chtH.getChatbotId());
                if (chatbot != null){
                    var flow = chatbot.getFlowById(chtH.getFlowId());
                    if (flow != null) {
                        System.out.println("\n" + chtH.messageFormat(flow, chatbot));
                    }
                }
            }
        }
    }

    @Override
    public void systemSimulate(int maxInteractions, int seed, System_21321047_MoncadaSanchez sistema){
        Random random = new Random(seed);
        var initialState = this.getCurrentState();
        var newSeed = random.nextInt();
        var eleccion = String.valueOf(newSeed % 10);
        sistema.systemTalk(eleccion);
        maxInteractions -= 1;
        while (true){
            if (maxInteractions == 0){
                break;
            }
            else if (initialState == sistema.getCurrentState()){
                break;
            }
            else{
                newSeed = random.nextInt();
                eleccion = String.valueOf(newSeed % 10);
                sistema.systemTalk(eleccion);
                maxInteractions -= 1;
            }
        }
        sistema.setCurrentState(initialState);
    }


    @Override
    public ArrayList<Chatbot_21321047_MoncadaSanchez> verifyChatbots(ArrayList<Chatbot_21321047_MoncadaSanchez> chatbots) {
        ArrayList<Chatbot_21321047_MoncadaSanchez> chatbotsClean = new ArrayList<>();
        for (Chatbot_21321047_MoncadaSanchez chatbot : chatbots) {
            int IdActual = chatbot.getId();
            boolean IdExiste = false;
            for (Chatbot_21321047_MoncadaSanchez chb : chatbotsClean) {
                if (chb.getId() == IdActual) {
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