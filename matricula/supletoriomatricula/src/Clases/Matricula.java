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
public class Matricula {
    private String anio;
    private Materia materia;
    private Estudiante estudiante;

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Matricula() {
    }

    public Matricula(String anio, Materia materia, Estudiante estudiante) {
        this.anio = anio;
        this.materia = materia;
        this.estudiante = estudiante;
    }
    
    
}
