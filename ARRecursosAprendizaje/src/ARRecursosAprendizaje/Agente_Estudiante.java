/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ARRecursosAprendizaje;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.Scanner;
import GUI.IntEstudiante;

/**
 *
 * @author Mauricio
 */
public class Agente_Estudiante extends Agent {
    boolean fin = false;
    Scanner es = new Scanner(System.in);
    IntEstudiante c = new IntEstudiante();
    public String comp="";
    public void setup() {
        System.out.println("* Agente_Humano: ha empezado su actividad *");
        System.out.println("Ingresar componente: ");
        comp = es.nextLine();
        addBehaviour(new EmisorComportamiento(comp));
    }
    
    class EmisorComportamiento extends SimpleBehaviour {
        String componente = comp;
        private EmisorComportamiento(String comp) {
            componente = comp; 
        }
        public void action() {
            System.out.println(getLocalName() + ": Preparandose para enviar un mensaje a Arenge_Recomendador");
            AID id = new AID();
            id.setLocalName("Agente_Recomendador");
            
//creacion del objeto ACLMessage
            ACLMessage mensaje = new ACLMessage(ACLMessage.INFORM);
            
//rellenar los campos necesarios del mensaje            
            mensaje.setSender(getAID());
            mensaje.setLanguage("Español");
            mensaje.addReceiver(id);
            mensaje.setContent(componente);
            
//envia el mensaje a los destinatarios
            send(mensaje);
            
            System.out.println("* "+getLocalName() + ": Enviando a Agente_Recomendador ");
            
            //Espera la respuesta
            ACLMessage mensaje2 = blockingReceive();
            if (mensaje2!= null)
            {
                System.out.println(getLocalName() + ": acaba de recibir el siguiente mensaje: ");;
                fin = true;
            }
            
        }
        // Determina si el comportamiento ha finalizado
        // Si el comportamiento ha finalizado, éste se elimina de la cola de comportamientos activos.
        public boolean done() {
            return fin;
        }
    }
}