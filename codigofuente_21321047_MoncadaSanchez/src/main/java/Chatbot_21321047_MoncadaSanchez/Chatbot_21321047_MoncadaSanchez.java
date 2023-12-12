package Chatbot_21321047_MoncadaSanchez;

import Flow_21321047_MoncadaSanchez.Flow_21321047_MoncadaSanchez;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Chatbot_21321047_MoncadaSanchez implements inChatbot_21321047_MoncadaSanchez {
    /**
     * Identificador unico de Chatbot dentro de un Sistema
     */
    private int id;

    /**
     * Nombre del Chatbot
     */
    private String name;

    /**
     * Mensaje de bienvenida del Chatbot
     */
    private String welcomeMessage;

    /**
     * Id del Flow inicial dentro del Chatbot
     */
    private int startFlowId;

    /**
     * Id del
     */
    private ArrayList<Flow_21321047_MoncadaSanchez> flows;

    /**
     * Constructor de un Chatbot
     * @param chatbotId (Identificador)
     * @param name (Nombre del Chatbot)
     * @param welcomeMessage (Mensaje de entrada)
     * @param startFlowId (Id del Flow inicial)
     * @param flows (Flows dentro del System)
     */
    public Chatbot_21321047_MoncadaSanchez(int chatbotId, String name, String welcomeMessage, int startFlowId, ArrayList<Flow_21321047_MoncadaSanchez> flows) {
        this.id = chatbotId;
        this.name = name;
        this.welcomeMessage = welcomeMessage;
        this.startFlowId = startFlowId;
        this.flows = verifyFlows(flows);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
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
    public Flow_21321047_MoncadaSanchez getFlowById(int flowId){
        for (Flow_21321047_MoncadaSanchez flw : this.getFlows()) {
            if (flw.getFlowId() == flowId) {
                return flw;
            }
        }
        return null;
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

    @Override
    public String toString() {
        return "Chatbot{" + id +
                ", '" + name + '\'' +
                ", " + welcomeMessage + '\'' +
                ", " + startFlowId +
                ", " + flows +
                '}';
    }
}