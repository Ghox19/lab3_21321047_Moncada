package Option_21321047_MoncadaSanchez;

import java.util.List;

public interface inOption_21321047_MoncadaSanchez{

    /**
     * Getter del code de una Opcion
     * @return
     */
    int getCode();

    /**
     * Getter del mensaje de una Opcion
     * @return
     */
    String getMessage();

    /**
     * Getter de la id de chatbot de una Opcion
     * @return
     */
    int getChatbotCodeLink();

    /**
     * Getter de la id de Flow de una Opcion
     * @return
     */
    int getInitialFlowCodeLink();

    /**
     * Getter de las palabras clave de una Opcion
     * @return
     */
    List<String> getKeywords();

    /**
     * Permite imprimir una Opcion
     * @return
     */
    String toString();
}
