package Agentes;

import Interfaz.Humano;
import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio
 */
public class agenteHumano extends Agent {

    @Override
    protected void setup() {

        addBehaviour(new CyclicBehaviour(this) {

            @Override
            public void action() {
                AID id = new AID();
                id.setLocalName("agenteGestor");

                // Creación del objeto ACLMessage
                ACLMessage mensaje = new ACLMessage(ACLMessage.REQUEST);

                //Rellenar los campos necesarios del mensaje
                mensaje.setSender(getAID());
                mensaje.setLanguage("Español");
                mensaje.addReceiver(id);
                String palabra = JOptionPane.showInputDialog("Palabra a buscar:");
                if ("".equals(palabra)) {
                   
                } else {
                    if (palabra != null) {
                        mensaje.setContent(palabra);

                        //Envia el mensaje a los destinatarios
                        send(mensaje);
                    } else {
                        System.exit(0);
                    }
                }

                //System.out.println(getLocalName() + ": Enviando hola a receptor");
                //System.out.println(mensaje.toString());
                //Espera la respuesta
                /*ACLMessage mensaje2 = blockingReceive();
                if (mensaje2 != null) {
                    System.out.println(getLocalName() + ": acaba de recibir el siguiente mensaje: ");
                    System.out.println(mensaje2.getContent());
                }*/
            }
        });
    }
}
