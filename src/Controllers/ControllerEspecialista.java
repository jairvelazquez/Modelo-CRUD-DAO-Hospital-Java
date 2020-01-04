/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.EspecialistaDaoImpl;
import Idao.IEspecialistaDAO;
import Modelo.Especialista;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jair Velazquez
 */
public class ControllerEspecialista {//Controlados por los botones
        public ControllerEspecialista() {    
        }
	//llama al DAO para guardar un Paciente
	public void registrar(Especialista especialista) {
		IEspecialistaDAO dao= new EspecialistaDaoImpl();
		dao.registrar(especialista);
	}
	
	//llama al DAO para actualizar un Paciente
	public void actualizar(Especialista especialista) {
		IEspecialistaDAO dao= new EspecialistaDaoImpl();
		dao.actualizar(especialista);
	}
	
	//llama al DAO para eliminar un cliente
	public void eliminar(Especialista especialista) {
		IEspecialistaDAO dao= new EspecialistaDaoImpl();
		dao.eliminar(especialista);
	}
	
	//llama al DAO para obtener todos los clientes y luego los muestra en la vista
	public void verDepartamentos(){
		List<Especialista> especialistas = new ArrayList<Especialista>();
		IEspecialistaDAO dao= new EspecialistaDaoImpl();
		especialistas = dao.obtener();
	}
}
