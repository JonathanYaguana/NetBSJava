/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Salas
 */
public class DATConexion {
    //Conectarse a la BDD
    public static Connection con;//obj tipo Conecction
    
    public Connection getConnection () throws ClassNotFoundException, SQLException{
        String driver="com.mysql.jdbc.Driver";
        String user="root";
        String password="";
        String url="jdbc:mysql://localhost:3306/matricula?zeroDateTimeBehavior=convertToNull";
        Class.forName(driver) ;//Diver jdbc para trabajr con access
        con =DriverManager.getConnection(url,user,password);
        return con;//retorna la cioneccion url+ruta bd
    }
    //Objeto tipo Connection para majenar la conecion
    public Connection AbrirConexion() throws ClassNotFoundException, SQLException
    {
        con = getConnection();
        return con;
    }
    //cerrar la coneccion 
    public void CerrarConexion() throws SQLException
    {
       con.close();
    }
}
