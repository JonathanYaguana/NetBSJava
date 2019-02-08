/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionfuncional;

/**
 *
 * @author Mauricio
 */
public class Estudiante {
    String apellido;
    String nombre;
    int edad;
    
    public Estudiante(){
      this.apellido="Correa";
      this.nombre="Ricardo";
      this.edad=-65;
    }
    
    public void setApellido(String apellido){
      this.apellido=apellido;
    }
    
    public String getApellido(){
      return apellido;
    }

    public void setNombre(String nombre){
      this.nombre=nombre;
    }
    
    public String getNombre(){
      return nombre;
    }

    public void setEdad(int edad){
      if(edad>0){
        this.edad=edad;
      }
      else{
        throw new IllegalArgumentException("Su edad no puede ser 0 o menor que 0");
      }
    }
    
    public int getEdad(){
      return edad;
    }

    @Override
    public String toString(){
      return apellido+","+nombre+","+edad;
    }
    
    public Estudiante(String apellido, String nombre, int edad){
      this.apellido=apellido;
      this.nombre=nombre;
      if(edad>0){
        this.edad=edad;
      }
      else{
        throw new IllegalArgumentException("Su edad no puede ser 0 ni negativa");
      }
    }
}

