package Chatbot_21321047_MoncadaSanchez;

import Flow_21321047_MoncadaSanchez.Flow_21321047_MoncadaSanchez;

import java.util.ArrayList;

public interface inChatbot_21321047_MoncadaSanchez {

    /**
     * Getter de una Id de Chatbot
     * @return
     */
    int getId();

    /**
     * Getter de un Nombre de Chatbot
     * @return
     */
    String getName();

    /**
     * Getter de una Id del Flow inicial de un Chatbot
     * @return
     */
    int getStartFlowId();

    /**
     * Getter de los Flows de un Chatbot
     * @return
     */
    ArrayList<Flow_21321047_MoncadaSanchez> getFlows();

    /**
     * Getter de un Flow en base a una Id
     * @param flowId
     * @return
     */
    Flow_21321047_MoncadaSanchez getFlowById(int flowId);

    /**
     * Setter de una lista de Flows de un Chatbot
     * @param flows
     */
    void setFlows(ArrayList<Flow_21321047_MoncadaSanchez> flows);

    /**
     * Metodo que permite Agregar un Flow en un Chatbot
     * @param flow
     */
    void chatbotAddFlow(Flow_21321047_MoncadaSanchez flow);

    /**
     * Metodo de verifica y retorna de una Lista de Flows una limpia en base a sus Ids
     * @param flows
     * @return
     */
    ArrayList<Flow_21321047_MoncadaSanchez> verifyFlows(ArrayList<Flow_21321047_MoncadaSanchez> flows);

    /**
     * Permite Imprimir un Chatbot
     * @return
     */
    String toString();
}
