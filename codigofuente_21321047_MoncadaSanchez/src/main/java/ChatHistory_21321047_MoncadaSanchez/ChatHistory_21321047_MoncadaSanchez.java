package ChatHistory_21321047_MoncadaSanchez;

import Chatbot_21321047_MoncadaSanchez.Chatbot_21321047_MoncadaSanchez;
import Flow_21321047_MoncadaSanchez.Flow_21321047_MoncadaSanchez;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatHistory_21321047_MoncadaSanchez implements inChatHistory_21321047_MoncadaSanchez {
    /**
     * Almacena la fecha de creacion de un ChatHistory
     */
    String fechaDeCreacion;
    /**
     * Almacena el username hecho en una interaccion
     */
    String user;

    /**
     * Almacena el mensaje enviado en una interaccion
     */
    String message;

    /**
     * Almacena la direccion del Chatbot que dirige la opcion seleccionada en una interaccion
     */
    int chatbotId;

    /**
     * Almacena la direccion del Chatbot que dirige la opcion seleccionada en una interaccion
     */
    int flowId;

    /**
     * Constructor de un ChatHistory
     * @param user (Usuario que envio el mensaje)
     * @param message (Lo que envio el Usuario)
     * @param chatbotId (Id del estado en el que estaba el usuario)
     * @param flowId (Id del estado dentro del chatbot que estaba el usuario)
     */
    public ChatHistory_21321047_MoncadaSanchez(String user, String message, int chatbotId, int flowId) {
        this.fechaDeCreacion = generarFecha();
        this.user = user;
        this.message = message;
        this.chatbotId = chatbotId;
        this.flowId = flowId;
    }

    @Override
    public String getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public int getChatbotId() {
        return chatbotId;
    }

    @Override
    public int getFlowId() {
        return flowId;
    }

    @Override
    public String generarFecha() {
        Date fechaHoraActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy HH:mm");
        String fechaFormateada = formatoFecha.format(fechaHoraActual);

        return fechaFormateada;
    }

    @Override
    public String messageFormat(Flow_21321047_MoncadaSanchez flow, Chatbot_21321047_MoncadaSanchez chatbot) {
        var fecha = this.getFechaDeCreacion();
        var user = this.getUser();
        var message = this.getMessage();
        var chatbotName = chatbot.getName();
        var flowName = flow.getName_msg();
        var flowOptions = flow.getOptionFormated();

        return  fecha + " - " + user + ": " + message + "\n" +
                fecha + " - " + chatbotName + ": " + flowName +
                flowOptions;
    }

    /**
     * Permite imprimir un ChatHistory
     * @return
     */
    @Override
    public String toString() {
        return "ChatHistory{" +
                "'" + fechaDeCreacion + '\'' +
                ", '" + user + '\'' +
                ", '" + message + '\'' +
                ", " + chatbotId +
                ", " + flowId +
                '}';
    }
}
