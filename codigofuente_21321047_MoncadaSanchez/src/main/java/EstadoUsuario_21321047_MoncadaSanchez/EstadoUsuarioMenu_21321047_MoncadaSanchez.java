package EstadoUsuario_21321047_MoncadaSanchez;

public class EstadoUsuarioMenu_21321047_MoncadaSanchez implements inEstadoUsuarioMenu_21321047_MoncadaSanchez {
    /**
     * Almacena el id del chatbot actual dentro de un Sistema
     */
    private int actualChatbotCodeLink;
    /**
     * Almacena la id del Flow actual dentro de un Sistema
     */
    private int actualFlowCodeLink;

    /**
     * Constructor de EstadoUsuarioMenu
     * @param actualChatbotCodeLink (Almacena el id del Chatbot Actual)
     * @param actualFlowCodeLink (Almacena el id del Flow Actual)
     */
    public EstadoUsuarioMenu_21321047_MoncadaSanchez(int actualChatbotCodeLink, int actualFlowCodeLink) {
        this.actualChatbotCodeLink = actualChatbotCodeLink;
        this.actualFlowCodeLink = actualFlowCodeLink;
    }

    @Override
    public int getActualChatbotCodeLink() {
        return actualChatbotCodeLink;
    }

    @Override
    public int getActualFlowCodeLink() {
        return actualFlowCodeLink;
    }

    @Override
    public void setActualChatbotCodeLink(int actualChatbotCodeLink) {
        this.actualChatbotCodeLink = actualChatbotCodeLink;
    }

    @Override
    public void setActualFlowCodeLink(int actualFlowCodeLink) {
        this.actualFlowCodeLink = actualFlowCodeLink;
    }

    @Override
    public String toString() {
        return "EstadoUsuarioMenu{" +
                "actualChatbotCodeLink=" + actualChatbotCodeLink +
                ", actualFlowCodeLink=" + actualFlowCodeLink +
                '}';
    }
}