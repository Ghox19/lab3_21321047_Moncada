package lab3.Paradigmas;

import java.util.ArrayList;

public interface inChatHistory_21321047_MoncadaSanchez {

    String getFechaDeCreacion();

    void setFechaDeCreacion(String fechaDeCreacion);

    String getUser();

    void setUser(String user);

    String getMessage();

    void setMessage(String message);

    int getChatbotId();

    void setChatbotId(int chatbotId);

    int getFlowId();

    void setFlowId(int flowId);

    String generarFecha();

    String messageFormat(Flow_21321047_MoncadaSanchez flow, Chatbot_21321047_MoncadaSanchez chatbot);

    String toString();
}
