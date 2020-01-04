/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Jair Velazquez
 */

public class Paciente {
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String sexo;
    private int edad;
    private String tipo_sangre;
    private String telefono;
    
    public Paciente(){
    }
    public Paciente(String nombre,String apellido1,String apellido2,String sexo,int edad,String tipo_sangre,String telefono){
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.sexo = sexo;
        this.edad = edad;
        this.tipo_sangre = tipo_sangre;
        this.telefono = telefono;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setTipo_sangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }

    public String getTipo_sangre() {
        return tipo_sangre;
    }

    public String getTelefono() {
        return telefono;
    }
    
}
