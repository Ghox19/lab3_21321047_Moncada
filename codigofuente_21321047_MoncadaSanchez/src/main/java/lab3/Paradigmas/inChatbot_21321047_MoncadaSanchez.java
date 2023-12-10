package lab3.Paradigmas;

import java.util.ArrayList;

public interface inChatbot_21321047_MoncadaSanchez {

    int getChatbotId();

    String getName();

    String getWelcomeMessage();

    int getStartFlowId();

    ArrayList<Flow_21321047_MoncadaSanchez> getFlows();

    void setFlows(ArrayList<Flow_21321047_MoncadaSanchez> flows);

    void chatbotAddFlow(Flow_21321047_MoncadaSanchez flow);

    ArrayList<Flow_21321047_MoncadaSanchez> verifyFlows(ArrayList<Flow_21321047_MoncadaSanchez> flows);

    String toString();
}
