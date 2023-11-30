package lab3.Paradigmas;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Flow implements inFlow{
    private int id;
    private String name_msg;
    private ArrayList<Option> options;

    public Flow(int id, String name_msg, ArrayList<Option> options) {
        this.id = id;
        this.name_msg = name_msg;
        this.options = verifyOptions(options);
    }

    public int getFlowId() {
        return id;
    }

    public String getName_msg() {
        return name_msg;
    }

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }

    public ArrayList<Option> verifyOptions(ArrayList<Option> options) {
        ArrayList<Option> OpcionesClean = new ArrayList<>();
        for (Option option : options) {
            int IdActual = option.getCode();
            boolean IdExiste = false;
            for (Option opt : OpcionesClean) {
                if (opt.getCode() == IdActual) {
                    IdExiste = true;
                    break;
                }
            }
            if (!IdExiste) {
                OpcionesClean.add(option);
            }
        }
        return OpcionesClean;
    }

    @Override
    public void flowAddOption(Option option){
        var code = option.getCode();
        var OptionsCodes = this.getOptions().stream()
                .map(Option::getCode)
                .collect(Collectors.toList());
        if (!OptionsCodes.contains(code)) {
            var Options = this.getOptions();
            Options.add(option);
            this.setOptions(Options);
        }
    }
}
