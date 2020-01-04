/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.UrgenciologoDaoImpl;
import Idao.IUrgenciologoDAO;
import Modelo.Urgenciologo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jair Velazquez
 */
public class ControllerUrgenciologo {
        public ControllerUrgenciologo() {    
    }
	//llama al DAO para guardar un Paciente
	public void registrar(Urgenciologo paciente) {
		IUrgenciologoDAO dao= new UrgenciologoDaoImpl();
		dao.registrar(paciente);
	}
	
	//llama al DAO para actualizar un Paciente
	public void actualizar(Urgenciologo paciente) {
		IUrgenciologoDAO dao= new UrgenciologoDaoImpl();
		dao.actualizar(paciente);
	}
	
	//llama al DAO para eliminar un cliente
	public void eliminar(Urgenciologo paciente) {
		IUrgenciologoDAO dao= new UrgenciologoDaoImpl();
		dao.eliminar(paciente);
	}
	
	//llama al DAO para obtener todos los clientes y luego los muestra en la vista
	public void verDepartamentos(){
		List<Urgenciologo> pacientes = new ArrayList<Urgenciologo>();
		IUrgenciologoDAO dao= new UrgenciologoDaoImpl();
		pacientes = dao.obtener();
	}
}
