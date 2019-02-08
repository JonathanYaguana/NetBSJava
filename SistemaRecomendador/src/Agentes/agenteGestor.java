package Agentes;

import Logica.searchGoogle;
import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauricio
 */
public class agenteGestor extends Agent{

    @Override
    protected void setup() {

        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                //ACLMessage message = receive();
                ACLMessage message = blockingReceive();
                if (message != null) {
                    try {
                        System.out.println(getLocalName() + ": acaba de recibir el siguiente mensaje: ");
                        new searchGoogle().busca(message.getContent());
                    } catch (IOException ex) {
                        Logger.getLogger(agenteGestor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
}
