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
public class Diagnostico {
    private int id;
    private int idUgrneciologo;
    private int idDepartamento;
    private int idEspecialista;
    private String gravedad; 
    private int idUrgencia;
    private String nombrePaciente;
    private String apellidoPaciente;
    private String nombreEspecialista;
    private String apellidoEspecialista;
    private String nombreDepartamento;
    public Diagnostico(){}
    public Diagnostico(int idUrgencia,int idUgrneciologo, int idDepartamento, int idEspecialista, String gravedad) {
        this.idUgrneciologo = idUgrneciologo;
        this.idDepartamento = idDepartamento;
        this.idEspecialista = idEspecialista;
        this.gravedad = gravedad;
        this.idUrgencia = idUrgencia;
    }

    public int getIdUrgencia() {
        return idUrgencia;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public String getApellidoPaciente() {
        return apellidoPaciente;
    }

    public String getNombreEspecialista() {
        return nombreEspecialista;
    }

    public String getApellidoEspecialista() {
        return apellidoEspecialista;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public void setApellidoPaciente(String apellidoPaciente) {
        this.apellidoPaciente = apellidoPaciente;
    }

    public void setNombreEspecialista(String nombreEspecialista) {
        this.nombreEspecialista = nombreEspecialista;
    }

    public void setApellidoEspecialista(String apellidoEspecialista) {
        this.apellidoEspecialista = apellidoEspecialista;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
    
    public int getIDUrgencia(){
        return this.idUrgencia;
    }
    public void setIdUrgencia(int idUrgencia){
        this.idUrgencia=idUrgencia;
    }
    public int getId() {
        return id;
    }
    public int getIdDiagnostico(){
        return this.idUrgencia;
    }
    public int getIdUgrneciologo() {
        return idUgrneciologo;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public int getIdEspecialista() {
        return idEspecialista;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdUgrneciologo(int idUgrneciologo) {
        this.idUgrneciologo = idUgrneciologo;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public void setIdEspecialista(int idEspecialista) {
        this.idEspecialista = idEspecialista;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }
    public void setIdUrgenciologo(int idUrgencia){
        this.idUrgencia = idUrgencia;
    }
}
