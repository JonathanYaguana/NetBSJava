/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sbc;

// import org.apache.jena.rdf.model.OntModel;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.RDFNode;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class RemoteQuery {
   public static JTable table;
      
   public static void drawUI() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
        JFrame frame;
        frame = new JFrame();
        JScrollPane scrollPane;
        // JToolBar toolBar;
        frame.setBounds(100, 100, 585, 413);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        frame.getContentPane().add(toolBar, BorderLayout.NORTH);

        JButton btnHelp = new JButton("Data");
        toolBar.add(btnHelp);

        scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        //Right here you just set the table headers
        String [] header={"uri", "name"};
        //Creating the tablemodel with no data , 'null', and give the tablemodel the header
        DefaultTableModel model;
        model = new DefaultTableModel(null, header);
        model = new DefaultTableModel(null, header);
        table = new JTable(model);
        scrollPane.setViewportView(table);
        frame.setVisible(true); 
        try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                        | UnsupportedLookAndFeelException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
   }
//Find a list of companies filtered by some criteria and return DBpedia URIs of them
   public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
   {
        String s1 = "http://dbpedia.org/sparql";
        String q1 = "PREFIX dbo: <http://dbpedia.org/ontology/> "
                    + "PREFIX dbr: <http://dbpedia.org/resource/> "
                    + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
                    + "PREFIX foaf: <http://xmlns.com/foaf/0.1/> "
                    + "SELECT distinct * "
                    + "WHERE { "
                    + "VALUES ?p {rdfs:label} "
                    + "?s a dbo:Person. "
                    + "?s dbo:country dbr:Ecuador. "
                    + "?s foaf:name ?name. "
                    + "FILTER (lang(?name)='en')"
                    + "} LIMIT 30";
        QueryExecution e1 = QueryExecutionFactory.sparqlService(s1,q1);
        ResultSet results1 = e1.execSelect();
        drawUI();
        while (results1.hasNext())
        {
            QuerySolution sol = results1.nextSolution();
            RDFNode object = sol.get("name"); 
            RDFNode subject = sol.get("s");

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.addRow(new Object[]{subject, object});
        }
         e1.close();
    }
     
}