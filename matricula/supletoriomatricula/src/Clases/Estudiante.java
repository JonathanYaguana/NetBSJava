/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Salas
 */
public class Estudiante {
    private String cedula;
    private String apellido;
    private String nombre;
    private String sexo;
    private String ciudad;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Estudiante() {
    }

    public Estudiante(String cedula, String apellido, String nombre, String sexo, String ciudad) {
        this.cedula = cedula;
        this.apellido = apellido;
        this.nombre = nombre;
        this.sexo = sexo;
        this.ciudad = ciudad;
    }
    
}
