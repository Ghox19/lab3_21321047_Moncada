package Flow_21321047_MoncadaSanchez;

import Option_21321047_MoncadaSanchez.Option_21321047_MoncadaSanchez;

import java.util.ArrayList;

public interface inFlow_21321047_MoncadaSanchez {

    /**
     * Getter de la Id del Flow
     * @return
     */
    int getFlowId();

    /**
     * Getter del nombre y su mensaje del Flow
     * @return
     */
    String getName_msg();

    /**
     * Getter de las Opciones de un Flow
     * @return
     */
    ArrayList<Option_21321047_MoncadaSanchez> getOptions();

    /**
     * Getter de una Opcion en base a una Id
     * @param Id
     * @return
     */
    Option_21321047_MoncadaSanchez getOptionById(int Id);

    /**
     * Getter de una Opcion en base a una de sus Keywords
     * @param message
     * @return
     */
    Option_21321047_MoncadaSanchez getOptionByKeyword(String message);

    /**
     * Obtiene las Opciones de un Flow para imprimirlas
     * @return
     */
    String getOptionFormated();

    /**
     * Setter de las Opciones de un Flow
     * @param options
     */
    void setOptions(ArrayList<Option_21321047_MoncadaSanchez> options);

    /**
     * Permite añadir una opcion en un Flow
     * @param option
     */
    void flowAddOption(Option_21321047_MoncadaSanchez option);

    /**
     * Metodo que ingresa una lista de opciones y en base a sus ids retorna una Limpia
     * @param options
     * @return
     */
    ArrayList<Option_21321047_MoncadaSanchez> verifyOptions(ArrayList<Option_21321047_MoncadaSanchez> options);

    /**
     * Permite imprimir un Flow
     * @return
     */
    String toString();
}