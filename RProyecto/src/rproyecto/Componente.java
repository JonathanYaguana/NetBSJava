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
public class Componente {
    private String nombre;
    private String tutor;
    private String titulacion;

    public Componente(String nombre, String tutor, String titulacion) {
        this.nombre = nombre;
        this.tutor = tutor;
        this.titulacion = titulacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }
    
    
}
