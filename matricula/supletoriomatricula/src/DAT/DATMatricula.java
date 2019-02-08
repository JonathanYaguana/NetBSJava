/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAT;

import Clases.Estudiante;
import Clases.Materia;
import Clases.Matricula;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Salas
 */
public class DATMatricula {
    DATConexion c = new DATConexion();
    public int Insertar(Matricula objMatricula) 
            throws SQLException, ClassNotFoundException {
        int intRetorno = 0;
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "INSERT INTO matricu (idMatricu, anio,idMateria, idEstudiante)  VALUES ( "
                + "'" + 0 + "'" + ","
                + "" + objMatricula.getAnio() + "" + ","
                + "" + objMatricula.getMateria() + "" + ","
                + "" + objMatricula.getEstudiante() + "" + ")";
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
    }
    ////////////////////////////////////////////
    public int InsertarMatricula(String anio, Materia objMateria, Estudiante objEstudiante)
            throws SQLException, ClassNotFoundException {
        int intRetorno = 0;
        Statement st = c.AbrirConexion().createStatement();
        
        String Sentencia = "INSERT INTO `matricu` (`idMatricu`, `idMaterias`, `idEst`, `anio`) VALUES ("
                +  0+ ","
                + objMateria.getMateria()  + ","
                +  objEstudiante.getNombre()+ ","
                + "'" + anio+ "'" + ")";
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
    }
}
