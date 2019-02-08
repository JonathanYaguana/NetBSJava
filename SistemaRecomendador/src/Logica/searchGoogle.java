package Logica;

import static Interfaz.Humano.jTable1;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class searchGoogle {

    public static final String GOOGLE_SEARCH_URL = "https://www.google.com/search";

    public void busca(String palabra) throws IOException {

        int num = 10;

        String searchURL = GOOGLE_SEARCH_URL + "?q=" + palabra + "&num=" + num;
        Document doc = Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();

        Elements results = doc.select("h3.r > a");

        String[][] arreglo = new String[num][2];
        int aux = 0;
        for (Element result : results) {
            String linkHref = result.attr("href");
            String linkHref2 = linkHref.substring(6, linkHref.indexOf("&"));
            String[] temp = linkHref2.split("=");
            String link = temp[1];
            String linkText = result.text();
            arreglo[aux][0] = linkText;
            arreglo[aux][1] = link;
            aux++;
        }
        loadInfo(arreglo);
    }

    DefaultTableModel model;

    void loadInfo(String[][] lista) {
        //arreglo con los titulos de la tabla
        String[] titulos = {"ID", "Prefijo", "URL"};
        model = new DefaultTableModel(null, titulos);//enviamos el arreglo en el modelo de la tabla
        String[] fila = new String[3];
        for (int i = 0; i < lista.length; i++) {
            fila[0] = "" + (i+1);
            fila[1] = lista[i][0];
            fila[2] = lista[i][1];
            System.out.println(fila[1]);
            model.addRow(fila);
        }        
        jTable1.setModel(model); //agregamos valores en la tabla
    }
}
