/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.UrgenciaDaoImpl;
import Idao.IUrgenciaDAO;
import Modelo.Urgencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jair Velazquez
 */
public class ControllerUrgencia {
    
    public ControllerUrgencia() {    
    }
	//llama al DAO para guardar un Paciente
    public void registrar(Urgencia urgencia) {
	IUrgenciaDAO dao = new UrgenciaDaoImpl();
	dao.registrar(urgencia);
    }
	
    //llama al DAO para actualizar un Paciente
    public void actualizar(Urgencia paciente) {
	IUrgenciaDAO dao = new UrgenciaDaoImpl();
	dao.actualizar(paciente);
    }
	
    //llama al DAO para eliminar un cliente
    public void eliminar(Urgencia paciente) {
	IUrgenciaDAO dao= new UrgenciaDaoImpl();
	dao.eliminar(paciente);
    }
    
    //llama al DAO para obtener todos los clientes y luego los muestra en la vista
    public void verDepartamentos(){
	List<Urgencia> pacientes = new ArrayList<Urgencia>();
	IUrgenciaDAO dao= new  UrgenciaDaoImpl();
	pacientes = dao.obtener();
    }
}
