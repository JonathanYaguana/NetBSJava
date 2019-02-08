
/**
 *
 * @author jachicaiza
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFWriter;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import static org.apache.jena.rdf.model.ResourceFactory.createResource;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.VCARD;

/**
 *
 * @author nopiedra
 */
public class example01 {

    public static void main(String[] args) throws FileNotFoundException {
// some definitions for ONTOLOGY
        // create an empty Model
        Model model = ModelFactory.createDefaultModel();
        File f= new File ("C:/Users/Mauricio/Documents/NetBeansProjects/sbc/rdf/people01.rdf"); 
	FileOutputStream os = new FileOutputStream(f);	
        
        //Fijar Prefijo para URI base de dos datos a crear 
        String dataPrefix = "http://example.org/data/";
        model.setNsPrefix("myData",dataPrefix);
        
        //Fijar prefijo de la ontología
        String vocabPrefix = "http://example.org/ontology#";
        model.setNsPrefix("myVocab",vocabPrefix);
        
        // Fijar URIs de objetos de ontología
        
        String courseClassURI = vocabPrefix+"Course";
        String studentClassURI = vocabPrefix+"Student";
        String courseNamePropertyURI = vocabPrefix+"courseName" ;
        String studentNamePropertyURI = vocabPrefix+"studentName" ;
        String studentGenderPropertuURI = vocabPrefix+"studentGender";
        String participantPropertyURI = vocabPrefix+"participant" ;
        String participantsListPropertyURI = vocabPrefix+"participantsList" ;

// some definitions about Resources

        String courseName = "Sistemas Basados en Conocimientos";
        String courseURI = dataPrefix+"sbc2018";
        String studentName01 = "Miguel Herrera";
        String studentName02 = "Danilo Diaz";
        String studentName03 = "Andrea Cordova";
        String studentgender01 ="Masculino";
        String studentgender02 ="Masculino";
        String studentgender03 ="Femenino";
        String studentURI01 = dataPrefix+"Miguel_Herrera";
        String studentURI02 = dataPrefix+"Danilo_Diaz";
        String studentURI03 = dataPrefix+"Andrea_Cordova";

	

// create Classes & properties
        Resource Course = ResourceFactory.createResource(courseClassURI);
        Resource Student = ResourceFactory.createResource(studentClassURI);
        Property courseNameProperty = ResourceFactory.createProperty(courseNamePropertyURI);
        Property studentNameProperty = ResourceFactory.createProperty(studentNamePropertyURI);
        Property studentGenderProperty = ResourceFactory.createProperty(studentGenderPropertuURI);
        Property participantProperty = ResourceFactory.createProperty(participantPropertyURI);
        Property participantsListProperty = ResourceFactory.createProperty(participantsListPropertyURI);


// create RESOURCES
        Resource course = model.createResource(courseURI)
                .addProperty(courseNameProperty, courseName)
                .addProperty(participantsListProperty, model.createResource()
                .addProperty (participantProperty,
                    model.createResource(studentURI01)
                             .addProperty (RDF.type, Student)
                             .addProperty (studentNameProperty, studentName01)
                             .addProperty (studentGenderProperty, studentgender01)
                    )
                    .addProperty (participantProperty,
                        model.createResource(studentURI02)
                             .addProperty (RDF.type, Student)
                             .addProperty (studentNameProperty, studentName02)
                             .addProperty (studentGenderProperty, studentgender02)
                    )
                    .addProperty (participantProperty,
                        model.createResource(studentURI03)
                             .addProperty (RDF.type, Student)
                             .addProperty (studentNameProperty, studentName03)
                             .addProperty (studentGenderProperty, studentgender03)
                    )
                );

        model.add(course, RDF.type, Course);

        // now write the model in XML form to a file
        model.write(System.out);
        model.write(System.out, "N3");
        RDFWriter writer = model.getWriter("RDF/XML");
	writer.write(model, os,  "");
    }
}