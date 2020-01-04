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
public class ApoyoEnfermero {
    private int id_enfermero;
    private int id_urgencia;
    private String nombrePaciente;
    private String apellidoPaciente;
    private String nombreEnfermero;
    private String apellidoEnfermero;

    public ApoyoEnfermero(){}
    
    public ApoyoEnfermero(int id_enfermero,int  id_urgencia){
        this.id_enfermero = id_enfermero;
        this.id_urgencia = id_urgencia;
    }
    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public void setApellidoPaciente(String apellidoPaciente) {
        this.apellidoPaciente = apellidoPaciente;
    }

    public void setNombreEnfermero(String nombreEnfermero) {
        this.nombreEnfermero = nombreEnfermero;
    }

    public void setApellidoEnfermero(String apellidoEnfermero) {
        this.apellidoEnfermero = apellidoEnfermero;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public String getApellidoPaciente() {
        return apellidoPaciente;
    }

    public String getNombreEnfermero() {
        return nombreEnfermero;
    }

    public String getApellidoEnfermero() {
        return apellidoEnfermero;
    }

    public int getId_enfermero() {
        return id_enfermero;
    }

    public int getId_urgencia() {
        return id_urgencia;
    }

    public void setId_enfermero(int id_enfermero) {
        this.id_enfermero = id_enfermero;
    }

    public void setId_urgencia(int id_urgencia) {
        this.id_urgencia = id_urgencia;
    }
    
}
