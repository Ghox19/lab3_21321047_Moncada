package lab3.Paradigmas;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Chatbot implements inChatbot{
    private int chatbotId;
    private String name;
    private String welcomeMessage;
    private int startFlowId;
    private ArrayList<Flow> flows;

    public Chatbot(int chatbotId, String name, String welcomeMessage, int startFlowId, ArrayList<Flow> flows) {
        this.chatbotId = chatbotId;
        this.name = name;
        this.welcomeMessage = welcomeMessage;
        this.startFlowId = startFlowId;
        this.flows = verifyFlows(flows);
    }

    public int getChatbotId() {
        return chatbotId;
    }

    public String getName() {
        return name;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public int getStartFlowId() {
        return startFlowId;
    }

    public ArrayList<Flow> getFlows() {
        return flows;
    }

    public void setFlows(ArrayList<Flow> flows) {
        this.flows = flows;
    }

    public ArrayList<Flow> verifyFlows(ArrayList<Flow> flows) {
        ArrayList<Flow> flowsClean = new ArrayList<>();
        for (Flow flow : flows) {
            int IdActual = flow.getFlowId();
            boolean IdExiste = false;
            for (Flow flw : flowsClean) {
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
    public void chatbotAddFlow(Flow flow){
        var code = flow.getFlowId();
        var OptionsCodes = this.getFlows().stream()
                .map(Flow::getFlowId)
                .collect(Collectors.toList());
        if (!OptionsCodes.contains(code)) {
            var Flows = this.getFlows();
            Flows.add(flow);
            this.setFlows(Flows);
        }
    }

    }