/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;


import Clases.Materia;
import DAT.DATCiudad;
import DAT.DATMateria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Salas
 */
public class BLMateria {
    DATMateria ObjDATMateria = new DATMateria();
       ArrayList<Materia> arraymateria;
    public ArrayList<Materia> ConsultarMateria() throws SQLException, ClassNotFoundException {
        arraymateria = new ArrayList<Materia>();
        int Incremento = 0;
        ResultSet rs;
        rs = ObjDATMateria.ConsultarMateria();
        while (rs.next()) {
            Materia ciu = new Materia();
            String value = rs.getString("nombre");
            ciu.setMateria(value);
            arraymateria.add(ciu);
            Incremento = Incremento + 1;
        }
        return arraymateria;
    }
}
