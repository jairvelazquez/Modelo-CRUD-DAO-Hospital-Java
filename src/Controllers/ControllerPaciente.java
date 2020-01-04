/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.PacienteDaoImpl;
import Idao.IPacienteDAO;
import Modelo.Paciente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jair Velazquez
 */
public class ControllerPaciente {//CLase que contendra los botones y controlara las funciones principales
    
    public ControllerPaciente() {    
    }
	//llama al DAO para guardar un Paciente
	public void registrar(Paciente paciente) {
		IPacienteDAO dao= new PacienteDaoImpl();
		dao.registrar(paciente);
	}
	
	//llama al DAO para actualizar un Paciente
	public void actualizar(Paciente paciente) {
		IPacienteDAO dao= new PacienteDaoImpl();
		dao.actualizar(paciente);
	}
	
	//llama al DAO para eliminar un cliente
	public void eliminar(Paciente paciente) {
		IPacienteDAO dao= new PacienteDaoImpl();
		dao.eliminar(paciente);
	}
	
	//llama al DAO para obtener todos los clientes y luego los muestra en la vista
	public void verDepartamentos(){
		List<Paciente> pacientes = new ArrayList<Paciente>();
		IPacienteDAO dao= new  PacienteDaoImpl();
		pacientes = dao.obtener();
	}
//        public void verPacientes(){
//            List
//        }
}
