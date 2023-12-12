package CargaDeDatos_21321047_MoncadaSanchez;

import Chatbot_21321047_MoncadaSanchez.Chatbot_21321047_MoncadaSanchez;
import Flow_21321047_MoncadaSanchez.Flow_21321047_MoncadaSanchez;
import Option_21321047_MoncadaSanchez.Option_21321047_MoncadaSanchez;
import System_21321047_MoncadaSanchez.System_21321047_MoncadaSanchez;

import java.util.ArrayList;
import java.util.Arrays;

public class CargaDeDatos_21321047_MoncadaSanchez implements inCargaDeDatos_21321047_MoncadaSanchez {

    @Override
    public System_21321047_MoncadaSanchez cargaDatos(){
        Option_21321047_MoncadaSanchez op1 = new Option_21321047_MoncadaSanchez(1, "1) Viajar", 1, 1, Arrays.asList("viajar", "turistear", "conocer"));
        Option_21321047_MoncadaSanchez op2 = new Option_21321047_MoncadaSanchez(2, "2) Estudiar", 2, 1, Arrays.asList("estudiar", "aprender", "perfeccionarme"));
        ArrayList<Option_21321047_MoncadaSanchez> optionList = new ArrayList<Option_21321047_MoncadaSanchez>(Arrays.asList(op1, op2, op2, op1));
        Flow_21321047_MoncadaSanchez f1 = new Flow_21321047_MoncadaSanchez (1, "Flujo Principal Chatbot 1\nBienvenido\n¿Qué te gustaría hacer?", optionList);
        ArrayList<Flow_21321047_MoncadaSanchez> flowList = new ArrayList<Flow_21321047_MoncadaSanchez>(Arrays.asList(f1, f1));
        Chatbot_21321047_MoncadaSanchez cb0 = new Chatbot_21321047_MoncadaSanchez (0, "Inicial", "Bienvenido\n¿Qué te gustaría hacer?", 1, flowList);
        Option_21321047_MoncadaSanchez op3 = new Option_21321047_MoncadaSanchez(1, "1) New York, USA", 1, 2, Arrays.asList("USA", "Estados Unidos", "New York"));
        Option_21321047_MoncadaSanchez op4 = new Option_21321047_MoncadaSanchez(2, "2) París, Francia", 1, 1, Arrays.asList("Paris", "Eiffel"));
        Option_21321047_MoncadaSanchez op5 = new Option_21321047_MoncadaSanchez(3, "3) Torres del Paine, Chile", 1, 1, Arrays.asList("Chile", "Torres", "Paine", "Torres Paine", "Torres del Paine"));
        Option_21321047_MoncadaSanchez op6 = new Option_21321047_MoncadaSanchez(4, "4) Volver", 0, 1, Arrays.asList("Regresar", "Salir", "Volver"));
        Option_21321047_MoncadaSanchez op7 = new Option_21321047_MoncadaSanchez(1, "1) Central Park", 1, 2, Arrays.asList("Central", "Park", "Central Park"));
        Option_21321047_MoncadaSanchez op8 = new Option_21321047_MoncadaSanchez(2, "2) París, Francia", 1, 1, Arrays.asList("Museo", "Antiguedades"));
        Option_21321047_MoncadaSanchez op9 = new Option_21321047_MoncadaSanchez(3, "3) Ningún otro atractivo", 1, 3, Arrays.asList("Ninguno"));
        Option_21321047_MoncadaSanchez op10 = new Option_21321047_MoncadaSanchez(4, "4) Cambiar destino", 1, 1, Arrays.asList("Cambiar", "Volver", "Salir"));
        Option_21321047_MoncadaSanchez op11 = new Option_21321047_MoncadaSanchez(1, "1) Solo", 1, 3, Arrays.asList("Solo"));
        Option_21321047_MoncadaSanchez op12 = new Option_21321047_MoncadaSanchez(2, "2) En pareja", 1, 3, Arrays.asList("Pareja"));
        Option_21321047_MoncadaSanchez op13 = new Option_21321047_MoncadaSanchez(3, "3) En familia", 1, 3, Arrays.asList("Familia"));
        Option_21321047_MoncadaSanchez op14 = new Option_21321047_MoncadaSanchez(4, "4) Agregar más atractivos", 1, 2, Arrays.asList("Volver", "Atractivos"));
        Option_21321047_MoncadaSanchez op15 = new Option_21321047_MoncadaSanchez(5, "5) En realidad quiero otro destino", 1, 1, Arrays.asList("Cambiar destino"));
        ArrayList<Option_21321047_MoncadaSanchez> optionList1 = new ArrayList<Option_21321047_MoncadaSanchez>(Arrays.asList(op3, op4, op5, op6));
        Flow_21321047_MoncadaSanchez f20 = new Flow_21321047_MoncadaSanchez (1, "Flujo 1 Chatbot1\n¿Dónde te Gustaría ir?", optionList1);
        ArrayList<Option_21321047_MoncadaSanchez> optionList2 = new ArrayList<Option_21321047_MoncadaSanchez>(Arrays.asList(op7, op8, op9, op10));
        Flow_21321047_MoncadaSanchez f21 = new Flow_21321047_MoncadaSanchez (2, "Flujo 2 Chatbot1\n¿Qué atractivos te gustaría visitar?", optionList2);
        ArrayList<Option_21321047_MoncadaSanchez> optionList3 = new ArrayList<Option_21321047_MoncadaSanchez>(Arrays.asList(op11, op12, op13, op14, op15));
        Flow_21321047_MoncadaSanchez f22 = new Flow_21321047_MoncadaSanchez (3, "Flujo 3 Chatbot1\n¿Vas solo o acompañado?", optionList3);
        ArrayList<Flow_21321047_MoncadaSanchez> flowList1 = new ArrayList<Flow_21321047_MoncadaSanchez>(Arrays.asList(f20, f21, f22));
        Chatbot_21321047_MoncadaSanchez cb1 = new Chatbot_21321047_MoncadaSanchez (1, "Agencia Viajes", "Bienvenido\n¿Dónde quieres viajar?", 1, flowList1);
        Option_21321047_MoncadaSanchez op16 = new Option_21321047_MoncadaSanchez(1, "1) Carrera Técnica", 2, 1, Arrays.asList("Técnica"));
        Option_21321047_MoncadaSanchez op17 = new Option_21321047_MoncadaSanchez(2, "2) Postgrado", 2, 1, Arrays.asList("Doctorado", "Magister", "Postgrado"));
        Option_21321047_MoncadaSanchez op18 = new Option_21321047_MoncadaSanchez(3, "3) Volver", 0, 1, Arrays.asList("Volver", "Salir", "Regresar"));
        ArrayList<Option_21321047_MoncadaSanchez> optionList4 = new ArrayList<Option_21321047_MoncadaSanchez>(Arrays.asList(op16, op17, op18));
        Flow_21321047_MoncadaSanchez f3 = new Flow_21321047_MoncadaSanchez (1, "Flujo 1 Chatbot2\n¿Qué te gustaría estudiar?", optionList4);
        ArrayList<Flow_21321047_MoncadaSanchez> flowList2 = new ArrayList<Flow_21321047_MoncadaSanchez>(Arrays.asList(f3));
        Chatbot_21321047_MoncadaSanchez cb2 = new Chatbot_21321047_MoncadaSanchez (2, "Orientador Académico", "Bienvenido\n¿Qué te gustaría estudiar?", 1, flowList2);
        ArrayList<Chatbot_21321047_MoncadaSanchez> chatbots = new ArrayList<>(Arrays.asList(cb0, cb1, cb2));
        System_21321047_MoncadaSanchez system = new System_21321047_MoncadaSanchez("Chatbots Paradigmas", 0, chatbots);
        system.systemAddUser("user1");
        system.systemAddUser("user2");
        system.systemAddUser("user3");
        system.systemLogin("user2");
        system.systemTalk("hola");
        system.systemTalk("1");
        system.systemTalk("1");
        system.systemTalk("Museo");
        system.systemTalk("1");
        system.systemTalk("3");
        system.systemTalk("5");
        system.systemLogout();
        return system;
    }
}
