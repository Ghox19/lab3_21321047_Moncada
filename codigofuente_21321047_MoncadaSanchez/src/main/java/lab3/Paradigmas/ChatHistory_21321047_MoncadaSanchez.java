package lab3.Paradigmas;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatHistory_21321047_MoncadaSanchez implements inChatHistory_21321047_MoncadaSanchez {
    String fechaDeCreacion;
    String user;
    String message;
    int chatbotId;
    int flowId;

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
    public void setFechaDeCreacion(String fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int getChatbotId() {
        return chatbotId;
    }

    @Override
    public void setChatbotId(int chatbotId) {
        this.chatbotId = chatbotId;
    }

    @Override
    public int getFlowId() {
        return flowId;
    }

    @Override
    public void setFlowId(int flowId) {
        this.flowId = flowId;
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
