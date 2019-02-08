/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAT;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Salas
 */
public class DATCiudad {
    DATConexion c = new DATConexion();
    public ResultSet ConsultarCiudad() throws ClassNotFoundException, SQLException{
        Statement st=c.AbrirConexion().createStatement();
        String Sentencia = "SELECT * FROM ciudad ";
        ResultSet rs=st.executeQuery(Sentencia);
        System.out.println("[[[[[[[  "+rs);
        return rs;
    }
}
