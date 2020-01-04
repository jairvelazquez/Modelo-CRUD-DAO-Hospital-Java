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
public class Especialista {
    private int id;
    private int id_departamento;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String especialidad;
    private int antiguedad;
    public Especialista(){}
    public Especialista(int id_departamento, String nombre, String apellido1, String apellido2, String especialidad, int antiguedad) {
        this.id_departamento = id_departamento;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.especialidad = especialidad;
        this.antiguedad = antiguedad;
    }

    public int getId() {
        return id;
    }

    public int getId_departamento() {
        return id_departamento;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public int getAntiguedad() {
        return antiguedad;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
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

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
}
