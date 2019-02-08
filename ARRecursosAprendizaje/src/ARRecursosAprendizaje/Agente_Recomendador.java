/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ARRecursosAprendizaje;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Mauricio
 */
public class Agente_Recomendador extends Agent {
    public static final String GOOGLE_SEARCH_URL = "https://www.google.com/search";
    class ReceptorComportamiento extends SimpleBehaviour {
        private boolean fin = false;
        public void action(){
            int num = 10;
            System.out.println(" Preparandose para recibir");
            //Obtiene el primer mensaje de la cola de mensajes
            ACLMessage mensaje = receive();
            if (mensaje!= null)
            {
                System.out.println(getLocalName() + ": acaba de recibir el siguiente mensaje: ");
                System.out.println(mensaje.toString());
                String searchURL = GOOGLE_SEARCH_URL + "?q="+mensaje.getContent()+"&num="+num;
                try {
                    Document doc = Jsoup.connect(searchURL).userAgent("Mozilla/58.0").get();
                    Elements results = doc.select("h3.r > a");
                    results.stream().forEach((result) -> {
                        String linkHref = result.attr("href");
                        String linkText = result.text();
                        String recurperar="";
                        boolean siempre =false;
                        
                        for (int i = 0; i < linkHref.length(); i++) {
                            if(siempre==true){
                                recurperar=recurperar+""+linkHref.charAt(i);

                            }
                            if(linkHref.charAt(i)=='='){
                                siempre=true;
                            }
                        }
                        
                        System.out.println(getLocalName() +": Enviando contestacion");
                        ACLMessage respuesta = mensaje.createReply();
                        respuesta.setContent("Descripción "+linkText +" \tlink "+ recurperar);
                        
                        respuesta.addReceiver( mensaje.getSender() );
                        send(respuesta);
                        System.out.println(getLocalName() +": Enviando Respuesta a Agente_Estudiante");
                        System.out.println(respuesta.toString());
                        fin = true;
                    });
                } catch (IOException ex) {
                    Logger.getLogger(Agente_Recomendador.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("ha ocurrido un error");
                }
            }else{
                System.out.println("Receptor: Esperando a recibir mensaje...");
                block();
            }          
        }
        public boolean done(){
            return fin;
        }
    }
    protected void setup()
    {
        addBehaviour(new ReceptorComportamiento());
    }

}
