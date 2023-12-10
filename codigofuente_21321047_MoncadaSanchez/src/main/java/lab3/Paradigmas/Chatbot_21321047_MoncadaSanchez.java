package lab3.Paradigmas;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Chatbot_21321047_MoncadaSanchez implements inChatbot_21321047_MoncadaSanchez {
    private int chatbotId;
    private String name;
    private String welcomeMessage;
    private int startFlowId;
    private ArrayList<Flow_21321047_MoncadaSanchez> flows;

    public Chatbot_21321047_MoncadaSanchez(int chatbotId, String name, String welcomeMessage, int startFlowId, ArrayList<Flow_21321047_MoncadaSanchez> flows) {
        this.chatbotId = chatbotId;
        this.name = name;
        this.welcomeMessage = welcomeMessage;
        this.startFlowId = startFlowId;
        this.flows = verifyFlows(flows);
    }

    @Override
    public int getChatbotId() {
        return chatbotId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    @Override
    public int getStartFlowId() {
        return startFlowId;
    }

    @Override
    public ArrayList<Flow_21321047_MoncadaSanchez> getFlows() {
        return flows;
    }

    @Override
    public void setFlows(ArrayList<Flow_21321047_MoncadaSanchez> flows) {
        this.flows = flows;
    }

    @Override
    public ArrayList<Flow_21321047_MoncadaSanchez> verifyFlows(ArrayList<Flow_21321047_MoncadaSanchez> flows) {
        ArrayList<Flow_21321047_MoncadaSanchez> flowsClean = new ArrayList<>();
        for (Flow_21321047_MoncadaSanchez flow : flows) {
            int IdActual = flow.getFlowId();
            boolean IdExiste = false;
            for (Flow_21321047_MoncadaSanchez flw : flowsClean) {
                if (flw.getFlowId() == IdActual) {
                    IdExiste = true;
                    break;
                }
            }
            if (!IdExiste) {
                flowsClean.add(flow);
            }
        }
        return flowsClean;
    }

    @Override
    public void chatbotAddFlow(Flow_21321047_MoncadaSanchez flow){
        var code = flow.getFlowId();
        var OptionsCodes = this.getFlows().stream()
                .map(Flow_21321047_MoncadaSanchez::getFlowId)
                .collect(Collectors.toList());
        if (!OptionsCodes.contains(code)) {
            var Flows = this.getFlows();
            Flows.add(flow);
            this.setFlows(Flows);
        }
    }

    public Flow_21321047_MoncadaSanchez getFlowById(int flowId){
        for (Flow_21321047_MoncadaSanchez flw : this.getFlows()) {
            if (flw.getFlowId() == flowId) {
                return flw;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Chatbot{" + chatbotId +
                ", '" + name + '\'' +
                ", " + welcomeMessage + '\'' +
                ", " + startFlowId +
                ", " + flows +
                '}';
    }
}