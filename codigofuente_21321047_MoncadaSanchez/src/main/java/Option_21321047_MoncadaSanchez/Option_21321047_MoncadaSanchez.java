package Option_21321047_MoncadaSanchez;

import java.util.List;

public class Option_21321047_MoncadaSanchez implements inOption_21321047_MoncadaSanchez {
    /**
     * Identificador unico dentro de un Flow
     */
    private int code;
    /**
     * Almacen el mensaje que muestra la opcion
     */
    private String message;
    /**
     * Almacena la direccion de Chatbot al que dirije la opcion
     */
    private int chatbotCodeLink;

    /**
     * Almacena la direccion de Flow al que dirije la opcion
     */
    private int initialFlowCodeLink;

    /**
     * Almacena las palabras que reconoce la Opcion
     */
    private List<String> keywords;

    /**
     * Constructor de una Opcion
     * @param code (Codigo Identificador)
     * @param message (Mensaje de la Opcion)
     * @param chatbotCodeLink (Id del chatbot en el que apunta la opcion)
     * @param initialFlowCodeLink (Id del flow en el que apunta la opcion)
     * @param keywords (Palabras clave de la Opcion)
     */
    public Option_21321047_MoncadaSanchez(int code, String message, int chatbotCodeLink, int initialFlowCodeLink, List<String> keywords) {
        this.code = code;
        this.message = message;
        this.chatbotCodeLink = chatbotCodeLink;
        this.initialFlowCodeLink = initialFlowCodeLink;
        this.keywords = keywords;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public int getChatbotCodeLink() {
        return chatbotCodeLink;
    }

    @Override
    public int getInitialFlowCodeLink() {
        return initialFlowCodeLink;
    }

    @Override
    public List<String> getKeywords() {
        return keywords;
    }

    @Override
    public String toString() {
        return "Option{" + code +
                ", '" + message + '\'' +
                ", " + chatbotCodeLink +
                ", " + initialFlowCodeLink +
                ", " + keywords +
                '}';
    }
}
