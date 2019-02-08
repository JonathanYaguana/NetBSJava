/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbc;

/**
 *
 * @author Mauricio
 */
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

public class Sbc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        //create an empty Model
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
        
        // crear people 1 mediante el vocabulario VCARD, incorporado directamente en Jena
        Resource person01
          = model.createResource(dataPrefix+"person01")
                 .addProperty(RDF.type, VCARD.AGENT)
                 .addProperty(VCARD.FN, "Luis Castro")
                 .addProperty(VCARD.Given, "Luis")
                 .addProperty(VCARD.Family, "Castro")
                 .addProperty(RDF.type, FOAF.Person)
                 .addProperty(FOAF.name, "Luis Castro")
                ;
        
        // create people 2 and add the properties cascading style
            String personURI    = dataPrefix + "person02";
            String givenName    = "Carla";
            String familyName   = "Burgos";
            String fullName     = givenName + " " + familyName;
        
            Resource person02 = model.createResource(personURI)
                 .addProperty(VCARD.FN, fullName)
                 .addProperty(VCARD.Given, givenName)
                 .addProperty(VCARD.Family, familyName)
                 .addProperty(RDF.type, VCARD.AGENT)
                 .addProperty(RDF.type, FOAF.Person);
        
       // Crear universidad utilizando clase y propiedad y recurso de la fuente externa dbo y dbr
          Resource utpl = model.createResource(dataPrefix + "UTPL")
                 .addProperty(VCARD.FN, "Universidad Técnica Particular de Loja")
                 .addProperty(RDF.type,  FOAF.Organization)
                 .addProperty(RDF.type,  dboModel.getResource(dbo + "EducationalOrganization"))
                  .addProperty(dboModel.getProperty(dbo+"city"),dboModel.getResource(dbo +"loja"));
       

        // Agregar propiedad que vincule los recursos tipo person al recurso utpl, ver las dos formas
           model.add(person01, FOAF.member, utpl);   // forma 1
           person02.addProperty(FOAF.member, utpl);  // forma 2
          
        // list the statements in the Model
            StmtIterator iter = model.listStatements();
        // print out the predicate, subject and object of each statement
            while (iter.hasNext()) {
                Statement stmt      = iter.nextStatement();  // get next statement
                Resource  subject   = stmt.getSubject();     // get the subject
                Property  predicate = stmt.getPredicate();   // get the predicate
                RDFNode   object    = stmt.getObject();      // get the object

                System.out.print(subject.toString());
                System.out.print(" " + predicate.toString() + " ");
                if (object instanceof Resource) {
                   System.out.print(object.toString());
                } else {
                    // object is a literal
                    System.out.print(" \"" + object.toString() + "\"");
                }

                System.out.println(" .");
         }
        

        // now write the model in XML form to a file
        System.out.println("MODELO RDF------");
        model.write(System.out, "RDF/XML-ABBREV");
        
        // Save to a file
        RDFWriter writer = model.getWriter("RDF/XML"); //RDF/XML
        writer.write(model,os, "");
        
        //Cerrar modelos
        dboModel.close();
        model.close();
        

    }
    
}
