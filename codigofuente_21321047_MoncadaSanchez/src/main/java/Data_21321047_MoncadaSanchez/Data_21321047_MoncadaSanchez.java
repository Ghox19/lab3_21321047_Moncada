package Data_21321047_MoncadaSanchez;

import Chatbot_21321047_MoncadaSanchez.Chatbot_21321047_MoncadaSanchez;
import Flow_21321047_MoncadaSanchez.Flow_21321047_MoncadaSanchez;
import Option_21321047_MoncadaSanchez.Option_21321047_MoncadaSanchez;

import java.util.ArrayList;

public class Data_21321047_MoncadaSanchez implements inData_21321047_MoncadaSanchez {
    /**
     * Almacena todas las opciones creadas
     */
    private ArrayList<Option_21321047_MoncadaSanchez> opciones;

    /**
     * Almacena todos los Flows creados
     */
    private ArrayList<Flow_21321047_MoncadaSanchez> flujos;

    /**
     * Almacena todos los Chatbots Creados
     */
    private ArrayList<Chatbot_21321047_MoncadaSanchez> chatbots;

    /**
     * Permite Almacenar los Datos generados dentro de un Espacio
     */
    public Data_21321047_MoncadaSanchez() {
        this.opciones = new ArrayList<>();
        this.flujos = new ArrayList<>();
        this.chatbots = new ArrayList<>();
    }

    @Override
    public ArrayList<Option_21321047_MoncadaSanchez> getOpciones() {
        return opciones;
    }

    @Override
    public ArrayList<Flow_21321047_MoncadaSanchez> getFlujos() {
        return flujos;
    }

    @Override
    public ArrayList<Chatbot_21321047_MoncadaSanchez> getChatbots() {
        return chatbots;
    }

    @Override
    public void setOpciones(ArrayList<Option_21321047_MoncadaSanchez> opciones) {
        this.opciones = opciones;
    }

    @Override
    public void setFlujos(ArrayList<Flow_21321047_MoncadaSanchez> flujos) {
        this.flujos = flujos;
    }

    @Override
    public void setChatbots(ArrayList<Chatbot_21321047_MoncadaSanchez> chatbots) {
        this.chatbots = chatbots;
    }

    @Override
    public String toString() {
        return "Data{" +
                "opciones=" + opciones +
                ", flujos=" + flujos +
                ", chatbots=" + chatbots +
                '}';
    }
}
