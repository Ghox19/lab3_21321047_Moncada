package lab3.Paradigmas;

public class EstadoUsuarioMenu {
    private int actualChatbotCodeLink;
    private int actualFlowCodeLink;

    public EstadoUsuarioMenu(int actualChatbotCodeLink, int actualFlowCodeLink) {
        this.actualChatbotCodeLink = actualChatbotCodeLink;
        this.actualFlowCodeLink = actualFlowCodeLink;
    }

    public int getActualChatbotCodeLink() {
        return actualChatbotCodeLink;
    }

    public void setActualChatbotCodeLink(int actualChatbotCodeLink) {
        this.actualChatbotCodeLink = actualChatbotCodeLink;
    }

    public int getActualFlowCodeLink() {
        return actualFlowCodeLink;
    }

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