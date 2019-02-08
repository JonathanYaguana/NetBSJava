/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

//
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;
import org.apache.jena.vocabulary.VCARD;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.rdf.model.RDFWriter;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.apache.jena.ontology.OntModelSpec;

/**
 *
 * @author Mauricio
 */
public class csv {
    public static final String SEPARATOR=";";
   public static final String QUOTE="\"";

   public static void main(String[] args) throws IOException, FileNotFoundException {
    BufferedReader br = null;
      Model model = ModelFactory.createDefaultModel();
        File f= new File ("C:/Users/Mauricio/Documents/NetBeansProjects/sbc/rdf/peoples00.rdf"); //Fijar ruta donde se creará el archivo RDF
        FileOutputStream os = new FileOutputStream(f);
        
        //Fijar Prefijo para URI base de dos datos a crear 
        String dataPrefix = "http://example.org/data/";
        model.setNsPrefix("myData",dataPrefix);
        
        //Fijar prefijos de vocabularios incorporados en Jena
        String foaf = "http://xmlns.com/foaf/0.1/";
        model.setNsPrefix("foaf",foaf);
        
        //Fijar Prefijo para otros vocabularios como DBPedia que no están directamente incorporados en Jena
        String dbo = "http://dbpedia.org/ontology/";
        model.setNsPrefix("dbo", dbo);
        // en el caso de vocabularios externos (no incorporados en Jena) se debe crear un modelo
        Model dboModel = ModelFactory.createDefaultModel();  // modelo para la ontología
        dboModel.read(dbo) ;
        
      try {
         
         br =new BufferedReader(new FileReader("C:/Users/Mauricio/Documents/NetBeansProjects/sbc/Libro1.csv"));
         String line = br.readLine();
         int i =0;
         while (null!=line) {
            String [] fields = line.split(SEPARATOR);
            //System.out.println(Arrays.toString(fields));
            fields = removeTrailingQuotes(fields);
            //System.out.println(Arrays.toString(fields));
             //System.out.println(fields[0] + i );
             Resource person01
                = model.createResource(dataPrefix+"person01")
                       .addProperty(RDF.type, VCARD.AGENT)
                       .addProperty(VCARD.FN, "Luis Castro")
                       .addProperty(VCARD.Given, "Luis")
                       .addProperty(VCARD.Family, "Castro")
                       .addProperty(RDF.type, FOAF.Person)
                       .addProperty(FOAF.name, "Luis Castro")
                      ;
            line = br.readLine();
            i++;
         }
         
      } catch (Exception e) {
            System.out.println("");
      } finally {
         if (null!=br) {
            br.close();
         }
      }     
}
   private static String[] removeTrailingQuotes(String[] fields) {

      String result[] = new String[fields.length];

      for (int i=0;i<result.length;i++){
         result[i] = fields[i].replaceAll("^"+QUOTE, "").replaceAll(QUOTE+"$", "");
      }
      return result;
   }
}
