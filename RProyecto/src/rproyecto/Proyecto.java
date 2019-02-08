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

import java.util.Date;

public class Proyecto {
    private String titulo;
    private String periodoAcademico;
    private Date fechaInicio;
    private Date fechaFin;
    private String Objetivos;
    private String estado;
    
//Relacion de composición    
    private Componente componente;
//Relacion de agregación    
    private Estudiante estudiante;
//Relacion de asociación    
    private Etiqueta etiqueta;
    

    public Proyecto(String titulo, String periodoAcademico, Date fechaInicio, Date fechaFin, String Objetivos, String estado) {
        this.titulo = titulo;
        this.periodoAcademico = periodoAcademico;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.Objetivos = Objetivos;
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPeriodoAcademico() {
        return periodoAcademico;
    }

    public void setPeriodoAcademico(String periodoAcademico) {
        this.periodoAcademico = periodoAcademico;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getObjetivos() {
        return Objetivos;
    }

    public void setObjetivos(String Objetivos) {
        this.Objetivos = Objetivos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
