package sbc;

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
public class Jonathan_Yaguana {
    public static void main(String[] args) throws FileNotFoundException {
        Model model = ModelFactory.createDefaultModel();
        File f = new File("C:/Users/Mauricio/Documents/NetBeansProjects/sbc/rdf/Jonathan_Yaguana.rdf"); //Fijar ruta donde se creará el archivo RDF
        FileOutputStream os = new FileOutputStream(f);
        String dataPrefix = "http://utpl.edu.ec/sbc/data/Jonathan_Yaguana";
        model.setNsPrefix("myData", dataPrefix);
        String foaf = "http://xmlns.com/foaf/0.1/";
        model.setNsPrefix("foaf", foaf);
        String dbo = "http://dbpedia.org/ontology/";
        model.setNsPrefix("dbo", dbo);
        String schema = "http://schema.org/";
        model.setNsPrefix("schema", schema);
        Model dboModel = ModelFactory.createDefaultModel();  // modelo para la ontología
        dboModel.read(dbo) ;  
        Resource Cristian = model.createResource(dataPrefix)
                .addProperty(RDF.type, FOAF.Person)
                .addProperty(FOAF.firstName, "Jonathan Mauricio")
                .addProperty(FOAF.lastName, "Yaguana Condoy")
                .addProperty(FOAF.gender, "Masculino")
                .addProperty(FOAF.nick, "eslaifer")
                .addProperty(FOAF.birthday, "01-05-1993")
                .addProperty(FOAF.phone, "0992807964")
                .addProperty(FOAF.age, "25")
                .addProperty(FOAF.topic_interest, "Comprar La expansion de BT del Wow");
        Resource utpl = model.createResource(dataPrefix + "_UTPL")
                .addProperty(FOAF.name, "Universidad Técnica Particular de Loja")
                .addProperty(RDF.type, FOAF.Organization)
                .addProperty(RDF.type, dboModel.getResource(dbo + "EducationalOrganization"));        
       
        model.add(Cristian, FOAF.member, utpl);
        StmtIterator iter = model.listStatements();
        // print out the predicate, subject and object of each statement
        
        // now write the model in XML form to a file
        
        //Grabar archivos en rdf 
        System.out.println("MODELO RDF------");
        model.write(System.out, "RDF/XML-ABBREV");
        // Save to a file
        RDFWriter writer = model.getWriter("RDF/XML"); //RDF/XML
        writer.write(model, os, "");
        //Cerrar modelos
        dboModel.close();
        model.close();
    }
}
