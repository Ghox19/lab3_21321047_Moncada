package lab3.Paradigmas;

import java.util.List;

public class Option {
    private int code;
    private String message;
    private int chatbotCodeLink;
    private int initialFlowCodeLink;
    private List<String> keywords;

    public Option(int incode, String inmessage, int inchatbotCodeLink, int ininitialFlowCodeLink, List<String> inkeywords) {
        code = incode;
        message = inmessage;
        chatbotCodeLink = inchatbotCodeLink;
        initialFlowCodeLink = ininitialFlowCodeLink;
        this.keywords = inkeywords;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getChatbotCodeLink() {
        return chatbotCodeLink;
    }

    public int getInitialFlowCodeLink() {
        return initialFlowCodeLink;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    //public Option getOptionById(List<Option> options){}

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
