/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rproyecto;

/**
 *
 * @author Mauricio
 */
public class Estudiante {
    private String correo;
    private String apellidos;
    private String nombres;

    public Estudiante(String correo, String apellidos, String nombres) {
        this.correo = correo;
        this.apellidos = apellidos;
        this.nombres = nombres;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
    
}
