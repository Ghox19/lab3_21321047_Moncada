package Menu_21321047_MoncadaSanchez;

import Data_21321047_MoncadaSanchez.Data_21321047_MoncadaSanchez;
import System_21321047_MoncadaSanchez.System_21321047_MoncadaSanchez;

import java.util.ArrayList;

public interface inMenu_21321047_MoncadaSanchez {
    /**
     * Getter de una System Actual dentro del Menu
     *
     * @return
     */
    System_21321047_MoncadaSanchez getSistemaActual();

    /**
     * Getter de los Sistemas dentro del Menu
     *
     * @return
     */
    ArrayList<System_21321047_MoncadaSanchez> getSistemas();

    /**
     * Getter de la Data dentro del Menu
     *
     * @return
     */
    Data_21321047_MoncadaSanchez getData();

    /**
     * Setter de un System Actual dentro del Menu
     *
     * @param sistema
     */
    void setSistemaActual(System_21321047_MoncadaSanchez sistema);

    /**
     * Metodo que permite a un Usuario iniciar sesion o Registrarse
     */
    void initialMenu();

    /**
     * Metodo que permite a un Usuario Logearse dentro del sistema Actual
     */
    void userLoginMenu();

    /**
     * Metodo que permite al Usuario definir que Tipo de Usuario se va a Registrar
     */
    void userTypeRegisterMenu();

    /**
     * Permite que un Admin se registre en el Sistema Actual
     */
    void userAdminRegisterMenu();

    /**
     * Permite a un Usuario Normal registrarse en el Sistema Actual
     */
    void userNormalRegisterMenu();

    /**
     * Permite a un Usuario Normal realizar distintas Opciones
     */
    void mainNormalMenu();

    /**
     * Permite Generar una Interaccion en el Sistema Actual
     */
    void interactionMenu();

    /**
     * Metodo que Genera una Synthesis del Historial del Usuario Actual
     */
    void synthesisNormalMenu();

    /**
     * Metodo que permite a un Usuario Normal generar una Simulacion en su Usuario
     */
    void normalSimulateMenu();

    /**
     * Deslogea del Sistema y vuelve al Inicio
     */
    void logoutMenu();

    /**
     * Menu Principal de un Administrador
     */
    void mainAdminMenu();

    /**
     * Menu que permite al Administrador generar todas las partes de un Chatbot y modificarlas
     */
    void chatbotCreationMenu();

    /**
     * Menu que permite generar una opcion y guardarla en la Data
     */
    void optionCreationMenu();

    /**
     * Metodo que Permite la creacion de un Flow y lo guarda en la Data
     */
    void flowCreationMenu();

    /**
     * Metodo que permite a un Administrador añadir una opcion de la data en un Flow
     */
    void flowAddOptionMenu();

    /**
     * Menu que permite definir y crear un Chatbot eh ingresarlo en la Data
     */
    void defineChatbotMenu();

    /**
     * Metodo que permite añadir un Flow a un Chatbot de la Data
     */
    void chatbotAddFlowMenu();

    /**
     * Menu que permite obtener el Historial de cualquier Usuario del Sistema
     */
    void synthesisAdminMenu();

    /**
     * Menu que permite ver todo lo almacenado en la Data
     */
    void showDataMenu();

    /**
     * Menu que permite ver todo lo almacenado en el Sistema Actual
     */
    void showDataSystemMenu();

    /**
     * Menu que permite la Creacion de un Sistema
     */
    void systemCreationMenu();

    /**
     * Menu que permite a un Administrados ingresar un Chatbot a un Sistema
     */
    void systemAddChatbotMenu();

    /**
     * Menu que permite definir un nuevo System Actual
     */
    void systemSetActualMenu();

    /**
     * Menu que permite generar una Simulacion externa en el Sistema Actual
     */
    void adminSimulateMenu();
}
