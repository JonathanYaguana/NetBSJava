/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rproyecto;

import java.util.Date;

/**
 *
 * @author Mauricio
 */
public class ProyectoProgramacion extends Proyecto{
    private String urlGit;
    private String lenguajeProgramacion;

    public ProyectoProgramacion(String urlGit, String lenguajeProgramacion, String titulo, String periodoAcademico, Date fechaInicio, Date fechaFin, String Objetivos, String estado) {
        super(titulo, periodoAcademico, fechaInicio, fechaFin, Objetivos, estado);
        this.urlGit = urlGit;
        this.lenguajeProgramacion = lenguajeProgramacion;
    }

    public String getUrlGit() {
        return urlGit;
    }

    public void setUrlGit(String urlGit) {
        this.urlGit = urlGit;
    }

    public String getLenguajeProgramacion() {
        return lenguajeProgramacion;
    }

    public void setLenguajeProgramacion(String lenguajeProgramacion) {
        this.lenguajeProgramacion = lenguajeProgramacion;
    }
    
    
}
