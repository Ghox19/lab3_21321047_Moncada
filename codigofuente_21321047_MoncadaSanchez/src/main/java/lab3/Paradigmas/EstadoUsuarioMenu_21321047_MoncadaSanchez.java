package lab3.Paradigmas;

public class EstadoUsuarioMenu_21321047_MoncadaSanchez implements inEstadoUsuarioMenu_21321047_MoncadaSanchez {
    private int actualChatbotCodeLink;
    private int actualFlowCodeLink;

    public EstadoUsuarioMenu_21321047_MoncadaSanchez(int actualChatbotCodeLink, int actualFlowCodeLink) {
        this.actualChatbotCodeLink = actualChatbotCodeLink;
        this.actualFlowCodeLink = actualFlowCodeLink;
    }

    @Override
    public int getActualChatbotCodeLink() {
        return actualChatbotCodeLink;
    }

    @Override
    public void setActualChatbotCodeLink(int actualChatbotCodeLink) {
        this.actualChatbotCodeLink = actualChatbotCodeLink;
    }

    @Override
    public int getActualFlowCodeLink() {
        return actualFlowCodeLink;
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