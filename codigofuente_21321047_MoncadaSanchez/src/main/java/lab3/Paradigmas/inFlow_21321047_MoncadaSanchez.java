package lab3.Paradigmas;

import java.util.ArrayList;

public interface inFlow_21321047_MoncadaSanchez {

    int getFlowId();

    String getName_msg();

    ArrayList<Option_21321047_MoncadaSanchez> getOptions();

    void setOptions(ArrayList<Option_21321047_MoncadaSanchez> options);

    void flowAddOption(Option_21321047_MoncadaSanchez option);

    ArrayList<Option_21321047_MoncadaSanchez> verifyOptions(ArrayList<Option_21321047_MoncadaSanchez> options);

    Option_21321047_MoncadaSanchez getOptionById(int Id);

    Option_21321047_MoncadaSanchez getOptionByKeyword(String message);

    String getOptionFormated();

    String toString();
}