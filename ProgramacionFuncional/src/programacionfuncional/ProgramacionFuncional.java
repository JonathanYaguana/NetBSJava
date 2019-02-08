/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionfuncional;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Mauricio
 */
public class ProgramacionFuncional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Estudiante e = new Estudiante();
    	List<Estudiante> listaEstudiantes = new ArrayList<>();
        listaEstudiantes.add(new Estudiante("López","Francisco",4));
        listaEstudiantes.add(new Estudiante("Piedra","Monserrat", 13));
        listaEstudiantes.add(new Estudiante("Calle","Esperanza", 70));
        listaEstudiantes.add(new Estudiante("León","Jaime",42));
        listaEstudiantes.add(new Estudiante("Gutierrez","Estefono", 2));
        
        System.out.println(e);
    }
    public static int obtenerMenor(List<Estudiante> estudiantes) {
      
    	return 0;
    }

    public static int sumar(List<Estudiante> estudiantes) {
        return 0;
        
    }

    public static List<Estudiante> ordenar(List<Estudiante> estudiantes) {
      
        return null;
    }

    //Aquí el código para responder a la actividad 5

    public static Estudiante obtenerEstudianteMenor(List<Estudiante> estudiantes) {
        return null;
    }
    
}
