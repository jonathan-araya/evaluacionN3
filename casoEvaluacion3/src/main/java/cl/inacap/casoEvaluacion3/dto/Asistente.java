/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.casoEvaluacion3.dto;

import javax.persistence.*;



@NamedQueries({
    @NamedQuery(name="Asistente.getAll", query = "SELECT a FROM Asistente a ORDER BY a.rut")
})


@Entity
public class Asistente {
    
    @Id
    @Column(name="rut")
    private String rut;
    private String nombre;
    private String apellido;
    private int edad;
    private String empresa;
    private String estado;
    private String region;
	
	public Asistente(){
            
        }
    
    
        public Asistente(String rut, String nombre, String apellido, int edad, String empresa, String estado, String region) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.empresa = empresa;
        this.estado = estado;
        this.region = region;
    }
        
	public String getRut() {
            return rut;
	}
	public void setRut(String rut) {
            this.rut = rut;
	}
	public String getNombre() {
            return nombre;
	}
	public void setNombre(String nombre) {
            this.nombre = nombre;
	}
	public String getApellido() {
            return apellido;
	}
	public void setApellido(String apellido) {
            this.apellido = apellido;
	}
	public int getEdad() {
            return edad;
	}
	public void setEdad(int edad) {
            this.edad = edad;
	}
	public String getEmpresa() {
            return empresa;
	}
	public void setEmpresa(String empresa) {
            this.empresa = empresa;
	}
	public String getEstado() {
            return estado;
	}
	public void setEstado(String estado) {
            this.estado = estado;
	}
	public String getRegion() {
            return region;
	}
	public void setRegion(String region) {
            this.region = region;
	}

    

    @Override
    public String toString() {
        return "Asistente{" + "rut=" + rut + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", empresa=" + empresa + ", estado=" + estado + ", region=" + region + '}';
    }
        
        
        
        
}
