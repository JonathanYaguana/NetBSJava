/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Clases.Ciudad;
import DAT.DATCiudad;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Salas
 */
public class BLCiudad {
    DATCiudad ObjDATCiudad = new DATCiudad();
       ArrayList<Ciudad> arrayciudad;
    public ArrayList<Ciudad> ConsultarCiudad() throws SQLException, ClassNotFoundException {
        arrayciudad = new ArrayList<Ciudad>();
        int Incremento = 0;
        ResultSet rs;
        rs = ObjDATCiudad.ConsultarCiudad();
        while (rs.next()) {
            Ciudad ciu = new Ciudad();
            String value = rs.getString("nombre");
            ciu.setNombre(value);
            arrayciudad.add(ciu);
            Incremento = Incremento + 1;
        }
        return arrayciudad;
    }
}
