package Commons_21321047_MoncadaSanchez;

import Chatbot_21321047_MoncadaSanchez.Chatbot_21321047_MoncadaSanchez;
import Flow_21321047_MoncadaSanchez.Flow_21321047_MoncadaSanchez;

import java.util.ArrayList;

public interface inCommons_21321047_MoncadaSanchez {

    /**
     * Metodo que permite verificar si es un numero o no un String
     * @param str
     * @return
     */
    boolean esNumero(String str);

    /**
     * Permite Formatear un Chatbot y Flow para Mostrarlo en Pantalla
     * @param flow
     * @param chatbot
     * @return
     */
    String messageIntroFormat(Flow_21321047_MoncadaSanchez flow, Chatbot_21321047_MoncadaSanchez chatbot);

    /**
     * Permite obtener de una lista de Objetos T el objeto del Indice ingresado
     * @param lista
     * @param indice
     * @return
     * @param <T>
     */
    <T> T obtenerElementoPorIndice(ArrayList<T> lista, int indice);

}
