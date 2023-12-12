package Data_21321047_MoncadaSanchez;

import Chatbot_21321047_MoncadaSanchez.Chatbot_21321047_MoncadaSanchez;
import Flow_21321047_MoncadaSanchez.Flow_21321047_MoncadaSanchez;
import Option_21321047_MoncadaSanchez.Option_21321047_MoncadaSanchez;

import java.util.ArrayList;

public interface inData_21321047_MoncadaSanchez {

    /**
     * Getter de la Lista de Opciones de la Data
     *
     * @return
     */
    ArrayList<Option_21321047_MoncadaSanchez> getOpciones();

    /**
     * Getter de la Lista de Flujos de la Data
     *
     * @return
     */
    ArrayList<Flow_21321047_MoncadaSanchez> getFlujos();

    /**
     * Getter de la Lista de Chatbots de la Data
     *
     * @return
     */
    ArrayList<Chatbot_21321047_MoncadaSanchez> getChatbots();

    /**
     * Setter de la lista de Opciones de la Data
     *
     * @param flujos
     */
    void setFlujos(ArrayList<Flow_21321047_MoncadaSanchez> flujos);

    /**
     * Setter de la lista de Opciones de la Data
     *
     * @param opciones
     */
    void setOpciones(ArrayList<Option_21321047_MoncadaSanchez> opciones);

    /**
     * Setter de la Lista de Chatbots de la Data
     *
     * @param chatbots
     */
    void setChatbots(ArrayList<Chatbot_21321047_MoncadaSanchez> chatbots);

    /**
     * Permite imprimir la Data
     * @return
     */
    String toString();
}
