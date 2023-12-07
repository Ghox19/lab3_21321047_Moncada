package lab3.Paradigmas;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatHistory {
    String fechaDeCreacion;
    String user;
    String message;
    int chatbotId;
    int flowId;

    public ChatHistory(String user, String message, int chatbotId, int flowId) {
        this.fechaDeCreacion = generarFecha();
        this.user = user;
        this.message = message;
        this.chatbotId = chatbotId;
        this.flowId = flowId;
    }

    public String getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(String fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getChatbotId() {
        return chatbotId;
    }

    public void setChatbotId(int chatbotId) {
        this.chatbotId = chatbotId;
    }

    public int getFlowId() {
        return flowId;
    }

    public void setFlowId(int flowId) {
        this.flowId = flowId;
    }

    private String generarFecha() {
        Date fechaHoraActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy HH:mm");
        String fechaFormateada = formatoFecha.format(fechaHoraActual);

        return fechaFormateada;
    }

    public String messageFormat(Flow flow, Chatbot chatbot) {
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
