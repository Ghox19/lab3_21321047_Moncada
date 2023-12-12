package Menu_21321047_MoncadaSanchez;

import CargaDeDatos_21321047_MoncadaSanchez.CargaDeDatos_21321047_MoncadaSanchez;
import Chatbot_21321047_MoncadaSanchez.Chatbot_21321047_MoncadaSanchez;
import Commons_21321047_MoncadaSanchez.Commons_21321047_MoncadaSanchez;
import Data_21321047_MoncadaSanchez.Data_21321047_MoncadaSanchez;
import Flow_21321047_MoncadaSanchez.Flow_21321047_MoncadaSanchez;
import Option_21321047_MoncadaSanchez.Option_21321047_MoncadaSanchez;
import System_21321047_MoncadaSanchez.System_21321047_MoncadaSanchez;
import User_21321047_MoncadaSanchez.User_21321047_MoncadaSanchez;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu_21321047_MoncadaSanchez implements inMenu_21321047_MoncadaSanchez {
    /**
     * Almacena los Sistemas registrados
     */
    private ArrayList<System_21321047_MoncadaSanchez> sistemas;
    /**
     * Almacena el sistema actual con el que el Usuario esta Interactuando
     */
    private System_21321047_MoncadaSanchez sistemaActual;

    /**
     * Almacena los datos creados
     */
    private Data_21321047_MoncadaSanchez data;

    /**
     * Constructor de un Menu, este permite crear su propio System eh ingresarle datos base
     */
    public Menu_21321047_MoncadaSanchez() {
        CargaDeDatos_21321047_MoncadaSanchez cargaDeDatos = new CargaDeDatos_21321047_MoncadaSanchez();
        this.sistemaActual = cargaDeDatos.cargaDatos();
        this.sistemas = new ArrayList<>();
        this.sistemas.add(this.sistemaActual);
        this.data = new Data_21321047_MoncadaSanchez();
        this.data.setOpciones(this.sistemaActual.getOptionInSystem());
        this.data.setFlujos(this.sistemaActual.getFlowInSystem());
        this.data.setChatbots(this.sistemaActual.getChatbots());
    }

    @Override
    public System_21321047_MoncadaSanchez getSistemaActual() {
        return sistemaActual;
    }

    @Override
    public ArrayList<System_21321047_MoncadaSanchez> getSistemas() {
        return sistemas;
    }

    @Override
    public Data_21321047_MoncadaSanchez getData() {
        return data;
    }

    @Override
    public void setSistemaActual(System_21321047_MoncadaSanchez sistema) {
        this.sistemaActual = sistema;
    }

    @Override
    public void initialMenu(){
        String formattedString = "### Sistema de Chatbots - Inicio ###\n" + "1. Login de Usuario\n"
                + "2. Registro de Usuario\n" + "3. Salir";
        System.out.println(formattedString);
        Scanner scanner = new Scanner(System.in);
        System.out.print("INTRODUZCA SU OPCION: ");
        int eleccion = scanner.nextInt();
        if (eleccion == 1){
            userLoginMenu();
        }
        else if (eleccion == 2){
            userTypeRegisterMenu();
            initialMenu();
        }
        else if (eleccion == 3){
            System.out.println("Muchas gracias por usar este Sistema");
        }
        else {
            System.out.println("No se ingreso una opcion Valida intentelo denuevo");
        }
    }

    @Override
    public void userLoginMenu(){
        String formattedString =
                "### Sistema de Chatbots - Login ###";
        System.out.println(formattedString);
        Scanner scanner = new Scanner(System.in);
        System.out.print("INTRODUZCA NOMBRE DE USUARIO: ");
        String username = scanner.nextLine();
        this.getSistemaActual().systemLogin(username);
        while(true){
            if (this.getSistemaActual().getLoggedUser() != null){
                var user = this.getSistemaActual().getUserByUsername(username);
                if (user.isAdmin()){
                    mainAdminMenu();
                    break;
                }
                else {
                    mainNormalMenu();
                    break;
                }
            }
            else {
                System.out.println("El usuario no Existe intentelo denuevo");
            }
        }
    }

    @Override
    public void userTypeRegisterMenu(){
        String formattedString =
                "### Sistema de Chatbots - Registro ###\n" +
                        "1. Registrar usuario normal\n" +
                        "2. Registrar usuario administrador";
        System.out.println(formattedString);
        System.out.print("INTRODUZCA SU OPCION: ");
        Scanner scanner = new Scanner(System.in);
        int eleccion = scanner.nextInt();
        if (eleccion == 1){
            userNormalRegisterMenu();
        }
        else if (eleccion == 2){
            userAdminRegisterMenu();
        }
        else {
            System.out.println("No se ingreso una opcion Valida intentelo denuevo");
        }
    }

    @Override
    public void userAdminRegisterMenu(){
        String formattedString = "### Sistema de Chatbots - Registro Usuario Administrador ###";
        System.out.println(formattedString);
        Scanner scanner = new Scanner(System.in);
        System.out.print("INTRODUZCA NOMBRE DEL USUARIO ADMINISTRADOR: ");
        String username = scanner.nextLine();
        this.getSistemaActual().systemAddUser(username);
        var user = this.getSistemaActual().getUserByUsername(username);
        if (user != null){
            user.setAdmin(true);
            System.out.println("El usuario se ingreso al Sistema correctamente");
        }
        else {
            System.out.println("El usuario ya existe en el Sistema");
        }
    }

    @Override
    public void userNormalRegisterMenu(){
        String formattedString = "### Sistema de Chatbots - Registro Usuario Normal ###";
        System.out.println(formattedString);
        Scanner scanner = new Scanner(System.in);
        System.out.print("INTRODUZCA NOMBRE DEL USUARIO NORMAL: ");
        String username = scanner.nextLine();
        this.getSistemaActual().systemAddUser(username);
        var user = this.getSistemaActual().getUserByUsername(username);
        if (user == null) {
            System.out.println("El usuario ya existe en el Sistema");
        }
        else {
            System.out.println("El usuario se ingreso al Sistema correctamente");
        }
    }

    @Override
    public void mainNormalMenu(){
        String formattedString =
                "### Sistema de Chatbots - Usuario Normal ###\n" +
                        "Bienvenido " + this.getSistemaActual().getLoggedUser() + " usted es usuario normal.\n" +
                        "1. Interactuar con el Sistema\n" +
                        "2. Revisar Historial\n" +
                        "3. Realizar una simulacion en el Sistema\n" +
                        "4. Salir";
        System.out.println(formattedString);
        Scanner scanner = new Scanner(System.in);
        System.out.print("INTRODUZCA SU OPCION: ");
        int eleccion = scanner.nextInt();
        if (eleccion == 1){
            interactionMenu();
            mainNormalMenu();
        }
        else if (eleccion == 2){
            synthesisNormalMenu();
        }
        else if (eleccion == 3){
            normalSimulateMenu();
        }
        else if (eleccion == 4){
            logoutMenu();
        } else {
            System.out.println("No se ingreso una opcion Valida, Intentelo Denuevo");
            mainNormalMenu();
        }
    }

    @Override
    public void interactionMenu(){
        var commons = new Commons_21321047_MoncadaSanchez();
        var chatbot = this.getSistemaActual().getChatbotById(this.getSistemaActual().getCurrentState().getActualChatbotCodeLink());
        var flow = chatbot.getFlowById(this.getSistemaActual().getCurrentState().getActualFlowCodeLink());
        String messageIntro = commons.messageIntroFormat(flow, chatbot) + "\nRESPUESTA: ";
        System.out.print(messageIntro);
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        var user = this.getSistemaActual().getUserByUsername(this.getSistemaActual().getLoggedUser());
        if (user.isFirstInteraction()){
            this.getSistemaActual().systemTalk("hola");
            user.setFirstInteraction(false);
        }
        this.getSistemaActual().systemTalk(message);
    }

    @Override
    public void synthesisNormalMenu(){
        this.getSistemaActual().systemSynthesis(this.getSistemaActual().getLoggedUser());
        mainNormalMenu();
    }

    @Override
    public void normalSimulateMenu(){
        Scanner scanner = new Scanner(System.in);
        String formattedString = "### Sistema de Chatbots - Usuario Normal ###\n"+
                "SE VA A GENERAR UNA INTERACCIONES CON ESTE USUARIO A BASE DE UNA SEED, ESTA SEED SERA INGRESADA POR USTED. \n"
                + "INGRESE LA SEED PARA LA SIMULACION: ";
        System.out.print(formattedString);
        var seed = scanner.nextInt();
        System.out.print("INGRESE EL NUMERO MAXIMO DE INTERACCIONES: ");
        var maxInteraccions = scanner.nextInt();
        var currentState = this.getSistemaActual().getCurrentState();
        this.getSistemaActual().systemSimulate(maxInteraccions, seed, this.sistemaActual);
        this.getSistemaActual().setCurrentState(currentState);
        System.out.println("Se genero la simulacion correctamente");
        mainNormalMenu();
    }

    @Override
    public void logoutMenu(){
        this.getSistemaActual().systemLogout();
        initialMenu();
    }

    @Override
    public void mainAdminMenu(){
        String formattedString =
                "### Sistema de Chatbots - Usuario Administrador ###\n" +
                        "Bienvenido " + this.getSistemaActual().getLoggedUser() + " usted es administrador.\n"
                        + "1. Crear un Chatbot\n" + "2. Modificar un Chatbot\n" +
                        "3. Interactuar con el Sistema\n" + "4. Obtener una Sintesis del Historial de un Usuario\n" +
                        "5. Visualizar todos los chatbots con sus flujos y opciones creadas\n" +
                        "6. Visualizar todos los chatbots con sus flujos y opciones creadas dentro del sistema Actual\n" +
                        "7. Crear un Sistema\n" + "8. Añadir Chatbot a un Sistema\n" +
                        "9. Cambiar Sistema actual\n" +
                        "10. Ejecutar una simulación del sistema de chatbot actual\n" + "11. Salir";
        System.out.println(formattedString);
        Scanner scanner = new Scanner(System.in);
        System.out.print("INTRODUZCA SU OPCION: ");
        int eleccion = scanner.nextInt();
        if (eleccion == 1){
            chatbotCreationMenu();
        }
        else if (eleccion == 2){
            chatbotAddFlowMenu();
        }
        else if (eleccion == 3){
            interactionMenu();
            mainAdminMenu();
        }
        else if (eleccion == 4){
            synthesisAdminMenu();
        }
        else if (eleccion == 5){
            showDataMenu();
            mainAdminMenu();
        }
        else if (eleccion == 6){
            showDataSystemMenu();
            mainAdminMenu();
        }
        else if (eleccion == 7){
            systemCreationMenu();
        }
        else if (eleccion == 8){
            systemAddChatbotMenu();
        }
        else if (eleccion == 9){
            systemSetActualMenu();
        }
        else if (eleccion == 10){
            adminSimulateMenu();
        }
        else if (eleccion == 11){
            logoutMenu();
        }
        else{
            System.out.println("No es una opcion valida, intentelo denuevo");
            mainAdminMenu();
        }
    }

    @Override
    public void chatbotCreationMenu(){
        String formattedString = "### Sistema de Chatbots - Usuario Administrador ###\n" +
                "1. Crear Opciones\n" + "2. Crear un Flow\n" + "3. Modificar un Flow\n" +
                "4. Definir un Chatbot\n" + "5. Volver";
        System.out.println(formattedString);
        Scanner scanner = new Scanner(System.in);
        System.out.print("INTRODUZCA SU OPCION: ");
        int eleccion = scanner.nextInt();
        if (eleccion == 1){
            optionCreationMenu();
        }
        else if (eleccion == 2){
            flowCreationMenu();
        }
        else if (eleccion == 3){
            flowAddOptionMenu();
        }
        else if (eleccion == 4){
            defineChatbotMenu();
        }
        else if (eleccion == 5){
            mainAdminMenu();
        }
        else{
            System.out.print("No es una opcion valida, intentelo denuevo.");
            chatbotCreationMenu();
        }
    }

    @Override
    public void optionCreationMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("### Sistema de Chatbots - Usuario Administrador ###\nINTRODUZCA LA ID ASIGNADA DE SU OPCION: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("INTRODUZCA EL MENSAJE DE SU OPCION: ");
        String message = scanner.nextLine();
        System.out.print("INTRODUZCA EL LINK AL CHATBOT DE SU OPCION: ");
        int chatbotCodeLink = scanner.nextInt();
        System.out.print("INTRODUZCA EL LINK AL FLOW DE SU OPCION: ");
        int flowCodeLink = scanner.nextInt();
        scanner.nextLine();
        System.out.print("INGRESA LAS PALABRAS CLAVE DE SU OPCION, CUANDO SEA LA ULTIMA INGRESA UN -1:\n");
        ArrayList<String> keywords = new ArrayList<>();
        while (true) {
            String entrada = scanner.nextLine();
            if (entrada.equalsIgnoreCase("-1")) {
                break;
            }
            keywords.add(entrada);
        }
        Option_21321047_MoncadaSanchez option = new Option_21321047_MoncadaSanchez(id, message, chatbotCodeLink, flowCodeLink, keywords);
        this.getData().getOpciones().add(option);
        System.out.println("La opcion se ingreso al registro correctamente");
        chatbotCreationMenu();
    }

    @Override
    public void flowCreationMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("### Sistema de Chatbots - Usuario Administrador ###\nINTRODUZCA LA ID ASIGNADA DE SU FLOW: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("INTRODUZCA EL NOMBRE Y MENSAJE DE SU FLOW(debe ser separado con un \\n ej: name \\n message): ");
        String name_message = scanner.nextLine();
        System.out.print("INTRODUZCA SECUENCIALMENTE LAS OPCIONES A INCLUIR, TERMINAR CON UN -1: \n");
        int i = 1;
        String formattedString = "";
        for(Option_21321047_MoncadaSanchez opt : this.getData().getOpciones()){
            formattedString += i + ". " + opt + "\n";
            i += 1;
        }
        System.out.println(formattedString);
        System.out.print("Ingrese Opciones Aqui. \n");
        ArrayList<Option_21321047_MoncadaSanchez> options = new ArrayList<>();
        while (true) {
            int entrada = scanner.nextInt();
            if (entrada == -1) {
                break;
            }
            else if (entrada > i){
                System.out.println("Esta no es una opcion valida, intentelo otra vez");
            }
            else{
                Commons_21321047_MoncadaSanchez common = new Commons_21321047_MoncadaSanchez();
                options.add(common.obtenerElementoPorIndice(this.getData().getOpciones(), entrada));
            }
        }
        Flow_21321047_MoncadaSanchez flow = new Flow_21321047_MoncadaSanchez(id, name_message, options);
        this.getData().getFlujos().add(flow);
        System.out.println("El flujo se ingreso al registro correctamente");
        chatbotCreationMenu();
    }

    @Override
    public void flowAddOptionMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("### Sistema de Chatbots - Usuario Administrador ###\nSELECCIONE UN FLOW: \n");
        int i = 1;
        String formattedString = "";
        for(Flow_21321047_MoncadaSanchez flw : this.getData().getFlujos()){
            formattedString += i + ". " + flw + "\n";
            i += 1;
        }
        System.out.println(formattedString);
        Flow_21321047_MoncadaSanchez flow = null;
        while (true) {
            int entrada = scanner.nextInt();
            if (entrada < 0 && entrada > i){
                System.out.println("Esta no es una opcion valida, intentelo otra vez");
            }
            else{
                Commons_21321047_MoncadaSanchez common = new Commons_21321047_MoncadaSanchez();
                flow = common.obtenerElementoPorIndice(this.getData().getFlujos(), entrada);
                break;
            }
        }
        System.out.print("INTRODUZCA LA OPCION A INGRESAR: ");
        i = 1;
        formattedString = "";
        for(Option_21321047_MoncadaSanchez opt : this.getData().getOpciones()){
            formattedString += i + ". " + opt + "\n";
            i += 1;
        }
        System.out.println(formattedString);
        Option_21321047_MoncadaSanchez option = null;
        while (true) {
            int entrada = scanner.nextInt();
            if (entrada < 0 && entrada > i){
                System.out.println("Esta no es una opcion valida, intentelo otra vez");
            }
            else{
                Commons_21321047_MoncadaSanchez common = new Commons_21321047_MoncadaSanchez();
                option = common.obtenerElementoPorIndice(this.getData().getOpciones(), entrada);
                break;
            }
        }
        flow.flowAddOption(option);
        System.out.println("El flujo se actualizo en el registro correctamente");
        chatbotCreationMenu();
    }

    @Override
    public void defineChatbotMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("### Sistema de Chatbots - Usuario Administrador ###\nINTRODUZCA LA ID ASIGNADA DE SU CHATBOT: ");
        int chatbotId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("INTRODUZCA EL NOMBRE DE SU CHATBOT: ");
        String name = scanner.nextLine();
        System.out.print("INTRODUZCA EL MENSAJE DE BIENVENIDA DE SU CHATBOT: ");
        String welcomeMessage = scanner.nextLine();
        System.out.print("INTRODUZCA EL LINK DE INICIO DE FLOW DE SU CHATBOT: ");
        int startFlowId = scanner.nextInt();
        System.out.print("INTRODUZCA SECUENCIALMENTE LOS FLUJOS A INCLUIR, TERMINAR CON UN -1: \n");
        int i = 1;
        String formattedString = "";
        for(Flow_21321047_MoncadaSanchez flw : this.getData().getFlujos()){
            formattedString += i + ". " + flw + "\n";
            i += 1;
        }
        System.out.println(formattedString);
        System.out.print("Ingrese Flujos Aqui. \n");
        ArrayList<Flow_21321047_MoncadaSanchez> flows = new ArrayList<>();
        while (true) {
            int entrada = scanner.nextInt();
            if (entrada == -1) {
                break;
            }
            else if (entrada > i){
                System.out.println("Esta no es una opcion valida, intentelo otra vez");
            }
            else{
                Commons_21321047_MoncadaSanchez common = new Commons_21321047_MoncadaSanchez();
                flows.add(common.obtenerElementoPorIndice(this.getData().getFlujos(), entrada));
            }
        }
        Chatbot_21321047_MoncadaSanchez chatbot = new Chatbot_21321047_MoncadaSanchez(chatbotId, name, welcomeMessage, startFlowId, flows);
        this.getData().getChatbots().add(chatbot);
        System.out.println("DESEA INGRESAR ESTE CHATBOT AL SISTEMA?:\n1. Si\n2. No");
        System.out.print("INTRODUZCA SU OPCION: ");
        while (true){
            int entrada = scanner.nextInt();
            if (entrada == 1) {
                this.getSistemaActual().systemAddChatbot(chatbot);
                break;
            }
            else if (entrada == 2){
                break;
            }
            else{
                System.out.println("Esta opcion no es valida, vuelva a intentarlo");
            }
        }
        System.out.println("El chatbot se ingreso correctamente");
        chatbotCreationMenu();
    }

    @Override
    public void chatbotAddFlowMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("### Sistema de Chatbots - Usuario Administrador ###\nSELECCIONE UN CHATBOT: \n");
        int i = 1;
        String formattedString = "";
        for(Chatbot_21321047_MoncadaSanchez chb : this.getData().getChatbots()){
            formattedString += i + ". " + chb + "\n";
            i += 1;
        }
        System.out.println(formattedString);
        Chatbot_21321047_MoncadaSanchez chatbot = null;
        while (true) {
            int entrada = scanner.nextInt();
            if (entrada < 0 && entrada > i){
                System.out.println("Esta no es una opcion valida, intentelo otra vez");
            }
            else{
                Commons_21321047_MoncadaSanchez common = new Commons_21321047_MoncadaSanchez();
                chatbot = common.obtenerElementoPorIndice(this.getData().getChatbots(), entrada);
                break;
            }
        }
        System.out.print("INTRODUZCA EL FLOW A INGRESAR: \n");
        i = 1;
        formattedString = "";
        for(Flow_21321047_MoncadaSanchez flw : this.getData().getFlujos()){
            formattedString += i + ". " + flw + "\n";
            i += 1;
        }
        System.out.println(formattedString);
        Flow_21321047_MoncadaSanchez flow = null;
        while (true) {
            int entrada = scanner.nextInt();
            if (entrada < 0 && entrada > i){
                System.out.println("Esta no es una opcion valida, intentelo otra vez");
            }
            else{
                Commons_21321047_MoncadaSanchez common = new Commons_21321047_MoncadaSanchez();
                flow = common.obtenerElementoPorIndice(this.getData().getFlujos(), entrada);
                break;
            }
        }
        chatbot.chatbotAddFlow(flow);
        System.out.println("El Chatbot se actualizo en el registro correctamente");
        mainAdminMenu();
    }

    @Override
    public void synthesisAdminMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("INTRODUZCA NOMBRE DE USUARIO A SINTETIZAR: ");
        String username = scanner.nextLine();
        List<String> existingUsernames = this.getSistemaActual().getUsers().stream()
                .map(User_21321047_MoncadaSanchez::getUsername)
                .collect(Collectors.toList());
        if (existingUsernames.contains(username)){
            this.getSistemaActual().systemSynthesis(username);
            mainAdminMenu();
        }
        else {
            System.out.println("El usuario no Existe intentelo denuevo");
            synthesisAdminMenu();
        }
    }

    @Override
    public void showDataMenu(){
        int i = 1;
        String formattedString = "";
        for(Chatbot_21321047_MoncadaSanchez chb : this.getData().getChatbots()){
            formattedString += i + ". " + chb + "\n";
            i += 1;
        }
        System.out.println(formattedString);
    }

    @Override
    public void showDataSystemMenu(){
        int i = 1;
        String formattedString = "";
        for(Chatbot_21321047_MoncadaSanchez chb : this.getSistemaActual().getChatbots()){
            formattedString += i + ". " + chb + "\n";
            i += 1;
        }
        System.out.println(formattedString);
    }

    @Override
    public void systemCreationMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("### Sistema de Chatbots - Usuario Administrador ###\nINTRODUZCA EL NOMBRE DEL SISTEMA: ");
        String name = scanner.nextLine();
        System.out.print("INTRODUZCA EL ID DEL CHATBOT INICIAL DEL SISTEMA: ");
        int initialChatbotCodeLink = scanner.nextInt();
        System.out.print("INTRODUZCA SECUENCIALMENTE LOS CHATBOTS A INCLUIR, TERMINAR CON UN -1: \n");
        int i = 1;
        String formattedString = "";
        for(Chatbot_21321047_MoncadaSanchez chb : this.getData().getChatbots()){
            formattedString += i + ". " + chb + "\n";
            i += 1;
        }
        System.out.println(formattedString);
        System.out.print("Ingrese Chatbots Aqui. \n");
        ArrayList<Chatbot_21321047_MoncadaSanchez> chatbots = new ArrayList<>();
        while (true) {
            int entrada = scanner.nextInt();
            if (entrada == -1) {
                break;
            }
            else if (entrada > i){
                System.out.println("Esta no es una opcion valida, intentelo otra vez");
            }
            else{
                Commons_21321047_MoncadaSanchez common = new Commons_21321047_MoncadaSanchez();
                chatbots.add(common.obtenerElementoPorIndice(this.getData().getChatbots(), entrada));
            }
        }
        System_21321047_MoncadaSanchez sistema = new System_21321047_MoncadaSanchez(name, initialChatbotCodeLink, chatbots);
        this.getSistemas().add(sistema);
        System.out.println("El Sistema se ingreso correctamente");
        mainAdminMenu();
    }

    @Override
    public void systemAddChatbotMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("### Sistema de Chatbots - Usuario Administrador ###\nSELECCIONE EL SISTEMA: \n");
        int i = 1;
        String formattedString = "";
        for(System_21321047_MoncadaSanchez sys : this.getSistemas()){
            formattedString += i + ". " + sys + "\n";
            i += 1;
        }
        System.out.println(formattedString);
        System_21321047_MoncadaSanchez sistema = null;
        while (true) {
            int entrada = scanner.nextInt();
            if (entrada < 0 && entrada > i){
                System.out.println("Esta no es una opcion valida, intentelo otra vez");
            }
            else{
                Commons_21321047_MoncadaSanchez common = new Commons_21321047_MoncadaSanchez();
                sistema = common.obtenerElementoPorIndice(this.getSistemas(), entrada);
                break;
            }
        }
        System.out.print("INTRODUZCA EL CHATBOT A INGRESAR: \n");
        i = 1;
        formattedString = "";
        for(Chatbot_21321047_MoncadaSanchez chb : this.getData().getChatbots()){
            formattedString += i + ". " + chb + "\n";
            i += 1;
        }
        System.out.println(formattedString);
        Chatbot_21321047_MoncadaSanchez chatbot = null;
        while (true) {
            int entrada = scanner.nextInt();
            if (entrada < 0 && entrada > i){
                System.out.println("Esta no es una opcion valida, intentelo otra vez");
            }
            else{
                Commons_21321047_MoncadaSanchez common = new Commons_21321047_MoncadaSanchez();
                chatbot = common.obtenerElementoPorIndice(this.getData().getChatbots(), entrada);
                break;
            }
        }
        sistema.systemAddChatbot(chatbot);
        System.out.println("El Sistema se actualizo en el registro correctamente");
        mainAdminMenu();
    }

    @Override
    public void systemSetActualMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("### Sistema de Chatbots - Usuario Administrador ###\nLISTA DE SISTEMAS. \n");
        int i = 1;
        String formattedString = "";
        for(System_21321047_MoncadaSanchez sys : this.getSistemas()){
            formattedString += i + ". " + sys + "\n";
            i += 1;
        }
        System.out.println(formattedString);
        System_21321047_MoncadaSanchez sistema = null;
        while (true) {
            int entrada = scanner.nextInt();
            if (entrada < 0 && entrada > i){
                System.out.println("Esta no es una opcion valida, intentelo otra vez");
            }
            else{
                Commons_21321047_MoncadaSanchez common = new Commons_21321047_MoncadaSanchez();
                sistema = common.obtenerElementoPorIndice(this.getSistemas(), entrada);
                break;
            }
        }
        System.out.print("SELECCIONE UN SISTEMA: ");
        System.out.print("\nEL SISTEMA SE VA A CAMBIAR Y VOLVERAS AL INICIO DE SESION, ESTAS SEGURO?:\n1. Si\n2. No\n");
        System.out.print("INTRODUZCA SU OPCION: ");
        while (true) {
            int entrada = scanner.nextInt();
            if (entrada == 1){
                this.getSistemaActual().systemLogout();
                this.setSistemaActual(sistema);
                initialMenu();
                break;
            }
            else if (entrada == 2){
                mainAdminMenu();
                break;
            }
            else{
                System.out.print("No es una opcion valida, intentelo denuevo");
            }
        }
    }

    @Override
    public void adminSimulateMenu(){
        Scanner scanner = new Scanner(System.in);
        String formattedString = "### Sistema de Chatbots - Usuario Administrador ###\n"+
                "SE VA A GENERAR UNA INTERACCION CON USUARIO NUEVO LLAMADO userSEED, ESTA SEED SERA INGRESADA POR USTED. \n"
                + "INGRESE LA SEED PARA LA SIMULACION: ";
        System.out.print(formattedString);
        var seed = scanner.nextInt();
        System.out.print("INGRESE EL NUMERO MAXIMO DE INTERACCIONES: ");
        var maxInteraccions = scanner.nextInt();
        var currentState = this.getSistemaActual().getCurrentState();
        var loggedUser = this.getSistemaActual().getLoggedUser();
        this.getSistemaActual().systemLogout();
        this.getSistemaActual().systemAddUser("user" + seed);
        this.getSistemaActual().systemLogin("user" + seed);
        this.getSistemaActual().systemSimulate(maxInteraccions, seed, this.sistemaActual);
        this.getSistemaActual().systemLogout();
        this.getSistemaActual().systemLogin(loggedUser);
        this.getSistemaActual().setCurrentState(currentState);
        System.out.println("Se genero la simulacion correctamente");
        mainAdminMenu();
    }
}
