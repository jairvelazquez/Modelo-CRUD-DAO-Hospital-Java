/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.EnfermeroDaoImpl;
import Idao.IEnfermeroDAO;
import Modelo.Enfermero;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jair Velazquez
 */
public class ControllerEnfermero {
        
    public ControllerEnfermero() {    
    }
    
    //llama al DAO para guardar un Paciente
    public void registrar(Enfermero enfermero) {
	IEnfermeroDAO dao= new EnfermeroDaoImpl();
	dao.registrar(enfermero);
    }
    
    //llama al DAO para actualizar un Paciente
    public void actualizar(Enfermero enfermero) {
	IEnfermeroDAO dao= new EnfermeroDaoImpl();
	dao.actualizar(enfermero);
    }
	
    //llama al DAO para eliminar un cliente
    public void eliminar(Enfermero enfermero) {
	IEnfermeroDAO dao= new EnfermeroDaoImpl();
	dao.eliminar(enfermero);
    }
	
    //llama al DAO para obtener todos los clientes y luego los muestra en la vista
    public void verDepartamentos(){
        List<Enfermero> enfermeros = new ArrayList<Enfermero>();
	IEnfermeroDAO dao= new  EnfermeroDaoImpl();
	enfermeros = dao.obtener();
    }
}
