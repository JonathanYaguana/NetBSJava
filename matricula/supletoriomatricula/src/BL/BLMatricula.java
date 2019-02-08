/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Clases.Estudiante;
import Clases.Matricula;
import DAT.DATConexion;
import DAT.DATEstudiante;
import DAT.DATMatricula;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Salas
 */
public class BLMatricula {
    DATMatricula ObjDATMatricula = new DATMatricula();
    ArrayList<Matricula> arraymatricula;
    DATConexion Conexi = new DATConexion();
       public int Insertar(Matricula objMatricula)
            throws SQLException, ClassNotFoundException {
        //metodo que me va poder insertar los elementos que ingreso por la gui
        //recive como parametro un objeto
        int retorno = 0;
        //creamos un objteto de la data de docente
        //y llamamos al metodo insertar
        retorno = this.ObjDATMatricula.Insertar(objMatricula);

        this.cerrarConexion();
        return retorno;
    }
     public void cerrarConexion() throws SQLException {
        Conexi.CerrarConexion();
    }
}
