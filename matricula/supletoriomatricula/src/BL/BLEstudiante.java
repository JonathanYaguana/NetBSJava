/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Clases.Ciudad;
import Clases.Estudiante;
import DAT.DATConexion;
import DAT.DATEstudiante;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Salas
 */
public class BLEstudiante {
    DATEstudiante ObjDATEstudiante = new DATEstudiante();
    ArrayList<Estudiante> arrayestudiante;
    DATConexion Conexi = new DATConexion();
       public int Insertar(Estudiante objEstudiante)
            throws SQLException, ClassNotFoundException {
        //metodo que me va poder insertar los elementos que ingreso por la gui
        //recive como parametro un objeto
        int retorno = 0;
        //creamos un objteto de la data de docente
        //y llamamos al metodo insertar
        retorno = this.ObjDATEstudiante.Insertar(objEstudiante);

        this.cerrarConexion();
        return retorno;
    }
     public void cerrarConexion() throws SQLException {
        Conexi.CerrarConexion();
    }
     public ArrayList<Estudiante> ConsultarEstudiante() throws SQLException, ClassNotFoundException {
        arrayestudiante = new ArrayList<Estudiante>();
        int Incremento = 0;
        ResultSet rs;
        rs = ObjDATEstudiante.ConsultarEstudiante();
        while (rs.next()) {
            Estudiante est = new Estudiante();
            String value = rs.getString("nombres");
            est.setNombre(value);
            arrayestudiante.add(est);
            Incremento = Incremento + 1;
        }
        return arrayestudiante;
    }
}
