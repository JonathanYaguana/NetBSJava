/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAT;

import Clases.Estudiante;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Salas
 */
public class DATEstudiante {
    DATConexion c = new DATConexion();
    public int Insertar(Estudiante objEstudiante) 
            throws SQLException, ClassNotFoundException {
        int intRetorno = 0;
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "INSERT INTO estudiante (idEst, cedula, apellidos, nombres, sexo, ciudad)  VALUES ( "
                + "'" + 0 + "'" + ","
                + "'" + objEstudiante.getCedula() + "'" + ","
                + "'" + objEstudiante.getApellido() + "'" + ","
                + "'" + objEstudiante.getNombre() + "'" + ","
                 + "'" + objEstudiante.getSexo() + "'" + ","
                + "'" + objEstudiante.getCiudad() + "'" + ")";
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
    }
    public ResultSet ConsultarEstudiante() throws ClassNotFoundException, SQLException{
        Statement st=c.AbrirConexion().createStatement();
        String Sentencia = "SELECT * FROM estudiante ";
        ResultSet rs=st.executeQuery(Sentencia);
        System.out.println("[[[[[[[  "+rs);
        return rs;
    }
}
