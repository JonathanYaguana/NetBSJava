package principal;

import Interfaz.Humano;
import Logica.VentanaAux;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class init {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Runtime rt = Runtime.instance();
        ProfileImpl p = new ProfileImpl();
        p.setParameter(Profile.MAIN_HOST, "localhost");
        p.setParameter(Profile.GUI, "true");
        ContainerController cc = rt.createMainContainer(p);
        AgentController ag1, ag2;

        new Humano().setVisible(true);        
        
        try {
            ag1 = cc.createNewAgent("AgenteGestor", "Agentes.agenteGestor", null);
            ag2 = cc.createNewAgent("AgenteHumano", "Agentes.agenteHumano", null);
            ag2.start();
            ag1.start();
        } catch (StaleProxyException ex) {
            Logger.getLogger(init.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
