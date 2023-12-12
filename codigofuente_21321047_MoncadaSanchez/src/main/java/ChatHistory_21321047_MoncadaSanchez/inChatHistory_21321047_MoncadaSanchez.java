package ChatHistory_21321047_MoncadaSanchez;

import Chatbot_21321047_MoncadaSanchez.Chatbot_21321047_MoncadaSanchez;
import Flow_21321047_MoncadaSanchez.Flow_21321047_MoncadaSanchez;

public interface inChatHistory_21321047_MoncadaSanchez {

    /**
     * Getter de la fecha de creacion de un ChatHistory
     * @return
     */
    String getFechaDeCreacion();

    /**
     * Getter del usuario de un ChatHistory
     * @return
     */
    String getUser();

    /**
     * Getter de un mensaje en un ChatHistory
     * @return
     */
    String getMessage();

    /**
     * Getter de una Id de un Chatbot de un ChatHistory
     * @return
     */
    int getChatbotId();

    /**
     * Getter de la Id del Flow dentro del Chatbot de un ChatHistory
     * @return
     */
    int getFlowId();

    /**
     * Metodo que Genera y Formatea la Fecha actual de modo a String
     * @return
     */
    String generarFecha();

    /**
     * Metodo que Genera y Formatea la Fecha actual de modo a String
     * @return
     */
    String messageFormat(Flow_21321047_MoncadaSanchez flow, Chatbot_21321047_MoncadaSanchez chatbot);

    /**
     * Metodo que permite generar un formato de String de los atriutos de un ChatHistory
     * @param flow
     * @param chatbot
     * @return
     */
    String toString();
}
