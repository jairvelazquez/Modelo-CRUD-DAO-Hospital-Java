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
public class Urgencia {
    private int id;
    private int id_paciente;
    private int id_urgenciologo;
    private int id_diagnostico;
    private String camilla;
    private String dateTimeIngreso;
    private String dateTimeSalida;
    private String causa;
    private String nombrePaciente;
    private String apellidoPaciente;
    private String nombreUrgenciologo;
    private String apellidoUrgenciologo;
    private String nombreEspecialista;
    private String apellidoEspecialista;
    private String gravedad;
    public Urgencia(int id_paciente, int id_urgenciologo,String camilla, String dateTimeIngreso,String causa) {
        this.id_paciente = id_paciente;
        this.id_urgenciologo = id_urgenciologo;
        this.dateTimeIngreso = dateTimeIngreso;
        this.camilla = camilla;
        this.causa = causa;
    }
    public Urgencia(){}

    public Urgencia(int id_paciente, int id_urgenciologo, String camilla, String causa) {
        this.id_paciente = id_paciente;
        this.id_urgenciologo = id_urgenciologo;
        this.camilla = camilla;
        this.causa = causa;
    }
    public void setGravedad(String gravedad){
        this.gravedad = gravedad;
    }
    public String getGravedad(){
        return this.gravedad;
    }
    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public void setApellidoPaciente(String apellidoPaciente) {
        this.apellidoPaciente = apellidoPaciente;
    }

    public void setNombreUrgenciologo(String nombreUrgenciologo) {
        this.nombreUrgenciologo = nombreUrgenciologo;
    }

    public void setApellidoUrgenciologo(String apellidoUrgenciologo) {
        this.apellidoUrgenciologo = apellidoUrgenciologo;
    }

    public void setNombreEspecialista(String nombreEspecialista) {
        this.nombreEspecialista = nombreEspecialista;
    }

    public void setApellidoEspecialista(String apellidoEspecialista) {
        this.apellidoEspecialista = apellidoEspecialista;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public String getApellidoPaciente() {
        return apellidoPaciente;
    }

    public String getNombreUrgenciologo() {
        return nombreUrgenciologo;
    }

    public String getApellidoUrgenciologo() {
        return apellidoUrgenciologo;
    }

    public String getNombreEspecialista() {
        return nombreEspecialista;
    }

    public String getApellidoEspecialista() {
        return apellidoEspecialista;
    }
    
    public String getCausa(){
        return this.causa;
    }
    public void setCausa(String causa){
        this.causa = causa;
    }
    public String getDateTimeSalida(){
        return this.dateTimeSalida;
    }
    public void setDateTimeSalida(String dateTimeSalida){
        this.dateTimeSalida = dateTimeSalida;
    }
    public String getDateTimeIngreso(){
        return this.dateTimeIngreso;
    }
    public void setDateTimeIngreso(String dateTimeIngreso){
        this.dateTimeIngreso = dateTimeIngreso;
    }
    public int getId() {
        return id;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public int getId_urgenciologo() {
        return id_urgenciologo;
    }

    public int getId_diagnostico() {
        return id_diagnostico;
    }

    public String getCamilla() {
        return camilla;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public void setId_urgenciologo(int id_urgenciologo) {
        this.id_urgenciologo = id_urgenciologo;
    }

    public void setId_diagnostico(int id_diagnostico) {
        this.id_diagnostico = id_diagnostico;
    }

    public void setCamilla(String camilla) {
        this.camilla = camilla;
    }
}
