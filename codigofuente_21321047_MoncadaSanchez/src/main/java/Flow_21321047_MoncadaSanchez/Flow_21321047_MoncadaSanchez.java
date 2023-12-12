package Flow_21321047_MoncadaSanchez;

import Option_21321047_MoncadaSanchez.Option_21321047_MoncadaSanchez;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Flow_21321047_MoncadaSanchez implements inFlow_21321047_MoncadaSanchez {
    /**
     * Almacena la id unica dentro de un Chatbot
     */
    private int id;
    /**
     * Almacena el nombre del Flujo y el mensaje que muestra
     */
    private String name_msg;
    /**
     * Almacena todas las opciones dentro de un Flow
     */
    private ArrayList<Option_21321047_MoncadaSanchez> options;

    /**
     * Constructor de un Flow
     * @param id (Identificador)
     * @param name_msg (Nombre de flow y el mensaje que obtiene)
     * @param options (Opciones dentro del Flow)
     */
    public Flow_21321047_MoncadaSanchez(int id, String name_msg, ArrayList<Option_21321047_MoncadaSanchez> options) {
        this.id = id;
        this.name_msg = name_msg;
        this.options = verifyOptions(options);
    }

    @Override
    public int getFlowId() {
        return id;
    }

    @Override
    public String getName_msg() {
        return name_msg;
    }

    @Override
    public ArrayList<Option_21321047_MoncadaSanchez> getOptions() {
        return options;
    }

    @Override
    public Option_21321047_MoncadaSanchez getOptionById(int Id){
        for (Option_21321047_MoncadaSanchez opt : this.getOptions()) {
            if (Id == opt.getCode()) {
                return opt;
            }
        }
        return null;
    }

    @Override
    public Option_21321047_MoncadaSanchez getOptionByKeyword(String message){
        for (Option_21321047_MoncadaSanchez opt : this.getOptions()) {

            if (opt.getKeywords().contains(message)) {
                return opt;
            }
        }
        return null;
    }

    @Override
    public String getOptionFormated(){
        String formattedMessage = "";
        for (Option_21321047_MoncadaSanchez opt : this.getOptions()){
            formattedMessage += "\n" + opt.getMessage();
        }
        return formattedMessage;
    }

    @Override
    public void setOptions(ArrayList<Option_21321047_MoncadaSanchez> options) {
        this.options = options;
    }

    @Override
    public ArrayList<Option_21321047_MoncadaSanchez> verifyOptions(ArrayList<Option_21321047_MoncadaSanchez> options) {
        ArrayList<Option_21321047_MoncadaSanchez> OpcionesClean = new ArrayList<>();
        for (Option_21321047_MoncadaSanchez option : options) {
            int IdActual = option.getCode();
            boolean IdExiste = false;
            for (Option_21321047_MoncadaSanchez opt : OpcionesClean) {
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
    public void flowAddOption(Option_21321047_MoncadaSanchez option){
        var code = option.getCode();
        var OptionsCodes = this.getOptions().stream()
                .map(Option_21321047_MoncadaSanchez::getCode)
                .collect(Collectors.toList());
        if (!OptionsCodes.contains(code)) {
            var Options = this.getOptions();
            Options.add(option);
            this.setOptions(Options);
        }
    }

    @Override
    public String toString() {
        return "Flow{" + id +
                ", '" + name_msg + '\'' +
                ", " + options +
                '}';
    }
}
