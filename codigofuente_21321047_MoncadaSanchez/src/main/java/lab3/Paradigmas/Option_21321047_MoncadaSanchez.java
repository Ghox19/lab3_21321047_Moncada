package lab3.Paradigmas;

import java.util.List;

public class Option_21321047_MoncadaSanchez implements inOption_21321047_MoncadaSanchez {
    private int code;
    private String message;
    private int chatbotCodeLink;
    private int initialFlowCodeLink;
    private List<String> keywords;

    public Option_21321047_MoncadaSanchez(int incode, String inmessage, int inchatbotCodeLink, int ininitialFlowCodeLink, List<String> inkeywords) {
        code = incode;
        message = inmessage;
        chatbotCodeLink = inchatbotCodeLink;
        initialFlowCodeLink = ininitialFlowCodeLink;
        this.keywords = inkeywords;
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
