package EstadoUsuario_21321047_MoncadaSanchez;

public interface inEstadoUsuarioMenu_21321047_MoncadaSanchez {

    /**
     * Getter de la id de Chatbot Actual
     * @return
     */
    int getActualChatbotCodeLink();

    /**
     * Getter de la id de Flow Actual
     * @return
     */
    int getActualFlowCodeLink();

    /**
     * Setter de la id de Chatbot Actual
     * @return
     */
    void setActualChatbotCodeLink(int actualChatbotCodeLink);

    /**
     * Setter de la id de Flow Actual
     * @return
     */
    void setActualFlowCodeLink(int actualFlowCodeLink);

    /**
     * Permite imprimir el Estado Usuario Menu
     * @return
     */
    String toString();
}
