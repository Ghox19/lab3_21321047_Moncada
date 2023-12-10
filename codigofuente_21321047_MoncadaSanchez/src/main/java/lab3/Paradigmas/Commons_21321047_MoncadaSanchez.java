package lab3.Paradigmas;

import java.util.ArrayList;

public class Commons_21321047_MoncadaSanchez implements inCommons_21321047_MoncadaSanchez{
    public boolean esNumero(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public String messageIntroFormat(Flow_21321047_MoncadaSanchez flow, Chatbot_21321047_MoncadaSanchez chatbot) {
        var chatbotName = chatbot.getName();
        var flowName = flow.getName_msg();
        var flowOptions = flow.getOptionFormated();

        return  chatbotName + ": " + flowName +
                flowOptions;
    }

    public <T> T obtenerElementoPorIndice(ArrayList<T> lista, int indice) {
        if (indice > 0 && indice < lista.size() + 1) {
            return lista.get(indice - 1);
        } else {
            throw new IndexOutOfBoundsException("El índice está fuera de los límites de la lista.");
        }
    }


}